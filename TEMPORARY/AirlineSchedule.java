import java.lang.reflect.Array;
import java.util.Arrays;

public class AirlineSchedule {
    Airline[] schedule;

    public AirlineSchedule(Airline[] schedule) {
        this.schedule = schedule;
    }

    public AirlineSchedule() {
        this.schedule = new Airline[0];
    }

    /*добавляет рейс (Airline) в рассписание (AirlineSchedule)
     *аргумент типа Airline
     *при успешном добавлении рейса в рассписание
     *метод возвращает номер добавленного рейса.
     *при наличии в рассписании идентичного рейса
     *рейс в рассписание не добавляется, а метод возвращает -1
     */
    public int addFlight(Airline newFlight) {
        int res;
        if (this.isAlreadyExist(newFlight)) {                 //проверка на наличие записи в рассписании
            res = -1;
        } else {                                              //добавляем запись в рассписание
            this.schedule = Arrays.copyOf(this.schedule, this.schedule.length + 1);
            this.schedule[this.schedule.length - 1] = newFlight;
            res = this.schedule[this.schedule.length -1].getFlightNumber();
        }
        return  res;
    }

    /*добавляет рейс (Airline) в рассписание (AirlineSchedule)
     *аргумент строка вида:
     * "1235, BOJ, WED, 06:00:00, B737300"
     *где:
     *"1235" - номер рейса, четырехзначное целое,
     *"BOJ" - пункт назначения, элемент перечесления CodeIATA,
     *"WED" - день недели, элемент перечесления DayOfWeek,
     *"06:00:00" - время вылета, объект типа Time,
     *"B737300" - тип самолета, элемент перечесления Airliner
     * разделитель полей ", ".
     *при успешном добавлении рейса в рассписание
     *метод возвращает номер добавленного рейса.
     *при получении некорректных входных данных
     *рейс в рассписание не добавляется, а метод возвращает -1
     */
    public int addFlight(String newFlight) {
        String[] field = newFlight.split(", ");
        int flightNumber = 0;
        CodeIATA destination;
        DayOfWeek dayOfWeek;
        Time departure;
        Airliner airliner;
        int res;
        if (field.length == 5) {                                    //проверка на количество полей в записи
            try {                                                   //проверка корректности номера рейса
                flightNumber = Integer.parseInt(field[0]);
                if (flightNumber < 1000 || flightNumber > 9999) {
                    flightNumber = -1;
                }
            } catch (NumberFormatException e) {
                flightNumber = -1;
            }
            try {                                                   //проверка корректности пункта назначения
                destination = CodeIATA.valueOf(field[1]);
            } catch (IllegalArgumentException e) {
                destination = null;
            }
            try {                                                   //проверка корректности дня недели
                dayOfWeek = DayOfWeek.valueOf(field[2]);
            } catch (IllegalArgumentException e) {
                dayOfWeek = null;
            }
            try {                                                   //проверка корректности времени
                departure = new Time(field[3]);
            } catch (IllegalArgumentException e) {
                departure = null;
            }
            try {                                                   //проверка корректности типа самолета
                airliner = Airliner.valueOf(field[4]);
            } catch (IllegalArgumentException e) {
                airliner = null;
            }
            if ((flightNumber != -1) &&                             //проверка на корректность всех полей вместе
                    (destination != null) &&
                    (dayOfWeek != null) &&
                    (departure != null) &&
                    (airliner != null)) {
                Airline airline = new Airline(flightNumber, destination, dayOfWeek, departure, airliner);
                if (this.isAlreadyExist(airline)) {                 //проверка на наличие записи в рассписании
                    res = -1;
                } else {                                            //добавляем запись в рассписание
                    this.schedule = Arrays.copyOf(this.schedule, this.schedule.length + 1);
                    this.schedule[this.schedule.length - 1] = airline;
                    res = flightNumber;
                }
            } else {
                res = -1;
            }
        } else {
            res = -1;
        }
        return  res;
    }

    /*
    *метод проверяет имеется ли идентичная запись в рассписании
    *метод возвращает true - если такая запись уже существует
    */
    private boolean isAlreadyExist(Airline airline){
        boolean res = false;
        for (Airline existed : this.schedule){
            if (airline.equals(existed)) {
                res = true;
                break;
            }
        }
        return  res;
    }

    public Airline[] getSchedule() {
        return schedule;
    }

    //возвращает рассписание рейсов до указанного пункта назначения
    public static AirlineSchedule allFlightTo(AirlineSchedule schedule, CodeIATA destination){
        AirlineSchedule newList = new AirlineSchedule();
        for (Airline flight : schedule.schedule) {
            if (flight.getDestination() == destination) {
                newList.addFlight(flight);
            }
        }
        return newList;
    }

    //возвращает рассписание рейсов для указанного дня недели
    public static AirlineSchedule allOnFriday(AirlineSchedule schedule, DayOfWeek day){
        AirlineSchedule newList = new AirlineSchedule();
        for (Airline flight : schedule.schedule) {
            if (flight.getDayOfWeek() == day) {
                newList.addFlight(flight);
            }
        }
        return newList;
    }

    //возвращает рассписание рейсов для указанного дня недели
    //позже указанного времени
    public static AirlineSchedule allOnFridayAfter(AirlineSchedule schedule, DayOfWeek day, Time time){
        AirlineSchedule newList = new AirlineSchedule();
        for (Airline flight : schedule.schedule) {
            if ((flight.getDayOfWeek() == day) && (time.compare(flight.getDeparture()) < 0)) {
                newList.addFlight(flight);
            }
        }
        return newList;
    }

    @Override
    public String toString() {
        StringBuilder schedule = new StringBuilder("Рассписание рейсов:\n");
        schedule.append(String.format("%-7s %-16s %-12s %-12s  %s\n",
                "N ",
                "пункт",
                "день",
                "время",
                "тип"));
        schedule.append(String.format("%-7s %-16s %-12s %-12s  %s\n-------------------------------------------------------------------\n",
                "рейса",
                "назначения",
                "недели",
                "вылета",
                "самолета"));

        for (int i = 0; i < this.schedule.length; i++) {
            schedule.append(String.format("%-7d %-16s %-12s %-12s  %s\n",
                    this.schedule[i].getFlightNumber(),
                    this.schedule[i].getDestination().getCity(),
                    this.schedule[i].getDayOfWeek().getRusLong(),
                    this.schedule[i].getDeparture().toStringShort(),
                    this.schedule[i].getAirliner()));
        }
        return schedule.toString();
    }
}
