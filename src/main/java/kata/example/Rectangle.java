package kata.example;

public class Rectangle extends Geometric {

    public Rectangle() {
        super();
    }

    public Rectangle(double base, double height) {
        super(base, height);
    }

    public Rectangle(Rectangle rectangle) {
        super(rectangle);
    }

    @Override
    public double perimeter() {
        return ( this.getBase() * 2 ) + ( this.getHeight() * 2 );
    }

    @Override
    public double area() {
        return this.getBase() * this.getHeight();
    }

}
