package tud.st.bpel.history;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import tud.st.bpel.history.facts.BpelProcess;
import tud.st.bpel.history.facts.InvokeFact;
import tud.st.bpel.history.facts.ReadVariableFact;
import tud.st.bpel.history.facts.WriteVariableFact;

/**
 * Log listener used for debugging
 * 
 * @author A. Look
 *
 */
public class BpelLogHistoryListener implements BpelHistoryListener {
	
	private static final Log log = LogFactory.getLog(BpelLogHistoryListener.class);

	public void addPolicy(String name, String faultName, String policy) {
		// TODO Auto-generated method stub
		log.debug("ADDING POLICY: " + name + ", " + faultName  + ", " + policy);
	}

	public void afterInvokeOneWay(Long pid, InvokeFact invoke,
			PolicyViolationHandler pvh) throws PolicyViolatedException {
		log.debug("AFTER INVOKE ONE WAY: " + invoke);		
	}


	public void afterInvokeTwoWay(Long pid, InvokeFact invoke,
			PolicyViolationHandler pvh) throws PolicyViolatedException {
		log.debug("AFTER INVOKE TWO WAY: " + invoke);
		
	}

	public void beforeInvoke(Long pid, InvokeFact invoke,
			PolicyViolationHandler pvh) throws PolicyViolatedException {
		log.debug("BEFORE INVOKE: " + invoke);		
	}


	public void getVar(Long pid, ReadVariableFact readVar,
			PolicyViolationHandler pvh) throws PolicyViolatedException {
		log.debug("GET VAR: " + readVar);		
	}

	public void processEnded(Long pid, BpelProcess process,
			PolicyViolationHandler pvh) throws PolicyViolatedException {
		log.debug("PROCESS ENDED: " + process);
	}

	public void processStarted(Long pid, BpelProcess process,
			PolicyViolationHandler pvh) throws PolicyViolatedException {
		log.debug("PROCESS STARTED: " + process);
		
	}

	public void registerProcess(BpelProcess process) {
		log.debug("REGSITER PROCESS: " + process);
	}

	public void setVar(Long pid, WriteVariableFact writeVar,
			PolicyViolationHandler pvh) throws PolicyViolatedException {
		log.debug("SET VAR: " + writeVar);		
	}

	public boolean isPolicyViolated(Long pid) {
		return false;
	}

}
