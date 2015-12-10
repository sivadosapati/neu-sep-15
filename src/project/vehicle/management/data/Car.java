package project.vehicle.management.data;

public class Car {
    private String id;
    private String dealerID;
    private Category category;
    private Integer year;
    private String make;
    private String model;
    private String trim;
    private String type;
    private Float price;

    public Car(String id, String dealerID, Category category, Integer year, String make,
            String model, String trim, String type, Float price) {
        this.id = id;
        this.dealerID = dealerID;
        this.category = category;
        this.year = year;
        this.make = make;
        this.model = model;
        this.trim = trim;
        this.type = type;
        this.price = price;
    }
    public Car(){}

    public void setID(String id) {this.id = id;}
    public void setDealerID(String dealerID){this.dealerID = dealerID;}
    public void setCategory(Category category){this.category = category;}
    public void setYear(Integer year){this.year = year;}
    public void setMake(String make){this.make = make;}
    public void setModel(String model){this.model = model;}
    public void setTrim(String trim){this.trim = trim;}
    public void setType(String type){this.type = type;}
    public void setPrice(Float price){this.price = price;}
    /*
     * private Date date; private String imageURL; private String exterior; private String interior;
     */
    public String getID(){return id;}
    public String getMake(){return make;}
    public String getDealerID(){return dealerID;}
	public Category getCategory(){return category;}
	public String getModel(){return model;}
	public String getTrim(){return trim;}
	public String getType(){return type;}
	public Integer getYear(){return year;}
	public Float getPrice(){return price;}
	
	public String toString(){
		StringBuffer tempCar = new StringBuffer();
		tempCar.append(id + "~").append(dealerID + "~")
				.append(category.toString() + "~")
				.append(year + "~");
		tempCar.append(make + "~").append(model + "~")
				.append(trim + "~").append(type + "~")
				.append(price);
		return tempCar.toString();
	}
}
