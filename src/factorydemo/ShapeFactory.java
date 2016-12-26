package factorydemo;

public class ShapeFactory {
	IShape shapeSelected;
	String shape;

	public ShapeFactory(String shape) {
		this.shape = shape;
	}

	public IShape getShape() {

		if (shape == "circle") {
			return new Circle();
		} else if (shape == "rectangle") {
			{
				return new Rectangle();
			}
		} else if (shape.equalsIgnoreCase("square")) {
			return new Square();
		}
		return null;

	}
}
