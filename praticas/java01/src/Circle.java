public class Circle {
    private double x;
    private double y;
    private double r;

    public Circle(double radius) {
        x = y = 0.0;
        r = radius;
        System.out.println("New Circle");
    }

    public void setRadius(double r) {
        this.r = r;
    }

    public double area() {
        return Math.PI * r * r;
    }
}
