package src;

public class Circle {
   private double x;
   private double y;
   private double r;
   
   public Circle(double r) {
      this.x = this.y = 0.0;
      this.r = r;
      System.out.println("New Circle");
   }
   public double area() {
      return Math.PI * r * r;
   }
}
