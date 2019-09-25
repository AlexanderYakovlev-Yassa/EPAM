import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

public class Demo {
    public static void main(String[] args) {
        System.out.println("-создаем двигатель и выводим информацию о нем");
        Engine engine = new Engine();
        System.out.println(engine);
        System.out.println("");

        System.out.println("-создаем колесо и выводим подробную информацию о нем");
        Wheel wheel_1 = new Wheel(1);
        System.out.println(wheel_1.getExtInfo());
        System.out.println("");

        System.out.println("-создаем еще 3 колеса и выводим информацию о них");
        Wheel wheel_2 = new Wheel(1);
        Wheel wheel_3 = new Wheel(1);
        Wheel wheel_4 = new Wheel(1);
        Wheel[] wheels = {wheel_1,wheel_2, wheel_3, wheel_4};

        for (Wheel w : wheels)
            System.out.println(w);
        System.out.println("");

        System.out.println("-создаем автомобиль");
        Automobile automobile_1 = new Automobile("Mercedes", engine, wheels, 4, 1, 90);

        System.out.println("-выводим марку автомобиля на консоль");
        System.out.println(automobile_1.getBrand());

        System.out.println("");

        System.out.println("-пытаемся поехать на автомобиле");
        System.out.println(automobile_1.startMoving());
        System.out.println("");

        System.out.println("-запускаем двигатель");
        System.out.println(automobile_1.startEngine());
        System.out.println("");

        System.out.println("-заправляем автомобиль");
        System.out.println(automobile_1.refuel(25));
        System.out.println();

        System.out.println("-запускаем двигатель");
        System.out.println(automobile_1.startEngine());
        System.out.println("");

        System.out.println("-пытаемся поехать на автомобиле");
        System.out.println(automobile_1.startMoving());
        System.out.println("");

        System.out.println("-выводим текущую информацию об автомобиле");
        System.out.println(automobile_1.getInfo());
        System.out.println("");

        System.out.println("-останавливаем автомобиль");
        System.out.println(automobile_1.stopMoving());
        System.out.println("");

        System.out.println("-создаем новое колесо");
        Wheel newWheel = new Wheel(1);
        System.out.println("");

        System.out.println("-меняем колесо");
        System.out.println(automobile_1.changeWheel(newWheel, 0));
        System.out.println("");

        System.out.println("-глушим двигатель");
        System.out.println(automobile_1.stopEngine());
        System.out.println("");

        System.out.println("-меняем колесо");
        System.out.println(automobile_1.changeWheel(newWheel, 0));
        System.out.println("");

        System.out.println("-выводим информацию об установленных на автомобиль колесах");
        System.out.println(automobile_1.getWheelsInfo());

    }
}
