package factorydemo;

public class FactoryPatternDemo {
public static void main(String[] args) {
	ShapeFactory shape=new ShapeFactory("rectangle");
	IShape shapeSelected=shape.getShape();
    shapeSelected.draw();

	}
}
