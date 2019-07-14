//2. Найти max{min(a, b), min(c, d)}.
public class Exercise_2_2 {

    public static void main(String[] args){

        System.out.println(maxOfMin(1, 2, 3, 4));
        System.out.println(maxOfMin(100, 2222, 53, 4));

    }

    public static double maxOfMin(double a, double b, double c, double d){
        return max(min(a, b),min(c, d));
    }

    public static double max(double a, double b){
        if ( a >= b) return a;
        else return b;
    }

    public static double min(double a, double b){
        if ( a <= b) return a;
        else return b;
    }
}
