package circle;

public class Circle {
    private double x;
    private double y;
    private double r;

    public Circle() {
        this.x = 0.0;
        this.y = 0.0;
        this.r = 0.0;

        System.out.println("New Circle");
    }

    public Circle(double r) {
        this.x = 0.0;
        this.y = 0.0;
        this.r = r;

        System.out.println("New Circle");
    }

    public Circle(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;

        System.out.println("New Circle");
    }

    public double area() {
        return Math.PI * this.r * this.r;
    }

    public void setRadius(double radius) {
        this.r = radius;
    }
}
