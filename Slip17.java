// Q.1 Write a Java Program to implement Abstract Factory Pattern for Shape interface. 


// Shape Interface
interface Shape {
    void draw();
}

// Concrete Shape Classes
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

// Abstract Factory Interface
interface ShapeFactory {
    Shape createShape();
}

// Concrete Factory for Circle
class CircleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Circle();
    }
}

// Concrete Factory for Rectangle
class RectangleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Rectangle();
    }
}

// Concrete Factory for Square
class SquareFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Square();
    }
}

// Factory Producer to get factories by shape type
class FactoryProducer {
    public static ShapeFactory getFactory(String shapeType) {
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new CircleFactory();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new RectangleFactory();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new SquareFactory();
        }
        return null;
    }
}

// Main Test Class named Slip17
public class Slip17 {
    public static void main(String[] args) {
        // Get a Circle factory and draw a Circle
        ShapeFactory circleFactory = FactoryProducer.getFactory("CIRCLE");
        Shape circle = circleFactory.createShape();
        circle.draw();

        // Get a Rectangle factory and draw a Rectangle
        ShapeFactory rectangleFactory = FactoryProducer.getFactory("RECTANGLE");
        Shape rectangle = rectangleFactory.createShape();
        rectangle.draw();

        // Get a Square factory and draw a Square
        ShapeFactory squareFactory = FactoryProducer.getFactory("SQUARE");
        Shape square = squareFactory.createShape();
        square.draw();
    }
}



// output

// Drawing a Circle
// Drawing a Rectangle
// Drawing a Square