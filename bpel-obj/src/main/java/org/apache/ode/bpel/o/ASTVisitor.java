package org.apache.ode.bpel.o;


public interface ASTVisitor {
	
	public void visit(OProcess oprocess);
	
	public void visit(OScope oscope);
	
	public void visit(OFaultHandler ofault);
	
	public void visit(OCatch ocatch);
	
	public void visit(OSequence osequence);
	
	public void visit(OActivity oactivity);
	
	public void visit(OAssign oassign);
	
	public void visit(OInvoke oinvoke);
	
	public void visit(OSwitch oswitch);
	
	public void visit(OFlow oflow);
	
	public void visit(OBase base);

}
