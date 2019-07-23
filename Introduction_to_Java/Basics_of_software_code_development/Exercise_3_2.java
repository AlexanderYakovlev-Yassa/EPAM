
//Вычислить значения функции на отрезке [а,b] c шагом h:

public class Exercise_3_2 {

    public static void main(String[] args){
        function_3_2(-50, 20, 2);
    }

    public static void function_3_2(int begin, int end, int step){
    int x = begin;
    int y = 0;
        while (x <= end){
            y = x <=2 ? -1 * x : x;
            System.out.println("x=" + x + " y=" + y);
            x += step;
        }
    }
}


