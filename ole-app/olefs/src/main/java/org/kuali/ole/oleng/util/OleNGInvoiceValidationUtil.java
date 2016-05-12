package org.kuali.ole.oleng.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.kuali.ole.Exchange;
import org.kuali.ole.oleng.exception.ValidationException;
import org.kuali.ole.pojo.OleInvoiceRecord;
import org.kuali.ole.pojo.OleOrderRecord;
import org.kuali.ole.pojo.OleTxRecord;
import org.kuali.ole.spring.batch.BatchUtil;

/**
 * Created by SheikS on 3/31/2016.
 */
public class OleNGInvoiceValidationUtil {

    private BatchUtil batchUtil;

    public boolean validateOleInvoiceRecord(OleInvoiceRecord oleInvoiceRecord, Exchange exchange, Integer recordIndex) {
        boolean valid = true;
        valid = validateVendorNumber(oleInvoiceRecord, exchange, recordIndex) && valid;
        valid = validateInvoiceNumber(oleInvoiceRecord, exchange, recordIndex) && valid;
        valid = validateInvoiceDate(oleInvoiceRecord, exchange, recordIndex) && valid;
        valid = validateInvoicePrice(oleInvoiceRecord, exchange, recordIndex) && valid;
        valid = validateItemDescription(oleInvoiceRecord, exchange, recordIndex) && valid;
        valid = validateQuantity(oleInvoiceRecord, exchange, recordIndex) && valid;

        return valid;
    }

    private boolean validateInvoiceNumber(OleInvoiceRecord oleInvoiceRecord, Exchange exchange, Integer recordIndex) {
        String invoiceNumber = oleInvoiceRecord.getInvoiceNumber();
        if (StringUtils.isBlank(invoiceNumber)){
            getBatchUtil().addInvoiceFaiureResponseToExchange(
                    new ValidationException("Invoice number cannot be blank or null"), recordIndex, exchange);
            return false;
        }
        return true;
    }

    private boolean validateVendorNumber(OleInvoiceRecord oleInvoiceRecord, Exchange exchange, Integer recordIndex) {
        if (StringUtils.isBlank(oleInvoiceRecord.getVendorNumber())){
            getBatchUtil().addInvoiceFaiureResponseToExchange(
                    new ValidationException("Vendor number cannot be blank or null"), recordIndex, exchange);
            return false;
        } else {
            String[] vendorIds = oleInvoiceRecord.getVendorNumber().split("-");
            if(!(vendorIds != null && vendorIds.length == 2 && org.apache.commons.lang.StringUtils.isNotBlank(vendorIds[0]) && org.apache.commons.lang.StringUtils.isNotBlank(vendorIds[1]))) {
                getBatchUtil().addInvoiceFaiureResponseToExchange(
                        new ValidationException("Vendor number is invalid"), recordIndex, exchange);
                return false;
            }
        }
        return true;
    }

    private boolean validateInvoiceDate(OleInvoiceRecord oleInvoiceRecord, Exchange exchange, Integer recordIndex) {
        if (StringUtils.isBlank(oleInvoiceRecord.getInvoiceDate())){
            getBatchUtil().addInvoiceFaiureResponseToExchange(
                    new ValidationException("Invoice date cannot be blank or null"), recordIndex, exchange);
            return false;
        }
        return true;
    }

    private boolean validateInvoicePrice(OleInvoiceRecord oleInvoiceRecord, Exchange exchange, Integer recordIndex) {
        String listPrice = oleInvoiceRecord.getListPrice();
        if (null == listPrice || !NumberUtils.isNumber(listPrice)){
            getBatchUtil().addInvoiceFaiureResponseToExchange(
                    new ValidationException("List Price cannot be blank or null and it should be numeric"), recordIndex, exchange);
            return false;
        }
        return true;
    }

    private boolean validateItemDescription(OleInvoiceRecord oleInvoiceRecord, Exchange exchange, Integer recordIndex) {
        if (StringUtils.isBlank(oleInvoiceRecord.getItemDescription())){
            getBatchUtil().addInvoiceFaiureResponseToExchange(
                    new ValidationException("Item description cannot be blank or null"), recordIndex, exchange);
            return false;
        }
        return true;
    }

    private boolean validateQuantity(OleInvoiceRecord oleInvoiceRecord, Exchange exchange, Integer recordIndex) {
        String quantity = oleInvoiceRecord.getQuantity();
        if (null == quantity || !NumberUtils.isDigits(quantity)){
            getBatchUtil().addInvoiceFaiureResponseToExchange(
                    new ValidationException("Quantity cannot be blank or null and it should be round number"), recordIndex, exchange);
            return false;
        }
        return true;
    }

    public BatchUtil getBatchUtil() {
        if(null == batchUtil) {
            batchUtil = new BatchUtil();
        }
        return batchUtil;
    }
}