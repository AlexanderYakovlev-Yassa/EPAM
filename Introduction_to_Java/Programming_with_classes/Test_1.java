public class Test_1 {
    int variable_1;
    int variable_2;


    public void setVariable_1(int variable_1) {
        this.variable_1 = variable_1;
    }

    public void setVariable_2(int variable_2) {
        this.variable_2 = variable_2;
    }

    public  int sum(){
        return variable_1 + variable_2;
    }

    public void print(){
        System.out.println("Variable 1: " + variable_1);
        System.out.println("Variable 2: " + variable_2);
    }

    public int max(){
        int max = variable_1 > variable_2 ? variable_1 : variable_2;
        return max;
    }
}
