package test6;

public class Rectangle extends Shape{

	public Rectangle(double width, double height) {
		super(width, height);
	}

	@Override
	public void area(){
		System.out.println("Rectangle ==>Area: "+(super.getWidth()*super.getHeight()));
	}
}
