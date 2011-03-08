package tud.st.bpel.prolog;

import alice.tuprolog.Struct;

/**
 * Interface to access the class StatisProcessFactGenerator
 * @author Philipp Zuehlke
 *
 */
public interface IStaticProcessFactGenerator {
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
	public void addInvoke(String token, String parent,
			String partnerLink, String portType, String operation,
			String inputVariable, String outputVariable);

	/**
	 * This methods adds information of a simple activity to the static process information
	 * @param token The unique token id of the activity
	 * @param parent A unique reference to the parent element
	 */
	public void addActivity(String token, String parent);

	
	/**
	 * This method aggregates all static information(all activities and all invokes) and puts them into
	 * a tuprolog fact
	 * @return All static information as a tuprolog fact
	 */
	public Struct getStaticProcessStruct();

}