
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AirFlowPercentType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AnimalFoodApprovedIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CharacteristicsType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DamageRemarksType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DangerousGoodsApprovedIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DispositionCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FullnessIndicationCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.GrossVolumeMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.GrossWeightMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.HumanFoodApprovedIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.HumidityPercentType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InformationType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LegalStatusIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OwnerTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PowerIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ProviderTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ReferencedConsignmentIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RefrigeratedIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RefrigerationOnIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ReturnabilityIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SizeTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SpecialTransportRequirmentsType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TareWeightMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TraceIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TrackingDeviceCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TransportEquipmentTypeCodeType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for TransportEquipmentType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="TransportEquipmentType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ReferencedConsignmentID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TransportEquipmentTypeCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ProviderTypeCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}OwnerTypeCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SizeTypeCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DispositionCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FullnessIndicationCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RefrigerationOnIndicator" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Information" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ReturnabilityIndicator" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LegalStatusIndicator" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AirFlowPercent" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}HumidityPercent" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AnimalFoodApprovedIndicator" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}HumanFoodApprovedIndicator" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DangerousGoodsApprovedIndicator" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RefrigeratedIndicator" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Characteristics" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DamageRemarks" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Description" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SpecialTransportRequirments" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}GrossWeightMeasure" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}GrossVolumeMeasure" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TareWeightMeasure" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TrackingDeviceCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PowerIndicator" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TraceID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}MeasurementDimension" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TransportEquipmentSeal" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}MinimumTemperature" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}MaximumTemperature" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ProviderParty" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}LoadingProofParty" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}SupplierParty" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OwnerParty" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OperatingParty" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}LoadingLocation" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}UnloadingLocation" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}StorageLocation" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PositioningTransportEvent" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}QuarantineTransportEvent" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DeliveryTransportEvent" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PickupTransportEvent" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}HandlingTransportEvent" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}LoadingTransportEvent" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TransportEvent" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ApplicableTransportMeans" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}HaulageTradingTerms" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}HazardousGoodsTransit" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PackagedTransportHandlingUnit" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ServiceAllowanceCharge" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}FreightAllowanceCharge" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AttachedTransportEquipment" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}GoodsItem" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Delivery" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ContainedInTransportEquipment" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Pickup" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Despatch" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ShipmentDocumentReference" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransportEquipmentType", propOrder = {
    "id",
    "referencedConsignmentID",
    "transportEquipmentTypeCode",
    "providerTypeCode",
    "ownerTypeCode",
    "sizeTypeCode",
    "dispositionCode",
    "fullnessIndicationCode",
    "refrigerationOnIndicator",
    "information",
    "returnabilityIndicator",
    "legalStatusIndicator",
    "airFlowPercent",
    "humidityPercent",
    "animalFoodApprovedIndicator",
    "humanFoodApprovedIndicator",
    "dangerousGoodsApprovedIndicator",
    "refrigeratedIndicator",
    "characteristics",
    "damageRemarks",
    "description",
    "specialTransportRequirments",
    "grossWeightMeasure",
    "grossVolumeMeasure",
    "tareWeightMeasure",
    "trackingDeviceCode",
    "powerIndicator",
    "traceID",
    "measurementDimension",
    "transportEquipmentSeal",
    "minimumTemperature",
    "maximumTemperature",
    "providerParty",
    "loadingProofParty",
    "supplierParty",
    "ownerParty",
    "operatingParty",
    "loadingLocation",
    "unloadingLocation",
    "storageLocation",
    "positioningTransportEvent",
    "quarantineTransportEvent",
    "deliveryTransportEvent",
    "pickupTransportEvent",
    "handlingTransportEvent",
    "loadingTransportEvent",
    "transportEvent",
    "applicableTransportMeans",
    "haulageTradingTerms",
    "hazardousGoodsTransit",
    "packagedTransportHandlingUnit",
    "serviceAllowanceCharge",
    "freightAllowanceCharge",
    "attachedTransportEquipment",
    "goodsItem",
    "delivery",
    "containedInTransportEquipment",
    "pickup",
    "despatch",
    "shipmentDocumentReference"
})
public class TransportEquipmentType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "ReferencedConsignmentID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ReferencedConsignmentIDType referencedConsignmentID;
    @XmlElement(name = "TransportEquipmentTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TransportEquipmentTypeCodeType transportEquipmentTypeCode;
    @XmlElement(name = "ProviderTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ProviderTypeCodeType providerTypeCode;
    @XmlElement(name = "OwnerTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected OwnerTypeCodeType ownerTypeCode;
    @XmlElement(name = "SizeTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SizeTypeCodeType sizeTypeCode;
    @XmlElement(name = "DispositionCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DispositionCodeType dispositionCode;
    @XmlElement(name = "FullnessIndicationCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected FullnessIndicationCodeType fullnessIndicationCode;
    @XmlElement(name = "RefrigerationOnIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RefrigerationOnIndicatorType refrigerationOnIndicator;
    @XmlElement(name = "Information", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected InformationType information;
    @XmlElement(name = "ReturnabilityIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ReturnabilityIndicatorType returnabilityIndicator;
    @XmlElement(name = "LegalStatusIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LegalStatusIndicatorType legalStatusIndicator;
    @XmlElement(name = "AirFlowPercent", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AirFlowPercentType airFlowPercent;
    @XmlElement(name = "HumidityPercent", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected HumidityPercentType humidityPercent;
    @XmlElement(name = "AnimalFoodApprovedIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AnimalFoodApprovedIndicatorType animalFoodApprovedIndicator;
    @XmlElement(name = "HumanFoodApprovedIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected HumanFoodApprovedIndicatorType humanFoodApprovedIndicator;
    @XmlElement(name = "DangerousGoodsApprovedIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DangerousGoodsApprovedIndicatorType dangerousGoodsApprovedIndicator;
    @XmlElement(name = "RefrigeratedIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RefrigeratedIndicatorType refrigeratedIndicator;
    @XmlElement(name = "Characteristics", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CharacteristicsType characteristics;
    @XmlElement(name = "DamageRemarks", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DamageRemarksType damageRemarks;
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DescriptionType description;
    @XmlElement(name = "SpecialTransportRequirments", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SpecialTransportRequirmentsType specialTransportRequirments;
    @XmlElement(name = "GrossWeightMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected GrossWeightMeasureType grossWeightMeasure;
    @XmlElement(name = "GrossVolumeMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected GrossVolumeMeasureType grossVolumeMeasure;
    @XmlElement(name = "TareWeightMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TareWeightMeasureType tareWeightMeasure;
    @XmlElement(name = "TrackingDeviceCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TrackingDeviceCodeType trackingDeviceCode;
    @XmlElement(name = "PowerIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PowerIndicatorType powerIndicator;
    @XmlElement(name = "TraceID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TraceIDType traceID;
    @XmlElement(name = "MeasurementDimension")
    protected List<DimensionType> measurementDimension;
    @XmlElement(name = "TransportEquipmentSeal")
    protected List<TransportEquipmentSealType> transportEquipmentSeal;
    @XmlElement(name = "MinimumTemperature")
    protected TemperatureType minimumTemperature;
    @XmlElement(name = "MaximumTemperature")
    protected TemperatureType maximumTemperature;
    @XmlElement(name = "ProviderParty")
    protected PartyType providerParty;
    @XmlElement(name = "LoadingProofParty")
    protected PartyType loadingProofParty;
    @XmlElement(name = "SupplierParty")
    protected SupplierPartyType supplierParty;
    @XmlElement(name = "OwnerParty")
    protected PartyType ownerParty;
    @XmlElement(name = "OperatingParty")
    protected PartyType operatingParty;
    @XmlElement(name = "LoadingLocation")
    protected LocationType loadingLocation;
    @XmlElement(name = "UnloadingLocation")
    protected LocationType unloadingLocation;
    @XmlElement(name = "StorageLocation")
    protected LocationType storageLocation;
    @XmlElement(name = "PositioningTransportEvent")
    protected List<TransportEventType> positioningTransportEvent;
    @XmlElement(name = "QuarantineTransportEvent")
    protected List<TransportEventType> quarantineTransportEvent;
    @XmlElement(name = "DeliveryTransportEvent")
    protected List<TransportEventType> deliveryTransportEvent;
    @XmlElement(name = "PickupTransportEvent")
    protected List<TransportEventType> pickupTransportEvent;
    @XmlElement(name = "HandlingTransportEvent")
    protected List<TransportEventType> handlingTransportEvent;
    @XmlElement(name = "LoadingTransportEvent")
    protected List<TransportEventType> loadingTransportEvent;
    @XmlElement(name = "TransportEvent")
    protected List<TransportEventType> transportEvent;
    @XmlElement(name = "ApplicableTransportMeans")
    protected TransportMeansType applicableTransportMeans;
    @XmlElement(name = "HaulageTradingTerms")
    protected List<TradingTermsType> haulageTradingTerms;
    @XmlElement(name = "HazardousGoodsTransit")
    protected List<HazardousGoodsTransitType> hazardousGoodsTransit;
    @XmlElement(name = "PackagedTransportHandlingUnit")
    protected List<TransportHandlingUnitType> packagedTransportHandlingUnit;
    @XmlElement(name = "ServiceAllowanceCharge")
    protected List<AllowanceChargeType> serviceAllowanceCharge;
    @XmlElement(name = "FreightAllowanceCharge")
    protected List<AllowanceChargeType> freightAllowanceCharge;
    @XmlElement(name = "AttachedTransportEquipment")
    protected List<TransportEquipmentType> attachedTransportEquipment;
    @XmlElement(name = "GoodsItem")
    protected List<GoodsItemType> goodsItem;
    @XmlElement(name = "Delivery")
    protected DeliveryType delivery;
    @XmlElement(name = "ContainedInTransportEquipment")
    protected List<TransportEquipmentType> containedInTransportEquipment;
    @XmlElement(name = "Pickup")
    protected PickupType pickup;
    @XmlElement(name = "Despatch")
    protected DespatchType despatch;
    @XmlElement(name = "ShipmentDocumentReference")
    protected DocumentReferenceType shipmentDocumentReference;

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
     * Gets the value of the referencedConsignmentID property.
     * 
     * @return
     *     possible object is
     *     {@link ReferencedConsignmentIDType }
     *     
     */
    public ReferencedConsignmentIDType getReferencedConsignmentID() {
        return referencedConsignmentID;
    }

    /**
     * Sets the value of the referencedConsignmentID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferencedConsignmentIDType }
     *     
     */
    public void setReferencedConsignmentID(ReferencedConsignmentIDType value) {
        this.referencedConsignmentID = value;
    }

    /**
     * Gets the value of the transportEquipmentTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link TransportEquipmentTypeCodeType }
     *     
     */
    public TransportEquipmentTypeCodeType getTransportEquipmentTypeCode() {
        return transportEquipmentTypeCode;
    }

    /**
     * Sets the value of the transportEquipmentTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEquipmentTypeCodeType }
     *     
     */
    public void setTransportEquipmentTypeCode(TransportEquipmentTypeCodeType value) {
        this.transportEquipmentTypeCode = value;
    }

    /**
     * Gets the value of the providerTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link ProviderTypeCodeType }
     *     
     */
    public ProviderTypeCodeType getProviderTypeCode() {
        return providerTypeCode;
    }

    /**
     * Sets the value of the providerTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProviderTypeCodeType }
     *     
     */
    public void setProviderTypeCode(ProviderTypeCodeType value) {
        this.providerTypeCode = value;
    }

    /**
     * Gets the value of the ownerTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link OwnerTypeCodeType }
     *     
     */
    public OwnerTypeCodeType getOwnerTypeCode() {
        return ownerTypeCode;
    }

    /**
     * Sets the value of the ownerTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link OwnerTypeCodeType }
     *     
     */
    public void setOwnerTypeCode(OwnerTypeCodeType value) {
        this.ownerTypeCode = value;
    }

    /**
     * Gets the value of the sizeTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link SizeTypeCodeType }
     *     
     */
    public SizeTypeCodeType getSizeTypeCode() {
        return sizeTypeCode;
    }

    /**
     * Sets the value of the sizeTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link SizeTypeCodeType }
     *     
     */
    public void setSizeTypeCode(SizeTypeCodeType value) {
        this.sizeTypeCode = value;
    }

    /**
     * Gets the value of the dispositionCode property.
     * 
     * @return
     *     possible object is
     *     {@link DispositionCodeType }
     *     
     */
    public DispositionCodeType getDispositionCode() {
        return dispositionCode;
    }

    /**
     * Sets the value of the dispositionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link DispositionCodeType }
     *     
     */
    public void setDispositionCode(DispositionCodeType value) {
        this.dispositionCode = value;
    }

    /**
     * Gets the value of the fullnessIndicationCode property.
     * 
     * @return
     *     possible object is
     *     {@link FullnessIndicationCodeType }
     *     
     */
    public FullnessIndicationCodeType getFullnessIndicationCode() {
        return fullnessIndicationCode;
    }

    /**
     * Sets the value of the fullnessIndicationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link FullnessIndicationCodeType }
     *     
     */
    public void setFullnessIndicationCode(FullnessIndicationCodeType value) {
        this.fullnessIndicationCode = value;
    }

    /**
     * Gets the value of the refrigerationOnIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link RefrigerationOnIndicatorType }
     *     
     */
    public RefrigerationOnIndicatorType getRefrigerationOnIndicator() {
        return refrigerationOnIndicator;
    }

    /**
     * Sets the value of the refrigerationOnIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link RefrigerationOnIndicatorType }
     *     
     */
    public void setRefrigerationOnIndicator(RefrigerationOnIndicatorType value) {
        this.refrigerationOnIndicator = value;
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
     * Gets the value of the returnabilityIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link ReturnabilityIndicatorType }
     *     
     */
    public ReturnabilityIndicatorType getReturnabilityIndicator() {
        return returnabilityIndicator;
    }

    /**
     * Sets the value of the returnabilityIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReturnabilityIndicatorType }
     *     
     */
    public void setReturnabilityIndicator(ReturnabilityIndicatorType value) {
        this.returnabilityIndicator = value;
    }

    /**
     * Gets the value of the legalStatusIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link LegalStatusIndicatorType }
     *     
     */
    public LegalStatusIndicatorType getLegalStatusIndicator() {
        return legalStatusIndicator;
    }

    /**
     * Sets the value of the legalStatusIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link LegalStatusIndicatorType }
     *     
     */
    public void setLegalStatusIndicator(LegalStatusIndicatorType value) {
        this.legalStatusIndicator = value;
    }

    /**
     * Gets the value of the airFlowPercent property.
     * 
     * @return
     *     possible object is
     *     {@link AirFlowPercentType }
     *     
     */
    public AirFlowPercentType getAirFlowPercent() {
        return airFlowPercent;
    }

    /**
     * Sets the value of the airFlowPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link AirFlowPercentType }
     *     
     */
    public void setAirFlowPercent(AirFlowPercentType value) {
        this.airFlowPercent = value;
    }

    /**
     * Gets the value of the humidityPercent property.
     * 
     * @return
     *     possible object is
     *     {@link HumidityPercentType }
     *     
     */
    public HumidityPercentType getHumidityPercent() {
        return humidityPercent;
    }

    /**
     * Sets the value of the humidityPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link HumidityPercentType }
     *     
     */
    public void setHumidityPercent(HumidityPercentType value) {
        this.humidityPercent = value;
    }

    /**
     * Gets the value of the animalFoodApprovedIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link AnimalFoodApprovedIndicatorType }
     *     
     */
    public AnimalFoodApprovedIndicatorType getAnimalFoodApprovedIndicator() {
        return animalFoodApprovedIndicator;
    }

    /**
     * Sets the value of the animalFoodApprovedIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnimalFoodApprovedIndicatorType }
     *     
     */
    public void setAnimalFoodApprovedIndicator(AnimalFoodApprovedIndicatorType value) {
        this.animalFoodApprovedIndicator = value;
    }

    /**
     * Gets the value of the humanFoodApprovedIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link HumanFoodApprovedIndicatorType }
     *     
     */
    public HumanFoodApprovedIndicatorType getHumanFoodApprovedIndicator() {
        return humanFoodApprovedIndicator;
    }

    /**
     * Sets the value of the humanFoodApprovedIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link HumanFoodApprovedIndicatorType }
     *     
     */
    public void setHumanFoodApprovedIndicator(HumanFoodApprovedIndicatorType value) {
        this.humanFoodApprovedIndicator = value;
    }

    /**
     * Gets the value of the dangerousGoodsApprovedIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link DangerousGoodsApprovedIndicatorType }
     *     
     */
    public DangerousGoodsApprovedIndicatorType getDangerousGoodsApprovedIndicator() {
        return dangerousGoodsApprovedIndicator;
    }

    /**
     * Sets the value of the dangerousGoodsApprovedIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link DangerousGoodsApprovedIndicatorType }
     *     
     */
    public void setDangerousGoodsApprovedIndicator(DangerousGoodsApprovedIndicatorType value) {
        this.dangerousGoodsApprovedIndicator = value;
    }

    /**
     * Gets the value of the refrigeratedIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link RefrigeratedIndicatorType }
     *     
     */
    public RefrigeratedIndicatorType getRefrigeratedIndicator() {
        return refrigeratedIndicator;
    }

    /**
     * Sets the value of the refrigeratedIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link RefrigeratedIndicatorType }
     *     
     */
    public void setRefrigeratedIndicator(RefrigeratedIndicatorType value) {
        this.refrigeratedIndicator = value;
    }

    /**
     * Gets the value of the characteristics property.
     * 
     * @return
     *     possible object is
     *     {@link CharacteristicsType }
     *     
     */
    public CharacteristicsType getCharacteristics() {
        return characteristics;
    }

    /**
     * Sets the value of the characteristics property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharacteristicsType }
     *     
     */
    public void setCharacteristics(CharacteristicsType value) {
        this.characteristics = value;
    }

    /**
     * Gets the value of the damageRemarks property.
     * 
     * @return
     *     possible object is
     *     {@link DamageRemarksType }
     *     
     */
    public DamageRemarksType getDamageRemarks() {
        return damageRemarks;
    }

    /**
     * Sets the value of the damageRemarks property.
     * 
     * @param value
     *     allowed object is
     *     {@link DamageRemarksType }
     *     
     */
    public void setDamageRemarks(DamageRemarksType value) {
        this.damageRemarks = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link DescriptionType }
     *     
     */
    public DescriptionType getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link DescriptionType }
     *     
     */
    public void setDescription(DescriptionType value) {
        this.description = value;
    }

    /**
     * Gets the value of the specialTransportRequirments property.
     * 
     * @return
     *     possible object is
     *     {@link SpecialTransportRequirmentsType }
     *     
     */
    public SpecialTransportRequirmentsType getSpecialTransportRequirments() {
        return specialTransportRequirments;
    }

    /**
     * Sets the value of the specialTransportRequirments property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecialTransportRequirmentsType }
     *     
     */
    public void setSpecialTransportRequirments(SpecialTransportRequirmentsType value) {
        this.specialTransportRequirments = value;
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
     * Gets the value of the tareWeightMeasure property.
     * 
     * @return
     *     possible object is
     *     {@link TareWeightMeasureType }
     *     
     */
    public TareWeightMeasureType getTareWeightMeasure() {
        return tareWeightMeasure;
    }

    /**
     * Sets the value of the tareWeightMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link TareWeightMeasureType }
     *     
     */
    public void setTareWeightMeasure(TareWeightMeasureType value) {
        this.tareWeightMeasure = value;
    }

    /**
     * Gets the value of the trackingDeviceCode property.
     * 
     * @return
     *     possible object is
     *     {@link TrackingDeviceCodeType }
     *     
     */
    public TrackingDeviceCodeType getTrackingDeviceCode() {
        return trackingDeviceCode;
    }

    /**
     * Sets the value of the trackingDeviceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackingDeviceCodeType }
     *     
     */
    public void setTrackingDeviceCode(TrackingDeviceCodeType value) {
        this.trackingDeviceCode = value;
    }

    /**
     * Gets the value of the powerIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link PowerIndicatorType }
     *     
     */
    public PowerIndicatorType getPowerIndicator() {
        return powerIndicator;
    }

    /**
     * Sets the value of the powerIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link PowerIndicatorType }
     *     
     */
    public void setPowerIndicator(PowerIndicatorType value) {
        this.powerIndicator = value;
    }

    /**
     * Gets the value of the traceID property.
     * 
     * @return
     *     possible object is
     *     {@link TraceIDType }
     *     
     */
    public TraceIDType getTraceID() {
        return traceID;
    }

    /**
     * Sets the value of the traceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link TraceIDType }
     *     
     */
    public void setTraceID(TraceIDType value) {
        this.traceID = value;
    }

    /**
     * Gets the value of the measurementDimension property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the measurementDimension property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getMeasurementDimension().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link DimensionType }
     * 
     * 
     */
    public List<DimensionType> getMeasurementDimension() {
        if (measurementDimension == null) {
            measurementDimension = new ArrayList<DimensionType>();
        }
        return this.measurementDimension;
    }

    /**
     * Gets the value of the transportEquipmentSeal property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the transportEquipmentSeal property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getTransportEquipmentSeal().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link TransportEquipmentSealType }
     * 
     * 
     */
    public List<TransportEquipmentSealType> getTransportEquipmentSeal() {
        if (transportEquipmentSeal == null) {
            transportEquipmentSeal = new ArrayList<TransportEquipmentSealType>();
        }
        return this.transportEquipmentSeal;
    }

    /**
     * Gets the value of the minimumTemperature property.
     * 
     * @return
     *     possible object is
     *     {@link TemperatureType }
     *     
     */
    public TemperatureType getMinimumTemperature() {
        return minimumTemperature;
    }

    /**
     * Sets the value of the minimumTemperature property.
     * 
     * @param value
     *     allowed object is
     *     {@link TemperatureType }
     *     
     */
    public void setMinimumTemperature(TemperatureType value) {
        this.minimumTemperature = value;
    }

    /**
     * Gets the value of the maximumTemperature property.
     * 
     * @return
     *     possible object is
     *     {@link TemperatureType }
     *     
     */
    public TemperatureType getMaximumTemperature() {
        return maximumTemperature;
    }

    /**
     * Sets the value of the maximumTemperature property.
     * 
     * @param value
     *     allowed object is
     *     {@link TemperatureType }
     *     
     */
    public void setMaximumTemperature(TemperatureType value) {
        this.maximumTemperature = value;
    }

    /**
     * Gets the value of the providerParty property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getProviderParty() {
        return providerParty;
    }

    /**
     * Sets the value of the providerParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setProviderParty(PartyType value) {
        this.providerParty = value;
    }

    /**
     * Gets the value of the loadingProofParty property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getLoadingProofParty() {
        return loadingProofParty;
    }

    /**
     * Sets the value of the loadingProofParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setLoadingProofParty(PartyType value) {
        this.loadingProofParty = value;
    }

    /**
     * Gets the value of the supplierParty property.
     * 
     * @return
     *     possible object is
     *     {@link SupplierPartyType }
     *     
     */
    public SupplierPartyType getSupplierParty() {
        return supplierParty;
    }

    /**
     * Sets the value of the supplierParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplierPartyType }
     *     
     */
    public void setSupplierParty(SupplierPartyType value) {
        this.supplierParty = value;
    }

    /**
     * Gets the value of the ownerParty property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getOwnerParty() {
        return ownerParty;
    }

    /**
     * Sets the value of the ownerParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setOwnerParty(PartyType value) {
        this.ownerParty = value;
    }

    /**
     * Gets the value of the operatingParty property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getOperatingParty() {
        return operatingParty;
    }

    /**
     * Sets the value of the operatingParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setOperatingParty(PartyType value) {
        this.operatingParty = value;
    }

    /**
     * Gets the value of the loadingLocation property.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getLoadingLocation() {
        return loadingLocation;
    }

    /**
     * Sets the value of the loadingLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setLoadingLocation(LocationType value) {
        this.loadingLocation = value;
    }

    /**
     * Gets the value of the unloadingLocation property.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getUnloadingLocation() {
        return unloadingLocation;
    }

    /**
     * Sets the value of the unloadingLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setUnloadingLocation(LocationType value) {
        this.unloadingLocation = value;
    }

    /**
     * Gets the value of the storageLocation property.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getStorageLocation() {
        return storageLocation;
    }

    /**
     * Sets the value of the storageLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setStorageLocation(LocationType value) {
        this.storageLocation = value;
    }

    /**
     * Gets the value of the positioningTransportEvent property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the positioningTransportEvent property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getPositioningTransportEvent().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link TransportEventType }
     * 
     * 
     */
    public List<TransportEventType> getPositioningTransportEvent() {
        if (positioningTransportEvent == null) {
            positioningTransportEvent = new ArrayList<TransportEventType>();
        }
        return this.positioningTransportEvent;
    }

    /**
     * Gets the value of the quarantineTransportEvent property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the quarantineTransportEvent property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getQuarantineTransportEvent().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link TransportEventType }
     * 
     * 
     */
    public List<TransportEventType> getQuarantineTransportEvent() {
        if (quarantineTransportEvent == null) {
            quarantineTransportEvent = new ArrayList<TransportEventType>();
        }
        return this.quarantineTransportEvent;
    }

    /**
     * Gets the value of the deliveryTransportEvent property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the deliveryTransportEvent property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getDeliveryTransportEvent().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link TransportEventType }
     * 
     * 
     */
    public List<TransportEventType> getDeliveryTransportEvent() {
        if (deliveryTransportEvent == null) {
            deliveryTransportEvent = new ArrayList<TransportEventType>();
        }
        return this.deliveryTransportEvent;
    }

    /**
     * Gets the value of the pickupTransportEvent property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the pickupTransportEvent property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getPickupTransportEvent().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link TransportEventType }
     * 
     * 
     */
    public List<TransportEventType> getPickupTransportEvent() {
        if (pickupTransportEvent == null) {
            pickupTransportEvent = new ArrayList<TransportEventType>();
        }
        return this.pickupTransportEvent;
    }

    /**
     * Gets the value of the handlingTransportEvent property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the handlingTransportEvent property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getHandlingTransportEvent().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link TransportEventType }
     * 
     * 
     */
    public List<TransportEventType> getHandlingTransportEvent() {
        if (handlingTransportEvent == null) {
            handlingTransportEvent = new ArrayList<TransportEventType>();
        }
        return this.handlingTransportEvent;
    }

    /**
     * Gets the value of the loadingTransportEvent property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the loadingTransportEvent property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getLoadingTransportEvent().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link TransportEventType }
     * 
     * 
     */
    public List<TransportEventType> getLoadingTransportEvent() {
        if (loadingTransportEvent == null) {
            loadingTransportEvent = new ArrayList<TransportEventType>();
        }
        return this.loadingTransportEvent;
    }

    /**
     * Gets the value of the transportEvent property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the transportEvent property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getTransportEvent().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link TransportEventType }
     * 
     * 
     */
    public List<TransportEventType> getTransportEvent() {
        if (transportEvent == null) {
            transportEvent = new ArrayList<TransportEventType>();
        }
        return this.transportEvent;
    }

    /**
     * Gets the value of the applicableTransportMeans property.
     * 
     * @return
     *     possible object is
     *     {@link TransportMeansType }
     *     
     */
    public TransportMeansType getApplicableTransportMeans() {
        return applicableTransportMeans;
    }

    /**
     * Sets the value of the applicableTransportMeans property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportMeansType }
     *     
     */
    public void setApplicableTransportMeans(TransportMeansType value) {
        this.applicableTransportMeans = value;
    }

    /**
     * Gets the value of the haulageTradingTerms property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the haulageTradingTerms property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getHaulageTradingTerms().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link TradingTermsType }
     * 
     * 
     */
    public List<TradingTermsType> getHaulageTradingTerms() {
        if (haulageTradingTerms == null) {
            haulageTradingTerms = new ArrayList<TradingTermsType>();
        }
        return this.haulageTradingTerms;
    }

    /**
     * Gets the value of the hazardousGoodsTransit property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the hazardousGoodsTransit property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getHazardousGoodsTransit().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link HazardousGoodsTransitType }
     * 
     * 
     */
    public List<HazardousGoodsTransitType> getHazardousGoodsTransit() {
        if (hazardousGoodsTransit == null) {
            hazardousGoodsTransit = new ArrayList<HazardousGoodsTransitType>();
        }
        return this.hazardousGoodsTransit;
    }

    /**
     * Gets the value of the packagedTransportHandlingUnit property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the packagedTransportHandlingUnit property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getPackagedTransportHandlingUnit().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link TransportHandlingUnitType }
     * 
     * 
     */
    public List<TransportHandlingUnitType> getPackagedTransportHandlingUnit() {
        if (packagedTransportHandlingUnit == null) {
            packagedTransportHandlingUnit = new ArrayList<TransportHandlingUnitType>();
        }
        return this.packagedTransportHandlingUnit;
    }

    /**
     * Gets the value of the serviceAllowanceCharge property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the serviceAllowanceCharge property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getServiceAllowanceCharge().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link AllowanceChargeType }
     * 
     * 
     */
    public List<AllowanceChargeType> getServiceAllowanceCharge() {
        if (serviceAllowanceCharge == null) {
            serviceAllowanceCharge = new ArrayList<AllowanceChargeType>();
        }
        return this.serviceAllowanceCharge;
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
     * Gets the value of the attachedTransportEquipment property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the attachedTransportEquipment property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getAttachedTransportEquipment().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link TransportEquipmentType }
     * 
     * 
     */
    public List<TransportEquipmentType> getAttachedTransportEquipment() {
        if (attachedTransportEquipment == null) {
            attachedTransportEquipment = new ArrayList<TransportEquipmentType>();
        }
        return this.attachedTransportEquipment;
    }

    /**
     * Gets the value of the goodsItem property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the goodsItem property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getGoodsItem().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link GoodsItemType }
     * 
     * 
     */
    public List<GoodsItemType> getGoodsItem() {
        if (goodsItem == null) {
            goodsItem = new ArrayList<GoodsItemType>();
        }
        return this.goodsItem;
    }

    /**
     * Gets the value of the delivery property.
     * 
     * @return
     *     possible object is
     *     {@link DeliveryType }
     *     
     */
    public DeliveryType getDelivery() {
        return delivery;
    }

    /**
     * Sets the value of the delivery property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeliveryType }
     *     
     */
    public void setDelivery(DeliveryType value) {
        this.delivery = value;
    }

    /**
     * Gets the value of the containedInTransportEquipment property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the containedInTransportEquipment property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getContainedInTransportEquipment().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link TransportEquipmentType }
     * 
     * 
     */
    public List<TransportEquipmentType> getContainedInTransportEquipment() {
        if (containedInTransportEquipment == null) {
            containedInTransportEquipment = new ArrayList<TransportEquipmentType>();
        }
        return this.containedInTransportEquipment;
    }

    /**
     * Gets the value of the pickup property.
     * 
     * @return
     *     possible object is
     *     {@link PickupType }
     *     
     */
    public PickupType getPickup() {
        return pickup;
    }

    /**
     * Sets the value of the pickup property.
     * 
     * @param value
     *     allowed object is
     *     {@link PickupType }
     *     
     */
    public void setPickup(PickupType value) {
        this.pickup = value;
    }

    /**
     * Gets the value of the despatch property.
     * 
     * @return
     *     possible object is
     *     {@link DespatchType }
     *     
     */
    public DespatchType getDespatch() {
        return despatch;
    }

    /**
     * Sets the value of the despatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link DespatchType }
     *     
     */
    public void setDespatch(DespatchType value) {
        this.despatch = value;
    }

    /**
     * Gets the value of the shipmentDocumentReference property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentReferenceType }
     *     
     */
    public DocumentReferenceType getShipmentDocumentReference() {
        return shipmentDocumentReference;
    }

    /**
     * Sets the value of the shipmentDocumentReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentReferenceType }
     *     
     */
    public void setShipmentDocumentReference(DocumentReferenceType value) {
        this.shipmentDocumentReference = value;
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
