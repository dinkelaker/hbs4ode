package tud.st.bpel.prolog;
import java.util.Vector;

import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.Prolog;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Struct;
import alice.tuprolog.Term;
import alice.tuprolog.Theory;


/**
 * This class is the heart of the BPEL Prolog Engine. 
 * It contains the Prolog engine and saves as well all policies.
 * Should be accessed through the interface.
 * @author Philipp Zuehlke
 *
 */
public class BPELPrologEngine implements IBPELPrologEngine {
	/**a reference to the tuProlog engine*/
	private Prolog engine = new Prolog();
	
	/**a vector of all policies*/
	private Vector<Policy> policies = new Vector<Policy>();
		
//	Example for defining new clauses:
//	private final static String theories = 
//		"invoke(ProcessID,Token,Timestamp,Params):-invoke(ProcessID,Token,Timestamp,Params,false).\n" +
//		"invoke_req(ProcessID,Token,Timestamp,Params):-invoke(ProcessID,Token,Timestamp,Params,true).\n" +
//		"hasbeen_invoked(ProcessID,Token,Timestamp):-invoke(ProcessID,Token,Timestamp,_),invoke_req(ProcessID,Token,Timestamp,_).\n"
//	;
	
	/**
	 * Constructs an instance of this class
	 * @param addConstistencyPolicies When true, policies concerning the consistency are added to the list of policies
	 */
	public BPELPrologEngine(boolean addConsistencyPolicies)
	{
//		Example for defining new clauses:
//		try {
//			engine.addTheory(new Theory(theories));
//		} catch (InvalidTheoryException e) {
//			e.printStackTrace();
//		}
		
		if(addConsistencyPolicies) //has the flag been set?
			addConsistencyPolicies();
	}
	
	/**
	 * This private methods adds policies to this engine to ensure consistency of the database
	 */
	private void addConsistencyPolicies()
	{
		//policy violated, when invoke happens _after_ corresponding end_invoke
		addPolicy("invoke(ProcessID,Token,T1,_,_)," +
				"end_invoke(ProcessID,Token,T2,_,_)," +
				"T1>T2."
			);
		
		//policy violated, when destroy_process happens before create_process
		addPolicy("create_process(_,ProcessID,CreateT,_)," +
				"destroy_process(ProcessID,DestroyT,_)," +
				"CreateT>DestroyT."
			);
		
		//policy violated, when invoke happens before process is created
		addPolicy("create_process(_,ProcessID,CreateT,_)," +
				"invoke(ProcessID,_,Time,_,_)," +
				"CreateT>Time."
			);
		
		//policy violated, when invoke happens after process is destroyed
		addPolicy("destroy_process(ProcessID,DestroyT,_)," +
				"invoke(ProcessID,_,Time,_,_)," +
				"Time>DestroyT."
			);
		
		//policy violated, when end_invoke happens before process is created
		addPolicy("create_process(_,ProcessID,CreateT,_)," +
				"end_invoke(ProcessID,_,Time,_,_)," +
				"CreateT>Time."
			);
		
		//policy violated, when end_invoke happens after process is destroyed
		addPolicy("destroy_process(ProcessID,DestroyT,_)," +
				"end_invoke(ProcessID,_,Time,_,_)," +
				"Time>DestroyT."
			);
		
		//policy violated, when get_var happens before process is created
		addPolicy("create_process(_,ProcessID,CreateT,_)," +
				"get_var(ProcessID,_,Time,_,_)," +
				"CreateT>Time."
			);
		
		//policy violated, when get_var happens after process is destroyed
		addPolicy("destroy_process(ProcessID,DestroyT,_)," +
				"get_var(ProcessID,_,Time,_,_)," +
				"Time>DestroyT."
			);
		
		//policy violated, when set_var happens before process is created
		addPolicy("create_process(_,ProcessID,CreateT,_)," +
				"set_var(ProcessID,_,Time,_,_,_)," +
				"CreateT>Time."
			);
		
		//policy violated, when set_var happens after process is destroyed
		addPolicy("destroy_process(ProcessID,DestroyT,_)," +
				"set_var(ProcessID,_,Time,_,_,_)," +
				"Time>DestroyT."
			);
		
		//policy violated, when invoke has no corresponding static process information
		addPolicy("invoke(ProcessID,Token,_,_,_)," +
						   "create_process(DefinitionID,ProcessID,_,_)," +
						   "s_process(DefinitionID,_,Invokes)," +
						   "\\+member(s_invoke(Token,_,_,_,_,_,_),Invokes)."
				);
		
		//policy violated, when end_invoke has no corresponding static process information
		addPolicy("end_invoke(ProcessID,Token,_,_,_)," +
				   		   "create_process(DefinitionID,ProcessID,_,_)," +
				   		   "s_process(DefinitionID,_,Invokes)," +
				   		   "\\+member(s_invoke(Token,_,_,_,_,_,_),Invokes)."
				);
		
		/* AL: invoke kann sowohl lesender als auch schreibender zurgriff sein
		//policy violated, when set_var has no corresponding static process information		
		addPolicy("set_var(ProcessID,Token,_,_,_,_)," +
						   "create_process(DefinitionID,ProcessID,_,_)," +
						   "s_process(DefinitionID,Activities,_)," +
		   		   		   "\\+member(s_act(Token,_),Activities)."
				);
		
		
		//policy violated, when get_var has no corresponding static process information		
		addPolicy("get_var(ProcessID,Token,_,_,_)," +
						   "create_process(DefinitionID,ProcessID,_,_)," +
						   "s_process(DefinitionID,Activities,_)," +
				   		   "\\+member(s_act(Token,_),Activities)."
				);
		*/
		
		// 
	
		addPolicy("set_var(ProcessID,Token,_,_,_,_)," +
				   "create_process(DefinitionID,ProcessID,_,_)," +
				   "s_process(DefinitionID,Activities,Invokes)," +
				   "((\\+member(s_act(Token,_),Activities))," +
					"(\\+member(s_invoke(Token,_,_,_,_,_,_),Invokes))).");
		

		addPolicy("get_var(ProcessID,Token,_,_,_)," +
		   "create_process(DefinitionID,ProcessID,_,_)," +
		   "s_process(DefinitionID,Activities,Invokes)," +
		   "((\\+member(s_act(Token,_),Activities))," +
		   "(\\+member(s_invoke(Token,_,_,_,_,_,_),Invokes))).");
	}

