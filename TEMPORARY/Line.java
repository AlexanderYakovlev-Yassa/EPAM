//Class represents the infinite line.
//Fields of class are factors of the line equation Y = AX + B.
public class Line {
    private double a;
    private double b;

    public Line(Point a, Point b) {
        double xa = a.getX();
        double ya = a.getY();
        double xb = b.getX();
        double yb = b.getY();
        this.a = (yb - ya) / (xb - xa);
        this.b = ya - this.a * xa;
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
        double x = (b2 - b1) / (a1 - a2);
        double y = a1 * x + b1;
        Point p = new Point(x, y);
        return p;
    }

    public boolean isPointInLine(Point a){
        return (a.getY() == this.a * a.getX() + this.b);
    }
}
