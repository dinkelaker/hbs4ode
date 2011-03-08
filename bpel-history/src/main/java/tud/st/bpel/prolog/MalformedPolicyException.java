package tud.st.bpel.prolog;

/**
 * This exception is thrown when a policy is malformed/invalid
 * @author Philipp Zuehlke
 *
 */
public class MalformedPolicyException extends Exception {
	private static final long serialVersionUID = 1L;
	/**the malformed policy*/
	private Policy policy;

	/**
	 * Constructs an exception for a policy that is malformed
	 * @param policy the invalid exception
	 */
	public MalformedPolicyException( Policy policy )
	{
		this.policy = policy;
	}
	
	/**
	 * Use to determine the malformed policy
	 * @return the malformed policy
	 */
	public Policy getMalformedPolicy()
	{
		return policy;
	}
}
