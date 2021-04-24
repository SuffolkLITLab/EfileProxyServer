
package tyler.ecf.extensions.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.TextType;


/**
 * &lt;p&gt;Java class for QuestionAnswerType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="QuestionAnswerType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}QuestionID"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}AnswerID"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuestionAnswerType", propOrder = {
    "questionID",
    "answerID"
})
public class QuestionAnswerType {

    @XmlElement(name = "QuestionID", required = true)
    protected TextType questionID;
    @XmlElement(name = "AnswerID", required = true)
    protected TextType answerID;

    /**
     * Gets the value of the questionID property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getQuestionID() {
        return questionID;
    }

    /**
     * Sets the value of the questionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setQuestionID(TextType value) {
        this.questionID = value;
    }

    /**
     * Gets the value of the answerID property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getAnswerID() {
        return answerID;
    }

    /**
     * Sets the value of the answerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setAnswerID(TextType value) {
        this.answerID = value;
    }

}
