package org.apache.ode.bpel.runtime.history;

import org.apache.ode.bpel.o.OBase;
import org.apache.ode.bpel.runtime.VariableInstance;
import org.apache.ode.utils.DOMUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import tud.st.bpel.history.facts.WriteVariableFact;

public class ODEWriteVariableFact extends ODEDynamicFact implements WriteVariableFact {
	
	private VariableInstance vinst;
	private Node response;

	public ODEWriteVariableFact(OBase src, VariableInstance vinst, Node response) {
		super(src);
		this.vinst = vinst;
		this.response = response;
	}

	public String getVarName() {
		return vinst.declaration.name;
	}

	public String getNewValue() {
		return DOMUtils.domToString(response);
	}

}
