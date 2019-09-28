import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DemoReadFromFile {
    public static void main(String[] args) {

        //создаем и наполняем государство из файла
        State bel = readStateFromFle("src\\Belarus.xml");

        //выводим детальную информацию о государстве
        System.out.println(bel.getDetaileInfo());
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

    /*
    * возвращает объект государство
    * информация о государстве наполняется из файла
    * */
    public static State readStateFromFle(String file){
        int res = 0;
        BufferedReader br = null;
        State s = null;
        City c = null;
        District d = null;
        District tmpDistrict;
        Region r = null;
        Region tmpRegion;
        int start;
        int finish;
        String tagName;
        String tag;
        double a = 0.0;
        int p = 0;

        Pattern pTag = Pattern.compile("[<][/]?[. &[^<>]]+[>]");
        Matcher mTag;

        try {
            br = new BufferedReader(new FileReader(file));
            String tmp = "";
            boolean firstRegion = true;
            while ((tmp = br.readLine()) != null) {
                mTag = pTag.matcher(tmp);
                while(mTag.find()){
                    tag = mTag.group();
                    tagName = tagName(tag);
                    if (tagType(tag) == 0){
                        if(tagName.equals("state")){
                            if (s == null) {
                                s = new State();
                            }
                        }else if (tagName.equals("sName")){
                            start = mTag.end();
                            mTag.find();
                            finish = mTag.start();
                            if (s != null) {
                                s.setName(tmp.substring(start, finish));
                            }
                        }else if (tagName.equals("sCapital")){
                            start = mTag.end();
                            mTag.find();
                            finish = mTag.start();
                            c = s.addCity(tmp.substring(start, finish));
                            if (s != null) {
                                s.setCapital(c);
                            }
                        }else if (tagName.equals("region")){
                            if (r == null) {
                                r = new Region();
                            }
                        }else if (tagName.equals("rName")){
                            start = mTag.end();
                            mTag.find();
                            finish = mTag.start();
                            if ((tmpRegion = s.getRegionByName(tmp.substring(start, finish))) == null) {
                                r.setName(tmp.substring(start, finish));
                            } else {
                                r = tmpRegion;
                            }
                        }else if (tagName.equals("rCapital")){
                            start = mTag.end();
                            mTag.find();
                            finish = mTag.start();
                            c = s.addCity(tmp.substring(start, finish));
                            if (r != null && r.getCapital() == null) {
                                r.setCapital(c);
                            }
                        }else if (tagName.equals("district")){
                            if (d == null) {
                                d = new District();
                            }
                        }else if (tagName.equals("dName")){
                            start = mTag.end();
                            mTag.find();
                            finish = mTag.start();
                            if ((tmpDistrict = r.getDistrictByName(tmp.substring(start, finish))) == null) {
                                d.setName(tmp.substring(start, finish));
                            } else {
                                d = tmpDistrict;
                            }
                        }else if (tagName.equals("dCapital")){
                            start = mTag.end();
                            mTag.find();
                            finish = mTag.start();
                            c = s.addCity(tmp.substring(start, finish));
                            if (d != null && d.getCenter() == null) {
                                d.setCenter(c);
                            }
                        }else if (tagName.equals("dArea")){
                            start = mTag.end();
                            mTag.find();
                            finish = mTag.start();
                            if (d != null && d.getArea() == 0.0) {
                                try {
                                    a = Double.parseDouble(tmp.substring(start, finish));
                                } catch (NumberFormatException e) {
                                    a = 0.0;
                                }
                                d.setArea(a);
                            }
                        }else if (tagName.equals("dPopulation")){
                            start = mTag.end();
                            mTag.find();
                            finish = mTag.start();
                            if (d != null && d.getPopulation() == 0) {
                                try {
                                    p = Integer.parseInt(tmp.substring(start, finish));
                                } catch (NumberFormatException e) {
                                    p = 0;
                                }
                                d.setPopulation(p);
                            }
                        }

                    } else if(tagType(tag) == 1) {
                        if(tagName.equals("state")){
                            //s = null;
                        }else if(tagName.equals("region")){
                            s.addRegion(r);
                            r = null;
                        }else if(tagName.equals("district")){
                            r.addDistrict(d);
                            d = null;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return s;
    }

    /*
     * Возвращает имя тэга
     * */
    public static String tagName(String tag) {
        String name;
        Pattern pName = Pattern.compile("[^</]?[\\w-]+[^\\s/>]?");
        Matcher mName = pName.matcher(tag);
        name = mName.find() ? mName.group() : "NameNotFound";
        return name;
    }

    /*
     * Определяет тип тэга
     * возвращает:
     * 0 - открывающий тэг
     * 1 - закрывающий тэг
     * 2 - тэг без тела
     * */
    public static int tagType(String tag) {
        int res;
        Pattern p1 = Pattern.compile("^[<][/][\\w\\W]+[>]$");
        Matcher m1 = p1.matcher(tag);
        Pattern p2 = Pattern.compile("^[<][\\w\\W]+[/][>]$");
        Matcher m2 = p2.matcher(tag);
        if (m1.find()) {
            res = 1;
        } else if (m2.find()){
            res = 2;
        } else {
            res = 0;
        }
        return res;
    }



}
