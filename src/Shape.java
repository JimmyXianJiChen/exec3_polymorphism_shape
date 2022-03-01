import java.text.DecimalFormat;

public abstract class Shape extends Point{
    abstract protected double area();
    abstract protected double perimeter();
    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("##.00");
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getName());
        sb.append("=> ");
        sb.append("中心點: (");
        sb.append(this.getX());
        sb.append(", ");
        sb.append(this.getY());
        sb.append(")");
        sb.append(", 面積: ");
        sb.append(df.format(this.area()));
        sb.append(", 周長: ");
        sb.append(df.format(this.perimeter()));
        return  sb.toString();
    }
    @Override
    public final int getX(){
        return this.x;
    }
    @Override
    public final int getY(){
        return this.y;
    }
}
