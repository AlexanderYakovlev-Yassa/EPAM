package by.epam.programming_with_classes.student.main;



import by.epam.programming_with_classes.student.logic.Logic;
import by.epam.programming_with_classes.student.objects.Student;
import by.epam.programming_with_classes.student.view.View;

public class Main {

    public static void main(String[] args) {
        int[] tmpGrade = new int[5];
        Student st1 = new Student("Иванов И.И.", 315);
        st1.setPerformance(new int[]{8, 9, 8, 9, 10});
        Student st2 = new Student("Петров А.И.", 316);
        st2.setPerformance(new int[]{8, 9, 9, 9, 10});
        Student st3 = new Student("Семенова И.К.", 215);
        st3.setPerformance(new int[]{9, 9, 10, 9, 10});
        Student st4 = new Student("Федоров С.В.", 245);
        st4.setPerformance(new int[]{7, 9, 10, 9, 10});
        Student st5 = new Student("Сидоров К.П.", 456);
        st5.setPerformance(new int[]{10, 9, 8, 9, 10});
        Student st6 = new Student("Кузнецов С.А.", 355);
        st6.setPerformance(new int[]{10, 9, 10, 9, 10});
        Student st7 = new Student("Соколов В.В.", 335);
        st7.setPerformance(new int[]{8, 9, 8, 7, 10});
        Student st8 = new Student("Куликов С.В.", 365);
        st8.setPerformance(new int[]{10, 9, 8, 9, 10});
        Student st9 = new Student("Кабаева О.Е.", 255);
        st9.setPerformance(new int[]{10, 9, 10, 9, 10});
        Student st10 = new Student("Алексеева А.А.", 845);
        st10.setPerformance(new int[]{8, 9, 8, 9, 10});

        Student[] students = {st1, st2, st3, st4, st5, st6, st7, st8, st9, st10};

        Logic logic = new Logic();
        View view = new View();

        System.out.println("Студенту с баллами 9 и 10:");
        view.printStudentArray(logic.studentsWithPerformanceBetterThan(students, 9));
    }
}
