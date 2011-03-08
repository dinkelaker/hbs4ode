package tud.st.bpel.history;

import tud.st.bpel.history.facts.BpelProcess;
import tud.st.bpel.history.facts.InvokeFact;
import tud.st.bpel.history.facts.ReadVariableFact;
import tud.st.bpel.history.facts.WriteVariableFact;

/**
 * Interface for all BpelHistoryListeners 
 * 
 * @author A. Look
 *
 */
public interface BpelHistoryListener {
	
	public void beforeInvoke(Long pid, InvokeFact invoke, PolicyViolationHandler pvh) throws PolicyViolatedException;

	public void afterInvokeOneWay(Long pid, InvokeFact invoke, PolicyViolationHandler pvh) throws PolicyViolatedException;

	public void afterInvokeTwoWay(Long pid, InvokeFact invoke, PolicyViolationHandler pvh) throws PolicyViolatedException;
	
	public void setVar(Long pid, WriteVariableFact writeVar, PolicyViolationHandler pvh) throws PolicyViolatedException;
	
	public void getVar(Long pid, ReadVariableFact readVar, PolicyViolationHandler pvh) throws PolicyViolatedException;
		
	public void registerProcess(BpelProcess process);

	public void processStarted(Long pid, BpelProcess process, PolicyViolationHandler pvh) throws PolicyViolatedException;
	
	public void processEnded(Long pid, BpelProcess process, PolicyViolationHandler pvh) throws PolicyViolatedException;

	public void addPolicy(String name, String faultName, String policy);

	public boolean isPolicyViolated(Long pid);

}
