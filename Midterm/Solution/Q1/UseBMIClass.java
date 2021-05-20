public class UseBMIClass {
	public static void main (String []args) {
		BMI b1= new BMI ("Ken", 18, 72, 150);
		System.out.println("The BMI for " + b1.getName() + " is " + + b1.getBMI() + " "+ b1.getStatus());
		BMI b2= new BMI ("Dan", 70, 240);
		System.out.println("The BMI for " + b2.getName() + " is " + + b2.getBMI() + " "+ b2.getStatus());
	}
}
