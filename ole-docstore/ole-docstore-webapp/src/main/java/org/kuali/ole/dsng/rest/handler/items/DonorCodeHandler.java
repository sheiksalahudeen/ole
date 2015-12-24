
package org.kuali.ole.dsng.rest.handler.items;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jettison.json.JSONObject;
import org.kuali.ole.docstore.engine.service.storage.rdbms.pojo.ItemRecord;
import org.kuali.ole.docstore.engine.service.storage.rdbms.pojo.OLEItemDonorRecord;

import java.util.Iterator;
import java.util.List;

/**
 * Created by SheikS on 12/20/2015.
 */
public class DonorCodeHandler extends ItemOverlayHandler {
    private final String TYPE = "Donor Code";

    @Override
    public boolean isInterested(JSONObject jsonObject) {
        return jsonObject.has(TYPE);
    }

    @Override
    public boolean isMatching(ItemRecord itemRecord, JSONObject jsonObject) {
        String donorCode = getStringValueFromJsonObject(jsonObject,TYPE);
        List<OLEItemDonorRecord> donorList = itemRecord.getDonorList();
        if(CollectionUtils.isNotEmpty(donorList)) {
            for (Iterator<OLEItemDonorRecord> iterator = donorList.iterator(); iterator.hasNext(); ) {
                OLEItemDonorRecord oleItemDonorRecord = iterator.next();
                if(StringUtils.equals(oleItemDonorRecord.getDonorCode(),donorCode)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public ItemRecord process(ItemRecord itemRecord, JSONObject jsonObject) {
        String donorCode = getStringValueFromJsonObject(jsonObject,TYPE);

        //Todo : need to get the information about the process.

        /*OLEItemDonorRecord oleItemDonorRecord = fetchDonorCodeByCode(donorCode);
        if(null != oleItemDonorRecord) {
            List<OLEItemDonorRecord> donorList = itemRecord.getDonorList();
            if(null == donorList) {
                donorList = new ArrayList<OLEItemDonorRecord>();
                donorList.add(oleDonorRecord);
            }
        }*/
        return itemRecord;
    }
}