package test.main.java.by.epam.jwd.yakovlev.multithread.service.impl;

import main.java.by.epam.jwd.yakovlev.multithread.entity.Matrix;
import main.java.by.epam.jwd.yakovlev.multithread.service.ServiceFactory;
import main.java.by.epam.jwd.yakovlev.multithread.service.ServiceLogic;

public class ServiceLogicImplTest {

    private static final ServiceLogic LOGIC =
            ServiceFactory.getINSTANCE().getServiceLogic();

    @org.junit.Test
    public void buildMatrixTest() {

        Matrix expected = buildRequiredMatrix();
        Matrix actual = LOGIC.getMatrix();

        System.out.println(expected.getStringVisualisedMatrix());
        System.out.println();
        System.out.println(actual.getStringVisualisedMatrix());



    }

    private Matrix buildRequiredMatrix(){

        Matrix matrix = new Matrix(5);

        /*  [ 1][10][20][30][40]
            [10][ 2][ 0][ 0][ 0]
            [20][ 0][ 3][ 0][ 0]
            [30][ 0][ 0][ 4][ 0]
            [40][ 0][ 0][ 0][ 5]*/

        for (int i = 0; i < 5; i++) {

            if(i > 0){
                matrix.getCellByLocation(1, i).setValueIfFree(i * 10);
                matrix.getCellByLocation(i, 1).setValueIfFree(i * 10);
            }
        }

        return matrix;
    }
}