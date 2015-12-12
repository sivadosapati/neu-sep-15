package project.vehicle.management.data;

public class Range {
	private Integer minimum;
	private Integer maximum;
	public Range(Integer min,Integer max){
		minimum=min;
		maximum=max;
	}
	public Integer getMin(){return minimum;}
	public Integer getMax(){return maximum;}
}
