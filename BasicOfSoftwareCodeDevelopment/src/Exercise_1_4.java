//4. Дано действительное число R вида nnn.ddd (три цифровых разряда в дробной и целой частях).
// Поменять местами дробную и целую части числа и вывести полученное значение числа.
public class Exercise_1_4 {

    public static void main(String[] args){

        System.out.println(chFunction(123.456));

    }

    public static double chFunction(double a){
        int oldOne = (int)(a * 1000);
        int leftPart = oldOne / 1000;
        int rightPart = oldOne - leftPart*1000;
        int newOne = rightPart * 1000 + leftPart;
        return ((double)newOne) / 1000;
    }
}
