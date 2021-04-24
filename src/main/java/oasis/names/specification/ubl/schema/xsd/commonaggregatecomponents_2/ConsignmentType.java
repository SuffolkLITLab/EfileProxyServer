
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AnimalFoodIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BrokerAssignedIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BulkCargoIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CarrierAssignedIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CarrierServiceInstructionsType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ChargeableWeightMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConsigneeAssignedIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConsignmentQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConsignorAssignedIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConsolidatableIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ContainerizedIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ContractedCarrierAssignedIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CustomsClearanceServiceInstructionsType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DeclaredCustomsValueAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DeclaredForCarriageValueAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DeclaredStatisticsValueAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DeliveryInstructionsType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ForwarderServiceInstructionsType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FreeOnBoardValueAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FreightForwarderAssignedIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.GeneralCargoIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.GrossVolumeMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.GrossWeightMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.HandlingCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.HandlingInstructionsType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.HaulageInstructionsType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.HazardousRiskIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.HumanFoodIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InformationType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InsurancePremiumAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InsuranceValueAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LivestockIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LoadingLengthMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LoadingSequenceIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NetNetWeightMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NetVolumeMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NetWeightMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PerformingCarrierAssignedIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RemarksType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SequenceIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ShippingPriorityLevelCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SpecialInstructionsType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SpecialSecurityIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SpecialServiceInstructionsType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SplitConsignmentIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SummaryDescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TariffCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TariffDescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ThirdPartyPayerIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TotalGoodsItemQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TotalInvoiceAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TotalTransportHandlingUnitQuantityType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for ConsignmentType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ConsignmentType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CarrierAssignedID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ConsigneeAssignedID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ConsignorAssignedID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FreightForwarderAssignedID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}BrokerAssignedID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ContractedCarrierAssignedID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PerformingCarrierAssignedID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SummaryDescription" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TotalInvoiceAmount" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DeclaredCustomsValueAmount" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TariffDescription" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TariffCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}InsurancePremiumAmount" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}GrossWeightMeasure" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}NetWeightMeasure" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}NetNetWeightMeasure" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ChargeableWeightMeasure" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}GrossVolumeMeasure" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}NetVolumeMeasure" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LoadingLengthMeasure" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Remarks" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}HazardousRiskIndicator" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AnimalFoodIndicator" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}HumanFoodIndicator" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LivestockIndicator" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}BulkCargoIndicator" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ContainerizedIndicator" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}GeneralCargoIndicator" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SpecialSecurityIndicator" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ThirdPartyPayerIndicator" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CarrierServiceInstructions" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CustomsClearanceServiceInstructions" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ForwarderServiceInstructions" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SpecialServiceInstructions" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SequenceID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ShippingPriorityLevelCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}HandlingCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}HandlingInstructions" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Information" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TotalGoodsItemQuantity" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TotalTransportHandlingUnitQuantity" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}InsuranceValueAmount" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DeclaredForCarriageValueAmount" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DeclaredStatisticsValueAmount" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FreeOnBoardValueAmount" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SpecialInstructions" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SplitConsignmentIndicator" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DeliveryInstructions" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ConsignmentQuantity" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ConsolidatableIndicator" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}HaulageInstructions" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LoadingSequenceID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ConsigneeParty" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ExporterParty" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ConsignorParty" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ImporterParty" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}CarrierParty" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}FreightForwarderParty" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}NotifyParty" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OriginalDespatchParty" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}FinalDeliveryParty" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PerformingCarrierParty" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}SubstituteCarrierParty" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}LogisticsOperatorParty" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TransportAdvisorParty" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}HazardousItemNotificationParty" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}InsuranceParty" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}MortgageHolderParty" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}BillOfLadingHolderParty" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OriginalDepartureCountry" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}FinalDestinationCountry" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TransitCountry" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TransportContract" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OriginalDespatchTransportationService" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}FinalDeliveryTransportationService" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DeliveryTerms" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PaymentTerms" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}CollectPaymentTerms" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DisbursementPaymentTerms" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PrepaidPaymentTerms" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}FreightAllowanceCharge" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ExtraAllowanceCharge" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}MainCarriageShipmentStage" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PreCarriageShipmentStage" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OnCarriageShipmentStage" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TransportHandlingUnit" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}FirstArrivalPortLocation" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}LastExitPortLocation" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ConsolidatedShipment" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsignmentType", propOrder = {
    "id",
    "carrierAssignedID",
    "consigneeAssignedID",
    "consignorAssignedID",
    "freightForwarderAssignedID",
    "brokerAssignedID",
    "contractedCarrierAssignedID",
    "performingCarrierAssignedID",
    "summaryDescription",
    "totalInvoiceAmount",
    "declaredCustomsValueAmount",
    "tariffDescription",
    "tariffCode",
    "insurancePremiumAmount",
    "grossWeightMeasure",
    "netWeightMeasure",
    "netNetWeightMeasure",
    "chargeableWeightMeasure",
    "grossVolumeMeasure",
    "netVolumeMeasure",
    "loadingLengthMeasure",
    "remarks",
    "hazardousRiskIndicator",
    "animalFoodIndicator",
    "humanFoodIndicator",
    "livestockIndicator",
    "bulkCargoIndicator",
    "containerizedIndicator",
    "generalCargoIndicator",
    "specialSecurityIndicator",
    "thirdPartyPayerIndicator",
    "carrierServiceInstructions",
    "customsClearanceServiceInstructions",
    "forwarderServiceInstructions",
    "specialServiceInstructions",
    "sequenceID",
    "shippingPriorityLevelCode",
    "handlingCode",
    "handlingInstructions",
    "information",
    "totalGoodsItemQuantity",
    "totalTransportHandlingUnitQuantity",
    "insuranceValueAmount",
    "declaredForCarriageValueAmount",
    "declaredStatisticsValueAmount",
    "freeOnBoardValueAmount",
    "specialInstructions",
    "splitConsignmentIndicator",
    "deliveryInstructions",
    "consignmentQuantity",
    "consolidatableIndicator",
    "haulageInstructions",
    "loadingSequenceID",
    "consigneeParty",
    "exporterParty",
    "consignorParty",
    "importerParty",
    "carrierParty",
    "freightForwarderParty",
    "notifyParty",
    "originalDespatchParty",
    "finalDeliveryParty",
    "performingCarrierParty",
    "substituteCarrierParty",
    "logisticsOperatorParty",
    "transportAdvisorParty",
    "hazardousItemNotificationParty",
    "insuranceParty",
    "mortgageHolderParty",
    "billOfLadingHolderParty",
    "originalDepartureCountry",
    "finalDestinationCountry",
    "transitCountry",
    "transportContract",
    "originalDespatchTransportationService",
    "finalDeliveryTransportationService",
    "deliveryTerms",
    "paymentTerms",
    "collectPaymentTerms",
    "disbursementPaymentTerms",
    "prepaidPaymentTerms",
    "freightAllowanceCharge",
    "extraAllowanceCharge",
    "mainCarriageShipmentStage",
    "preCarriageShipmentStage",
    "onCarriageShipmentStage",
    "transportHandlingUnit",
    "firstArrivalPortLocation",
    "lastExitPortLocation",
    "consolidatedShipment"
})
public class ConsignmentType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected IDType id;
    @XmlElement(name = "CarrierAssignedID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CarrierAssignedIDType carrierAssignedID;
    @XmlElement(name = "ConsigneeAssignedID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ConsigneeAssignedIDType consigneeAssignedID;
    @XmlElement(name = "ConsignorAssignedID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ConsignorAssignedIDType consignorAssignedID;
    @XmlElement(name = "FreightForwarderAssignedID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected FreightForwarderAssignedIDType freightForwarderAssignedID;
    @XmlElement(name = "BrokerAssignedID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected BrokerAssignedIDType brokerAssignedID;
    @XmlElement(name = "ContractedCarrierAssignedID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ContractedCarrierAssignedIDType contractedCarrierAssignedID;
    @XmlElement(name = "PerformingCarrierAssignedID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PerformingCarrierAssignedIDType performingCarrierAssignedID;
    @XmlElement(name = "SummaryDescription", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<SummaryDescriptionType> summaryDescription;
    @XmlElement(name = "TotalInvoiceAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TotalInvoiceAmountType totalInvoiceAmount;
    @XmlElement(name = "DeclaredCustomsValueAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DeclaredCustomsValueAmountType declaredCustomsValueAmount;
    @XmlElement(name = "TariffDescription", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<TariffDescriptionType> tariffDescription;
    @XmlElement(name = "TariffCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TariffCodeType tariffCode;
    @XmlElement(name = "InsurancePremiumAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected InsurancePremiumAmountType insurancePremiumAmount;
    @XmlElement(name = "GrossWeightMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected GrossWeightMeasureType grossWeightMeasure;
    @XmlElement(name = "NetWeightMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected NetWeightMeasureType netWeightMeasure;
    @XmlElement(name = "NetNetWeightMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected NetNetWeightMeasureType netNetWeightMeasure;
    @XmlElement(name = "ChargeableWeightMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ChargeableWeightMeasureType chargeableWeightMeasure;
    @XmlElement(name = "GrossVolumeMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected GrossVolumeMeasureType grossVolumeMeasure;
    @XmlElement(name = "NetVolumeMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected NetVolumeMeasureType netVolumeMeasure;
    @XmlElement(name = "LoadingLengthMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LoadingLengthMeasureType loadingLengthMeasure;
    @XmlElement(name = "Remarks", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<RemarksType> remarks;
    @XmlElement(name = "HazardousRiskIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected HazardousRiskIndicatorType hazardousRiskIndicator;
    @XmlElement(name = "AnimalFoodIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AnimalFoodIndicatorType animalFoodIndicator;
    @XmlElement(name = "HumanFoodIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected HumanFoodIndicatorType humanFoodIndicator;
    @XmlElement(name = "LivestockIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LivestockIndicatorType livestockIndicator;
    @XmlElement(name = "BulkCargoIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected BulkCargoIndicatorType bulkCargoIndicator;
    @XmlElement(name = "ContainerizedIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ContainerizedIndicatorType containerizedIndicator;
    @XmlElement(name = "GeneralCargoIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected GeneralCargoIndicatorType generalCargoIndicator;
    @XmlElement(name = "SpecialSecurityIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SpecialSecurityIndicatorType specialSecurityIndicator;
    @XmlElement(name = "ThirdPartyPayerIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ThirdPartyPayerIndicatorType thirdPartyPayerIndicator;
    @XmlElement(name = "CarrierServiceInstructions", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CarrierServiceInstructionsType carrierServiceInstructions;
    @XmlElement(name = "CustomsClearanceServiceInstructions", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CustomsClearanceServiceInstructionsType customsClearanceServiceInstructions;
    @XmlElement(name = "ForwarderServiceInstructions", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ForwarderServiceInstructionsType forwarderServiceInstructions;
    @XmlElement(name = "SpecialServiceInstructions", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SpecialServiceInstructionsType specialServiceInstructions;
    @XmlElement(name = "SequenceID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SequenceIDType sequenceID;
    @XmlElement(name = "ShippingPriorityLevelCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ShippingPriorityLevelCodeType shippingPriorityLevelCode;
    @XmlElement(name = "HandlingCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected HandlingCodeType handlingCode;
    @XmlElement(name = "HandlingInstructions", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected HandlingInstructionsType handlingInstructions;
    @XmlElement(name = "Information", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected InformationType information;
    @XmlElement(name = "TotalGoodsItemQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TotalGoodsItemQuantityType totalGoodsItemQuantity;
    @XmlElement(name = "TotalTransportHandlingUnitQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TotalTransportHandlingUnitQuantityType totalTransportHandlingUnitQuantity;
    @XmlElement(name = "InsuranceValueAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected InsuranceValueAmountType insuranceValueAmount;
    @XmlElement(name = "DeclaredForCarriageValueAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DeclaredForCarriageValueAmountType declaredForCarriageValueAmount;
    @XmlElement(name = "DeclaredStatisticsValueAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DeclaredStatisticsValueAmountType declaredStatisticsValueAmount;
    @XmlElement(name = "FreeOnBoardValueAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected FreeOnBoardValueAmountType freeOnBoardValueAmount;
    @XmlElement(name = "SpecialInstructions", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<SpecialInstructionsType> specialInstructions;
    @XmlElement(name = "SplitConsignmentIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SplitConsignmentIndicatorType splitConsignmentIndicator;
    @XmlElement(name = "DeliveryInstructions", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DeliveryInstructionsType> deliveryInstructions;
    @XmlElement(name = "ConsignmentQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ConsignmentQuantityType consignmentQuantity;
    @XmlElement(name = "ConsolidatableIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ConsolidatableIndicatorType consolidatableIndicator;
    @XmlElement(name = "HaulageInstructions", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<HaulageInstructionsType> haulageInstructions;
    @XmlElement(name = "LoadingSequenceID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LoadingSequenceIDType loadingSequenceID;
    @XmlElement(name = "ConsigneeParty")
    protected PartyType consigneeParty;
    @XmlElement(name = "ExporterParty")
    protected PartyType exporterParty;
    @XmlElement(name = "ConsignorParty")
    protected PartyType consignorParty;
    @XmlElement(name = "ImporterParty")
    protected PartyType importerParty;
    @XmlElement(name = "CarrierParty")
    protected PartyType carrierParty;
    @XmlElement(name = "FreightForwarderParty")
    protected PartyType freightForwarderParty;
    @XmlElement(name = "NotifyParty")
    protected PartyType notifyParty;
    @XmlElement(name = "OriginalDespatchParty")
    protected PartyType originalDespatchParty;
    @XmlElement(name = "FinalDeliveryParty")
    protected PartyType finalDeliveryParty;
    @XmlElement(name = "PerformingCarrierParty")
    protected PartyType performingCarrierParty;
    @XmlElement(name = "SubstituteCarrierParty")
    protected PartyType substituteCarrierParty;
    @XmlElement(name = "LogisticsOperatorParty")
    protected PartyType logisticsOperatorParty;
    @XmlElement(name = "TransportAdvisorParty")
    protected PartyType transportAdvisorParty;
    @XmlElement(name = "HazardousItemNotificationParty")
    protected PartyType hazardousItemNotificationParty;
    @XmlElement(name = "InsuranceParty")
    protected PartyType insuranceParty;
    @XmlElement(name = "MortgageHolderParty")
    protected PartyType mortgageHolderParty;
    @XmlElement(name = "BillOfLadingHolderParty")
    protected PartyType billOfLadingHolderParty;
    @XmlElement(name = "OriginalDepartureCountry")
    protected CountryType originalDepartureCountry;
    @XmlElement(name = "FinalDestinationCountry")
    protected CountryType finalDestinationCountry;
    @XmlElement(name = "TransitCountry")
    protected List<CountryType> transitCountry;
    @XmlElement(name = "TransportContract")
    protected ContractType transportContract;
    @XmlElement(name = "OriginalDespatchTransportationService")
    protected TransportationServiceType originalDespatchTransportationService;
    @XmlElement(name = "FinalDeliveryTransportationService")
    protected TransportationServiceType finalDeliveryTransportationService;
    @XmlElement(name = "DeliveryTerms")
    protected DeliveryTermsType deliveryTerms;
    @XmlElement(name = "PaymentTerms")
    protected PaymentTermsType paymentTerms;
    @XmlElement(name = "CollectPaymentTerms")
    protected PaymentTermsType collectPaymentTerms;
    @XmlElement(name = "DisbursementPaymentTerms")
    protected PaymentTermsType disbursementPaymentTerms;
    @XmlElement(name = "PrepaidPaymentTerms")
    protected PaymentTermsType prepaidPaymentTerms;
    @XmlElement(name = "FreightAllowanceCharge")
    protected List<AllowanceChargeType> freightAllowanceCharge;
    @XmlElement(name = "ExtraAllowanceCharge")
    protected List<AllowanceChargeType> extraAllowanceCharge;
    @XmlElement(name = "MainCarriageShipmentStage")
    protected ShipmentStageType mainCarriageShipmentStage;
    @XmlElement(name = "PreCarriageShipmentStage")
    protected List<ShipmentStageType> preCarriageShipmentStage;
    @XmlElement(name = "OnCarriageShipmentStage")
    protected List<ShipmentStageType> onCarriageShipmentStage;
    @XmlElement(name = "TransportHandlingUnit")
    protected List<TransportHandlingUnitType> transportHandlingUnit;
    @XmlElement(name = "FirstArrivalPortLocation")
    protected LocationType firstArrivalPortLocation;
    @XmlElement(name = "LastExitPortLocation")
    protected LocationType lastExitPortLocation;
    @XmlElement(name = "ConsolidatedShipment")
    protected List<ShipmentType> consolidatedShipment;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setID(IDType value) {
        this.id = value;
    }

    /**
     * Gets the value of the carrierAssignedID property.
     * 
     * @return
     *     possible object is
     *     {@link CarrierAssignedIDType }
     *     
     */
    public CarrierAssignedIDType getCarrierAssignedID() {
        return carrierAssignedID;
    }

    /**
     * Sets the value of the carrierAssignedID property.
     * 
     * @param value
     *     allowed object is
     *     {@link CarrierAssignedIDType }
     *     
     */
    public void setCarrierAssignedID(CarrierAssignedIDType value) {
        this.carrierAssignedID = value;
    }

    /**
     * Gets the value of the consigneeAssignedID property.
     * 
     * @return
     *     possible object is
     *     {@link ConsigneeAssignedIDType }
     *     
     */
    public ConsigneeAssignedIDType getConsigneeAssignedID() {
        return consigneeAssignedID;
    }

    /**
     * Sets the value of the consigneeAssignedID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsigneeAssignedIDType }
     *     
     */
    public void setConsigneeAssignedID(ConsigneeAssignedIDType value) {
        this.consigneeAssignedID = value;
    }

    /**
     * Gets the value of the consignorAssignedID property.
     * 
     * @return
     *     possible object is
     *     {@link ConsignorAssignedIDType }
     *     
     */
    public ConsignorAssignedIDType getConsignorAssignedID() {
        return consignorAssignedID;
    }

    /**
     * Sets the value of the consignorAssignedID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsignorAssignedIDType }
     *     
     */
    public void setConsignorAssignedID(ConsignorAssignedIDType value) {
        this.consignorAssignedID = value;
    }

    /**
     * Gets the value of the freightForwarderAssignedID property.
     * 
     * @return
     *     possible object is
     *     {@link FreightForwarderAssignedIDType }
     *     
     */
    public FreightForwarderAssignedIDType getFreightForwarderAssignedID() {
        return freightForwarderAssignedID;
    }

    /**
     * Sets the value of the freightForwarderAssignedID property.
     * 
     * @param value
     *     allowed object is
     *     {@link FreightForwarderAssignedIDType }
     *     
     */
    public void setFreightForwarderAssignedID(FreightForwarderAssignedIDType value) {
        this.freightForwarderAssignedID = value;
    }

    /**
     * Gets the value of the brokerAssignedID property.
     * 
     * @return
     *     possible object is
     *     {@link BrokerAssignedIDType }
     *     
     */
    public BrokerAssignedIDType getBrokerAssignedID() {
        return brokerAssignedID;
    }

    /**
     * Sets the value of the brokerAssignedID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BrokerAssignedIDType }
     *     
     */
    public void setBrokerAssignedID(BrokerAssignedIDType value) {
        this.brokerAssignedID = value;
    }

    /**
     * Gets the value of the contractedCarrierAssignedID property.
     * 
     * @return
     *     possible object is
     *     {@link ContractedCarrierAssignedIDType }
     *     
     */
    public ContractedCarrierAssignedIDType getContractedCarrierAssignedID() {
        return contractedCarrierAssignedID;
    }

    /**
     * Sets the value of the contractedCarrierAssignedID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractedCarrierAssignedIDType }
     *     
     */
    public void setContractedCarrierAssignedID(ContractedCarrierAssignedIDType value) {
        this.contractedCarrierAssignedID = value;
    }

    /**
     * Gets the value of the performingCarrierAssignedID property.
     * 
     * @return
     *     possible object is
     *     {@link PerformingCarrierAssignedIDType }
     *     
     */
    public PerformingCarrierAssignedIDType getPerformingCarrierAssignedID() {
        return performingCarrierAssignedID;
    }

    /**
     * Sets the value of the performingCarrierAssignedID property.
     * 
     * @param value
     *     allowed object is
     *     {@link PerformingCarrierAssignedIDType }
     *     
     */
    public void setPerformingCarrierAssignedID(PerformingCarrierAssignedIDType value) {
        this.performingCarrierAssignedID = value;
    }

    /**
     * Gets the value of the summaryDescription property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the summaryDescription property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getSummaryDescription().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link SummaryDescriptionType }
     * 
     * 
     */
    public List<SummaryDescriptionType> getSummaryDescription() {
        if (summaryDescription == null) {
            summaryDescription = new ArrayList<SummaryDescriptionType>();
        }
        return this.summaryDescription;
    }

    /**
     * Gets the value of the totalInvoiceAmount property.
     * 
     * @return
     *     possible object is
     *     {@link TotalInvoiceAmountType }
     *     
     */
    public TotalInvoiceAmountType getTotalInvoiceAmount() {
        return totalInvoiceAmount;
    }

    /**
     * Sets the value of the totalInvoiceAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link TotalInvoiceAmountType }
     *     
     */
    public void setTotalInvoiceAmount(TotalInvoiceAmountType value) {
        this.totalInvoiceAmount = value;
    }

    /**
     * Gets the value of the declaredCustomsValueAmount property.
     * 
     * @return
     *     possible object is
     *     {@link DeclaredCustomsValueAmountType }
     *     
     */
    public DeclaredCustomsValueAmountType getDeclaredCustomsValueAmount() {
        return declaredCustomsValueAmount;
    }

    /**
     * Sets the value of the declaredCustomsValueAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeclaredCustomsValueAmountType }
     *     
     */
    public void setDeclaredCustomsValueAmount(DeclaredCustomsValueAmountType value) {
        this.declaredCustomsValueAmount = value;
    }

    /**
     * Gets the value of the tariffDescription property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the tariffDescription property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getTariffDescription().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link TariffDescriptionType }
     * 
     * 
     */
    public List<TariffDescriptionType> getTariffDescription() {
        if (tariffDescription == null) {
            tariffDescription = new ArrayList<TariffDescriptionType>();
        }
        return this.tariffDescription;
    }

    /**
     * Gets the value of the tariffCode property.
     * 
     * @return
     *     possible object is
     *     {@link TariffCodeType }
     *     
     */
    public TariffCodeType getTariffCode() {
        return tariffCode;
    }

    /**
     * Sets the value of the tariffCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TariffCodeType }
     *     
     */
    public void setTariffCode(TariffCodeType value) {
        this.tariffCode = value;
    }

    /**
     * Gets the value of the insurancePremiumAmount property.
     * 
     * @return
     *     possible object is
     *     {@link InsurancePremiumAmountType }
     *     
     */
    public InsurancePremiumAmountType getInsurancePremiumAmount() {
        return insurancePremiumAmount;
    }

    /**
     * Sets the value of the insurancePremiumAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link InsurancePremiumAmountType }
     *     
     */
    public void setInsurancePremiumAmount(InsurancePremiumAmountType value) {
        this.insurancePremiumAmount = value;
    }

    /**
     * Gets the value of the grossWeightMeasure property.
     * 
     * @return
     *     possible object is
     *     {@link GrossWeightMeasureType }
     *     
     */
    public GrossWeightMeasureType getGrossWeightMeasure() {
        return grossWeightMeasure;
    }

    /**
     * Sets the value of the grossWeightMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link GrossWeightMeasureType }
     *     
     */
    public void setGrossWeightMeasure(GrossWeightMeasureType value) {
        this.grossWeightMeasure = value;
    }

    /**
     * Gets the value of the netWeightMeasure property.
     * 
     * @return
     *     possible object is
     *     {@link NetWeightMeasureType }
     *     
     */
    public NetWeightMeasureType getNetWeightMeasure() {
        return netWeightMeasure;
    }

    /**
     * Sets the value of the netWeightMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetWeightMeasureType }
     *     
     */
    public void setNetWeightMeasure(NetWeightMeasureType value) {
        this.netWeightMeasure = value;
    }

    /**
     * Gets the value of the netNetWeightMeasure property.
     * 
     * @return
     *     possible object is
     *     {@link NetNetWeightMeasureType }
     *     
     */
    public NetNetWeightMeasureType getNetNetWeightMeasure() {
        return netNetWeightMeasure;
    }

    /**
     * Sets the value of the netNetWeightMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetNetWeightMeasureType }
     *     
     */
    public void setNetNetWeightMeasure(NetNetWeightMeasureType value) {
        this.netNetWeightMeasure = value;
    }

    /**
     * Gets the value of the chargeableWeightMeasure property.
     * 
     * @return
     *     possible object is
     *     {@link ChargeableWeightMeasureType }
     *     
     */
    public ChargeableWeightMeasureType getChargeableWeightMeasure() {
        return chargeableWeightMeasure;
    }

    /**
     * Sets the value of the chargeableWeightMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChargeableWeightMeasureType }
     *     
     */
    public void setChargeableWeightMeasure(ChargeableWeightMeasureType value) {
        this.chargeableWeightMeasure = value;
    }

    /**
     * Gets the value of the grossVolumeMeasure property.
     * 
     * @return
     *     possible object is
     *     {@link GrossVolumeMeasureType }
     *     
     */
    public GrossVolumeMeasureType getGrossVolumeMeasure() {
        return grossVolumeMeasure;
    }

    /**
     * Sets the value of the grossVolumeMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link GrossVolumeMeasureType }
     *     
     */
    public void setGrossVolumeMeasure(GrossVolumeMeasureType value) {
        this.grossVolumeMeasure = value;
    }

    /**
     * Gets the value of the netVolumeMeasure property.
     * 
     * @return
     *     possible object is
     *     {@link NetVolumeMeasureType }
     *     
     */
    public NetVolumeMeasureType getNetVolumeMeasure() {
        return netVolumeMeasure;
    }

    /**
     * Sets the value of the netVolumeMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetVolumeMeasureType }
     *     
     */
    public void setNetVolumeMeasure(NetVolumeMeasureType value) {
        this.netVolumeMeasure = value;
    }

    /**
     * Gets the value of the loadingLengthMeasure property.
     * 
     * @return
     *     possible object is
     *     {@link LoadingLengthMeasureType }
     *     
     */
    public LoadingLengthMeasureType getLoadingLengthMeasure() {
        return loadingLengthMeasure;
    }

    /**
     * Sets the value of the loadingLengthMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoadingLengthMeasureType }
     *     
     */
    public void setLoadingLengthMeasure(LoadingLengthMeasureType value) {
        this.loadingLengthMeasure = value;
    }

    /**
     * Gets the value of the remarks property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the remarks property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getRemarks().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link RemarksType }
     * 
     * 
     */
    public List<RemarksType> getRemarks() {
        if (remarks == null) {
            remarks = new ArrayList<RemarksType>();
        }
        return this.remarks;
    }

    /**
     * Gets the value of the hazardousRiskIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link HazardousRiskIndicatorType }
     *     
     */
    public HazardousRiskIndicatorType getHazardousRiskIndicator() {
        return hazardousRiskIndicator;
    }

    /**
     * Sets the value of the hazardousRiskIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link HazardousRiskIndicatorType }
     *     
     */
    public void setHazardousRiskIndicator(HazardousRiskIndicatorType value) {
        this.hazardousRiskIndicator = value;
    }

    /**
     * Gets the value of the animalFoodIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link AnimalFoodIndicatorType }
     *     
     */
    public AnimalFoodIndicatorType getAnimalFoodIndicator() {
        return animalFoodIndicator;
    }

    /**
     * Sets the value of the animalFoodIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnimalFoodIndicatorType }
     *     
     */
    public void setAnimalFoodIndicator(AnimalFoodIndicatorType value) {
        this.animalFoodIndicator = value;
    }

    /**
     * Gets the value of the humanFoodIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link HumanFoodIndicatorType }
     *     
     */
    public HumanFoodIndicatorType getHumanFoodIndicator() {
        return humanFoodIndicator;
    }

    /**
     * Sets the value of the humanFoodIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link HumanFoodIndicatorType }
     *     
     */
    public void setHumanFoodIndicator(HumanFoodIndicatorType value) {
        this.humanFoodIndicator = value;
    }

    /**
     * Gets the value of the livestockIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link LivestockIndicatorType }
     *     
     */
    public LivestockIndicatorType getLivestockIndicator() {
        return livestockIndicator;
    }

    /**
     * Sets the value of the livestockIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link LivestockIndicatorType }
     *     
     */
    public void setLivestockIndicator(LivestockIndicatorType value) {
        this.livestockIndicator = value;
    }

    /**
     * Gets the value of the bulkCargoIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link BulkCargoIndicatorType }
     *     
     */
    public BulkCargoIndicatorType getBulkCargoIndicator() {
        return bulkCargoIndicator;
    }

    /**
     * Sets the value of the bulkCargoIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link BulkCargoIndicatorType }
     *     
     */
    public void setBulkCargoIndicator(BulkCargoIndicatorType value) {
        this.bulkCargoIndicator = value;
    }

    /**
     * Gets the value of the containerizedIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link ContainerizedIndicatorType }
     *     
     */
    public ContainerizedIndicatorType getContainerizedIndicator() {
        return containerizedIndicator;
    }

    /**
     * Sets the value of the containerizedIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContainerizedIndicatorType }
     *     
     */
    public void setContainerizedIndicator(ContainerizedIndicatorType value) {
        this.containerizedIndicator = value;
    }

    /**
     * Gets the value of the generalCargoIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link GeneralCargoIndicatorType }
     *     
     */
    public GeneralCargoIndicatorType getGeneralCargoIndicator() {
        return generalCargoIndicator;
    }

    /**
     * Sets the value of the generalCargoIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeneralCargoIndicatorType }
     *     
     */
    public void setGeneralCargoIndicator(GeneralCargoIndicatorType value) {
        this.generalCargoIndicator = value;
    }

    /**
     * Gets the value of the specialSecurityIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link SpecialSecurityIndicatorType }
     *     
     */
    public SpecialSecurityIndicatorType getSpecialSecurityIndicator() {
        return specialSecurityIndicator;
    }

    /**
     * Sets the value of the specialSecurityIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecialSecurityIndicatorType }
     *     
     */
    public void setSpecialSecurityIndicator(SpecialSecurityIndicatorType value) {
        this.specialSecurityIndicator = value;
    }

    /**
     * Gets the value of the thirdPartyPayerIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link ThirdPartyPayerIndicatorType }
     *     
     */
    public ThirdPartyPayerIndicatorType getThirdPartyPayerIndicator() {
        return thirdPartyPayerIndicator;
    }

    /**
     * Sets the value of the thirdPartyPayerIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link ThirdPartyPayerIndicatorType }
     *     
     */
    public void setThirdPartyPayerIndicator(ThirdPartyPayerIndicatorType value) {
        this.thirdPartyPayerIndicator = value;
    }

    /**
     * Gets the value of the carrierServiceInstructions property.
     * 
     * @return
     *     possible object is
     *     {@link CarrierServiceInstructionsType }
     *     
     */
    public CarrierServiceInstructionsType getCarrierServiceInstructions() {
        return carrierServiceInstructions;
    }

    /**
     * Sets the value of the carrierServiceInstructions property.
     * 
     * @param value
     *     allowed object is
     *     {@link CarrierServiceInstructionsType }
     *     
     */
    public void setCarrierServiceInstructions(CarrierServiceInstructionsType value) {
        this.carrierServiceInstructions = value;
    }

    /**
     * Gets the value of the customsClearanceServiceInstructions property.
     * 
     * @return
     *     possible object is
     *     {@link CustomsClearanceServiceInstructionsType }
     *     
     */
    public CustomsClearanceServiceInstructionsType getCustomsClearanceServiceInstructions() {
        return customsClearanceServiceInstructions;
    }

    /**
     * Sets the value of the customsClearanceServiceInstructions property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomsClearanceServiceInstructionsType }
     *     
     */
    public void setCustomsClearanceServiceInstructions(CustomsClearanceServiceInstructionsType value) {
        this.customsClearanceServiceInstructions = value;
    }

    /**
     * Gets the value of the forwarderServiceInstructions property.
     * 
     * @return
     *     possible object is
     *     {@link ForwarderServiceInstructionsType }
     *     
     */
    public ForwarderServiceInstructionsType getForwarderServiceInstructions() {
        return forwarderServiceInstructions;
    }

    /**
     * Sets the value of the forwarderServiceInstructions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ForwarderServiceInstructionsType }
     *     
     */
    public void setForwarderServiceInstructions(ForwarderServiceInstructionsType value) {
        this.forwarderServiceInstructions = value;
    }

    /**
     * Gets the value of the specialServiceInstructions property.
     * 
     * @return
     *     possible object is
     *     {@link SpecialServiceInstructionsType }
     *     
     */
    public SpecialServiceInstructionsType getSpecialServiceInstructions() {
        return specialServiceInstructions;
    }

    /**
     * Sets the value of the specialServiceInstructions property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecialServiceInstructionsType }
     *     
     */
    public void setSpecialServiceInstructions(SpecialServiceInstructionsType value) {
        this.specialServiceInstructions = value;
    }

    /**
     * Gets the value of the sequenceID property.
     * 
     * @return
     *     possible object is
     *     {@link SequenceIDType }
     *     
     */
    public SequenceIDType getSequenceID() {
        return sequenceID;
    }

    /**
     * Sets the value of the sequenceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link SequenceIDType }
     *     
     */
    public void setSequenceID(SequenceIDType value) {
        this.sequenceID = value;
    }

    /**
     * Gets the value of the shippingPriorityLevelCode property.
     * 
     * @return
     *     possible object is
     *     {@link ShippingPriorityLevelCodeType }
     *     
     */
    public ShippingPriorityLevelCodeType getShippingPriorityLevelCode() {
        return shippingPriorityLevelCode;
    }

    /**
     * Sets the value of the shippingPriorityLevelCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShippingPriorityLevelCodeType }
     *     
     */
    public void setShippingPriorityLevelCode(ShippingPriorityLevelCodeType value) {
        this.shippingPriorityLevelCode = value;
    }

    /**
     * Gets the value of the handlingCode property.
     * 
     * @return
     *     possible object is
     *     {@link HandlingCodeType }
     *     
     */
    public HandlingCodeType getHandlingCode() {
        return handlingCode;
    }

    /**
     * Sets the value of the handlingCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link HandlingCodeType }
     *     
     */
    public void setHandlingCode(HandlingCodeType value) {
        this.handlingCode = value;
    }

    /**
     * Gets the value of the handlingInstructions property.
     * 
     * @return
     *     possible object is
     *     {@link HandlingInstructionsType }
     *     
     */
    public HandlingInstructionsType getHandlingInstructions() {
        return handlingInstructions;
    }

    /**
     * Sets the value of the handlingInstructions property.
     * 
     * @param value
     *     allowed object is
     *     {@link HandlingInstructionsType }
     *     
     */
    public void setHandlingInstructions(HandlingInstructionsType value) {
        this.handlingInstructions = value;
    }

    /**
     * Gets the value of the information property.
     * 
     * @return
     *     possible object is
     *     {@link InformationType }
     *     
     */
    public InformationType getInformation() {
        return information;
    }

    /**
     * Sets the value of the information property.
     * 
     * @param value
     *     allowed object is
     *     {@link InformationType }
     *     
     */
    public void setInformation(InformationType value) {
        this.information = value;
    }

    /**
     * Gets the value of the totalGoodsItemQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link TotalGoodsItemQuantityType }
     *     
     */
    public TotalGoodsItemQuantityType getTotalGoodsItemQuantity() {
        return totalGoodsItemQuantity;
    }

    /**
     * Sets the value of the totalGoodsItemQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link TotalGoodsItemQuantityType }
     *     
     */
    public void setTotalGoodsItemQuantity(TotalGoodsItemQuantityType value) {
        this.totalGoodsItemQuantity = value;
    }

    /**
     * Gets the value of the totalTransportHandlingUnitQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link TotalTransportHandlingUnitQuantityType }
     *     
     */
    public TotalTransportHandlingUnitQuantityType getTotalTransportHandlingUnitQuantity() {
        return totalTransportHandlingUnitQuantity;
    }

    /**
     * Sets the value of the totalTransportHandlingUnitQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link TotalTransportHandlingUnitQuantityType }
     *     
     */
    public void setTotalTransportHandlingUnitQuantity(TotalTransportHandlingUnitQuantityType value) {
        this.totalTransportHandlingUnitQuantity = value;
    }

    /**
     * Gets the value of the insuranceValueAmount property.
     * 
     * @return
     *     possible object is
     *     {@link InsuranceValueAmountType }
     *     
     */
    public InsuranceValueAmountType getInsuranceValueAmount() {
        return insuranceValueAmount;
    }

    /**
     * Sets the value of the insuranceValueAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link InsuranceValueAmountType }
     *     
     */
    public void setInsuranceValueAmount(InsuranceValueAmountType value) {
        this.insuranceValueAmount = value;
    }

    /**
     * Gets the value of the declaredForCarriageValueAmount property.
     * 
     * @return
     *     possible object is
     *     {@link DeclaredForCarriageValueAmountType }
     *     
     */
    public DeclaredForCarriageValueAmountType getDeclaredForCarriageValueAmount() {
        return declaredForCarriageValueAmount;
    }

    /**
     * Sets the value of the declaredForCarriageValueAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeclaredForCarriageValueAmountType }
     *     
     */
    public void setDeclaredForCarriageValueAmount(DeclaredForCarriageValueAmountType value) {
        this.declaredForCarriageValueAmount = value;
    }

    /**
     * Gets the value of the declaredStatisticsValueAmount property.
     * 
     * @return
     *     possible object is
     *     {@link DeclaredStatisticsValueAmountType }
     *     
     */
    public DeclaredStatisticsValueAmountType getDeclaredStatisticsValueAmount() {
        return declaredStatisticsValueAmount;
    }

    /**
     * Sets the value of the declaredStatisticsValueAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeclaredStatisticsValueAmountType }
     *     
     */
    public void setDeclaredStatisticsValueAmount(DeclaredStatisticsValueAmountType value) {
        this.declaredStatisticsValueAmount = value;
    }

    /**
     * Gets the value of the freeOnBoardValueAmount property.
     * 
     * @return
     *     possible object is
     *     {@link FreeOnBoardValueAmountType }
     *     
     */
    public FreeOnBoardValueAmountType getFreeOnBoardValueAmount() {
        return freeOnBoardValueAmount;
    }

    /**
     * Sets the value of the freeOnBoardValueAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link FreeOnBoardValueAmountType }
     *     
     */
    public void setFreeOnBoardValueAmount(FreeOnBoardValueAmountType value) {
        this.freeOnBoardValueAmount = value;
    }

    /**
     * Gets the value of the specialInstructions property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the specialInstructions property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getSpecialInstructions().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link SpecialInstructionsType }
     * 
     * 
     */
    public List<SpecialInstructionsType> getSpecialInstructions() {
        if (specialInstructions == null) {
            specialInstructions = new ArrayList<SpecialInstructionsType>();
        }
        return this.specialInstructions;
    }

    /**
     * Gets the value of the splitConsignmentIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link SplitConsignmentIndicatorType }
     *     
     */
    public SplitConsignmentIndicatorType getSplitConsignmentIndicator() {
        return splitConsignmentIndicator;
    }

    /**
     * Sets the value of the splitConsignmentIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link SplitConsignmentIndicatorType }
     *     
     */
    public void setSplitConsignmentIndicator(SplitConsignmentIndicatorType value) {
        this.splitConsignmentIndicator = value;
    }

    /**
     * Gets the value of the deliveryInstructions property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the deliveryInstructions property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getDeliveryInstructions().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link DeliveryInstructionsType }
     * 
     * 
     */
    public List<DeliveryInstructionsType> getDeliveryInstructions() {
        if (deliveryInstructions == null) {
            deliveryInstructions = new ArrayList<DeliveryInstructionsType>();
        }
        return this.deliveryInstructions;
    }

    /**
     * Gets the value of the consignmentQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link ConsignmentQuantityType }
     *     
     */
    public ConsignmentQuantityType getConsignmentQuantity() {
        return consignmentQuantity;
    }

    /**
     * Sets the value of the consignmentQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsignmentQuantityType }
     *     
     */
    public void setConsignmentQuantity(ConsignmentQuantityType value) {
        this.consignmentQuantity = value;
    }

    /**
     * Gets the value of the consolidatableIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link ConsolidatableIndicatorType }
     *     
     */
    public ConsolidatableIndicatorType getConsolidatableIndicator() {
        return consolidatableIndicator;
    }

    /**
     * Sets the value of the consolidatableIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsolidatableIndicatorType }
     *     
     */
    public void setConsolidatableIndicator(ConsolidatableIndicatorType value) {
        this.consolidatableIndicator = value;
    }

    /**
     * Gets the value of the haulageInstructions property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the haulageInstructions property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getHaulageInstructions().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link HaulageInstructionsType }
     * 
     * 
     */
    public List<HaulageInstructionsType> getHaulageInstructions() {
        if (haulageInstructions == null) {
            haulageInstructions = new ArrayList<HaulageInstructionsType>();
        }
        return this.haulageInstructions;
    }

    /**
     * Gets the value of the loadingSequenceID property.
     * 
     * @return
     *     possible object is
     *     {@link LoadingSequenceIDType }
     *     
     */
    public LoadingSequenceIDType getLoadingSequenceID() {
        return loadingSequenceID;
    }

    /**
     * Sets the value of the loadingSequenceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoadingSequenceIDType }
     *     
     */
    public void setLoadingSequenceID(LoadingSequenceIDType value) {
        this.loadingSequenceID = value;
    }

    /**
     * Gets the value of the consigneeParty property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getConsigneeParty() {
        return consigneeParty;
    }

    /**
     * Sets the value of the consigneeParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setConsigneeParty(PartyType value) {
        this.consigneeParty = value;
    }

    /**
     * Gets the value of the exporterParty property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getExporterParty() {
        return exporterParty;
    }

    /**
     * Sets the value of the exporterParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setExporterParty(PartyType value) {
        this.exporterParty = value;
    }

    /**
     * Gets the value of the consignorParty property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getConsignorParty() {
        return consignorParty;
    }

    /**
     * Sets the value of the consignorParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setConsignorParty(PartyType value) {
        this.consignorParty = value;
    }

    /**
     * Gets the value of the importerParty property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getImporterParty() {
        return importerParty;
    }

    /**
     * Sets the value of the importerParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setImporterParty(PartyType value) {
        this.importerParty = value;
    }

    /**
     * Gets the value of the carrierParty property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getCarrierParty() {
        return carrierParty;
    }

    /**
     * Sets the value of the carrierParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setCarrierParty(PartyType value) {
        this.carrierParty = value;
    }

    /**
     * Gets the value of the freightForwarderParty property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getFreightForwarderParty() {
        return freightForwarderParty;
    }

    /**
     * Sets the value of the freightForwarderParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setFreightForwarderParty(PartyType value) {
        this.freightForwarderParty = value;
    }

    /**
     * Gets the value of the notifyParty property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getNotifyParty() {
        return notifyParty;
    }

    /**
     * Sets the value of the notifyParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setNotifyParty(PartyType value) {
        this.notifyParty = value;
    }

    /**
     * Gets the value of the originalDespatchParty property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getOriginalDespatchParty() {
        return originalDespatchParty;
    }

    /**
     * Sets the value of the originalDespatchParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setOriginalDespatchParty(PartyType value) {
        this.originalDespatchParty = value;
    }

    /**
     * Gets the value of the finalDeliveryParty property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getFinalDeliveryParty() {
        return finalDeliveryParty;
    }

    /**
     * Sets the value of the finalDeliveryParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setFinalDeliveryParty(PartyType value) {
        this.finalDeliveryParty = value;
    }

    /**
     * Gets the value of the performingCarrierParty property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getPerformingCarrierParty() {
        return performingCarrierParty;
    }

    /**
     * Sets the value of the performingCarrierParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setPerformingCarrierParty(PartyType value) {
        this.performingCarrierParty = value;
    }

    /**
     * Gets the value of the substituteCarrierParty property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getSubstituteCarrierParty() {
        return substituteCarrierParty;
    }

    /**
     * Sets the value of the substituteCarrierParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setSubstituteCarrierParty(PartyType value) {
        this.substituteCarrierParty = value;
    }

    /**
     * Gets the value of the logisticsOperatorParty property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getLogisticsOperatorParty() {
        return logisticsOperatorParty;
    }

    /**
     * Sets the value of the logisticsOperatorParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setLogisticsOperatorParty(PartyType value) {
        this.logisticsOperatorParty = value;
    }

    /**
     * Gets the value of the transportAdvisorParty property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getTransportAdvisorParty() {
        return transportAdvisorParty;
    }

    /**
     * Sets the value of the transportAdvisorParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setTransportAdvisorParty(PartyType value) {
        this.transportAdvisorParty = value;
    }

    /**
     * Gets the value of the hazardousItemNotificationParty property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getHazardousItemNotificationParty() {
        return hazardousItemNotificationParty;
    }

    /**
     * Sets the value of the hazardousItemNotificationParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setHazardousItemNotificationParty(PartyType value) {
        this.hazardousItemNotificationParty = value;
    }

    /**
     * Gets the value of the insuranceParty property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getInsuranceParty() {
        return insuranceParty;
    }

    /**
     * Sets the value of the insuranceParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setInsuranceParty(PartyType value) {
        this.insuranceParty = value;
    }

    /**
     * Gets the value of the mortgageHolderParty property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getMortgageHolderParty() {
        return mortgageHolderParty;
    }

    /**
     * Sets the value of the mortgageHolderParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setMortgageHolderParty(PartyType value) {
        this.mortgageHolderParty = value;
    }

    /**
     * Gets the value of the billOfLadingHolderParty property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getBillOfLadingHolderParty() {
        return billOfLadingHolderParty;
    }

    /**
     * Sets the value of the billOfLadingHolderParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setBillOfLadingHolderParty(PartyType value) {
        this.billOfLadingHolderParty = value;
    }

    /**
     * Gets the value of the originalDepartureCountry property.
     * 
     * @return
     *     possible object is
     *     {@link CountryType }
     *     
     */
    public CountryType getOriginalDepartureCountry() {
        return originalDepartureCountry;
    }

    /**
     * Sets the value of the originalDepartureCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link CountryType }
     *     
     */
    public void setOriginalDepartureCountry(CountryType value) {
        this.originalDepartureCountry = value;
    }

    /**
     * Gets the value of the finalDestinationCountry property.
     * 
     * @return
     *     possible object is
     *     {@link CountryType }
     *     
     */
    public CountryType getFinalDestinationCountry() {
        return finalDestinationCountry;
    }

    /**
     * Sets the value of the finalDestinationCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link CountryType }
     *     
     */
    public void setFinalDestinationCountry(CountryType value) {
        this.finalDestinationCountry = value;
    }

    /**
     * Gets the value of the transitCountry property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the transitCountry property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getTransitCountry().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link CountryType }
     * 
     * 
     */
    public List<CountryType> getTransitCountry() {
        if (transitCountry == null) {
            transitCountry = new ArrayList<CountryType>();
        }
        return this.transitCountry;
    }

    /**
     * Gets the value of the transportContract property.
     * 
     * @return
     *     possible object is
     *     {@link ContractType }
     *     
     */
    public ContractType getTransportContract() {
        return transportContract;
    }

    /**
     * Sets the value of the transportContract property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractType }
     *     
     */
    public void setTransportContract(ContractType value) {
        this.transportContract = value;
    }

    /**
     * Gets the value of the originalDespatchTransportationService property.
     * 
     * @return
     *     possible object is
     *     {@link TransportationServiceType }
     *     
     */
    public TransportationServiceType getOriginalDespatchTransportationService() {
        return originalDespatchTransportationService;
    }

    /**
     * Sets the value of the originalDespatchTransportationService property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportationServiceType }
     *     
     */
    public void setOriginalDespatchTransportationService(TransportationServiceType value) {
        this.originalDespatchTransportationService = value;
    }

    /**
     * Gets the value of the finalDeliveryTransportationService property.
     * 
     * @return
     *     possible object is
     *     {@link TransportationServiceType }
     *     
     */
    public TransportationServiceType getFinalDeliveryTransportationService() {
        return finalDeliveryTransportationService;
    }

    /**
     * Sets the value of the finalDeliveryTransportationService property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportationServiceType }
     *     
     */
    public void setFinalDeliveryTransportationService(TransportationServiceType value) {
        this.finalDeliveryTransportationService = value;
    }

    /**
     * Gets the value of the deliveryTerms property.
     * 
     * @return
     *     possible object is
     *     {@link DeliveryTermsType }
     *     
     */
    public DeliveryTermsType getDeliveryTerms() {
        return deliveryTerms;
    }

    /**
     * Sets the value of the deliveryTerms property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeliveryTermsType }
     *     
     */
    public void setDeliveryTerms(DeliveryTermsType value) {
        this.deliveryTerms = value;
    }

    /**
     * Gets the value of the paymentTerms property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentTermsType }
     *     
     */
    public PaymentTermsType getPaymentTerms() {
        return paymentTerms;
    }

    /**
     * Sets the value of the paymentTerms property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTermsType }
     *     
     */
    public void setPaymentTerms(PaymentTermsType value) {
        this.paymentTerms = value;
    }

    /**
     * Gets the value of the collectPaymentTerms property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentTermsType }
     *     
     */
    public PaymentTermsType getCollectPaymentTerms() {
        return collectPaymentTerms;
    }

    /**
     * Sets the value of the collectPaymentTerms property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTermsType }
     *     
     */
    public void setCollectPaymentTerms(PaymentTermsType value) {
        this.collectPaymentTerms = value;
    }

    /**
     * Gets the value of the disbursementPaymentTerms property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentTermsType }
     *     
     */
    public PaymentTermsType getDisbursementPaymentTerms() {
        return disbursementPaymentTerms;
    }

    /**
     * Sets the value of the disbursementPaymentTerms property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTermsType }
     *     
     */
    public void setDisbursementPaymentTerms(PaymentTermsType value) {
        this.disbursementPaymentTerms = value;
    }

    /**
     * Gets the value of the prepaidPaymentTerms property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentTermsType }
     *     
     */
    public PaymentTermsType getPrepaidPaymentTerms() {
        return prepaidPaymentTerms;
    }

    /**
     * Sets the value of the prepaidPaymentTerms property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTermsType }
     *     
     */
    public void setPrepaidPaymentTerms(PaymentTermsType value) {
        this.prepaidPaymentTerms = value;
    }

    /**
     * Gets the value of the freightAllowanceCharge property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the freightAllowanceCharge property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getFreightAllowanceCharge().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link AllowanceChargeType }
     * 
     * 
     */
    public List<AllowanceChargeType> getFreightAllowanceCharge() {
        if (freightAllowanceCharge == null) {
            freightAllowanceCharge = new ArrayList<AllowanceChargeType>();
        }
        return this.freightAllowanceCharge;
    }

    /**
     * Gets the value of the extraAllowanceCharge property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the extraAllowanceCharge property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getExtraAllowanceCharge().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link AllowanceChargeType }
     * 
     * 
     */
    public List<AllowanceChargeType> getExtraAllowanceCharge() {
        if (extraAllowanceCharge == null) {
            extraAllowanceCharge = new ArrayList<AllowanceChargeType>();
        }
        return this.extraAllowanceCharge;
    }

    /**
     * Gets the value of the mainCarriageShipmentStage property.
     * 
     * @return
     *     possible object is
     *     {@link ShipmentStageType }
     *     
     */
    public ShipmentStageType getMainCarriageShipmentStage() {
        return mainCarriageShipmentStage;
    }

    /**
     * Sets the value of the mainCarriageShipmentStage property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShipmentStageType }
     *     
     */
    public void setMainCarriageShipmentStage(ShipmentStageType value) {
        this.mainCarriageShipmentStage = value;
    }

    /**
     * Gets the value of the preCarriageShipmentStage property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the preCarriageShipmentStage property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getPreCarriageShipmentStage().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link ShipmentStageType }
     * 
     * 
     */
    public List<ShipmentStageType> getPreCarriageShipmentStage() {
        if (preCarriageShipmentStage == null) {
            preCarriageShipmentStage = new ArrayList<ShipmentStageType>();
        }
        return this.preCarriageShipmentStage;
    }

    /**
     * Gets the value of the onCarriageShipmentStage property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the onCarriageShipmentStage property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getOnCarriageShipmentStage().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link ShipmentStageType }
     * 
     * 
     */
    public List<ShipmentStageType> getOnCarriageShipmentStage() {
        if (onCarriageShipmentStage == null) {
            onCarriageShipmentStage = new ArrayList<ShipmentStageType>();
        }
        return this.onCarriageShipmentStage;
    }

    /**
     * Gets the value of the transportHandlingUnit property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the transportHandlingUnit property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getTransportHandlingUnit().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link TransportHandlingUnitType }
     * 
     * 
     */
    public List<TransportHandlingUnitType> getTransportHandlingUnit() {
        if (transportHandlingUnit == null) {
            transportHandlingUnit = new ArrayList<TransportHandlingUnitType>();
        }
        return this.transportHandlingUnit;
    }

    /**
     * Gets the value of the firstArrivalPortLocation property.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getFirstArrivalPortLocation() {
        return firstArrivalPortLocation;
    }

    /**
     * Sets the value of the firstArrivalPortLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setFirstArrivalPortLocation(LocationType value) {
        this.firstArrivalPortLocation = value;
    }

    /**
     * Gets the value of the lastExitPortLocation property.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getLastExitPortLocation() {
        return lastExitPortLocation;
    }

    /**
     * Sets the value of the lastExitPortLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setLastExitPortLocation(LocationType value) {
        this.lastExitPortLocation = value;
    }

    /**
     * Gets the value of the consolidatedShipment property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the consolidatedShipment property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getConsolidatedShipment().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link ShipmentType }
     * 
     * 
     */
    public List<ShipmentType> getConsolidatedShipment() {
        if (consolidatedShipment == null) {
            consolidatedShipment = new ArrayList<ShipmentType>();
        }
        return this.consolidatedShipment;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
