package org.apache.ode.bpel.runtime.history;

import org.apache.ode.bpel.o.OInvoke;
import org.w3c.dom.Element;

import tud.st.bpel.history.facts.InvokeFact;

public class ODEInvokeFact extends ODEDynamicFact implements InvokeFact {

	private OInvoke oinvoke;
	private Element response = null;

	public ODEInvokeFact(OInvoke oinvoke) {
		super(oinvoke);
		this.oinvoke = oinvoke;
	}
	
	public ODEInvokeFact(OInvoke oinvoke, Element response) {
		super(oinvoke);
		this.oinvoke = oinvoke;
		this.response = response;
	}

	public String[] getParameters() {
		return new String[] { oinvoke.inputVar.name };
	}

	public String getResponse() {
		return response.getTextContent();
	}

}
