import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class AirlineDemo {

    public static void main(String[] args) {
        int flightNumber = 3665;
        CodeIATA destination = CodeIATA.BOJ;
        DayOfWeek dayOfWeek = DayOfWeek.MON;
        Time departure = new Time("06:00:00");
        Airliner airliner = Airliner.B737300;

        Airline a = new Airline(flightNumber, destination, dayOfWeek, departure, airliner);
        System.out.println(a);
    }
}
