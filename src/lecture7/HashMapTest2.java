package lecture7;

import java.util.Map;
import java.util.TreeMap;

public class HashMapTest2 {

	public static void main(String[] args) {
		TreeMap<Phone, Person> phonePersonMap = new TreeMap<Phone, Person>();
		phonePersonMap.put(new Phone("111-222-3333"), new Person("Yan"));
		phonePersonMap.put(new Phone("111-221-3311"), new Person("Jigang"));
		phonePersonMap.put(new Phone("111-221-3344"), new Person("Siva"));
		System.out.println(phonePersonMap.size());
		for (Map.Entry<Phone, Person> entry : phonePersonMap.entrySet()) {
			System.out.println(entry.getKey().number + " - > "
					+ entry.getValue().name);
		}

	}

}

class Phone implements Comparable {
	String number;

	Phone(String n) {
		this.number = n;
	}

	@Override
	public boolean equals(Object o) {
		Phone p = (Phone) o;
		return number.equals(p.number);
	}

	@Override
	public int hashCode() {
		return number.hashCode();
	}

	@Override
	public int compareTo(Object o) {
		Phone p = (Phone) o;
		return this.number.compareTo(p.number);
	}
}

class Person {
	String name;

	Person(String name) {
		this.name = name;
	}
}
