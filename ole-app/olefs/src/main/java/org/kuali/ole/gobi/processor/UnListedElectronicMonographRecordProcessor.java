package org.kuali.ole.gobi.processor;

import org.kuali.ole.OLEConstants;
import org.kuali.ole.gobi.GobiRequest;
import org.kuali.ole.gobi.datobjects.CollectionType;
import org.kuali.ole.gobi.datobjects.PurchaseOrder;
import org.kuali.ole.gobi.service.impl.OleGobiOrderRecordServiceImpl;
import org.kuali.ole.gobi.service.impl.UnListedElectronicMonographGobiOrderRecordServiceImpl;
import org.kuali.ole.pojo.OleOrderRecord;

import java.util.Iterator;
import java.util.List;

/**
 * Created by pvsubrah on 9/22/15.
 */
public class UnListedElectronicMonographRecordProcessor extends GobiAPIProcessor {
    @Override
    public boolean isInterested(GobiRequest gobiRequest) {
        return null != gobiRequest.getPurchaseOrder().getOrder().getUnlistedElectronicMonograph();
    }

    @Override
    public String getMarcXMLContent(GobiRequest gobiRequest) {
        String collectionSerializedContent = null;
        PurchaseOrder.Order.UnlistedElectronicMonograph unlistedElectronicMonograph =
                gobiRequest.getPurchaseOrder().getOrder().getUnlistedElectronicMonograph();
        CollectionType collection = unlistedElectronicMonograph.getCollection();
        if (null != collection) {
            collectionSerializedContent = collection.serialize(collection);
        }
        return collectionSerializedContent;
    }

    @Override
    protected OleGobiOrderRecordServiceImpl getOleOrderRecordService() {
        return new UnListedElectronicMonographGobiOrderRecordServiceImpl();
    }

    @Override
    protected void linkToOrderOption() {
        List<OleOrderRecord> oleOrderRecordList = getOleOrderRecordList();
        for (Iterator<OleOrderRecord> iterator = oleOrderRecordList.iterator(); iterator.hasNext(); ) {
            OleOrderRecord oleOrderRecord = iterator.next();
            oleOrderRecord.setLinkToOrderOption(OLEConstants.ORDER_RECORD_IMPORT_MARC_ONLY_ELECTRONIC);
        }
    }
}
