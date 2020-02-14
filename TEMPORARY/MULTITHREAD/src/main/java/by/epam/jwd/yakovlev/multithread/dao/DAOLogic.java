package main.java.by.epam.jwd.yakovlev.multithread.dao;

import main.java.by.epam.jwd.yakovlev.multithread.dao.exception.DAOLogicException;

import java.io.File;
import java.util.ArrayList;

public interface DAOLogic {

    ArrayList<String> readMatrixBlueprint() throws DAOLogicException;
    void saveResult(String string) throws DAOLogicException;
}
