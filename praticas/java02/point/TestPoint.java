package point;

public class TestPoint {
    public static void main(String[] args) {
        Point p1 = new Point();
        Point p2 = new Point(4.5, 10.17);

        p1.move(8.4, 7.4);
        p2.move(87.6, 32.11);

        System.out.println("\nDistance between p1 and p2: " + p1.distance(p2) + "\n");
    }
}
