package by.epam.programming_with_classes.tour_agency.data;

import by.epam.programming_with_classes.tour_agency.enumerators.MealType;
import by.epam.programming_with_classes.tour_agency.enumerators.TourType;
import by.epam.programming_with_classes.tour_agency.enumerators.Transportation;
import by.epam.programming_with_classes.tour_agency.objects.Tour;
import by.epam.programming_with_classes.tour_agency.objects.Tours;

public class Data {

    public Tour readTour(String string){

        String[] fields = string.split(", ");

        try {
            TourType type = TourType.valueOf(fields[0]);
            Transportation transportation = Transportation.valueOf(fields[1]);
            int stars = Integer.parseInt(fields[2]);
            MealType meal = MealType.valueOf(fields[3]);
            int days = Integer.parseInt(fields[4]);
            String name = fields[5];
            int cost = Integer.parseInt(fields[6]);

           return new Tour(type,transportation,stars,meal,days,name,cost);
        } catch (Exception e){

            return  null;
        }
    }

    public Tours readTours() {

        String[] records = null;

        try {

            records = readData().split("\n");

            Tours tours = new Tours();
            for (String r : records) {

                Tour tour = readTour(r);
                if(tour != null) {
                    tours.add(tour);
                }
            }
            return tours;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public String readData(){
        return "VACATION, AIR, 4, AI, 14, Роскошная Адриатика, 1500\n" +
                "VACATION, AIR, 4, RO, 21, Удивительный Несебр, 1000\n" +
                "VACATION, BUS, 4, BB, 14, Янтарное лето, 800\n" +
                "VACATION, BUS, 3, FB, 14, Черноморское приключение, 800\n" +
                "VACATION, AIR, 3, FB, 10, Белые пляжи Флориды, 2500\n" +
                "EXCURSION, BUS, 2, BB, 5, Замки Франции, 2000\n" +
                "EXCURSION, BUS, 4, BB, 3, Соборы Петербурга, 150\n" +
                "EXCURSION, BUS, 3, BB, 7, Удивительная Европа, 300\n" +
                "EXCURSION, BUS, 2, BB, 3, Историческая Украина, 100\n" +
                "EXCURSION, BUS, 0, RO, 1, Дореволюционная Беларусь, 30\n" +
                "TREATMENT, AIR, 4, FB, 14, Бад-Гоштайн Австрия, 950\n" +
                "TREATMENT, AIR, 4, FB, 14, Мариинские лазни, 900\n" +
                "TREATMENT, AIR, 4, FB, 21, Лутраки Греция, 1000\n" +
                "TREATMENT, AIR, 4, FB, 21, Джимбаран Индонезия, 1600\n" +
                "TREATMENT, BUS, 4, FB, 21, Грязелечебницы Одессы, 350\n" +
                "SHOPPING, AIR, 2, BB, 3, Шоптур в Турцию, 150\n" +
                "SHOPPING, AIR, 2, BB, 3, Шоптур в Китай, 250\n" +
                "SHOPPING, BUS, 2, BB, 3, Шоптур в Польшу, 80\n" +
                "SHOPPING, AIR, 2, BB, 5, Шоптур в Индию, 200\n" +
                "SHOPPING, AIR, 2, BB, 5, Шоптур в Египет, 150\n" +
                "CRUISE, SHIP, 4, FB, 7, Славянская Адриатика, 500\n" +
                "CRUISE, SHIP, 4, FB, 15, Гастрономический рай средиземноморья, 1500\n" +
                "CRUISE, SHIP, 4, FB, 12, Атлантика, 2500\n" +
                "CRUISE, SHIP, 4, FB, 8, Шумный Тихий океан, 2600\n" +
                "CRUISE, TRAIN, 4, RO, 3, Горная австрия, 800";
    }
}
