package tud.st.bpel.prolog;

public class Policy {
	
	private String name;
	private String faultName;
	private String policy;
	
	public Policy(String name, String faultName, String policy) {
		this.name = name;
		this.faultName = faultName;
		this.policy = policy;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFaultName() {
		return faultName;
	}
	public void setFaultName(String faultName) {
		this.faultName = faultName;
	}
	public String getPolicy() {
		return policy;
	}
	public void setPolicy(String policy) {
		this.policy = policy;
	}
	
	@Override
	public String toString() {
		return "(" + name + ", " + faultName + ", " + policy + ")";
	}

}
