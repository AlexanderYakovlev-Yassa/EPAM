package cl_obj.read;

import cl_obj.base.Base;
import cl_obj.library.Food;
import cl_obj.library.Transportation;
import cl_obj.library.Type;
import cl_obj.tour_offers.Tour;

public class ReadBase {
    public Base readBase(){
        Base tours = new Base();
        Tour t0 = new Tour(Type.VACATION, Transportation.AIR, 4, Food.AI, 14, "Просто пляж");
        tours.addTour(t0);
        Tour t1	 = new Tour(Type.VACATION, Transportation.AIR, 	4, Food.AI, 	14, "Роскошная Адриатика");
        tours.addTour(t1);
        Tour t2 = new Tour(Type.VACATION, Transportation.AIR, 4, Food.RO, 21, "Удивительный Несебр");
        tours.addTour(t2);
        Tour t3 = new Tour(Type.VACATION, Transportation.BUS, 4, Food.BB, 14, "Янтарное лето");
        tours.addTour(t3);
        Tour t4 = new Tour(Type.VACATION, Transportation.BUS, 3, Food.FB, 14, "Черноморское приключение");
        tours.addTour(t4);
        Tour t5 = new Tour(Type.VACATION, Transportation.AIR, 3, Food.FB, 10, "Белые пляжи Флориды");
        tours.addTour(t5);
        Tour t6 = new Tour(Type.EXCURSION, Transportation.BUS, 2, Food.BB, 5, "Замки Франции");
        tours.addTour(t6);
        Tour t7 = new Tour(Type.EXCURSION, Transportation.BUS, 4, Food.BB, 3, "Соборы Петербурга");
        tours.addTour(t7);
        Tour t8 = new Tour(Type.EXCURSION, Transportation.BUS, 3, Food.BB, 7, "Удивительная Европа");
        tours.addTour(t8);
        Tour t9 = new Tour(Type.EXCURSION, Transportation.BUS, 2, Food.BB, 3, "Историческая Украина");
        tours.addTour(t9);
        Tour t10 = new Tour(Type.EXCURSION, Transportation.BUS, 0, Food.RO, 1, "Дореволюционная Беларусь");
        tours.addTour(t10);
        Tour t11 = new Tour(Type.TREATMENT, Transportation.AIR, 4, Food.FB, 14, "Бад-Гоштайн, Австрия");
        tours.addTour(t11);
        Tour t12 = new Tour(Type.TREATMENT, Transportation.AIR, 4, Food.FB, 14, "Мариинские лазни");
        tours.addTour(t12);
        Tour t13 = new Tour(Type.TREATMENT, Transportation.AIR, 4, Food.FB, 21, "Лутраки, Греция");
        tours.addTour(t13);
        Tour t14 = new Tour(Type.TREATMENT, Transportation.AIR, 4, Food.FB, 21, "Джимбаран, Индонезия");
        tours.addTour(t14);
        Tour t15 = new Tour(Type.TREATMENT, Transportation.BUS, 4, Food.FB, 21, "Грязелечебницы, Одесса");
        tours.addTour(t15);
        Tour t16 = new Tour(Type.SHOPPING, Transportation.AIR, 2, Food.BB, 3, "Шоптур в Турцию");
        tours.addTour(t16);
        Tour t17 = new Tour(Type.SHOPPING, Transportation.AIR, 2, Food.BB, 3, "Шоптур в Китай");
        tours.addTour(t17);
        Tour t18 = new Tour(Type.SHOPPING, Transportation.BUS, 2, Food.BB, 3, "Шоптур в Польшу");
        tours.addTour(t18);
        Tour t19 = new Tour(Type.SHOPPING, Transportation.AIR, 2, Food.BB, 5, "Шоптур в Индию");
        tours.addTour(t19);
        Tour t20 = new Tour(Type.SHOPPING, Transportation.AIR, 2, Food.BB, 5, "Шоптур в Египет");
        tours.addTour(t20);
        Tour t21 = new Tour(Type.CRUISE, Transportation.SHIP, 4, Food.FB, 7, "Славянская Адриатика");
        tours.addTour(t21);
        Tour t22 = new Tour(Type.CRUISE, Transportation.SHIP, 4, Food.FB, 15, "Гастрономический рай средиземноморья");
        tours.addTour(t22);
        Tour t23 = new Tour(Type.CRUISE, Transportation.SHIP, 4, Food.FB, 12, "Атлантика");
        tours.addTour(t23);
        Tour t24 = new Tour(Type.CRUISE, Transportation.SHIP, 4, Food.FB, 8, "Шумный Тихий океан");
        tours.addTour(t24);
        Tour t25 = new Tour(Type.CRUISE, Transportation.TRAIN, 4, Food.RO, 3, "Горная Австрия");
        tours.addTour(t25);
        return tours;
    }
}
