package kata.example;

public class Square extends Geometric {

    public Square(double base) {
        super(base, base);
    }

    @Override
    public double perimeter() {
        return this.getBase() * 4;
    }

    @Override
    public double area() {
        return this.getBase() * this.getHeight();
    }

    public double side() {
        return this.getBase();
    }
}
