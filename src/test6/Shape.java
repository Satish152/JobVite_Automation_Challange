package test6;

public abstract class Shape {
private double width;
private double height;

public Shape(double width,double height){
	super();
	this.height=height;
	this.width=width;
}

public void setWidth(double width){
	this.width=width;
}

public double getWidth(){
	return width;
}

public void setHeight(double height){
	this.height=height;
}

public double getHeight(){
	return height;
}

public abstract void area();
}
