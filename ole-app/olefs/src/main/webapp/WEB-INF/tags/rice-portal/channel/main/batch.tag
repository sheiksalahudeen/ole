<%--
 Copyright 2007-2009 The Kuali Foundation

 Licensed under the Educational Community License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.opensource.org/licenses/ecl2.php

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
--%>
<%@ include file="/rice-portal/jsp/sys/riceTldHeader.jsp"%>

<channel:portalChannelTop channelTitle="Batch" />
<div class="body">
    <portal:portalLink displayTitle="true" title="Batch Process Profile" url="${ConfigProperties.application.url}/ole-kr-krad/lookup?methodToCall=start&dataObjectClassName=org.kuali.ole.batch.bo.OLEBatchProcessProfileBo&returnLocation=${ConfigProperties.application.url}/portal.do&hideReturnLink=true&showMaintenanceLinks=true" /><br/>
    <portal:portalLink displayTitle="true" title="Batch Process Filter Criteria" url="${ConfigProperties.application.url}/ole-kr-krad/lookup?methodToCall=start&dataObjectClassName=org.kuali.ole.batch.bo.OLEBatchProcessFilterCriteriaBo&returnLocation=${ConfigProperties.application.url}/portal.do&hideReturnLink=true&showMaintenanceLinks=true" /><br/>
    <portal:portalLink displayTitle="true" title="Batch File Type" url="${ConfigProperties.application.url}/ole-kr-krad/lookup?methodToCall=start&dataObjectClassName=org.kuali.ole.batch.bo.OLEBatchProcessFileTypeBo&returnLocation=${ConfigProperties.application.url}/portal.do&hideReturnLink=true&showMaintenanceLinks=true" /><br/>
    <portal:portalLink displayTitle="true" title="Batch Process Type" url="${ConfigProperties.application.url}/ole-kr-krad/lookup?methodToCall=start&dataObjectClassName=org.kuali.ole.batch.bo.OLEBatchProcessTypeBo&returnLocation=${ConfigProperties.application.url}/portal.do&hideReturnLink=true&showMaintenanceLinks=true" /><br/>
    <portal:portalLink displayTitle="true" title="Batch Process"
                       url="${ConfigProperties.application.url}/ole-kr-krad/oleBatchProcessDefinitionController?viewId=OLEBatchProcessDefinitionView&methodToCall=docHandler&command=initiate&documentClass=org.kuali.ole.batch.document.OLEBatchProcessDefinitionDocument"/><br/><br/>
</div>
<channel:portalChannelBottom />
