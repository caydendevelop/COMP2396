public class BMI {

  private String name = "";
  private int age = 0;
  private double weight = 0;
  private double height = 0;

  public BMI(String name, int age, double height, double weight) {
    this.name = name;
    this.age = age;
    this.weight = weight;
    this.height = height;
  }

  public BMI(String name, double height, double weight ) {
    this.name = name;
    this.age = 25;
    this.weight = weight;
    this.height = height;
  }

  public double getBMI() {
    double meter = height * 0.0254;
    double kg = weight * 0.45359237;
    double old_bmi = kg / (meter * meter);
    double new_bmi = Math.round(old_bmi * 100.0) / 100.0;
    return new_bmi;
    
  }

  public String getStatus(){
    double bmi = getBMI();
    if(bmi < 16)
      return "seriously underweight";
    else if(bmi >=16 && bmi <18){
      return "underweight";
    }
    else if(bmi >=18 && bmi <24){
      return "normal weight";
    }
    else if(bmi >=24 && bmi <29){
      return "over weight";
    }
    else if(bmi >=29 && bmi <35){
      return "seriously over weight";
    }
    else {
      return "gravely over weight";
    }
  }

  public String getName(){
    return name;
  }

  public int getAge(){
    return age;
  }

  public double getWeight(){
    return weight;
  }

  public double getHeight(){
    return height;
  }
}