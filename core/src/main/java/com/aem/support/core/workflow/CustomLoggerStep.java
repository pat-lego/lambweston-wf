package com.aem.support.core.workflow;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;

import org.osgi.framework.Constants;

@Component(property = {
    Constants.SERVICE_DESCRIPTION + "=Log to logger from workflow",
    Constants.SERVICE_VENDOR + "=Adobe Systems",
    "process.label" + "=Log Payload to logger"
})
public class CustomLoggerStep implements WorkflowProcess {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void execute(WorkItem arg0, WorkflowSession arg1, MetaDataMap arg2) throws WorkflowException {
        logger.info("About to execute the {} process step", this.getClass().getName());
        if (arg0.getWorkflowData().getPayloadType().equals("JCR_PATH")) {
            logger.info("The payload in the workflow is set to {}", arg0.getWorkflowData().getPayload());
        } else {
            logger.info("The payload is set to something other then JCR_PATH, it is currently set to {}", arg0.getWorkflowData().getPayloadType());
        }

    } 

}