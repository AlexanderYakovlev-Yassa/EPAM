/*На плоскости заданы своими координатами n точек. Написать метод(методы), определяющие,
 между какими из пар точек самое большое расстояние. Указание. Координаты точек занести в массив.*/

import java.lang.Math;

public class Exercise_2_4_4 {

    public static void main(String[] args) {
        int[] points = {0, 1, 0, 3, -15, 2, -16, -58, 45, 87, 74, 47, 0, 0, 77, -88}; //array contains coordinates of points: x1, y1, x2, y2...
        double d = distance(0, 0, 3, 4);
        int[] twoPoints = pointsWithMaxDistance(points);
        System.out.println("Максимально удаленные друг от друга точки имеют координаты:");
        System.out.println("точка 1   X = " + twoPoints[0] + "  Y = " + twoPoints[1]);
        System.out.println("точка 2   X = " + twoPoints[2] + "  Y = " + twoPoints[3]);
    }
    //returns coordinates of two points with maximal distance
    public static int[] pointsWithMaxDistance(int[] points) { // x1,y1,x2,y2
        int[] p = new int[4];
        double max = 0;
        double d;

        for (int i = 0; i < points.length - 2; i += 2) {
            for (int j = i + 2; j < points.length; j += 2) {
                d = distance(points[i], points[i + 1], points[j], points[j + 1]);
                if (d > max) {
                    max = d;
                    p[0] = points[i];
                    p[1] = points[i + 1];
                    p[2] = points[j];
                    p[3] = points[j + 1];
                }
            }
        }
        return p;
    }
    //returns the distance between two points
    public static double distance(int x1, int y1, int x2, int y2) {
        double d = Math.sqrt(Math.pow((double) (x1 - x2), 2) + Math.pow((double) (y1 - y2), 2));
        return d;
    }
}
