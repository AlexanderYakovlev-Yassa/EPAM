package by.epam.programming_with_classes.tour_agency.objects;

import java.util.*;

public class Tours extends ArrayList<Tour>{

    //private ArrayList<Tour> tours;

    public Tours(ArrayList<Tour> tours) {
        super(tours);
    }

    public Tours() {
        super(new ArrayList<Tour>());
    }
}
