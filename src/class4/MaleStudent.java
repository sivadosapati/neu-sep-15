package class4;

public class MaleStudent extends Student{
	//Public, Protected, default - scope
	
	public void doSomeWork(){
		//String n = name;
		System.out.println(getName() + " is working ");
		System.out.println("Age is -> "+age);
	}
	
	public void listen(){
		super.listen();
		System.out.println(getName()+" is writing in the book");
	}
}
