import java.util.Objects;

/*
 * Class represents the infinite line on the Cartesian plane.
 * Fields of class are factors of the line equation Y = AX + B.
 * If line is vertical field verical = true and X coordinate restored in b
 **/

public class Line {
    private double a;
    private double b;
    boolean vertical;
    boolean exist;

    public Line(Point a, Point b) {
        double xa;
        double ya;
        double xb;
        double yb;

        if (a.isExist() && b.isExist()) {
            xa = a.getX();
            ya = a.getY();
            xb = b.getX();
            yb = b.getY();

            if ((xa == xb) && (ya != yb)) {
                this.vertical = true;
                this.a = 1;
                this.b = xa;
            } else if ((xa == xb) && (ya == yb)) {
                this.exist = false;
                this.a = Double.NaN;
                this.b = Double.NaN;
                this.vertical = false;
            } else {
                this.exist = true;
                this.vertical = false;
                this.a = (yb - ya) / (xb - xa);
                this.b = ya - this.a * xa;
            }
        } else {
            this.exist = false;
            this.a = Double.NaN;
            this.b = Double.NaN;
            this.vertical = false;
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

    //Returns the intersection point of the lines
    public static Point intersection(Line l1, Line l2) {
        double a1 = l1.a;
        double b1 = l1.b;
        double a2 = l2.a;
        double b2 = l2.b;
        double x;
        double y;
        Point p;
        if (l1.vertical || l2.vertical) {
            if (l1.vertical && !l2.vertical) {
                x = l1.b;
                y = a2 * x + b2;
            } else if (!l1.vertical && l2.vertical) {
                x = l2.b;
                y = a1 * x + b1;
            } else {
                x = Double.NaN;
                y = Double.NaN;
            }

        } else if (a1 == a2) {
            x = Double.NaN;
            y = Double.NaN;

        } else {
            x = (b2 - b1) / (a1 - a2);
            y = a1 * x + b1;
        }
        return p = new Point(x, y);
    }

    //Determine whether or not the poin belongs to the line
    public boolean isPointInLine(Point a) {
        boolean res;
        if (this.exist && a.isExist()) {

            if (this.vertical && (a.getX() == this.b)) {
                res = true;
            } else {
                res = (a.getY() == this.a * a.getX() + this.b);
            }
        } else {
            res = false;
        }
        return res;
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
