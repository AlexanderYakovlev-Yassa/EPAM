package cl_obj.demo;

import cl_obj.base.Base;
import cl_obj.selection.Selection;
import cl_obj.library.Transportation;
import cl_obj.library.Type;
import cl_obj.sort.Sort;
import cl_obj.tour_offers.Tour;
import cl_obj.report.Report;
import cl_obj.filters.*;
import cl_obj.read.ReadBase;

public class Demo {
    public static void main(String[] args) {

        //наполняем базу путевок
        ReadBase read = new ReadBase();
        Base tours = read.readBase();

        //создаем пустой фильтр для отчета о тур предложении
        ReportFilter reportFilter = new ReportFilter();

        //создаем отчет о турпредложении и применяем к нему фильтр
        Report report = new Report(reportFilter);
        System.out.println("\t\tтур предложение 1:");
        System.out.println(report.report(tours.getTours()[1]));
        System.out.println("\t\tтур предложение 2:");
        System.out.println(report.report(tours.getTours()[2]));

        //изменяем фильтр
        //убераем из отчета тип и звездность отеля,
        reportFilter.setType(false);
        reportFilter.setHotel(false);
        //выводим отчет о предложении 2 (для сравнения)
        System.out.println("\t\tтур предложение 2:");
        System.out.println(report.report(tours.getTours()[2]));

        System.out.println("");

        //создаем пустой фильтр для выбора нужных тур предложений
        ListFilter listFilter = new ListFilter();
        //создаем выборку применив пустой фильтр
        Selection i = new Selection();
        //выводим выборку в консоль
        System.out.println("\tвыборка с пустым фильтром (все доступные тур предложения)");
        System.out.println(report.report(i.applyFilter(tours, listFilter)));

        //добавляем в фильтр транспорт (самолет и автобус)
        listFilter.addTransportation(Transportation.AIR, Transportation.BUS);
        //выводим выборку в консоль
        System.out.println("\tвыборка с фильтром по транспорту (самолет, автобус)");
        Tour[] tours1 = i.applyFilter(tours, listFilter);
        System.out.println(report.report(tours1));

        //сортируем ту же выборку по количеству дней по возрастанию
        Sort sort = new Sort();
        System.out.println("\tта же выборка отсортирована по возрастанию количества дней");
        sort.sortByDays(tours1, true);
        System.out.println(report.report(tours1));

        //сортируем ту же выборку по типу питания по убыванию
        System.out.println("\tта же выборка отсортирована по убыванию типа питания");
        sort.sortByFood(tours1, true);

        System.out.println(report.report(tours1));

        //добавляем в фильтр количество дней (21)
        listFilter.setMinDays(21);
        listFilter.setMaxDays(21);
        //выводим выборку в консоль
        System.out.println("\tвыборка с фильтром (самолет, автобус) + (21 день)");
        System.out.println(report.report(i.applyFilter(tours, listFilter)));

        //добавляем в фильтр тип (оздоровление)
        listFilter.addType(Type.TREATMENT);
        //выводим выборку в консоль
        System.out.println("\tвыборка с фильтром (самолет, автобус) + (21 день) + (оздоровление)");
        System.out.println(report.report(i.applyFilter(tours, listFilter)));
    }
}
