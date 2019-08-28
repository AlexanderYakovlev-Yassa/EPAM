public class MainStudent {
    public static void main(String[] args) {
        Test_2 t = new Test_2();
        Test_2 r = new Test_2(2, 5);
        System.out.println(t.getVariable_1() + "  " + t.getVariable_2());
        t.setVariable_1(15);
        t.setVariable_2(44);
        //System.out.println(t.getVariable_1() + "  " + t.getVariable_2());
        //System.out.println(r.getVariable_1() + "  " + r.getVariable_2());

        Student[] st = new Student[10];
        st[0] = new Student("Петров А.А.", 109875);
        st[1] = new Student("Иванов А.И.", 109875);
        st[2] = new Student("Сидоров И.А.", 109875);
        st[3] = new Student("Васечкин П.А.", 109875);
        st[4] = new Student("Пута С.У.", 109875);
        st[5] = new Student("Бут Е.Р.", 109875);
        st[6] = new Student("Понч И.К.", 109875);
        st[7] = new Student("Кам О.Д.", 109875);
        st[8] = new Student("Сталев А.Р.", 109875);
        st[9] = new Student("Яковлев А.В.", 109875);

        //sets grades
        for (int i = 0; i < st.length; i++) {
            st[i].setPerformance(setRandomGrades());
        }

        for (int i = 0; i < st.length; i++) {
            st[i].print();
        }

        int minGrade = 9;
        boolean flag = false;

        System.out.println("Student with performance better than " + minGrade + ":\n");
        for (int i = 0; i < st.length; i++) {
            flag = st[i].printIfBetterThan(minGrade) ? true : flag;
        }
        if (!flag) {
            System.out.println("There are no students with the all grades better theh " + minGrade);
        }
    }

    //sets random grades to the students
    public static int[] setRandomGrades(){
        int[] gr = new int[5];
        for (int i = 0; i < 5; i++) {
            gr[i] = (int)(Math.random()*4+6.99);
        }
        return gr;
    }
}
