import java.text.DecimalFormat;
import java.util.Comparator;

abstract public class Shape {
    abstract protected double area();
    abstract protected double perimeter();
    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("##.00");
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getName());
        sb.append("=> ");
        sb.append("面積: ");
        sb.append(df.format(this.area()));
        sb.append(", 周長: ");
        sb.append(df.format(this.perimeter()));
        return  sb.toString();
    }
}
