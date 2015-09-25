
public class Book {

	String name;
	Book (String name){
		this.name = name;
	}
	Book (){
		
	}
	void fold(){}
	public static void main(String[] args) {
		Book b = new Book();
		Book b1 = new Book();
		Book b2 = new Book("Computer");
		b2.fold();
		b2 = null;
	}

}
