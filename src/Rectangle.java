public class Rectangle extends Shape{
    private final double h, w;
    public Rectangle(int x, int y, double height, double width){
        this.x = x;
        this.y = y;
        this.h = height;
        this.w = width;
    }
    public final double area(){
        return (double) Math.round(this.h*this.w*100)/100;
    }
    public final double perimeter(){
        return (double) Math.round(2 * (this.h + this.w)*100)/100;
    }
}
