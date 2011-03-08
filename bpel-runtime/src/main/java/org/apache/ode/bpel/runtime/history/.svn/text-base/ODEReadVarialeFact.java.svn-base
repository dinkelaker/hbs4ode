package org.apache.ode.bpel.runtime.history;

import org.apache.ode.bpel.o.OBase;
import org.apache.ode.bpel.o.OAssign.Copy;
import org.apache.ode.bpel.runtime.VariableInstance;

import tud.st.bpel.history.facts.ReadVariableFact;

public class ODEReadVarialeFact extends ODEDynamicFact implements ReadVariableFact {
	
	private OBase src;
	private VariableInstance vinst;

	public ODEReadVarialeFact(OBase src, VariableInstance vinst) {
		super(src);
		this.src = src;
		this.vinst = vinst;
	}

	public String getVarName() {
		return vinst.declaration.name;
	}

	public String getXPath() {
		return src.getXPath();
	}

}
