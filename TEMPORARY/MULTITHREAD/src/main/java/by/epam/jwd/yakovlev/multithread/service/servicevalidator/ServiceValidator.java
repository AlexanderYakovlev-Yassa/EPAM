package main.java.by.epam.jwd.yakovlev.multithread.service.servicevalidator;

import main.java.by.epam.jwd.yakovlev.multithread.service.ServiceFactory;
import main.java.by.epam.jwd.yakovlev.multithread.service.ServiceLogic;

public class ServiceValidator {

    private static ServiceValidator INSTANCE = new ServiceValidator();

    private final ServiceLogic LOGIC = ServiceFactory.getINSTANCE().getServiceLogic();

    private ServiceValidator() {
    }

    public static ServiceValidator getINSTANCE() {
        return INSTANCE;
    }

    boolean isTaskInitialised(){


        return true;
    }
}
