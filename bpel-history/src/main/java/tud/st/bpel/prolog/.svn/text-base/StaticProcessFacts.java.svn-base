package tud.st.bpel.prolog;
import java.io.FileNotFoundException;
import java.io.IOException;

import alice.tuprolog.Struct;
import alice.tuprolog.Term;


public class StaticProcessFacts{
	
	private Struct activityList = new Struct();
	private Struct invokeList = new Struct();
	private String definitionID;
	
	public StaticProcessFacts( String definitionID )
	{
		this.definitionID = definitionID;
	}
	
	
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

	public void addActivity( String token, String parent )
	{
		Term activity = new Struct(
				"s_act", 
				new Struct(token), 
				new Struct(parent)
		);
		
		activityList.append(activity);
	}
	
	public final Struct getActivityList()
	{
		return activityList;
	}
	
	public final Struct getInvokeList()
	{
		return invokeList;
	}
	
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
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		StaticProcessFacts ps = new StaticProcessFacts("ID");
		
		ps.addActivity("/process/sequence/assign","/process/sequence");
		
		//ps.getActivityList();
		ps.addInvoke(	"/process/sequence/invokeFlightService",
					 	"/process/sequence",
					 	"flightPartner",
					 	"fs:FindAFlightServicePortType", 
					 	"findAFlight", 
					 	"flightrequest", 
					 	"flightresponse"
		);
		
		System.out.println(ps.getStaticProcessStruct());
	}

}
