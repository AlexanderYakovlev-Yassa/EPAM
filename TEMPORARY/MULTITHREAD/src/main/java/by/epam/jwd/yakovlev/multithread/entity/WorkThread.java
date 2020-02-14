package main.java.by.epam.jwd.yakovlev.multithread.entity;

import main.java.by.epam.jwd.yakovlev.multithread.service.ServiceFactory;
import main.java.by.epam.jwd.yakovlev.multithread.service.ServiceLogic;

import java.util.ArrayList;

public class WorkThread extends Thread {

    private static ServiceLogic LOGIC = ServiceFactory.getINSTANCE().getServiceLogic();

    private int id;

    public WorkThread(int id) {
        super(String.valueOf(id));
        this.id = id;
    }

    @Override
    public void run() {
        super.run();

        Cell crossPointCell = setRandomCellValue(LOGIC.getMatrix().getDiagonalRange(), id);
        //System.out.println("cross point cell of thread N " + id + " - " + crossPointCell.getStringLocation());

        int cruciformRangeCellSum = 0;

        ArrayList<Cell> cruciformRange = LOGIC.getMatrix().getCruciformRange(crossPointCell);
        increaseRandomCellValue(cruciformRange);

        cruciformRangeCellSum = LOGIC.getCellRangeSum(cruciformRange);

        LOGIC.getResult().append(String.format("Tread N %d has returned sum = %d.\n", id, cruciformRangeCellSum));
    }

    private Cell setRandomCellValue(ArrayList<Cell> cellRange, int value){

        boolean successFlag = false;
        Cell cell = null;

        while (!successFlag) {
            int randomIndex = (int) (Math.random() * cellRange.size());
            cell = cellRange.get(randomIndex);
            successFlag = cell.setValueIfFree(value);
        }

        return cell;
    }

    private void increaseRandomCellValue(ArrayList<Cell> cellRange){

        if (cellRange == null){
            return;
        }

        boolean successFlag = false;
        Cell cell = null;

        while (!successFlag) {
            int randomIndex = (int) (Math.random() * cellRange.size());
            cell = cellRange.get(randomIndex);
            successFlag = cell.increaseValue();
        }
    }
}
