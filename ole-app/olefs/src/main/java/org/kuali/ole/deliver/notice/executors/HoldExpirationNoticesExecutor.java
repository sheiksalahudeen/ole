package org.kuali.ole.deliver.notice.executors;

import org.kuali.ole.OLEConstants;
import org.kuali.ole.OLEParameterConstants;
import org.kuali.ole.deliver.bo.OLEDeliverNotice;
import org.kuali.ole.deliver.bo.OleDeliverRequestBo;
import org.kuali.ole.deliver.notice.noticeFormatters.RequestEmailContentFormatter;
import org.kuali.ole.deliver.notice.noticeFormatters.RequestExpirationEmailContentFormatter;
import org.kuali.ole.deliver.service.OleDeliverRequestDocumentHelperServiceImpl;

import java.util.List;

/**
 * Created by maheswarang on 6/24/15.
 */
public class HoldExpirationNoticesExecutor extends RequestNoticesExecutor {

    public HoldExpirationNoticesExecutor(List<OLEDeliverNotice> deliverNotices) {
        super(deliverNotices);
    }

    public OleDeliverRequestDocumentHelperServiceImpl getOleDeliverRequestHelperService(){
        return new OleDeliverRequestDocumentHelperServiceImpl();
    }

    @Override
    public RequestEmailContentFormatter getRequestEmailContentFormatter() {
        if(requestEmailContentFormatter == null){
        requestEmailContentFormatter =  new RequestExpirationEmailContentFormatter();
        }return requestEmailContentFormatter;
        }

    @Override
    public boolean isValidRequestToSendNotice(OleDeliverRequestBo oleDeliverRequestBo) {
        return true;
    }

    @Override
    protected void postProcess() {
        getOleDeliverRequestHelperService().deleteExpiredOnHoldNotices(deliverRequestBos);
        //To do create the request history record and delete the record from the request table
    }


    @Override
    public String getTitle() {
        String title = getParameterResolverInstance().getParameter(OLEConstants.APPL_ID, OLEConstants
                .DLVR_NMSPC, OLEConstants.DLVR_CMPNT,
                OLEParameterConstants
                        .EXPIRED_TITLE);
        return title;
    }

    @Override
    public String getBody() {
        String body = getParameterResolverInstance().getParameter(OLEConstants.APPL_ID_OLE, OLEConstants
                .DLVR_NMSPC, OLEConstants.DLVR_CMPNT, OLEConstants.OleDeliverRequest.EXP_HOLD_NOTICE_CONTENT);
        return body;
    }


}