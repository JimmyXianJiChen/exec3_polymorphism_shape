public class Circle extends Shape{
    private double r, pi;
    public Circle(double radius){
        this.r = radius;
        this.pi = Math.PI;
    }
    public final double area(){
        return (double) Math.round(this.pi * this.r*this.r*100)/100;
    }
    public final double perimeter(){
        return (double) Math.round(2 * this.pi * this.r*100)/100;
    }
}
