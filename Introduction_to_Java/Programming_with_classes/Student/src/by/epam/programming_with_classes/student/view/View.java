package by.epam.programming_with_classes.student.view;


import by.epam.programming_with_classes.student.objects.Student;

public class View {

    public void printStudentInfo(Student student){
        System.out.println("Student: " + student.getName());
        System.out.println("Group: " + student.getGroupNum());
        System.out.print("Performance: ");
        for (int performance:student.getPerformance()) {
            System.out.print(performance + ", ");
        }
        System.out.print("\b\b.\n\n");
    }

    public void printStudentArray(Student[] students){

        for (Student st: students){
            printStudentNameGroup(st);
        }
    }

    public void printStudentNameGroup(Student student){
        System.out.println(String.format("%20s гр. %s", student.getName(), student.getGroupNum()));
    }
}
