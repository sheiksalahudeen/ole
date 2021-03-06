package org.kuali.ole.docstore.common.document.content.instance;

import org.apache.commons.net.ntp.TimeStamp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by hemalathas on 3/25/15.
 */

/**
 * (R)
 * Does not map to MFHD. Identifies types of locally defined statistical categories.
 * Example:
 * codeValue=STRVIDEO
 * fullValue=Streaming Video
 * typeOrSource=Can be a pointer to LOC to pull down pre-defined list
 * <p/>
 * <p/>
 * <p>Java class for statisticalSearchingCode complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="statisticalSearchingCode">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fullValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="typeOrSource" type="{http://ole.kuali.org/standards/ole-instance}typeOrSource"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "missingPieceItemRecord", propOrder = {

        "missingPieceDate",
        "missingPieceCount",
        "missingPieceFlagNote",
        "operatorId",
        "patronBarcode",
        "patronId",
        "itemId",
        "missingPieceItemId",
        "patronURL"
})
public class MissingPieceItemRecord {

    @XmlElement(required = true)
    protected String missingPieceDate ;
    @XmlElement(required = true)
    protected String missingPieceCount ;
    @XmlElement(required = true)
    protected String missingPieceFlagNote;
    @XmlElement(required = true)
    protected String operatorId ;
    @XmlElement(required = true)
    protected String patronBarcode ;
    @XmlElement(required = true)
    protected String patronId ;
    @XmlElement(required = true)
    protected String itemId ;
    @XmlElement(required = true)
    protected String patronURL;
    @XmlElement(required = true)
    protected String missingPieceItemId ;

    public String getMissingPieceFlagNote() {
        return missingPieceFlagNote;
    }

    public void setMissingPieceFlagNote(String missingPieceFlagNote) {
        this.missingPieceFlagNote = missingPieceFlagNote;
    }

    public String getMissingPieceCount() {
        return missingPieceCount;
    }

    public void setMissingPieceCount(String missingPieceCount) {
        this.missingPieceCount = missingPieceCount;
    }

    public String getMissingPieceDate() {
        return missingPieceDate;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getMissingPieceItemId() {
        return missingPieceItemId;
    }

    public void setMissingPieceItemId(String missingPieceItemId) {
        this.missingPieceItemId = missingPieceItemId;
    }

    public void setMissingPieceDate(String missingPieceDate) {
        this.missingPieceDate = missingPieceDate;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getPatronBarcode() {
        return patronBarcode;
    }

    public void setPatronBarcode(String patronBarcode) {
        this.patronBarcode = patronBarcode;
    }

    public String getPatronURL() {
        return patronURL;
    }

    public void setPatronURL(String patronURL) {
        this.patronURL = patronURL;
    }

    public String getPatronId() {
        return patronId;
    }

    public void setPatronId(String patronId) {
        this.patronId = patronId;
    }


}
