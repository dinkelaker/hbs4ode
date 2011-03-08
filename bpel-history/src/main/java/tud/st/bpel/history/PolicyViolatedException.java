package tud.st.bpel.history;

import javax.xml.namespace.QName;

import tud.st.bpel.prolog.Policy;

/**
 * This Exception will be handed over to the PolicyViolationHandler
 * when a policy has been violated.
 * If thrown, the Engine is notified about the policy violation
 * and can react appropriately.
 * 
 * @author A. Look
 *
 */
public class PolicyViolatedException extends Exception {

	private static final long serialVersionUID = 1L;

	public static final String FAULT_NS_URI = "http://bpel.st.informatik.tu-darmstadt.de/policyViolated";
	
	private tud.st.bpel.prolog.PolicyViolatedException prologException;
	private Policy policy;
	private String reason;
	
	public PolicyViolatedException(tud.st.bpel.prolog.PolicyViolatedException prologException) {
		this.prologException = prologException;
		this.policy = prologException.getPolicy();
	}
	
	public String getFaultName() {
		if(policy.getFaultName() != null)
			return policy.getFaultName();
		else
			return "PolicyViolatedException";
	}

	public QName getFaultQName() {
		return new QName(FAULT_NS_URI, getFaultName());
	}
	
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * Use to determine the violated policy
	 * @return the violated policy
	 */
	public String getFaultDetail()
	{
		// return this.policy;
		/* WTF?!?!?!
		 * ERROR 22001: A truncation error was encountered trying to shrink
		 * VARCHAR 'invoke(ProcessID,"process/sequence[@name='packageSequence']/&'
		 * to length 255.
		 * 
		 * Die verletzte policy wird gelogt. Das fault-detail darf aber nicht
		 * mehr als 255 Zeichen haben! ARGH! ;)
		 */
		
		String detail = policy.toString();
		if(detail.length() > 250)
			detail = detail.substring(0, 250) + "[...]";
		return detail;
	}

	public Policy getPolicy() {
		return prologException.getPolicy();
	}

}
