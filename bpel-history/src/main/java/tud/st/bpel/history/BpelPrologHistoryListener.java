package tud.st.bpel.history;

import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import tud.st.bpel.history.facts.BpelProcess;
import tud.st.bpel.history.facts.InvokeFact;
import tud.st.bpel.history.facts.ReadVariableFact;
import tud.st.bpel.history.facts.StaticActivityFact;
import tud.st.bpel.history.facts.StaticInvokeFact;
import tud.st.bpel.history.facts.WriteVariableFact;
import tud.st.bpel.prolog.BPELPrologEngine;
import tud.st.bpel.prolog.IBPELPrologEngine;
import tud.st.bpel.prolog.IStaticProcessFactGenerator;
import tud.st.bpel.prolog.MalformedPolicyException;
import tud.st.bpel.prolog.Policy;
import tud.st.bpel.prolog.StaticProcessFactGenerator;

/**
 * This listener connects the BPEL-Prolog-Engine to the
 * history framework.
 * 
 * @author A. Look
 *
 */
public class BpelPrologHistoryListener implements BpelHistoryListener {
	
	// The engine
	IBPELPrologEngine engine = new BPELPrologEngine(true);
	protected final Log log = LogFactory.getLog(BpelPrologHistoryListener.class);
	
	// Remember violated policies for debugging
	private Vector<Policy> violatedPolicies = new Vector<Policy>();
	
	// We need to disable policy checking for failed processes,
	// for fault handlers to work
	private Vector<Long> failedProcesses = new Vector<Long>();
			
	public void beforeInvoke(Long pid, InvokeFact invoke, PolicyViolationHandler pvh) throws PolicyViolatedException {

		engine.addInvoke(pid+"",				
				invoke.getXPath(),
				System.currentTimeMillis(),
				invoke.getParameters(),
				true);
		
		checkAllPolicies(pid, pvh, "Invoke will not be executed because a policy was violated!");
		
		engine.addInvoke(pid+"",
				invoke.getXPath(),				 
				System.currentTimeMillis(),
				invoke.getParameters(),
				false);

	}

	

	public void afterInvokeOneWay(Long pid, InvokeFact invoke,
			PolicyViolationHandler pvh) throws PolicyViolatedException {

		engine.addEndInvoke(pid+"",
				invoke.getXPath(),				 
				System.currentTimeMillis(),
				null,
				true);
		
		checkAllPolicies(pid, pvh, "A policy was violated after one way invoke!");
		
		engine.addEndInvoke(pid+"",
				invoke.getXPath(),				 
				System.currentTimeMillis(),
				null,
				false);
		
	}

	public void afterInvokeTwoWay(Long pid, InvokeFact invoke,
			PolicyViolationHandler pvh) throws PolicyViolatedException {
		
		engine.addEndInvoke(pid+"",
				invoke.getXPath(),				 
				System.currentTimeMillis(),
				invoke.getResponse(),
				true);
		
		checkAllPolicies(pid, pvh, "A policy was violated after two way invoke!");
		
		engine.addEndInvoke(pid+"",
				invoke.getXPath(),				 
				System.currentTimeMillis(),
				invoke.getResponse(),
				false);
		
	}
	
	public void setVar(Long pid, WriteVariableFact writeVar,
			PolicyViolationHandler pvh) throws PolicyViolatedException {
		engine.addSetVar(pid+"",
				writeVar.getXPath(),
				System.currentTimeMillis(),
				writeVar.getVarName(),
				writeVar.getNewValue(),
				true);
		
		checkAllPolicies(pid, pvh, "Variable will not be set because a policy was violated: " + writeVar.getVarName() + " (XPath: " + writeVar.getXPath() + ")");
		
		engine.addSetVar(pid+"",
				writeVar.getXPath(),
				System.currentTimeMillis(),
				writeVar.getVarName(),
				writeVar.getNewValue(),
				false);
	}
	
