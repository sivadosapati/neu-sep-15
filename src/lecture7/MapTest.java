package lecture7;

import java.util.HashMap;

public class MapTest {

	public static void main(String[] args) {
		HashMap phoneNumberMap = new HashMap();
		phoneNumberMap.put("425-987-7654", "Siva");
		phoneNumberMap.put("425-543-1234", "Jigang");

		System.out.println(phoneNumberMap.size());
		boolean b = phoneNumberMap.containsKey("425-999-1212");
		System.out.println(b);
		b = phoneNumberMap.containsKey("425-987-7654");
		System.out.println(b);
		
		Object value = phoneNumberMap.get("425-987-7654");
		System.out.println(value);
		phoneNumberMap.put("425-987-7654","Yan");
		value = phoneNumberMap.get("425-987-7654");
		System.out.println(value);
		
		
	}

}
