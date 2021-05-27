package edu.suffolk.assemblyline.efspserver;

import com.google.gson.Gson;
import edu.suffolk.assemblyline.efspserver.codes.CaseCategory;
import edu.suffolk.assemblyline.efspserver.codes.CodeDatabase;
import edu.suffolk.assemblyline.efspserver.codes.DataFieldRow;
import edu.suffolk.assemblyline.efspserver.codes.PartyType;
import gov.niem.niem.iso_4217._2.CurrencyCodeSimpleType;
import gov.niem.niem.niem_core._2.AmountType;
import gov.niem.niem.niem_core._2.TextType;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import javax.xml.bind.JAXBElement;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4.CivilCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseParticipantType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4.DomesticCaseType;
import tyler.ecf.extensions.common.FilingAssociationType;
import tyler.ecf.extensions.common.ProviderChargeType;

public class EcfCaseTypeFactory {
  private CodeDatabase cd;
  
  public EcfCaseTypeFactory(CodeDatabase cd) {
    this.cd = cd;
  }
  
  /**
   * Makes a case from specific info + unorganized JSON dumps.
   *
   * @param courtLocationId the court's name a unique string. ex: 'adams'
   * @param caseCategory the {@link CaseCategory} object, from a code database
   * @param caseType the case type code from the casetype table
   * @param caseSubType the case subtype code, empty if not present
   * @param plaintiffs List of plaintiff person objects
   * @param defendants List of defendant person objects
   * @param filingIds The UIDs of all of the filings
   * @param paymentId The UID of the tyler payment account, from GetPaymentAccountList
   * @param jsonDump Misc info, case dependant, from DA
   * @return
   */
  public Optional<JAXBElement<? extends gov.niem.niem.niem_core._2.CaseType>> 
      makeCaseTypeFromTylerCategory(
      String courtLocationId,
      CaseCategory caseCategory,
      String caseType,
      String caseSubType,
      List<Person> plaintiffs, List<Person> defendants,
      List<String> filingIds,
      String paymentId,
      // HACK(brycew): hacky: needed because fee querys put the payment stuff in the tyler Aug
      String queryType, 
      Gson jsonDump
  ) throws SQLException {
    JAXBElement<gov.niem.niem.domains.jxdm._4.CaseAugmentationType> caseAug = makeNiemCaseAug(courtLocationId);
    JAXBElement<tyler.ecf.extensions.common.CaseAugmentationType> tylerAug = 
              makeTylerCaseAug(courtLocationId, Integer.toString(caseCategory.code), 
                  caseType, caseSubType, plaintiffs, defendants, filingIds,
                  paymentId, queryType);
    if (caseCategory.ecfcasetype.equals("CivilCase")) {
      JAXBElement<? extends gov.niem.niem.niem_core._2.CaseType> myCase = 
          makeCivilCaseType(
              caseAug, tylerAug,
              // TODO(brycew) from the gson
              new BigDecimal(500.0));
      myCase.getValue().setCaseCategoryText(
          XmlHelper.convertText(Integer.toString(caseCategory.code)));
      return Optional.of(myCase);
    } else if (caseCategory.ecfcasetype.equals("DomesticCase")) {
      JAXBElement<? extends gov.niem.niem.niem_core._2.CaseType> myCase = 
          makeDomesticCaseType(
              caseAug, tylerAug, 
              // TODO(brycew) from the gson
              false
              );
      myCase.getValue().setCaseCategoryText(
          XmlHelper.convertText(Integer.toString(caseCategory.code)));
      return Optional.of(myCase);
    } else {
      // TODO(brycew): start passing back why we couldn't make a case from this info
      return Optional.empty();
    }
  }
  
  private JAXBElement<gov.niem.niem.domains.jxdm._4.CaseAugmentationType> 
      makeNiemCaseAug(String courtLocationId) {
    gov.niem.niem.domains.jxdm._4.ObjectFactory jof = 
        new gov.niem.niem.domains.jxdm._4.ObjectFactory();
    gov.niem.niem.domains.jxdm._4.CaseAugmentationType caseAug = jof.createCaseAugmentationType();
    caseAug.setCaseCourt(XmlHelper.convertCourtType(courtLocationId));
    return jof.createCaseAugmentation(caseAug);
  }
  