	public void getVar(Long pid, ReadVariableFact readVar,
			PolicyViolationHandler pvh) throws PolicyViolatedException {
		engine.addGetVar(pid+"",
				readVar.getXPath(),
				System.currentTimeMillis(),
				readVar.getVarName(),
				true);
		
		checkAllPolicies(pid, pvh, "A Policy was violated trying to read a variable: " + readVar.getVarName() + " (XPath: " + readVar.getXPath() + ")");
		
		engine.addGetVar(pid+"",
				readVar.getXPath(),
				System.currentTimeMillis(),
				readVar.getXPath(),
				false);
	}
	
	

	public void registerProcess(BpelProcess process) {
		
		// get static facts from BpelProcess implementation		
		IStaticProcessFactGenerator ps = new StaticProcessFactGenerator(process.getName());
		
		for(StaticActivityFact act : process.getStaticActivityFacts()) {
			ps.addActivity(act.getXPath(), act.getParentXPath());
		}
		for(StaticInvokeFact inv : process.getStaticInvokeFacts()) {
			ps.addInvoke(inv.getXPath(),
					inv.getParentXPath(),
					inv.getPartnerLink(),
					inv.getPortType(),
					inv.getOperation(),
					inv.getInputVar(),
					inv.getOutputVar());
		}
		engine.addStaticProcessFacts(ps);		

	}
	
	public void processStarted(Long pid, BpelProcess process, PolicyViolationHandler pvh) throws PolicyViolatedException {
		engine.addCreateProcessInstance(process.getName(), pid+"", System.currentTimeMillis(), true);
		checkAllPolicies(pid, pvh, "A policy was violated during process startup");
		engine.addCreateProcessInstance(process.getName(), pid+"", System.currentTimeMillis(), false);
	}

	public void processEnded(Long pid, BpelProcess process, PolicyViolationHandler pvh) throws PolicyViolatedException {
		engine.addDestroyProcessInstance(pid+"", System.currentTimeMillis(), true);
		checkAllPolicies(pid, pvh, "A policy was violated during process shutdown");
		engine.addDestroyProcessInstance(pid+"", System.currentTimeMillis(), false);
				
		// Debug output:
		engine.printFacts();
		
		if(violatedPolicies.size() > 0) {
			System.out.println("Violated policies:");
			for(Policy pol : violatedPolicies) {
				System.out.println(pol);
			}
		}
		else {
			System.out.println("No violated policies!");
		}
	}

	public void addPolicy(String name, String faultName, String policy) {
		Policy pol = new Policy(name, faultName, policy);
		System.out.println("Adding policy: " + pol);
		
		engine.addPolicy(pol);
		
		// Only check for malformed policies!
		try {
			System.out.println("Checking for malformed policy");
			engine.checkAllPolicies();
		} catch (tud.st.bpel.prolog.PolicyViolatedException e) {
			// ignore!
		} catch (MalformedPolicyException e) {
			log.error(e.getMessage());
		}
	}
	
	private void checkAllPolicies(Long pid, PolicyViolationHandler pvh, String reason) throws PolicyViolatedException {	
		
		// check all policies
		try {
			// Allow fault handlers to be executed
			if(BpelHistory.getInstance().getAllowFaultHandlers()
					&& failedProcesses.contains(pid))
				log.debug("Ignoring policies for FAILED pid: " + pid);				
			else
				engine.checkAllPolicies(pid);
		}
		catch(tud.st.bpel.prolog.PolicyViolatedException prologPVE) {	
			
			// A policy was violated
			PolicyViolatedException pve = new PolicyViolatedException(prologPVE);
			Policy pol = pve.getPolicy();
			violatedPolicies.add(pol);
			log.error("PolicyViolatedException: " + pol + " (" + reason + ")");			
			pve.setReason(reason);
			
			// Remeber failed processes so we can disable policy checking
			// for fault handlers
			failedProcesses.add(pid);
			
			pvh.handlePolicyViolation(pve);
			
		}
		catch(MalformedPolicyException mpe) {
			log.error("Malformed policy detected: " + mpe.getMalformedPolicy());
			System.out.println("Malformed policy detected: " + mpe.getMalformedPolicy());
		}
		
		
	}

	public boolean isPolicyViolated(Long pid) {
		return failedProcesses.contains(pid);
	}

}
