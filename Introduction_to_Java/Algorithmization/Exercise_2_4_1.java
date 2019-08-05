public class Exercise_2_4_1 {

    public static int g_c_d(int a, int b) {
        if (a == b) {
            return a;
        }
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        if ((a == 1) || (b == 1)) {
            return 1;
        }

        if (a % 2 == 0) {
            if (b % 2 != 0) {
                return g_c_d(a / 2, b);
            } else {
                return 2 * g_c_d(a / 2, b / 2);
            }

            if (a > b) {
                return g_c_d((a - b) / 2, b);
            } else {
                return g_c_d(a, (b - a) / 2);
            }
        }
    }
}
