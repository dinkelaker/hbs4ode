package tud.st.bpel.history.facts;

/**
 * Use this fact whenever a variable is set!
 * 
 * @author A. Look
 *
 */
public interface WriteVariableFact extends DynamicFact {

	String getVarName();

	String getNewValue();

}
