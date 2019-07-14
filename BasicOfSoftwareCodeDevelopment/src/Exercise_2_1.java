//1. Даны два угла треугольника (в градусах).
// Определить, существует ли такой треугольник, и если да, то будет ли он прямоугольным.
public class Exercise_2_1 {

    public static void main(String[] args){

        int alpha, beta;
        alpha = 30;
        beta = 60;
        System.out.println("angles: alpha=" + alpha + "; beta=" + beta + "   " + triangle(alpha, beta));
        alpha = 35;
        beta = 60;
        System.out.println("angles: alpha=" + alpha + "; beta=" + beta + "   " + triangle(alpha, beta));
        alpha = -35;
        beta = 60;
        System.out.println("angles: alpha=" + alpha + "; beta=" + beta + "   " + triangle(alpha, beta));
        alpha = 125;
        beta = 60;
        System.out.println("angles: alpha=" + alpha + "; beta=" + beta + "   " + triangle(alpha, beta));


    }

    public static String triangle(double alpha, double beta){
        String res;
        if (trExist(alpha, beta)) {
            res = "the triangle is sxisting";
            if(trRight(alpha, beta)){
                res += " and it's right triangle";
            }
        }
        else res = "triangle isn't existing";
        return res;
    }

    private static boolean trExist(double alpha, double beta){

        return (alpha + beta < 180) && alpha > 0 && beta > 0;
    }

    private static boolean trRight(double alpha, double beta){

        return (alpha + beta == 90);
    }

}
