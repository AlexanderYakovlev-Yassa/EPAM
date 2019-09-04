import java.util.Objects;

/*
* Represents a point on the Cartesian plane
* double x is the X coordinate
* double y is the Y coordinate
* boolean exist is the point state
**/

public class Point {
    private double x;
    private double y;
    private boolean exist;

    public Point() {
        this.x = 0;
        this.y = 0;
        this.exist = true;
    }

    public Point(double x, double y) {
        if (Double.isNaN(x) || Double.isInfinite(x) ||
        Double.isNaN(y) || Double.isInfinite(y)){
            this.exist = false;
            this.x = Double.NaN;
            this.y = Double.NaN;
        } else {
            this.x = x;
            this.y = y;
        }
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = exist ? x : Double.NaN;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
            this.y = exist ? y : Double.NaN;
    }

    public boolean isExist() {
        return exist;
    }

    //Returns the distance between two points.
    public static double distance(Point a, Point b){
        double dist;
        if (a.exist && b.exist) {
            double dx = a.x - b.x;
            double dy = a.y - b.y;
            dist = Math.sqrt(dx * dx + dy * dy);
        } else {
            dist = Double.NaN;
        }
        return dist;
    }

    //Returns the point that located at the middle between points a and b
    public static Point midPoint(Point a, Point b){
        Point c = new Point();
        if (a.exist && b.exist) {
            c.x = a.x + (b.x - a.x) / 2;
            c.y = a.y + (b.y - a.y) / 2;
        } else {
            c.exist = false;
            c.x = Double.NaN;
            c.y = Double.NaN;
        }
        return  c;
    }

    @Override
    public String toString() {
        if (exist) {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        } else {
            return "Point doesn't exist";
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0 &&
                exist == point.exist;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, exist);
    }
}