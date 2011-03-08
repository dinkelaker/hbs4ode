package org.apache.ode.bpel.runtime.history;

import org.apache.ode.bpel.o.OBase;

import tud.st.bpel.history.facts.DynamicFact;

public class ODEDynamicFact implements DynamicFact {
	
	private OBase obase;

	public ODEDynamicFact(OBase obase) {
		this.obase = obase;
	}

	public String getXPath() {
		return obase.getXPath();
	}

}