  private JAXBElement<tyler.ecf.extensions.common.CaseAugmentationType> 
      makeTylerCaseAug(
          String courtLocationId,
          String caseCategoryCode,
          String caseType,
          String caseSubtype,
          List<Person> plaintiffs, List<Person> defendants,
          List<String> filingIds,
          String paymentId, String queryType
       ) throws SQLException {
    tyler.ecf.extensions.common.ObjectFactory tylerObjFac = new tyler.ecf.extensions.common.ObjectFactory();
    oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory ecfCommonObjFac = 
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory();
    tyler.ecf.extensions.common.CaseAugmentationType ecfAug = tylerObjFac.createCaseAugmentationType();
    gov.niem.niem.niem_core._2.ObjectFactory of = new gov.niem.niem.niem_core._2.ObjectFactory();

    List<PartyType> partyTypes = cd.getPartyTypeFor(courtLocationId, caseCategoryCode);

    for (Person plaintiff : plaintiffs) {
      CaseParticipantType cp = plaintiff.getEcfCaseParticipant();
      TextType tt = of.createTextType();
      partyTypes.stream()
          .filter((pt) -> pt.partyTypeName.toLowerCase().contains("plaintiff"))
          .findFirst()
          .ifPresent((pt) -> tt.setValue(pt.partyTypeCode));
      cp.setCaseParticipantRoleCode(tt);
      ecfAug.getCaseParticipant().add(ecfCommonObjFac.createCaseParticipant(cp));
    }

    for (Person defendant : defendants) {
      CaseParticipantType cp = defendant.getEcfCaseParticipant();
      TextType tt = of.createTextType();
      partyTypes.stream()
          .filter((pt) -> pt.partyTypeName.toLowerCase().contains("defendant"))
          .findFirst()
          .ifPresent((pt) -> tt.setValue(pt.partyTypeCode));
      cp.setCaseParticipantRoleCode(tt);
      ecfAug.getCaseParticipant().add(ecfCommonObjFac.createCaseParticipant(cp));
    }
    
    ecfAug.setCaseTypeText(XmlHelper.convertText(caseType));
    ecfAug.setCaseSubTypeText(XmlHelper.convertText(caseSubtype));
    gov.niem.niem.proxy.xsd._2.Boolean falseVal = XmlHelper.convertBool(false); 
    ecfAug.setAttachServiceContactIndicator(falseVal);
    
    // TODO(brycew): FilerType and DamageAmount and ProcedureRemedy are all 
    // empty tables, so can't tell what they might be

    Optional<DataFieldRow> filingcaseparties = cd.getDataField(courtLocationId, "FilingEventCaseParties");
    boolean needToAssociateFilings = filingcaseparties.isPresent() && filingcaseparties.get().isrequired;
    gov.niem.niem.structures._2.ObjectFactory structOf = new gov.niem.niem.structures._2.ObjectFactory();
    if (needToAssociateFilings) {
      for (String filingId : filingIds) {
        FilingAssociationType fat = tylerObjFac.createFilingAssociationType();
        gov.niem.niem.structures._2.ReferenceType rt = structOf.createReferenceType(); 
        rt.setId(filingId);
        fat.setPartyReference(rt);
        ecfAug.getFilingAssociation().add(fat); 
      }
    }
    
    if (queryType.equalsIgnoreCase("fees")) {
      PaymentFactory pf = new PaymentFactory();
      ProviderChargeType pct = pf.makeProviderChargeType(paymentId);
      ecfAug.setProviderCharge(pct);
    }

    return tylerObjFac.createCaseAugmentation(ecfAug);
  }
  
  /**
   * Makes a civil case to include in queries like FeesQuery and ReviewFiling.
   *
   * @param caseAug The Niem JXDM augmentation type, contains the case court
   * @param tylerAug The Tyler case augementation type, contains most of the case info
   * @param amountInControversy "The ad damnum value. Only applicable if the filing code is 
   *     configured AmountInControversy=Required. When enabled this value affects the 
   *     calculations for fees and return date."
   * @return A complete Civil Case type
   */
  private JAXBElement<CivilCaseType> makeCivilCaseType(
      JAXBElement<gov.niem.niem.domains.jxdm._4.CaseAugmentationType> caseAug,
      JAXBElement<tyler.ecf.extensions.common.CaseAugmentationType> tylerAug,
      BigDecimal amountInControversy) {
    oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4.ObjectFactory ecfCivilObjFac = 
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4.ObjectFactory();
    oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory ecfCommonObjFac = 
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory();
    
    CivilCaseType c = ecfCivilObjFac.createCivilCaseType();
    c.getRest().add(caseAug);
    c.getRest().add(tylerAug);
    JAXBElement<TextType> causeOfAction = ecfCommonObjFac.createCauseOfActionCode(new TextType());
    c.getRest().add(causeOfAction);

    AmountType amount = new AmountType();
    amount.setValue(amountInControversy);
    amount.setCurrencyCode(CurrencyCodeSimpleType.USD);
    c.getRest().add(ecfCivilObjFac.createAmountInControversy(amount));
    c.getRest().add(ecfCivilObjFac.createClassActionIndicator(XmlHelper.convertBool(false)));
    c.getRest().add(ecfCivilObjFac.createJurisdictionalGroundsCode(XmlHelper.convertText("")));
    c.getRest().add(ecfCivilObjFac.createJuryDemandIndicator(XmlHelper.convertBool(false)));
    JAXBElement<TextType> relief = ecfCivilObjFac.createReliefTypeCode(new TextType());
    c.getRest().add(relief);
    return ecfCivilObjFac.createCivilCase(c);
  }
  
  private JAXBElement<DomesticCaseType> makeDomesticCaseType(
      JAXBElement<gov.niem.niem.domains.jxdm._4.CaseAugmentationType> caseAug,
      JAXBElement<tyler.ecf.extensions.common.CaseAugmentationType> tylerAug,
      boolean contestedCase) {
    oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4.ObjectFactory ecfDomesticObjFac = 
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4.ObjectFactory();
    oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory ecfCommonObjFac = 
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory();
    DomesticCaseType d = ecfDomesticObjFac.createDomesticCaseType();
    d.getRest().add(caseAug);
    d.getRest().add(tylerAug);
    JAXBElement<TextType> causeOfAction = ecfCommonObjFac.createCauseOfActionCode(new TextType());
    d.getRest().add(causeOfAction);
    d.getRest().add(ecfDomesticObjFac.createCaseContestedIndicator(
        XmlHelper.convertBool(contestedCase))); 
    d.getRest().add(ecfDomesticObjFac.createDomesticCasePerson(new PersonType())); 
    return ecfDomesticObjFac.createDomesticCase(d);
  }
  
}
