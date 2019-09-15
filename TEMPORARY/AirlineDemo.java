import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class AirlineDemo {

    public static void main(String[] args) {

        //создаем поля для наполнения объекта Airline
        int flightNumber = 3665;
        CodeIATA destination = CodeIATA.BOJ;
        DayOfWeek dayOfWeek = DayOfWeek.MON;
        Time departure = new Time("06:00:00");
        Airliner airliner = Airliner.B737300;

        //создаем объект Airline и выводим его на консоль
        Airline a = new Airline(flightNumber, destination, dayOfWeek, departure, airliner);
        System.out.println(a);

        //создаем объект Schedule и добавляем
        //в него ранее созданный рейс
        //и выводим список на консоль
        AirlineSchedule mySchedule = new AirlineSchedule();
        mySchedule.addFlight(a);

        //наполняем рассписание рейсами
        mySchedule.addFlight("3666, BOJ, MON, 06:00:00, B737300");
        mySchedule.addFlight("3666, BOJ, WED, 06:00:00, B737300");
        mySchedule.addFlight("3666, BOJ, FRI, 06:00:00, B737300");
        mySchedule.addFlight("3666, BOJ, SUN, 06:00:00, B737300");
        mySchedule.addFlight("3365, CDG, MON, 06:50:00, A320");
        mySchedule.addFlight("3365, CDG, WED, 06:50:00, A320");
        mySchedule.addFlight("3375, CDG, THU, 18:50:00, A320");
        mySchedule.addFlight("3375, CDG, FRI, 18:50:00, A320");
        mySchedule.addFlight("1254, LAX, MON, 07:30:00, B7767300");
        mySchedule.addFlight("1254, LAX, THU, 07:30:00, B7767300");
        mySchedule.addFlight("1888, LED, MON, 08:00:00, B737500");
        mySchedule.addFlight("1888, LED, TUE, 08:00:00, B737500");
        mySchedule.addFlight("1888, LED, WED, 08:00:00, B737500");
        mySchedule.addFlight("1888, LED, THU, 08:00:00, B737500");
        mySchedule.addFlight("1888, LED, FRI, 08:00:00, B737500");
        mySchedule.addFlight("1888, LED, SAT, 08:00:00, B737500");
        mySchedule.addFlight("1889, LED, MON, 20:00:00, B737500");
        mySchedule.addFlight("1889, LED, TUE, 20:00:00, B737500");
        mySchedule.addFlight("1889, LED, WED, 20:00:00, B737500");
        mySchedule.addFlight("1889, LED, THU, 20:00:00, B737500");
        mySchedule.addFlight("1889, LED, FRI, 20:00:00, B737500");
        mySchedule.addFlight("1889, LED, SAT, 20:00:00, B737500");
        mySchedule.addFlight("2277, SVO, MON, 10:00:00, B737800");
        mySchedule.addFlight("2277, SVO, TUE, 10:00:00, B737800");
        mySchedule.addFlight("2277, SVO, WED, 10:00:00, B737800");
        mySchedule.addFlight("2277, SVO, THU, 10:00:00, B737800");
        mySchedule.addFlight("2277, SVO, FRI, 10:00:00, B737800");
        mySchedule.addFlight("2277, SVO, SAT, 10:00:00, B737800");
        mySchedule.addFlight("2277, SVO, SUN, 10:00:00, B737800");
        mySchedule.addFlight("2278, SVO, MON, 22:00:00, B737800");
        mySchedule.addFlight("2278, SVO, TUE, 22:00:00, B737800");
        mySchedule.addFlight("2278, SVO, WED, 22:00:00, B737800");
        mySchedule.addFlight("2278, SVO, THU, 22:00:00, B737800");
        mySchedule.addFlight("2278, SVO, FRI, 22:00:00, B737800");
        mySchedule.addFlight("2278, SVO, SAT, 22:00:00, B737800");
        mySchedule.addFlight("2278, SVO, SUN, 22:00:00, B737800");
        mySchedule.addFlight("8877, JRB, MON, 11:00:00, B737800");
        mySchedule.addFlight("8877, JRB, THU, 11:00:00, B737800");
        mySchedule.addFlight("9977, JRB, TUE, 23:00:00, B737800");
        mySchedule.addFlight("9977, JRB, FRI, 23:00:00, B737800");
        mySchedule.addFlight("2278, SVO, SUN, 22:00:00, B737800");//уже существующая запись
        mySchedule.addFlight("");                                   //пустая строка
        mySchedule.addFlight("1177, VASS, TUE, 7:00:00, CRJ200");//некорректный пункт назначения
        mySchedule.addFlight("1177, VAR, TUU, 7:00:00, CRJ200");//некорректный пункт день недели
        mySchedule.addFlight("1177, VAR, TUE, 7:88:00, CRJ200");//некорректное время
        mySchedule.addFlight("1177, VAR, TUE, 7:00:00, CRJ220");//некорректный тип самолета
        mySchedule.addFlight("1177, VAR, TUE, 7:00:00, CRJ200, 7:00:00");//некорректное количество полей
        mySchedule.addFlight("1177, VAR, TUE, 7:00:00, CRJ200");
        mySchedule.addFlight("1177, VAR, THU, 7:00:00, CRJ200");
        mySchedule.addFlight("117755, VAR, SAT, 7:00:00, CRJ200");//некорректный номер рейса
        mySchedule.addFlight("s177, VAR, SAT, 7:00:00, CRJ200");//некорректный номер рейса
        System.out.println(mySchedule);

        //создаем список всех рейсов до Петербурга
        // и выводим их на консоль
        AirlineSchedule toPetersburg = AirlineSchedule.allFlightTo(mySchedule, CodeIATA.LED);
        System.out.println("\nРейсы до Петербурга");
        System.out.println(toPetersburg);

        //создаем список всех рейсов с вылетом в пятницу
        // и выводим их на консоль
        AirlineSchedule onFriday = AirlineSchedule.allOnFriday(mySchedule, DayOfWeek.FRI);
        System.out.println("\nРейсы с вылетом в пятницу");
        System.out.println(onFriday);

        //создаем список всех рейсов с вылетом в пятницу
        //и временем вылета после 12:00
        // и выводим их на консоль
        AirlineSchedule onFridayAfter = AirlineSchedule.allOnFridayAfter(mySchedule, DayOfWeek.FRI, new Time("12:00:00"));
        System.out.println("\nРейсы с вылетом в пятницу после 12:00");
        System.out.println(onFridayAfter);
    }
}
