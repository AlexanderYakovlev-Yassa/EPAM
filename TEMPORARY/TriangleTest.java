public class TriangleTest {
    public static void main(String[] args) {
        Triangle t = new Triangle(0,0,0,100,100,100);
        System.out.printf("Периметр треугольника %f\n",t.perimeter());
        System.out.printf("Площадь треугольника %f\n", t.area());
    }
}