	/**
	 * This method adds a single fact to the prolog database
	 * @param fact the fact to add
	 */
	private void addFact(Term fact)
	{
		try {
			Struct struct = new Struct();
			struct.append(fact);
			engine.addTheory(new Theory(struct));
		} catch (InvalidTheoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Adds all static process facts to the BPEL Prolog Engine. It is possible to add several 
	 * StaticProcessFacts as long as their DefinitionID differs
	 * @param spf the instance which holds the static process facts
	 */
	// @Override
	public void addStaticProcessFacts(IStaticProcessFactGenerator spf) {
		addFact(spf.getStaticProcessStruct());
	}


	/**
	 * Will be called when a new BPEL process is created
	 * @param definitionID The unique ID of the corresponding static process facts
	 * @param processID unique ID of this process. All activities of this process share this id
	 * @param timestamp The creation time
	 * @param request True, activity is requested but not yet checked, false, activity will be executed and granted.
	 */
	// @Override
	public void addCreateProcessInstance(String definitionID, String processID, long timestamp, boolean request) {
		Term createprocess = new Struct(
				"create_process", 
				new Struct(definitionID),
				new Struct(processID),
				new alice.tuprolog.Long(timestamp),
				new Struct(new Boolean(request).toString())
		);
		
		addFact(createprocess);
		
	}

	/**
	 * Will be called when a BPEL process terminates/ends
	 * @param processID unique ID of this process. All activities of this process share this id
	 * @param timestamp The destruction time
	 * @param request True, activity is requested but not yet checked, false, activity will be executed and granted.
	 */
	// @Override
	public void addDestroyProcessInstance(String processID, long timestamp, boolean request) {
		Term destroyprocess = new Struct(
				"destroy_process", 
				new Struct(processID),
				new alice.tuprolog.Long(timestamp),
				new Struct(new Boolean(request).toString())
		);
		
		addFact(destroyprocess);
	}

	/**
	 * Will be invoked when an Invoke activity response is received.
	 * @param processID unique ID of the process
	 * @param token unique id of BPEL activity
	 * @param timestamp The invocation time
	 * @param returnVal the returned value
	 * @param request True, response is requested but not yet checked, false, response is granted.
	 * */
	// @Override
	public void addEndInvoke(String processID, String token, long timestamp,
			String returnVal, boolean request) {
		Term end_invoke = new Struct(
				"end_invoke", 
				new Struct(processID),
				new Struct(token), 
				new alice.tuprolog.Long(timestamp),
				new Struct(returnVal),
				new Struct(new Boolean(request).toString())
			);
			
		
		addFact(end_invoke);
	}

	/**
	 * Will be invoked when an Invoke activity is requested or executed.
	 * @param processID unique ID of the process
	 * @param token unique id of BPEL activity
	 * @param timestamp The invocation time
	 * @param params Array of string parameters
	 * @param request True, activity is requested but not yet checked, false, activity will be executed and granted.
	 * */
	// @Override
	public void addInvoke(String processID, String token, long timestamp,
			String[] params, boolean request) {
		Struct list = new Struct();
		for( String s : params )
			list.append(new Struct(s));
		
		Term invoke = new Struct(
				"invoke", 
				new Struct(processID),
				new Struct(token), 
				new alice.tuprolog.Long(timestamp),
				list,
				new Struct(new Boolean(request).toString())
			);
			
		
		addFact(invoke);
	}

	/**
	 * Will be invoked whenever a variable is read.
	 * @param processID unique ID of the process
	 * @param token unique id of BPEL activity
	 * @param timestamp The invocation time
	 * @param varName The name of the variable which is read
	 * @param request True, reading is requested but not yet checked, false, reading of the variable is granted.
	 */
	// @Override
	public void addGetVar(String processID, String token, long timestamp,
			String varName, boolean request) {
		Term end_invoke = new Struct(
				"get_var", 
				new Struct(processID),
				new Struct(token), 
				new alice.tuprolog.Long(timestamp),
				new Struct(varName),
				new Struct(new Boolean(request).toString())
			);
			
		addFact(end_invoke);
	}


	/**
	 * Will be invoked whenever a variable has changed. 
	 * @param processID unique ID of the process
	 * @param token unique id of BPEL activity
	 * @param timestamp The invocation time
	 * @param varName The name of the variable which is set
	 * @param value the new value of the variable
	 * @param request True, setting is requested but not yet checked, false, setting of the variable is granted.
	 */
	// @Override
	public void addSetVar(String processID, String token, long timestamp,
			String varName, String value, boolean request) {
		Term end_invoke = new Struct(
				"set_var", 
				new Struct(processID),
				new Struct(token), 
				new alice.tuprolog.Long(timestamp),
				new Struct(varName),
				new Struct(value),
				new Struct(new Boolean(request).toString())
			);
			
		addFact(end_invoke);
	}

	/**
	 * Adds a policy to the BPEL prolog engine. This policy is always checked whenever checkAllPolicies gets called()
	 * @param policy the policy in prolog format
	 */
	// @Override
	public void addPolicy(Policy policy) {
		policies.add(policy);
	}
	
	private void addPolicy(String policy) {
		policies.add(new Policy(null, null, policy));
	}
	
	/**
	 * This method checks if any policy is violated or not
	 * @return false, if one of the policies is violated, otherwise true
	 * @throws MalformedPolicyException Exception is thrown, when a policy is invalid
	 * @throws PolicyViolatedException Exception is thrown, when a policy has been violated
	 */
	// @Override
	public void checkAllPolicies() throws PolicyViolatedException, MalformedPolicyException
	{
		for( Policy policy : policies )
		{
			executeCheckAllPolicies(policy, null);
		}
	}
	
	// AL: checkAllPolicies nur für eine Prozess-Instanz
	public void checkAllPolicies(long pid) throws PolicyViolatedException, MalformedPolicyException {
		
		for( Policy policy : policies )
		{	
			executeCheckAllPolicies(policy, pid+"");
		}
		
	}
	
	private void executeCheckAllPolicies(Policy policy, String pid) throws PolicyViolatedException, MalformedPolicyException {
		
		String pol = policy.getPolicy();
		
		// Replace ProcessID with pid
		if(pid != null) {
			pol = pol.replaceAll("ProcessID", "'" + pid + "'");
		}
		
		try {
			SolveInfo si = engine.solve(pol);
			if(si.isSuccess()) { //policy is violated 
				throw new PolicyViolatedException(policy,si);
			}
		} catch (MalformedGoalException e) {
			//just throw our exception class
			throw new MalformedPolicyException(policy);
		}
	}
	
	/**
	 * Debug method
	 * @param str The query to solve
	 * @return The result of the query
	 * @throws MalformedGoalException Exception, when the query was invalid
	 */
	public SolveInfo solve(String str) throws MalformedGoalException {
		return engine.solve(str);
	}
	
	/**
	 * DEBUG METHOD
	 * Prints all facts in the database to the screen
	 */
	public void printFacts()
	{
		System.out.println(engine.getTheory());
	}

	// @Override
	public void addRule(String rule) {
		try {
			engine.addTheory(new Theory(rule));
		} catch (InvalidTheoryException e) {
			e.printStackTrace();
		}
	}
	
	// AL: Fakten müssen sich auch entfernen lassen!
	public void removeFactsForProcess(Long pid) {
		// engine.clearTheory();
		try {
			System.out.println("Removing process facts for process: " + pid);
			engine.solve("retractall(get_var('"+pid+"',_,_,_,_)).");
			engine.solve("retractall(set_var('"+pid+"',_,_,_,_,_)).");
			engine.solve("retractall(invoke('"+pid+"',_,_,_,_)).");
			engine.solve("retractall(end_invoke('"+pid+"',_,_,_,_)).");
			engine.solve("retractall(create_process(_,'"+pid+"',_,_)).");
			engine.solve("retractall(destroy_process('"+pid+"',_,_)).");
		} catch (MalformedGoalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}