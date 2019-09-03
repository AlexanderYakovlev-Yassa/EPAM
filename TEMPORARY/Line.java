
import java.util.Objects;

//Class represents the infinite line.
//Fields of class are factors of the line equation Y = AX + B.
public class Line {
    private double a;
    private double b;

    //If a == NaN equation of the line is X = b (vertical line).
    public Line(Point a, Point b) {
            double xa = a.getX();
            double ya = a.getY();
            double xb = b.getX();
            double yb = b.getY();
            if (xa == xb) {
                this.a = Double.NaN;
                this.b = xa;
            } else {
                this.a = (yb - ya) / (xb - xa);
                this.b = ya - this.a * xa;
            }
    }

    public Line(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public static Point intersection(Line l1, Line l2) {
        double a1 = l1.a;
        double b1 = l1.b;
        double a2 = l2.a;
        double b2 = l2.b;
        double x;
        double y;
        Point p;
        if (Double.isNaN(a1)){
            x = b1;
        } else if (Double.isNaN(a2)){
            x = b2;
        } else if (a1 == a2) {

        } else {
            x = (b2 - b1) / (a1 - a2);
            y = a1 * x + b1;
            Point p = new Point(x, y);
        }
        return p;
    }
    //Determine whether or not the poin belongs to the line
    public boolean isPointInLine(Point a){
        System.out.println(this.a);
        System.out.println(this.a * a.getX() + this.b);
        return (a.getY() == this.a * a.getX() + this.b);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Double.compare(line.a, a) == 0 &&
                Double.compare(line.b, b) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}