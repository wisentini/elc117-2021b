package circle;

public class TestCircle {
    public static void main(String[] args) {
        Circle c1 = new Circle(1.0);
        Circle c2 = new Circle(2.0);

        System.out.println("Area c1: " + c1.area());
        System.out.println("Area c2: " + c2.area());

        Circle c3 = new Circle(4.3, 9.8, 5.0);
        System.out.println("Area c3: " + c3.area());

        Circle[] circles = new Circle[10];

        for (int i = 0; i < circles.length; i++) {
            circles[i] = new Circle();
        }
    }
}
