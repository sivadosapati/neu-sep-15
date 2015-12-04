package lecture6;

public class WrapperClassTest {
	int i;
	Integer ii;

	public static void main(String args[]) {
		WrapperClassTest wct = new WrapperClassTest();
		wct.ii = new Integer(45);
		System.out.println("int -> "+wct.i);
		System.out.println("Integer -> "+wct.ii);
		System.out.println("Int value -> "+wct.ii.intValue());
		
		String s = "12345";
		int i = Integer.parseInt(s);
		System.out.println(s +" converted to number "+i);
		
		Float f;
		Boolean b;
		Character c;
		Long l;
		
		String ss = "siva";
		String ss1 = new String("siva");
		StringBuffer sb = new StringBuffer("Yan");
		//sb = ss;
		
		int ix = 0;
		Integer ixy = null;
		ixy = ix;
		System.out.println("output "+ixy);
		
		
		ix = 1000;
		ixy = 1000;
		if( ix == ixy.intValue() ){
			System.out.println("Match");
		}
		else{
			System.out.println("Didn't match");
		}
		
	}
}
