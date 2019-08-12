

// Для данной области составить линейную программу, которая печатает true,
// если точка с координатами (х, у) принадлежит закрашенной области,
// и false — в противном случае:

public class Task_1_1_6 {

    public static void main(String[] args) {
        System.out.println(area(-2, 1));
        validation();
    }

    public static boolean area(int x, int y) {
        return ((y <= 0) && (y >= -3)) && ((x >= -4) && (x <= 4)) || ((y >= 0) && (y <= 4)) && ((x >= -2) && (x <= 2));
    }

    public static void validation() {
        String k;
        for (int i = 5; i > -5; i--) {
            for (int j = -5; j < 7; j++) {
                if (area(j, i)) k = "X";
                else k = "O";
                System.out.print(k + " ");
            }
            System.out.println("");
        }
    }
}
