package tud.st.bpel.prolog;

import alice.tuprolog.SolveInfo;

/**
 * This exception is thrown when a policy is violated
 * @author Philipp Zuehlke
 *
 */
public class PolicyViolatedException extends Exception {
		
	private static final long serialVersionUID = 1L;
	/**holds the violated policy*/
	private Policy policy;
	
	private SolveInfo solution;
	
	/**
	 * Constructs an exception for a policy that is violated
	 * @param policy the invalid exception
	 */
	public PolicyViolatedException(Policy policy, SolveInfo solution )
	{
		this.policy = policy;
		this.solution = solution;
	}
		
	public Policy getPolicy() {
		return this.policy;
	}
	
	public SolveInfo getSolution() {
		return solution;
	}	
	
}
