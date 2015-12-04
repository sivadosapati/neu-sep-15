package lecture5;

public class StringImmutabilityTest {
	public static void main(String args[]) {
		String a = "Siva";
		System.out.println("Before changing the string ->"+ a);
		char ch[] = a.toCharArray();
		for( char c : ch){
			System.out.println(c);
		}
		ch[0] = 'D';
		String x = new String(ch);
		System.out.println(x);
		System.out.println("After changing the character -> "+a);
		
		String a1 = "Siva";
		String a11 = "Siva";
		String a2 = new String("Siva");
		String a21 = new String("Si") +"va";
		String a3 = new String("Siva");
		if( a1 == a21){
			System.out.println("True");
		}
		else{
			System.out.println("False");
		}
		
		Student s = new Student();
		Person p = s;
		if( p == s){
			System.out.println("True");
		}
		else{
			System.out.println("False");
		}
		
		StringBuilder builder = new StringBuilder("Siva");
		builder.append("Kumar");
		System.out.println(builder.toString());
	}
}

class Person{
	
}


class Student extends Person{
	
}