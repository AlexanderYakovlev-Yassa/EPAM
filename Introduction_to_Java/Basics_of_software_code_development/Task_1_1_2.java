// Вычислить значение выражения по формуле (все переменные принимают действительные значения):

public class Task_1_1_2 {

    public static void main(String[] args){

        System.out.println(quadFunction(5, 3,58));

    }

    public static double quadFunction(double a, double b, double c){
        double quad = (b + Math.sqrt(Math.pow(b, 2) + 4 * a * c))/(2 * a) - Math.pow(a,3) * c + Math.pow(b, -2);
        return quad;
    }
}
