package by.epam.programming_with_classes.triangle.main;

import by.epam.programming_with_classes.triangle.logic.Logic;
import by.epam.programming_with_classes.triangle.objects.Triangle;
import by.epam.programming_with_classes.triangle.objects.Point;

public class Main {
    public static void main(String[] args) {

        Point a = new Point(0, 0);
        Point b = new Point(0, 1000);
        Point c = new Point(-1000, 1000);

        Triangle triangle = new Triangle(a, b, c);

        Logic logic = new Logic();

        System.out.printf("Периметр треугольника %.2f\n", logic.perimeter(triangle));
        System.out.printf("Площадь треугольника %.2f\n", logic.area(triangle));
        System.out.println("");

        Point mCross = logic.mediansIntersection(triangle);
        System.out.println("Координаты точки пересечения медиан:");
        System.out.println(String.format("x=%d y=%d",mCross.getX(), mCross.getY()));
    }
}