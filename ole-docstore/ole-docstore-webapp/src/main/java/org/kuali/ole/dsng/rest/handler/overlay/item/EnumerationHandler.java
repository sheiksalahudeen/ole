package org.kuali.ole.dsng.rest.handler.overlay.item;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jettison.json.JSONObject;
import org.kuali.ole.docstore.engine.service.storage.rdbms.pojo.ItemRecord;

/**
 * Created by SheikS on 12/20/2015.
 */
public class EnumerationHandler extends ItemOverlayHandler {
    private final String TYPE = "Enumeration";

    @Override
    public boolean isInterested(JSONObject jsonObject) {
        return jsonObject.has(TYPE);
    }

    @Override
    public boolean isMatching(ItemRecord itemRecord, JSONObject jsonObject) {
        String enumeration = getStringValueFromJsonObject(jsonObject,TYPE);
        return StringUtils.equals(itemRecord.getEnumeration(),enumeration);
    }

    @Override
    public ItemRecord process(ItemRecord itemRecord, JSONObject jsonObject) {
        String enumeration = getStringValueFromJsonObject(jsonObject,TYPE);
        itemRecord.setEnumeration(enumeration);
        return itemRecord;
    }
}