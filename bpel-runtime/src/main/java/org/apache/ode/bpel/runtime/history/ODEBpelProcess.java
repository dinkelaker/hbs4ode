package org.apache.ode.bpel.runtime.history;

import java.util.Iterator;

import org.apache.ode.bpel.o.OProcess;

import tud.st.bpel.history.facts.BpelProcess;
import tud.st.bpel.history.facts.StaticActivityFact;
import tud.st.bpel.history.facts.StaticInvokeFact;
import tud.st.bpel.prolog.IStaticProcessFactGenerator;
import tud.st.bpel.prolog.StaticProcessFactGenerator;

/**
 * Object-Adapter for OProcess
 * 
 * @author A. Look
 *
 */
public class ODEBpelProcess extends ODEDynamicFact implements BpelProcess {
	
	private OProcess oprocess;
	private ODECollectStaticProcessFactsVisitor psv; 
	
	public ODEBpelProcess(OProcess oprocess) {
		super(oprocess);
		this.oprocess = oprocess;
		psv = new ODECollectStaticProcessFactsVisitor();
		oprocess.accept(psv);
	}

	public String getName() {
		return oprocess.getName();
	}

	public Iterable<StaticActivityFact> getStaticActivityFacts() {
		return psv.getActivites();
	}

	public Iterable<StaticInvokeFact> getStaticInvokeFacts() {
		return psv.getInvokes();
	}

	

}
