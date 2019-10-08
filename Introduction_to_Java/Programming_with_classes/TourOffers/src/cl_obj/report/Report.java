package cl_obj.report;

import cl_obj.filters.ReportFilter;
import cl_obj.tour_offers.Tour;

public class Report {

    private ReportFilter reportFilter;

    public Report(ReportFilter reportFilter) {
        this.reportFilter = reportFilter;
    }

    /*
     * возвращает строку содержащую поля объекта Tour отфильтрованные
     * в соответствии с принятыми параметрами
     * true - поле выводится
     * false - поле не выводится
     * */
    public String report(Tour tour) {
        StringBuilder t = new StringBuilder();
        String nextStr;
        nextStr = reportFilter.isId() ? ("Путевка ID-" + tour.getId()) : "";
        t.append(nextStr);
        nextStr = reportFilter.isName() ? (" " + tour.getName()) : "";
        t.append(nextStr);
        nextStr = reportFilter.isType() ? (" " + tour.getType().getRusName()) : "";
        t.append(nextStr);
        nextStr = reportFilter.isTransportation() ? (" " + tour.getTransportation().getRusName()) : "";
        t.append(nextStr);
        nextStr = reportFilter.isHotel() ? (" отель ") : "";
        t.append(nextStr);
        if (reportFilter.isHotel()) {
            if (tour.getHotelStars() == 0){
                t.append("нет");
            } else {
                for (int i = 0; i < tour.getHotelStars(); i++) {
                    t.append("*");
                }
            }
        }
        nextStr = reportFilter.isFilterFood() ? (" " + tour.getFood().getRusName()) : "";
        t.append(nextStr);
        nextStr = reportFilter.isDays() ? (" " + tour.getDays() + " дней") : "";
        t.append(nextStr);

        return t.toString();
    }

    public String report(Tour[] tours){
        StringBuilder res = new StringBuilder("\t\tСПИСОК ТУРИСТИЧЕСКИХ ПРЕДЛОЖЕНИЙ:\n");
        for (Tour t : tours) {
            res.append(report(t) + "\n");
        }
        return res.toString();
    }
}
