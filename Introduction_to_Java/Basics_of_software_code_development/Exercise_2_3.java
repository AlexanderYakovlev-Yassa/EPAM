//3. Даны три точки А(х1,у1), В(х2,у2) и С(х3,у3).
// Определить, будут ли они расположены на одной прямой.

import java.awt.Point;

public class Exercise_2_3 {

    public static void main(String[] args){
        Point a = new Point(0, 0);
        Point b = new Point(0, 0);
        Point c = new Point(25, 15);
        int x = 5;

       System.out.print(isInLine(a, b, c) ?
               "The points are in the same line" :
               "The points are not in the same line");
    }

    public static boolean isInLine(Point a, Point b, Point c){
        double tolerance = 0.0001;
        int dX1 = a.x - b.x; System.out.println("dX1=" + dX1);
        int dX2 = a.x - c.x; System.out.println("dX2=" + dX2);
        int dY1 = a.y - b.y; System.out.println("dY1=" + dY1);
        int dY2 = a.y - c.y; System.out.println("dY2=" + dY2);

        boolean res;
        if ((dX1 == 0) || (dX2 == 0)){                                      //
            if (((dX1 == 0) && (dY1 == 0)) || ((dX2 == 0) && (dY2 == 0))){  // this part is for avoid
                res = true; //System.out.println("br1");                    //   division by zero
            } else {                                                        //
                res = false; //System.out.println("br2");                   //
            }
        } else {
            double tg1 = (double)dY1/(double)dX1; //System.out.println("tg1=" + tg1);
            double tg2 = (double)dY2/(double)dX2; //System.out.println("tg2=" + tg2);
            if (tg1 == tg2){
                res = true;
            } else {
                res = false;
            }
        }
        return res;

    }
}
