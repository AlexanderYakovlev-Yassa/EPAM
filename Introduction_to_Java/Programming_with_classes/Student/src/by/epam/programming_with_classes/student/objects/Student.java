package by.epam.programming_with_classes.student.objects;

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
        this.performance = new int[5];
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

    public String getName() {
        return name;
    }

    public int getGroupNum() {
        return groupNum;
    }

    public int[] getPerformance() {
        return performance;
    }
}
