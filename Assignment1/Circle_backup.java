public class Circle_backup {
  private double x;
  private double y;
  private double r;
  public Circle_backup(double x, double y, double r) {
    this.x = x;
    this.y = y;
    this.r = r;
  }
  public void setPosition(double x, double y) {
    this.x = x;
    this.y = y;
  }
  public void setRadius(double r) {
    this.r = r;
  }
  public double getPositionX() {
    return x;
  }
  public double getPositionY() {
    return y;
  }
  public double getRadius() {
    return r;
  }
  public double getArea() {
    return Math.PI * r * r;
  }
  public boolean isCollidedWith(Circle_backup c) {
    double distX = this.x - c.x;
    double distY = this.y - c.y;
    double distOfCircle = Math.sqrt( (distX*distX) + (distY*distY) );
    double sumOfRadius = this.r + c.r;

    return distOfCircle > sumOfRadius ? true : false;
  }
  
}

