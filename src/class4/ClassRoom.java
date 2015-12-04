package class4;

public class ClassRoom {
	public static void main(String args[]) {
		MaleStudent murali = new MaleStudent();
		murali.setName("Murali");
		murali.listen();
		//murali.getGpa().setScore("3.5");
		

		FemaleStudent yang = new FemaleStudent();
		yang.setName("Yang");
		yang.listen();
		yang.doVolunteeringForHSG();
	}
}
