package kata.example;

public abstract class Geometric {

    private double height;
    private double base;

    public Geometric() {
        this.base = 0;
        this.height = 0;
    }

    public Geometric(double base, double height) {
        this.height = height;
        this.base = base;
    }

    public Geometric(Geometric geometric) {
        this.base = geometric.base;
        this.height = geometric.height;
    }

    public abstract double perimeter();
    public abstract double area();

    public double getHeight() {
        return height;
    }

    public double getBase() {
        return base;
    }
}
