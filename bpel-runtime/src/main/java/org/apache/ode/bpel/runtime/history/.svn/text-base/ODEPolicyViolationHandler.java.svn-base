package org.apache.ode.bpel.runtime.history;

import java.util.Collections;

import org.apache.ode.bpel.o.OActivity;
import org.apache.ode.bpel.o.OInvoke;
import org.apache.ode.bpel.runtime.ActivityInfo;
import org.apache.ode.bpel.runtime.CompensationHandler;
import org.apache.ode.bpel.runtime.channels.FaultData;
import org.apache.ode.bpel.runtime.channels.ParentScopeChannel;
import org.apache.ode.bpel.runtime.channels.TerminationChannel;
import org.apache.ode.utils.DOMUtils;
import org.w3c.dom.Element;

import tud.st.bpel.history.PolicyViolationHandler;
import tud.st.bpel.history.PolicyViolatedException;

public class ODEPolicyViolationHandler implements PolicyViolationHandler {

	OActivity o;
    TerminationChannel self;
    ParentScopeChannel parent;
	
	public ODEPolicyViolationHandler(ActivityInfo actinfo) {
		this(actinfo.getO(), actinfo.getSelf(), actinfo.getParent());
	}
	
	public ODEPolicyViolationHandler(OActivity o, TerminationChannel self,
			ParentScopeChannel parent) {
		this.o = o;
		this.self = self;
		this.parent = parent;
	}

	public void handlePolicyViolation(PolicyViolatedException pve) throws PolicyViolatedException {		

		FaultData fD = new FaultData(pve.getFaultQName(), o,
				pve.getFaultDetail());
		parent.completed(fD, CompensationHandler.emptySet());
		
		throw pve;
		
	}

}
