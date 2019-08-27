public class Main {
    public static void main(String[] args) {
        Test_1 test = new Test_1();
        test.setVariable_1(5);
        test.setVariable_2(-4);
        test.print();
        int max = test.max();
        int sum = test.sum();
        System.out.println("Sum = " + sum + "; max = " + max + ".");
    }
}
