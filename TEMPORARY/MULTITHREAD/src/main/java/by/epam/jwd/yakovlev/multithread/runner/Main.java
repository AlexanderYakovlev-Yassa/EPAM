package main.java.by.epam.jwd.yakovlev.multithread.runner;

import main.java.by.epam.jwd.yakovlev.multithread.entity.Matrix;
import main.java.by.epam.jwd.yakovlev.multithread.service.exception.ServiceException;
import main.java.by.epam.jwd.yakovlev.multithread.service.ServiceFactory;
import main.java.by.epam.jwd.yakovlev.multithread.service.ServiceLogic;

public class Main {

    private static final ServiceLogic LOGIC = ServiceFactory.getINSTANCE().getServiceLogic();

    public static void main(String[] args) {

        /*Matrix matrix = null;
        try {
            matrix = LOGIC.buildMatrix();
        } catch (ServiceException e) {
            System.out.println(e);;
        }
        if (matrix == null){
            System.out.println("NULL MATRIX !!!");
        } else {
            System.out.println(matrix.getStringVisualisedMatrix());
        }*/

        try {
            LOGIC.initialiseTask(5);
        } catch (ServiceException e) {
            System.out.println("Can't initialise Task !!!");
            System.out.println(e);
        }

        try {
            LOGIC.executeTask();
        } catch (ServiceException e) {
            System.out.println(e.getMessage());//e.printStackTrace();
        }
    }
}
