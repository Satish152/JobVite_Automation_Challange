package test6;

public class Triangle extends Shape{

	public Triangle(double width, double height) {
		super(width, height);
	}

	@Override
	public void area() {
		System.out.println("Triangle ==> Area: "+(super.getWidth()*super.getHeight()/2));	
	}

}
