
package ecf5.v2024_6.ietf.params.xml.ns.icalendar_2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for RecurType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RecurType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="freq" type="{urn:ietf:params:xml:ns:icalendar-2.0}FreqRecurType"/&gt;
 *         &lt;sequence&gt;
 *           &lt;choice minOccurs="0"&gt;
 *             &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}until"/&gt;
 *             &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}count"/&gt;
 *           &lt;/choice&gt;
 *         &lt;/sequence&gt;
 *         &lt;element name="interval" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="bysecond" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="byminute" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="byhour" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="byday" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="byyearday" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="bymonthday" type="{urn:ietf:params:xml:ns:icalendar-2.0}BymonthdayRecurType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="byweekno" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="bymonth" type="{urn:ietf:params:xml:ns:icalendar-2.0}BymonthRecurType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="bysetpos" type="{http://www.w3.org/2001/XMLSchema}integer" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="wkst" type="{urn:ietf:params:xml:ns:icalendar-2.0}WeekdayRecurType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecurType", propOrder = {
    "freq",
    "until",
    "count",
    "interval",
    "bysecond",
    "byminute",
    "byhour",
    "byday",
    "byyearday",
    "bymonthday",
    "byweekno",
    "bymonth",
    "bysetpos",
    "wkst"
})
public class RecurType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "token")
    protected FreqRecurType freq;
    protected UntilRecurType until;
    protected BigInteger count;
    protected String interval;
    protected List<String> bysecond;
    protected List<String> byminute;
    protected List<String> byhour;
    protected List<String> byday;
    protected List<String> byyearday;
    @XmlElement(type = Integer.class)
    @XmlSchemaType(name = "integer")
    protected List<Integer> bymonthday;
    protected List<String> byweekno;
    @XmlElement(type = Integer.class)
    @XmlSchemaType(name = "integer")
    protected List<Integer> bymonth;
    protected List<BigInteger> bysetpos;
    @XmlSchemaType(name = "token")
    protected WeekdayRecurType wkst;

    /**
     * Gets the value of the freq property.
     * 
     * @return
     *     possible object is
     *     {@link FreqRecurType }
     *     
     */
    public FreqRecurType getFreq() {
        return freq;
    }

    /**
     * Sets the value of the freq property.
     * 
     * @param value
     *     allowed object is
     *     {@link FreqRecurType }
     *     
     */
    public void setFreq(FreqRecurType value) {
        this.freq = value;
    }

    /**
     * Gets the value of the until property.
     * 
     * @return
     *     possible object is
     *     {@link UntilRecurType }
     *     
     */
    public UntilRecurType getUntil() {
        return until;
    }

    /**
     * Sets the value of the until property.
     * 
     * @param value
     *     allowed object is
     *     {@link UntilRecurType }
     *     
     */
    public void setUntil(UntilRecurType value) {
        this.until = value;
    }

    /**
     * Gets the value of the count property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCount() {
        return count;
    }

    /**
     * Sets the value of the count property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCount(BigInteger value) {
        this.count = value;
    }

    /**
     * Gets the value of the interval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterval() {
        return interval;
    }

    /**
     * Sets the value of the interval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterval(String value) {
        this.interval = value;
    }

    /**
     * Gets the value of the bysecond property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the bysecond property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBysecond().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getBysecond() {
        if (bysecond == null) {
            bysecond = new ArrayList<String>();
        }
        return this.bysecond;
    }

    /**
     * Gets the value of the byminute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the byminute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getByminute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getByminute() {
        if (byminute == null) {
            byminute = new ArrayList<String>();
        }
        return this.byminute;
    }

    /**
     * Gets the value of the byhour property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the byhour property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getByhour().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getByhour() {
        if (byhour == null) {
            byhour = new ArrayList<String>();
        }
        return this.byhour;
    }

    /**
     * Gets the value of the byday property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the byday property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getByday().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getByday() {
        if (byday == null) {
            byday = new ArrayList<String>();
        }
        return this.byday;
    }

    /**
     * Gets the value of the byyearday property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the byyearday property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getByyearday().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getByyearday() {
        if (byyearday == null) {
            byyearday = new ArrayList<String>();
        }
        return this.byyearday;
    }

    /**
     * Gets the value of the bymonthday property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the bymonthday property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBymonthday().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getBymonthday() {
        if (bymonthday == null) {
            bymonthday = new ArrayList<Integer>();
        }
        return this.bymonthday;
    }

    /**
     * Gets the value of the byweekno property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the byweekno property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getByweekno().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getByweekno() {
        if (byweekno == null) {
            byweekno = new ArrayList<String>();
        }
        return this.byweekno;
    }

    /**
     * Gets the value of the bymonth property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the bymonth property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBymonth().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getBymonth() {
        if (bymonth == null) {
            bymonth = new ArrayList<Integer>();
        }
        return this.bymonth;
    }

    /**
     * Gets the value of the bysetpos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the bysetpos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBysetpos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BigInteger }
     * 
     * 
     */
    public List<BigInteger> getBysetpos() {
        if (bysetpos == null) {
            bysetpos = new ArrayList<BigInteger>();
        }
        return this.bysetpos;
    }

    /**
     * Gets the value of the wkst property.
     * 
     * @return
     *     possible object is
     *     {@link WeekdayRecurType }
     *     
     */
    public WeekdayRecurType getWkst() {
        return wkst;
    }

    /**
     * Sets the value of the wkst property.
     * 
     * @param value
     *     allowed object is
     *     {@link WeekdayRecurType }
     *     
     */
    public void setWkst(WeekdayRecurType value) {
        this.wkst = value;
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
