/*
 * Copyright 2007 The Kuali Foundation
 * 
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/ecl2.php
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.ole.fp.businessobject.options;

import java.util.ArrayList;
import java.util.List;

import org.kuali.ole.fp.businessobject.TravelExpenseTypeCode;
import org.kuali.ole.sys.context.SpringContext;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.keyvalues.KeyValuesBase;
import org.kuali.rice.krad.service.KeyValuesService;

/**
 * This class returns list of travel expense type category value pairs.
 */
public class TravelExpenseTypeValuesFinder extends KeyValuesBase {

    /*
     * @see org.kuali.keyvalues.KeyValuesFinder#getKeyValues()
     */
    public List getKeyValues() {
        List<TravelExpenseTypeCode> boList = (List<TravelExpenseTypeCode>) SpringContext.getBean(KeyValuesService.class).findAllOrderBy(TravelExpenseTypeCode.class, "name", true);
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        keyValues.add(new ConcreteKeyValue("", ""));
        for (TravelExpenseTypeCode element : boList) {
            if (!element.isPrepaidExpense()) {
                if(element.isActive()) {
                    keyValues.add(new ConcreteKeyValue(element.getCode(), element.getCodeAndDescription()));
                }
            }
        }

        return keyValues;
    }

}
