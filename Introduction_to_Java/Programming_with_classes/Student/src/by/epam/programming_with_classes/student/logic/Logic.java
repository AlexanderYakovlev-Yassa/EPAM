package by.epam.programming_with_classes.student.logic;

import by.epam.programming_with_classes.student.objects.Student;

import java.util.Arrays;

public class Logic {

    public Student[] studentsWithPerformanceBetterThan(Student[] students, int minPerformance){
        Student[] studentsWP = new Student[0];
        boolean goodPerf;

        for (Student st : students){
            goodPerf = true;
            for (int perf: st.getPerformance()){
                if (perf < minPerformance){
                    goodPerf = false;
                    break;
                }
            }
            if (goodPerf) {
                studentsWP = Arrays.copyOf(studentsWP, studentsWP.length + 1);
                studentsWP[studentsWP.length - 1] = st;
            }
        }

        return studentsWP;
    }
}
