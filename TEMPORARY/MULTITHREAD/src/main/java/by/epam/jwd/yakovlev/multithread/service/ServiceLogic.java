package main.java.by.epam.jwd.yakovlev.multithread.service;

import main.java.by.epam.jwd.yakovlev.multithread.entity.Cell;
import main.java.by.epam.jwd.yakovlev.multithread.entity.Matrix;
import main.java.by.epam.jwd.yakovlev.multithread.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;

public interface ServiceLogic {

int getCellRangeSum(ArrayList<Cell> range);
void executeTask() throws ServiceException;
void printResult();
void startGroupOfWorkThread();
public void initialiseTask(int groupCount) throws ServiceException;
Matrix getMatrix();
StringBuffer getResult();
void clearResult();
Matrix buildMatrix() throws ServiceException;
void sendToResultStorage(String result) throws ServiceException;
}
