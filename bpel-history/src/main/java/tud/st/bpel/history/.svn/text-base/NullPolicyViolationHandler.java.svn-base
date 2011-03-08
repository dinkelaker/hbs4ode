package tud.st.bpel.history;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import tud.st.bpel.history.PolicyViolatedException;

/***
 * Default handler for situation where you don't want to do anything
 * after a policy violation
 * 
 * @author A. Look
 *
 */
public class NullPolicyViolationHandler implements PolicyViolationHandler {
	
	private final Log log = LogFactory.getLog(NullPolicyViolationHandler.class);
	
	public void handlePolicyViolation(PolicyViolatedException pve) throws PolicyViolatedException {
		log.error(pve.toString());
		throw pve;
	}

}
