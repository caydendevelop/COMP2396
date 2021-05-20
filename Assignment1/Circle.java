public class Circle {

  private Position p;
  private double r;

  public Circle(Position p, double r) {
    this.p = p;
    this.r = r;
  }

  public void setPosition(Position p) {
    this.p = p;
  }

  public void setRadius(double r) {
    this.r = r;
  }

  public Position getPosition() {
    return p;
  }

  public double getRadius() {
    return r;
  }

  public double getArea() {
    return Math.PI * r * r;
  }

  public boolean isCollidedWith(Circle c) {
    double distX = this.p.getX() - c.p.getX();
    double distY = this.p.getY() - c.p.getY();
    double distOfCircle = Math.sqrt( (distX*distX) + (distY*distY) );
    double sumOfRadius = this.r + c.r;

    return distOfCircle < sumOfRadius ? true : false;
  }

  public static void main(String[] args) {
    Circle c1 = new Circle(new Position(10, 10), 5);
    Circle c2 = new Circle(new Position(20, 10), 5);
    System.out.println("Reporting c1:");
    System.out.println("r: " + c1.getRadius());
    System.out.println("Area:" + c1.getArea());
    c1.setPosition(new Position(18, 10));
    Position c1_p = c1.getPosition();
    System.out.println("c1 is now at " + c1_p.getX() + ", " + c1_p.getY());
    if (c1.isCollidedWith(c2) == true) {
    System.out.println("c1 and c2 collide");
    } else {
    System.out.println("c1 and c2 do not collide");
    }
    }
  
}
