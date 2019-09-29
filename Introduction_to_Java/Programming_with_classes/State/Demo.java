public class Demo {

    public static void main(String[] args) {

        //создаем и наполняем государство
        State bel = setState();

        //выводим детальную информацию о государстве
        System.out.println(bel.getDetailedInfo());
        //System.out.println("");

        //выводим столицу государства
        System.out.print("Столица: ");
        System.out.println(bel.getCapital());

        //выводим количество областей
        System.out.print("Количество областей: ");
        System.out.println(bel.getRegionsCount());

        //выводим площадь страны
        System.out.printf("Площадь страны: %.2f кв.км\n", bel.getArea());

        //выводим список областных центров
        System.out.println("Областные центры:");
        for (City c : bel.getRegionCapitals()){
            System.out.println("\t" + c);
        }
    }

    public static State setState() {
        int res = 0;
        State s = null;
        City c = null;
        District d = null;
        Region r = null;
        double a = 0.0;
        int p = 0;

        s = new State();//создаем государство
        s.setName("Беларусь");//задаем название государства
        c = s.addCity("Минск");//создаем город и добавляем его в города страны
        s.setCapital(c);//задаем столицу государства

        r = new Region();//создаем область
        r.setName("Брестская");//задаем название области
        c = s.addCity("Брест");//создаем город и добавляем его в города страны
        r.setCapital(c);//задаем столицу области

        d = new District();//создаем район
        d.setName("Барановичский");//задаем название района
        c = s.addCity("Барановичи");//создаем город и добавляем его в города страны
        d.setCenter(c);//задаем районный центр
        a = 2171.88;//площадь района
        d.setArea(a);//задаем площадь района
        p = 30344;//население района
        d.setPopulation(p);//задаем население района
        r.addDistrict(d);//добавляем район в область

        d = new District();
        d.setName("Берёзовский");
        c = s.addCity("Берёза");
        d.setCenter(c);
        a = 1412.77;
        d.setArea(a);
        p = 62331;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Брестский");
        c = s.addCity("Брест");
        d.setCenter(c);
        a = 1544.11;
        d.setArea(a);
        p = 42588;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Ганцевичский");
        c = s.addCity("Ганцевичи");
        d.setCenter(c);
        a = 1709.58;
        d.setArea(a);
        p = 26954;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Дрогичинский");
        c = s.addCity("Дрогичин");
        d.setCenter(c);
        a = 1855.06;
        d.setArea(a);
        p = 35809;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Жабинковский");
        c = s.addCity("Жабинка");
        d.setCenter(c);
        a = 684.17;
        d.setArea(a);
        p = 24151;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Ивановский");
        c = s.addCity("Иваново");
        d.setCenter(c);
        a = 1551.41;
        d.setArea(a);
        p = 37842;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Ивацевичский");
        c = s.addCity("Ивацевичи");
        d.setCenter(c);
        a = 2998.11;
        d.setArea(a);
        p = 53709;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Каменецкий");
        c = s.addCity("Каменец");
        d.setCenter(c);
        a = 1687.11;
        d.setArea(a);
        p = 34388;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Кобринский");
        c = s.addCity("Кобрин");
        d.setCenter(c);
        a = 1687.11;
        d.setArea(a);
        p = 84625;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Лунинецкий");
        c = s.addCity("Лунинец");
        d.setCenter(c);
        a = 2708.51;
        d.setArea(a);
        p = 66194;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Ляховичский");
        c = s.addCity("Ляховичи");
        d.setCenter(c);
        a = 1352.31;
        d.setArea(a);
        p = 24767;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Малоритский");
        c = s.addCity("Малорита");
        d.setCenter(c);
        a = 1373.63;
        d.setArea(a);
        p = 24152;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Пинский");
        c = s.addCity("Пинск");
        d.setCenter(c);
        a = 3252.77;
        d.setArea(a);
        p = 45943;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Пружанский");
        c = s.addCity("Пружаны");
        d.setCenter(c);
        a = 2825.91;
        d.setArea(a);
        p = 46341;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Столинский");
        c = s.addCity("Столин");
        d.setCenter(c);
        a = 3342.06;
        d.setArea(a);
        p = 72797;
        d.setPopulation(p);
        r.addDistrict(d);

        s.addRegion(r);

        r = new Region();
        r.setName("Витебская");
        c = s.addCity("Витебск");
        r.setCapital(c);
        d = new District();
        d.setName("Бешенковичский");
        c = s.addCity("Бешенковичи");
        d.setCenter(c);
        a = 1249.65;
        d.setArea(a);
        p = 15187;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Браславский");
        c = s.addCity("Браслав");
        d.setCenter(c);
        a = 2270.07;
        d.setArea(a);
        p = 25153;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Верхнедвинский");
        c = s.addCity("Верхнедвинск");
        d.setCenter(c);
        a = 2140.76;
        d.setArea(a);
        p = 20900;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Витебский");
        c = s.addCity("Витебск");
        d.setCenter(c);
        a = 2705.12;
        d.setArea(a);
        p = 36640;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Глубокский");
        c = s.addCity("Глубокое");
        d.setCenter(c);
        a = 1759.58;
        d.setArea(a);
        p = 36565;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Городокский");
        c = s.addCity("Городок");
        d.setCenter(c);
        a = 2980.13;
        d.setArea(a);
        p = 22622;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Докшицкий");
        c = s.addCity("Докшицы");
        d.setCenter(c);
        a = 2267.61;
        d.setArea(a);
        p = 22392;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Дубровенский");
        c = s.addCity("Дубровно");
        d.setCenter(c);
        a = 1249.69;
        d.setArea(a);
        p = 13903;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Лепельский");
        c = s.addCity("Лепель");
        d.setCenter(c);
        a = 1822.22;
        d.setArea(a);
        p = 32519;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Лиозненский");
        c = s.addCity("Лиозно");
        d.setCenter(c);
        a = 1417.63;
        d.setArea(a);
        p = 14985;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Миорский");
        c = s.addCity("Миоры");
        d.setCenter(c);
        a = 1786.64;
        d.setArea(a);
        p = 19619;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Оршанский");
        c = s.addCity("Орша");
        d.setCenter(c);
        a = 1707.66;
        d.setArea(a);
        p = 154943;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Полоцкий");
        c = s.addCity("Полоцк");
        d.setCenter(c);
        a = 3178.55;
        d.setArea(a);
        p = 106939;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Поставский");
        c = s.addCity("Поставы");
        d.setCenter(c);
        a = 2096.44;
        d.setArea(a);
        p = 35152;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Россонский");
        c = s.addCity("Россоны");
        d.setCenter(c);
        a = 1926.87;
        d.setArea(a);
        p = 9042;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Сенненский");
        c = s.addCity("Сенно");
        d.setCenter(c);
        a = 1966.05;
        d.setArea(a);
        p = 20667;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Толочинский");
        c = s.addCity("Толочин");
        d.setCenter(c);
        a = 1498.56;
        d.setArea(a);
        p = 24121;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Ушачский");
        c = s.addCity("Ушачи");
        d.setCenter(c);
        a = 1489.38;
        d.setArea(a);
        p = 12942;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Чашникский");
        c = s.addCity("Чашники");
        d.setCenter(c);
        a = 1481.12;
        d.setArea(a);
        p = 29940;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Шарковщинский");
        c = s.addCity("Шарковщина");
        d.setCenter(c);
        a = 1189.18;
        d.setArea(a);
        p = 14351;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Шумилинский");
        c = s.addCity("Шумилино");
        d.setCenter(c);
        a = 1695.4;
        d.setArea(a);
        p = 17523;
        d.setPopulation(p);
        r.addDistrict(d);

        s.addRegion(r);

        r = new Region();
        r.setName("Гомельская");
        c = s.addCity("Гомель");
        r.setCapital(c);
        d = new District();
        d.setName("Брагинский");
        c = s.addCity("Брагин");
        d.setCenter(c);
        a = 1960.46;
        d.setArea(a);
        p = 11779;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Буда-Кошелёвский");
        c = s.addCity("Буда-Кошелёво");
        d.setCenter(c);
        a = 1594.50;
        d.setArea(a);
        p = 29087;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Ветковский");
        c = s.addCity("Ветка");
        d.setCenter(c);
        a = 1558.62;
        d.setArea(a);
        p = 17810;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Гомельский");
        c = s.addCity("Гомель");
        d.setCenter(c);
        a = 1951.4;
        d.setArea(a);
        p = 68182;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Добрушский");
        c = s.addCity("Добруш");
        d.setCenter(c);
        a = 1452.72;
        d.setArea(a);
        p = 35538;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Ельский");
        c = s.addCity("Ельск");
        d.setCenter(c);
        a = 1365.68;
        d.setArea(a);
        p = 14887;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Житковичский");
        c = s.addCity("Житковичи");
        d.setCenter(c);
        a = 2916.27;
        d.setArea(a);
        p = 34916;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Жлобинский");
        c = s.addCity("Жлобин");
        d.setCenter(c);
        a = 2110.77;
        d.setArea(a);
        p = 101661;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Калинковичский");
        c = s.addCity("Калинковичи");
        d.setCenter(c);
        a = 2756.24;
        d.setArea(a);
        p = 58662;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Кормянский");
        c = s.addCity("Корма");
        d.setCenter(c);
        a = 949.15;
        d.setArea(a);
        p = 13056;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Лельчицкий");
        c = s.addCity("Лельчицы");
        d.setCenter(c);
        a = 3221.31;
        d.setArea(a);
        p = 23511;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Лоевский");
        c = s.addCity("Лоев");
        d.setCenter(c);
        a = 1045.53;
        d.setArea(a);
        p = 11514;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Мозырский");
        c = s.addCity("Мозырь");
        d.setCenter(c);
        a = 1603.47;
        d.setArea(a);
        p = 133953;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Наровлянский");
        c = s.addCity("Наровля");
        d.setCenter(c);
        a = 1588.82;
        d.setArea(a);
        p = 10394;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Октябрьский");
        c = s.addCity("Октябрьский");
        d.setCenter(c);
        a = 1381.19;
        d.setArea(a);
        p = 13197;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Петриковский");
        c = s.addCity("Октябрьский");
        d.setCenter(c);
        a = 2835.18;
        d.setArea(a);
        p = 26369;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Речицкий");
        c = s.addCity("Речица");
        d.setCenter(c);
        a = 2713.95;
        d.setArea(a);
        p = 97188;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Рогачёвский");
        c = s.addCity("Рогачёв");
        d.setCenter(c);
        a = 2066.99;
        d.setArea(a);
        p = 56037;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Светлогорский");
        c = s.addCity("Светлогорск");
        d.setCenter(c);
        a = 1899.91;
        d.setArea(a);
        p = 82243;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Хойникский");
        c = s.addCity("Хойники");
        d.setCenter(c);
        a = 2027.74;
        d.setArea(a);
        p = 18798;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Чечерский");
        c = s.addCity("Чечерск");
        d.setCenter(c);
        a = 1229.88;
        d.setArea(a);
        p = 14217;
        d.setPopulation(p);
        r.addDistrict(d);

        s.addRegion(r);

        r = new Region();
        r.setName("Гродненская");
        c = s.addCity("Гродно");
        r.setCapital(c);
        d = new District();
        d.setName("Берестовицкий");
        c = s.addCity("Большая Берестовица");
        d.setCenter(c);
        a = 74.58;
        d.setArea(a);
        p = 15193;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Волковысский");
        c = s.addCity("Волковыск");
        d.setCenter(c);
        a = 1192.85;
        d.setArea(a);
        p = 69105;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Вороновский");
        c = s.addCity("Вороново");
        d.setCenter(c);
        a = 1418.9;
        d.setArea(a);
        p = 24335;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Гродненский");
        c = s.addCity("Гродно");
        d.setCenter(c);
        a = 2594.05;
        d.setArea(a);
        p = 49466;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Дятловский");
        c = s.addCity("Дятлово");
        d.setCenter(c);
        a = 1544.09;
        d.setArea(a);
        p = 23774;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Зельвенский");
        c = s.addCity("Зельва");
        d.setCenter(c);
        a = 869.69;
        d.setArea(a);
        p = 14375;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Ивьевский");
        c = s.addCity("Ивье");
        d.setCenter(c);
        a = 1845.50;
        d.setArea(a);
        p = 22458;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Кореличский");
        c = s.addCity("Кореличи");
        d.setCenter(c);
        a = 109.66;
        d.setArea(a);
        p = 19336;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Лидский");
        c = s.addCity("Лида");
        d.setCenter(c);
        a = 1566.74;
        d.setArea(a);
        p = 131240;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Мостовский");
        c = s.addCity("Мосты");
        d.setCenter(c);
        a = 142.04;
        d.setArea(a);
        p = 27735;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Новогрудский");
        c = s.addCity("Новогрудок");
        d.setCenter(c);
        a = 1668.01;
        d.setArea(a);
        p = 44630;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Ошмянский");
        c = s.addCity("Ошмяны");
        d.setCenter(c);
        a = 1215.92;
        d.setArea(a);
        p = 30613;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Островецкий");
        c = s.addCity("Островец");
        d.setCenter(c);
        a = 1568.77;
        d.setArea(a);
        p = 25131;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Свислочский");
        c = s.addCity("Свислочь");
        d.setCenter(c);
        a = 1449.5;
        d.setArea(a);
        p = 14797;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Слонимский");
        c = s.addCity("Слоним");
        d.setCenter(c);
        a = 1470.6;
        d.setArea(a);
        p = 63687;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Сморгонский");
        c = s.addCity("Сморгонь");
        d.setCenter(c);
        a = 1490.01;
        d.setArea(a);
        p = 51390;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Щучинский");
        c = s.addCity("Щучин");
        d.setCenter(c);
        a = 1911.54;
        d.setArea(a);
        p = 38496;
        d.setPopulation(p);
        r.addDistrict(d);

        s.addRegion(r);

        r = new Region();
        r.setName("Минская");
        c = s.addCity("Минск");
        r.setCapital(c);
        d = new District();
        d.setName("Березинский");
        c = s.addCity("Березино");
        d.setCenter(c);
        a = 1940.34;
        d.setArea(a);
        p = 21707;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Борисовский");
        c = s.addCity("Борисов");
        d.setCenter(c);
        a = 2987.95;
        d.setArea(a);
        p = 180049;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Вилейский");
        c = s.addCity("Вилейка");
        d.setCenter(c);
        a = 2453.81;
        d.setArea(a);
        p = 46810;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Воложинский");
        c = s.addCity("Воложин");
        d.setCenter(c);
        a = 1916.78;
        d.setArea(a);
        p = 33028;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Дзержинский");
        c = s.addCity("Дзержинск");
        d.setCenter(c);
        a = 1189.50;
        d.setArea(a);
        p = 67360;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Клецкий");
        c = s.addCity("Клецк");
        d.setCenter(c);
        a = 974.12;
        d.setArea(a);
        p = 26979;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Копыльский");
        c = s.addCity("Копыль");
        d.setCenter(c);
        a = 1607.66;
        d.setArea(a);
        p = 27506;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Крупский");
        c = s.addCity("Крупки");
        d.setCenter(c);
        a = 2138.73;
        d.setArea(a);
        p = 22270;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Логойский");
        c = s.addCity("Логойск");
        d.setCenter(c);
        a = 2365.02;
        d.setArea(a);
        p = 35689;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Любанский");
        c = s.addCity("Любань");
        d.setCenter(c);
        a = 1913.75;
        d.setArea(a);
        p = 30726;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Минский");
        c = s.addCity("Минск");
        d.setCenter(c);
        a = 1902.66;
        d.setArea(a);
        p = 222145;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Молодечненский");
        c = s.addCity("Молодечно");
        d.setCenter(c);
        a = 1392.18;
        d.setArea(a);
        p = 136237;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Мядельский");
        c = s.addCity("Мядель");
        d.setCenter(c);
        a = 1964.30;
        d.setArea(a);
        p = 25458;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Несвижский");
        c = s.addCity("Несвиж");
        d.setCenter(c);
        a = 862.75;
        d.setArea(a);
        p = 38795;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Пуховичский");
        c = s.addCity("Марьина Горка");
        d.setCenter(c);
        a = 2442.23;
        d.setArea(a);
        p = 64889;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Слуцкий");
        c = s.addCity("Слуцк");
        d.setCenter(c);
        a = 1821.06;
        d.setArea(a);
        p = 90305;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Смолевичский");
        c = s.addCity("Смолевичи");
        d.setCenter(c);
        a = 1392.57;
        d.setArea(a);
        p = 46735;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Солигорский");
        c = s.addCity("Солигорск");
        d.setCenter(c);
        a = 2498.91;
        d.setArea(a);
        p = 133881;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Стародорожский");
        c = s.addCity("Старые Дороги");
        d.setCenter(c);
        a = 1370.38;
        d.setArea(a);
        p = 18892;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Столбцовский");
        c = s.addCity("Столбцы");
        d.setCenter(c);
        a = 1884.52;
        d.setArea(a);
        p = 39086;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Узденский");
        c = s.addCity("Узда");
        d.setCenter(c);
        a = 1180.97;
        d.setArea(a);
        p = 23512;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Червенский");
        c = s.addCity("Червень");
        d.setCenter(c);
        a = 1630.39;
        d.setArea(a);
        p = 31776;
        d.setPopulation(p);
        r.addDistrict(d);

        s.addRegion(r);

        r = new Region();
        r.setName("Могилёвская");
        c = s.addCity("Могилев");
        r.setCapital(c);
        d = new District();
        d.setName("Белыничский");
        c = s.addCity("Белыничи");
        d.setCenter(c);
        a = 1419.52;
        d.setArea(a);
        p = 18044;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Бобруйский");
        c = s.addCity("Бобруйск");
        d.setCenter(c);
        a = 1592.67;
        d.setArea(a);
        p = 16254;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Быховский");
        c = s.addCity("Быхов");
        d.setCenter(c);
        a = 2263.16;
        d.setArea(a);
        p = 28611;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Глусский");
        c = s.addCity("Глуск");
        d.setCenter(c);
        a = 1335.44;
        d.setArea(a);
        p = 13067;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Горецкий");
        c = s.addCity("Горки");
        d.setCenter(c);
        a = 1284.31;
        d.setArea(a);
        p = 45856;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Дрибинский");
        c = s.addCity("Дрибин");
        d.setCenter(c);
        a = 766.53;
        d.setArea(a);
        p = 9397;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Кировский");
        c = s.addCity("Кировск");
        d.setCenter(c);
        a = 1295.20;
        d.setArea(a);
        p = 18694;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Климовичский");
        c = s.addCity("Климовичи");
        d.setCenter(c);
        a = 1542.78;
        d.setArea(a);
        p = 24154;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Кличевский");
        c = s.addCity("Кличев");
        d.setCenter(c);
        a = 1800.32;
        d.setArea(a);
        p = 14691;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Краснопольский");
        c = s.addCity("Краснополье");
        d.setCenter(c);
        a = 1223.04;
        d.setArea(a);
        p = 9217;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Кричевский");
        c = s.addCity("Кричев");
        d.setCenter(c);
        a = 777.54;
        d.setArea(a);
        p = 31298;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Круглянский");
        c = s.addCity("Круглое");
        d.setCenter(c);
        a = 881.81;
        d.setArea(a);
        p = 13573;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Костюковичский");
        c = s.addCity("Костюковичи");
        d.setCenter(c);
        a = 1493.84;
        d.setArea(a);
        p = 22542;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Могилёвский");
        c = s.addCity("Могилёв");
        d.setCenter(c);
        a = 1895.40;
        d.setArea(a);
        p = 39667;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Мстиславский");
        c = s.addCity("Мстиславль");
        d.setCenter(c);
        a = 1332.51;
        d.setArea(a);
        p = 20400;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Осиповичский");
        c = s.addCity("Осиповичи");
        d.setCenter(c);
        a = 1947.21;
        d.setArea(a);
        p = 46723;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Славгородский");
        c = s.addCity("Славгород");
        d.setCenter(c);
        a = 1317.82;
        d.setArea(a);
        p = 12651;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Хотимский");
        c = s.addCity("Хотимск");
        d.setCenter(c);
        a = 858.87;
        d.setArea(a);
        p = 10218;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Чаусский");
        c = s.addCity("Чаусы");
        d.setCenter(c);
        a = 1471.39;
        d.setArea(a);
        p = 17907;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Чериковский");
        c = s.addCity("Чериков");
        d.setCenter(c);
        a = 1020.20;
        d.setArea(a);
        p = 12960;
        d.setPopulation(p);
        r.addDistrict(d);

        d = new District();
        d.setName("Шкловский");
        c = s.addCity("Шклов");
        d.setCenter(c);
        a = 1333.16;
        d.setArea(a);
        p = 26848;
        d.setPopulation(p);
        r.addDistrict(d);

        s.addRegion(r);

        return s;
    }
}
