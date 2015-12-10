package project.vehicle.management.data;

public class SortCriteria {
	private String attribute;
	private boolean sequence;
	
	public SortCriteria(String a, boolean s){
		attribute = a;
		sequence = s;
	}
	
	public String getAttribute(){return attribute;}
	public boolean getSequence(){return sequence;}
}
