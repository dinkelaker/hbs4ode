package tud.st.bpel.history.facts;

import java.util.Iterator;

import tud.st.bpel.prolog.IStaticProcessFactGenerator;

/**
 * This fact should be added when a process has been registered
 * or started
 * 
 * Engines need to provide an implementation that
 * collects static process facts
 * 
 * @author A. Look
 *
 */
public interface BpelProcess extends DynamicFact {

	public String getName();

	public Iterable<StaticActivityFact> getStaticActivityFacts();
	
	public Iterable<StaticInvokeFact> getStaticInvokeFacts();

}
