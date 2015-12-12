package project.vehicle.management.data;

public class SearchFilter {
	private boolean category[] = new boolean[3];
	private String make;
	private String model;
	private String trim;
	private Integer year;
	private Range priceRange;
	private String keywords;
	
	public String getMake(){return make;}
	public boolean[] getCategory(){return category;}
	public String getModel(){return model;}
	public String getTrim(){return trim;}
	public Integer getYear(){return year;}
	public Range getRange(){return priceRange;}
	public String getKeywords(){return keywords;}
	
	public void setCategory(boolean[] category){this.category = category;}
    public void setYear(Integer year){this.year = year;}
    public void setMake(String make){this.make = make;}
    public void setModel(String model){this.model = model;}
    public void setTrim(String trim){this.trim = trim;}
    public void setRange(Range priceRange){this.priceRange = priceRange;}
    public void setKeywords(String keywords){this.keywords = keywords;}
	
	public SearchFilter(boolean category[], String make, String model, String trim, Integer year, Range priceRange, String keywords){
		this.category=category;
		this.make=make;
		this.model=model;
		this.trim=trim;
		this.year=year;
		this.priceRange=priceRange;
		this.keywords = keywords;
	}
	public SearchFilter(){}
}
