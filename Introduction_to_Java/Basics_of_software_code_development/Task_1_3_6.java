public class Task_1_3_6 {
/*
Вывести на экран соответствий между символами и их численными обозначениями в памяти компьютера.
 */
    public static void main(String[] args){

        tableOfChar();
        System.out.println(Character.getDirectionality((char)64117));
    }

    public static void tableOfChar() {

        for ( int i = 0; i < 65536; i++) {
            char ch = (char) i;

                System.out.print("[ " + i + "  " + ch + " ]" + "\t" + "\t");

            if (i % 5 == 0) {
                System.out.println("");
            }
        }
    }
}
