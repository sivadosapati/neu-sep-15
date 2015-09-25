

public class Marker {
	final String color;
	int price;
	Marker(){
		this("Red");
	}
	Marker(String color){
		this.color = color;
		price = 2;
	}
	public String toString(){
		return "Color -> "+color+ " : Price -> "+price;
	}
	public static void main(String args[]){
		Marker m = new Marker();
		System.out.println(m);
		m = new Marker("Blue");
		System.out.println(m);
		//m.color = "Brown";
		System.out.println(m);
	}
}
