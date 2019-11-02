package by.epam.programming_with_classes.time.view;

import by.epam.programming_with_classes.time.objects.Time;

public class View {
    public void printTimeHMS(Time time){
        System.out.println(String.format("%02d:%02d:%02d", time.getHour(), time.getMinute(), time.getSecond()));
    }

    public void printTimeHM(Time time){
        System.out.println(String.format("%02d:%02d", time.getHour(), time.getMinute()));
    }
}
