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
package org.kuali.ole.module.cg.businessobject.options;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.kuali.ole.module.cg.businessobject.LetterOfCreditFundGroup;
import org.kuali.ole.sys.context.SpringContext;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.keyvalues.KeyValuesBase;
import org.kuali.rice.krad.service.KeyValuesService;

/**
 * Gets a custom-formatted list of {@link LetterOfCreditFundGroup} values.
 */
public class LetterOfCreditFundGroupValuesFinder extends KeyValuesBase {

    /**
     * @see org.kuali.rice.kns.lookup.keyvalues.KeyValuesFinder#getKeyValues()
     */
    public List getKeyValues() {

        Collection<LetterOfCreditFundGroup> codes = SpringContext.getBean(KeyValuesService.class).findAll(LetterOfCreditFundGroup.class);

        List<KeyValue> labels = new ArrayList<KeyValue>();
        labels.add(new ConcreteKeyValue("", ""));

        for (LetterOfCreditFundGroup code : codes) {
            if (code.isActive()) {
                labels.add(new ConcreteKeyValue(code.getLetterOfCreditFundGroupCode(), code.getLetterOfCreditFundGroupCode() + " - " + code.getLetterOfCreditFundGroupDescription()));
            }
        }

        return labels;
    }
}
