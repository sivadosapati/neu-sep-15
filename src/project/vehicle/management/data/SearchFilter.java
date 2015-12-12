package project.vehicle.management.data;

public class SearchFilter {
	private Category[] category;
	private String make;
	private String model;
	private String trim;
	private Integer year;
	private Range priceRange;
	
	public String getMake(){return make;}
	public Category[] getCategory(){return category;}
	public String getModel(){return model;}
	public String getTrim(){return trim;}
	public Integer getYear(){return year;}
	public Range getRange(){return priceRange;}
	
	public void setCategory(Category[] category){this.category = category;}
    public void setYear(Integer year){this.year = year;}
    public void setMake(String make){this.make = make;}
    public void setModel(String model){this.model = model;}
    public void setTrim(String trim){this.trim = trim;}
    public void setRange(Range priceRange){this.priceRange = priceRange;}
	
	public SearchFilter(Category[] category, String make, String model, String trim, Integer year, Range priceRange){
		this.category=category;
		this.make=make;
		this.model=model;
		this.trim=trim;
		this.year=year;
		this.priceRange=priceRange;
	}
	public SearchFilter(){}
}
