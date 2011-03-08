package tud.st.bpel.prolog;
import alice.tuprolog.Struct;
import alice.tuprolog.Term;

/**
 * This class helps to create the nested static process information fact
 * @author Philipp Zuehlke
 *
 */
public class StaticProcessFactGenerator implements IStaticProcessFactGenerator{
	/**holds a list of all activities*/
	private Struct activityList = new Struct();
	/**holds a list of all invokes*/
	private Struct invokeList = new Struct();
	/**the unique ID of this static process information*/
	private String definitionID;
	
	/**
	 * Constructs a StaticProcessFactGenerator instance
	 * @param definitionID A unique ID of this static process information
	 */
	public StaticProcessFactGenerator( String definitionID )
	{
		this.definitionID = definitionID;
	}
	
	
	/**
	 * With help of this method it is possible to add all relevant information of an invoke activity to the
	 * static process information
	 * @param token The unique token id of the invoke activity
	 * @param parent A unique reference to the parent element
	 * @param partnerLink The partnerlink in the BPEL definition
	 * @param portType The Porttype in the BPEL definition
	 * @param operation The Operation in the BPEL definition
	 * @param inputVariable The Inputvariable in the BPEL definition
	 * @param outputVariable The Outputvariable in the BPEL definition
	 */
	public void addInvoke( String token, 
						 String parent,
						 String partnerLink,
						 String portType,
						 String operation,
						 String inputVariable,
						 String outputVariable)
	{
		Term invoke = new Struct(
				"s_invoke", 
				new Struct(token),
				new Struct(parent),
				new Struct(partnerLink),
				new Struct(portType),
				new Struct(operation),
				new Struct(inputVariable),
				new Struct(outputVariable)
		);
		
		invokeList.append(invoke);
	}

	/**
	 * This methods adds information of a simple activity to the static process information
	 * @param token The unique token id of the activity
	 * @param parent A unique reference to the parent element
	 */
	public void addActivity( String token, String parent )
	{
		Term activity = new Struct(
				"s_act", 
				new Struct(token), 
				new Struct(parent)
		);
		
		activityList.append(activity);
	}
	
	/**
	 * @return a list of all activities
	 */
	public final Struct getActivityList()
	{
		return activityList;
	}
	
	/**
	 * @return a list of all invokes
	 */
	public final Struct getInvokeList()
	{
		return invokeList;
	}
	
	/**
	 * This method aggregates all static information(all activities and all invokes) and puts them into
	 * a tuprolog fact
	 * @return All static information as a tuprolog fact
	 */
	public final Struct getStaticProcessStruct()
	{
		Struct s_process = new Struct(
				"s_process", 
				new Struct(this.definitionID),
				getActivityList(),
				getInvokeList()
		);
		
		return s_process;
	}
}
