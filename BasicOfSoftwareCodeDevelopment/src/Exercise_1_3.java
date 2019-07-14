//3. Вычислить значение выражения по формуле (все переменные принимают действительные значения):
public class Exercise_1_3 {

    public static void main(String[] args){
        System.out.println(anglFunction(5, 3));
    }

    public static double anglFunction(double x, double y){
        double res = (Math.sin(x) + Math.cos(y))/(Math.cos(x) - Math.sin(y)) * Math.tan(x * y);
        return res;
    }
}
