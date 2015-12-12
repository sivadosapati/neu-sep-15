package project.vehicle.management.data;

public class SortCriteria {
	private String attribute;
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	
	private boolean sequence;
	
	public void setSequence(boolean sequence) {
		this.sequence = sequence;
	}
	public SortCriteria(String a, boolean s){
		attribute = a;
		sequence = s;
	}
	
	public String getAttribute(){return attribute;}
	public boolean getSequence(){return sequence;}
}
