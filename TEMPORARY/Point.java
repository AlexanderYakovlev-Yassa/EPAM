import java.util.Objects;

public class Point {
    private double x;
    private double y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    //Returns the distance between two points.
    public static double distance(Point a, Point b){
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        double dist = Math.sqrt(dx * dx + dy * dy);
        return dist;
    }

    public static Point midPoint(Point a, Point b){
        Point c = new Point();
        c.x = a.x + ( b.x - a.x) / 2;
        c.y = a.y + ( b.y - a.y) / 2;
        return  c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}