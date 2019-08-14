/*В строке вставить после каждого символа 'a' символ 'b'.*/

public class Task_3_2_2 {

    public static void main(String[] args) {
        String str = "The average Wall Street salary rose 13 percent last year to its highest level since 2008, when Lehman Brothers Holdings Inc. collapsed.";
        str = str.replaceAll("a", "ab");
        System.out.println(str);
    }

}
