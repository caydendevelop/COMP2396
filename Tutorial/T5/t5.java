class A {
  int n;

  public A() {
    this.n = 1;
  }

  public void calculate() {
    this.n = 4 * this.n;
  }

  public void print() {
    calculate();
    System.out.println("In A: " + this.n);
  }
}

class B extends A {
  int n;

  public B() {
    this.n = 10;
  }

  public void calculate() {
    this.n = 4 * super.n;
  }

  public void print() {
    calculate();
    System.out.println("In B: " + this.n);
  }
}

class C extends B {
  int n;

  public C() {
    this.n = 100;
  }

  public void calculate() {
    this.n = 4 * this.n;
  }

  public void print() {
    super.print();
    System.out.println("In C: " + this.n);
  }
}

public class t5 {
  public static void main(String[] args) {
    A x1 = new A();
    x1.print();
    B x2 = new B();
    x2.print();
    C x3 = new C();
    x3.print();
  }
}