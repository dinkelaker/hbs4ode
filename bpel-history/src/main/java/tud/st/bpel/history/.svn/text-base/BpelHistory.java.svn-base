package tud.st.bpel.history;

import java.util.List;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import tud.st.bpel.history.facts.BpelProcess;
import tud.st.bpel.history.facts.InvokeFact;
import tud.st.bpel.history.facts.ReadVariableFact;
import tud.st.bpel.history.facts.WriteVariableFact;

/**
 * Controller to be used by the engine to notify all
 * registered BpelHistoryListeners about history events.
 *  
 * @author A. Look
 *
 */
public class BpelHistory {
	
	// thread safe singleton for BPELHistory
	private static BpelHistory instance = new BpelHistory();
	
	private List<BpelHistoryListener> listeners;
	private final Log log = LogFactory.getLog(BpelHistory.class);
	
	// Should fault handlers be executed after policy violation?
	private boolean allowFaultHandlers = false;
	
	private BpelHistory() {
		listeners = new Vector<BpelHistoryListener>();
	}
	
	public static BpelHistory getInstance() {				
		return instance;
	}
	
	public void addListener(BpelHistoryListener listener) {
		log.debug("Adding BPEL history listener: " + listener);
		listeners.add(listener);
	}
	
	public void afterInvokeOneWay(Long pid, InvokeFact invoke, PolicyViolationHandler pvh) throws PolicyViolatedException {
		log.debug("Invoke OneWay");
		for(BpelHistoryListener l : listeners) {
			l.afterInvokeOneWay(pid, invoke, pvh);
		}
	}

	public void afterInvokeTwoWay(Long pid, InvokeFact invoke, PolicyViolationHandler pvh) throws PolicyViolatedException {
		log.debug("Invoke TwoWay");
		for(BpelHistoryListener l : listeners) {
			l.afterInvokeTwoWay(pid, invoke, pvh);
		}
	}
	
	public void beforeInvoke(Long pid, InvokeFact invoke, PolicyViolationHandler pvh) throws PolicyViolatedException {		
		log.debug("Before OneWay");
		for(BpelHistoryListener l : listeners) {
			l.beforeInvoke(pid, invoke, pvh);
		}		
	}
	
	public void setVar(Long pid, WriteVariableFact writeVar, PolicyViolationHandler pvh) throws PolicyViolatedException {
		log.debug("SetVar");
		for(BpelHistoryListener l : listeners) {
			l.setVar(pid, writeVar, pvh);
		}		
	}

	public void getVar(Long pid, ReadVariableFact readVar, PolicyViolationHandler pvh) throws PolicyViolatedException {
		log.debug("GetVar");
		for(BpelHistoryListener l : listeners) {
			l.getVar(pid, readVar, pvh);
		}		
	}
	
	public void runProcess(Long pid, BpelProcess process, PolicyViolationHandler pvh) throws PolicyViolatedException {
		log.debug("Process started");
		for(BpelHistoryListener l : listeners) {
			l.processStarted(pid, process, pvh);
		}
	}

	public void registerProcess(BpelProcess process) {
		log.debug("Process registered");
		for(BpelHistoryListener l : listeners) {
			l.registerProcess(process);
		}
	}

	public void processEnded(Long pid, BpelProcess process, PolicyViolationHandler pvh) throws PolicyViolatedException {
		log.debug("Process done!");
		for(BpelHistoryListener l : listeners) {
			l.processEnded(pid, process, pvh);
		}
	}
	
	public void addPolicy(String name, String faultName, String policy) {
		log.debug("Adding Policy: " + policy);
		for(BpelHistoryListener l : listeners) {
			l.addPolicy(name, faultName, policy);
		}
	}
	
	/**
	 * @param b true if you want to use fault handlers after policy violation
	 */
	public void setAllowFaultHandlers(boolean b) {
		log.debug("setAllowFaultHandlers: " + b);
		this.allowFaultHandlers = b;
	}
	
	public boolean getAllowFaultHandlers() {
		return allowFaultHandlers;
	}

	/**
	 * 
	 * @param pid Process-ID
	 * @return true if any of the BpelHistoryListeners reports a policy violation
	 */
	public boolean isPolicyViolated(Long pid) {
		boolean policyViolated = false;
		for(BpelHistoryListener l : listeners) {
			policyViolated = policyViolated || l.isPolicyViolated(pid);
		}
		return policyViolated;
	}
	
}
