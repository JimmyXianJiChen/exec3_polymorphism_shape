public final class Circle extends Shape{
    private final double r, pi;
    public Circle(int x, int y, double radius){
        this.x = x;
        this.y = y;
        this.r = radius;
        this.pi = Math.PI;
    }
    public double area(){
        return (double) Math.round(this.pi * this.r*this.r*100)/100;
    }
    public double perimeter(){
        return (double) Math.round(2 * this.pi * this.r*100)/100;
    }
}
