package test6;

public class ShapeMain {

	public static void main(String[] args) {
		try{
			double width=100;
			double height=50;
			Shape triangleShape=new Triangle(width, height);
			triangleShape.area();
			Shape rectangleShape=new Rectangle(width, height);
			rectangleShape.area();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
