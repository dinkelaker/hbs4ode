package tud.st.bpel.prolog;


/**
 * Interface to access the class BPELPrologEngine
 * @author Philipp Zuehlke
 *
 */
public interface IBPELPrologEngine {
	
	/**
	 * Adds all static process facts to the BPEL Prolog Engine. It is possible to add several 
	 * StaticProcessFacts as long as their DefinitionID differs
	 * @param spf the instance which holds the static process facts
	 */
	public void addStaticProcessFacts( IStaticProcessFactGenerator spf );
	
	//dynamic facts:
	
	/**
	 * Will be called when a new BPEL process is created
	 * @param definitionID The unique ID of the corresponding static process facts
	 * @param processID unique ID of this process. All activities of this process share this id
	 * @param timestamp The creation time
	 * @param request True, activity is requested but not yet checked, false, activity will be executed and granted.
	 */
	public void addCreateProcessInstance( String definitionID, String processID, long timestamp, boolean request );
	
	/**
	 * Will be called when a BPEL process terminates/ends
	 * @param processID unique ID of this process. All activities of this process share this id
	 * @param timestamp The destruction time
	 * @param request True, activity is requested but not yet checked, false, activity will be executed and granted.
	 */
	public void addDestroyProcessInstance( String processID, long timestamp, boolean request );
	
	/**
	 * Will be invoked when an Invoke activity is requested or executed.
	 * @param processID unique ID of the process
	 * @param token unique id of BPEL activity
	 * @param timestamp The invocation time
	 * @param params Array of string parameters
	 * @param request True, activity is requested but not yet checked, false, activity will be executed and granted.
	 * */
	public void addInvoke( String processID, String token, long timestamp, String[] params, boolean request);

	/**
	 * Will be invoked when an Invoke activity response is received.
	 * @param processID unique ID of the process
	 * @param token unique id of BPEL activity
	 * @param timestamp The invocation time
	 * @param returnVal the returned value
	 * @param request True, response is requested but not yet checked, false, response is granted.
	 * */
	public void addEndInvoke( String processID, String token, long timestamp, String returnVal, boolean request );
	
	/**
	 * Will be invoked whenever a variable is changed. 
	 * @param processID unique ID of the process
	 * @param token unique id of BPEL activity
	 * @param timestamp The invocation time
	 * @param varName The name of the variable which is set
	 * @param value the new value of the variable
	 * @param request True, setting is requested but not yet checked, false, setting of the variable is granted.
	 */
	public void addSetVar ( String processID, String token, long timestamp, String varName, String value, boolean request );
	
	/**
	 * Will be invoked whenever a variable is read.
	 * @param processID unique ID of the process
	 * @param token unique id of BPEL activity
	 * @param timestamp The invocation time
	 * @param varName The name of the variable which is read
	 * @param request True, reading is requested but not yet checked, false, reading of the variable is granted.
	 */
	public void addGetVar ( String processID, String token, long timestamp, String varName, boolean request );
	

	/**
	 * This method checks if any policy is violated or not
	 * @return false, if one of the policies is violated, otherwise true
	 * @throws MalformedPolicyException Exception is thrown, when a policy is invalid
	 * @throws PolicyViolatedException Exception is thrown, when a policy has been violated
	 */
	public void checkAllPolicies() throws PolicyViolatedException, MalformedPolicyException;
	
	// AL: checkAllPolicies nur für eine Prozess-Instanz
	public void checkAllPolicies(long pid) throws PolicyViolatedException, MalformedPolicyException;
	
	/**
	 * Adds a policy to the BPEL prolog engine. This policy is always checked whenever checkAllPolicies gets called()
	 * @param pol the policy in prolog format
	 */
	public void addPolicy(Policy pol);
	
	/**
	 * Adds a rule to the BPEL prolog engine.
	 * @param rule a prolog rule
	 */
	public void addRule(String rule);
	
	// AL: printFacts, removeFactsForProcess
	public void printFacts();
	
	public void removeFactsForProcess(Long pid);

}
