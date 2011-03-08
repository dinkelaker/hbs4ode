package tud.st.bpel.history;

import tud.st.bpel.history.PolicyViolatedException;

/**
 * Interface for all PolicyViolationHandlers
 * 
 * @author A. Look
 *
 */
public interface PolicyViolationHandler {
	
	/**
	 * This method will be called when a policy is violated
	 * The engines implementation should use this method for
	 * common activities that should happen after policy violation
	 * 
	 * @param pve
	 * @throws PolicyViolatedException
	 */
	public void handlePolicyViolation(PolicyViolatedException pve) throws PolicyViolatedException;

}
