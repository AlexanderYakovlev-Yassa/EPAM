public class Student {

    private String name;
    private int groupNum;
    private int[] performance;

    public Student() {
        this.name = "";
        this.groupNum = 0;
        this.performance = new int[5];
    }

    public Student(String name, int groupNum) {
        this.name = name;
        this.groupNum = groupNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroupNum(int groupNum) {
        this.groupNum = groupNum;
    }

    public void setPerformance(int[] performance) {
        this.performance = performance;
    }



    public void print(){
        System.out.println("Student: " + name);
        System.out.println("Group: " + groupNum);
        System.out.print("Perfornance: ");
        for (int i = 0; i < performance.length; i++) {
            System.out.print(performance[i] + ", ");
        }
        System.out.print("\b\b.\n\n");
    }

    public boolean printIfBetterThan(int minPerformance){
        boolean flag = true;
        int k = 0;
        while (k < 5){
            if (performance[k] < minPerformance){
                flag = false;
                break;
            }
            k++;
        }
        if (flag) {
            System.out.println("Student: " + name);
            System.out.println("Group: " + groupNum);
            System.out.print("Perfornance: ");
            for (int i = 0; i < performance.length; i++) {
                System.out.print(performance[i] + ", ");
            }
            System.out.print("\b\b.\n\n");
        }
        return flag;
    }
}
