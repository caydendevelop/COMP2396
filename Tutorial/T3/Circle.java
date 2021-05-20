public class Circle {

	private double diameter = 1;
	private static int numberOfObjects = 0;
	private String color = "red";
	private boolean filled = true;

	public Circle() {

		numberOfObjects += 1;
	}

	public Circle(double diameter) {
		this.diameter = diameter;
		numberOfObjects += 1;
	}

	public Circle(double diameter, String color, boolean filled) {
		this.diameter = diameter;
		this.color = color;
		this.filled = filled;
		numberOfObjects += 1;
	}

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	public double getPerimeter() {
		final double pi = 3.14;
		return (diameter * pi);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean getFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public static int getNumberOfObjects() {
		return numberOfObjects;
	}

}
