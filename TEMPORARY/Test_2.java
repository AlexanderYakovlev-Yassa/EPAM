public class Test_2 {
    private int variable_1;
    private int variable_2;

    public Test_2(int variable_1, int variable_2) {
        this.variable_1 = variable_1;
        this.variable_2 = variable_2;
    }

    public Test_2() {
        this.variable_1 = 0;
        this.variable_2 = 0;
    }

    public void setVariable_1(int variable_1) {
        this.variable_1 = variable_1;
    }

    public void setVariable_2(int variable_2) {
        this.variable_2 = variable_2;
    }

    public int getVariable_1() {
        return variable_1;
    }

    public int getVariable_2() {
        return variable_2;
    }
}

