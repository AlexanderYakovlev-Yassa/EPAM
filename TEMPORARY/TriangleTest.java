public class TriangleTest {
    public static void main(String[] args) {
        Point a = new Point(0, 0);
        Point b = new Point(0, 100);
        Point c = new Point(-100, 100);
        Triangle t = new Triangle(a.getX(), a.getY(), b.getX(), b.getY(), c.getX(), c.getY());
        System.out.printf("Периметр треугольника %f\n", t.perimeter());
        System.out.printf("Площадь треугольника %f\n", t.area());
        System.out.println("");
        Point mA = a;
        Point mBC = Point.midPoint(b, c);
        Point mB = b;
        Point mAC = Point.midPoint(a, c);
        double[] mCross = t.mediansIntersection();
        System.out.println(mCross[0] + "  " + mCross[1]);
        System.out.println(t.toString());
        System.out.println(t.hashCode());
    }
}