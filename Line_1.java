import java.math.*;
public class Line_1 {

    public static void main(String[] args){
        System.out.println(zFunction(5, 3,58));
        System.out.println(quadFunction(5, 3,58));
        System.out.println(anglFunction(5, 3));
        System.out.println(chFunction(123.456));
        System.out.println(time(9587));
        System.out.println(area(-2, 1));
    }

    public static double zFunction(double a, double b, double c){
        double z = ((a - 3) * b / 2) + c;
        return z;
    }

    public static double quadFunction(double a, double b, double c){
        double quad = (b + Math.sqrt(Math.pow(b, 2) + 4 * a * c))/(2 * a) - Math.pow(a,3) * c + Math.pow(b, -2);
        return quad;
    }

    public static double anglFunction(double x, double y){
        double res = (Math.sin(x) + Math.cos(y))/(Math.cos(x) - Math.sin(y)) * Math.tan(x * y);
        return res;
    }

    public static double chFunction(double a){
        int i = (int)a;
        double b = a - i;
        return ((double)(Math.round(b * 1000000 + i ))) / 1000;
    }

    public static String time(int sec){
        int hours = sec / 3600;
        int minutes = (sec - hours * 3600) / 60;
        int secundes = sec - hours * 3600 - minutes * 60;
        String timeStr = hours + "ч " + minutes  + "мин " + secundes + "с.";
        return timeStr;
    }

    public static boolean area(int x, int y){
        return ((y <= 0) && (y >= -3)) && ((x >= -4) && (x <= 4)) || ((y >= 0) && (y <= 4)) && ((x >= -2) && (x <= 2));
    }
}
