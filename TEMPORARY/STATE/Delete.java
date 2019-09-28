import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delete {
    public static void main(String[] args) {

        //создаем и наполняем государство из файла
        State bel = readStateFromFle("src\\Belarus.xml");
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
        String str;

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

                                System.out.println("s = new State();");
                            }
                        }else if (tagName.equals("sName")){
                            start = mTag.end();
                            mTag.find();
                            finish = mTag.start();
                            str = tmp.substring(start, finish);
                            if (s != null) {
                                System.out.println("s.setName(\"" + str + "\");");
                            }
                        }else if (tagName.equals("sCapital")){
                            start = mTag.end();
                            mTag.find();
                            finish = mTag.start();
                            str = tmp.substring(start, finish);
                            System.out.println("c = s.addCity(\"" + str + "\");");
                            System.out.println("s.setCapital(c);");

                        }else if (tagName.equals("region")){
                            if (r == null) {
                                System.out.println("r = new Region();");
                            }
                        }else if (tagName.equals("rName")){
                            start = mTag.end();
                            mTag.find();
                            finish = mTag.start();
                            str = tmp.substring(start, finish);
                            System.out.println("r.setName(\"" + str + "\");");
                        }else if (tagName.equals("rCapital")){
                            start = mTag.end();
                            mTag.find();
                            finish = mTag.start();
                            str = tmp.substring(start, finish);
                            System.out.println("c = s.addCity(\"" + str + "\");");
                            System.out.println("r.setCapital(c);");

                        }else if (tagName.equals("district")){

                                System.out.println("d = new District();");

                        }else if (tagName.equals("dName")){
                            start = mTag.end();
                            mTag.find();
                            finish = mTag.start();
                            str = tmp.substring(start, finish);
                        System.out.println("d.setName(\""+ str + "\");");
                        }else if (tagName.equals("dCapital")){
                            start = mTag.end();
                            mTag.find();
                            finish = mTag.start();
                            str = tmp.substring(start, finish);
                        System.out.println("c = s.addCity(\"" + str + "\");");
                        System.out.println("d.setCenter(c);");
                        }else if (tagName.equals("dArea")){
                            start = mTag.end();
                            mTag.find();
                            finish = mTag.start();
                            str = tmp.substring(start, finish);

                        System.out.println("a = " + str + ";");
                        System.out.println("d.setArea(a);");
                        }else if (tagName.equals("dPopulation")){
                            start = mTag.end();
                            mTag.find();
                            finish = mTag.start();
                            str = tmp.substring(start, finish);
                        System.out.println("p = " + str + ";");
                        System.out.println("d.setPopulation(p);");
                        }

                    } else if(tagType(tag) == 1) {
                        if(tagName.equals("state")){
                            //s = null;
                        }else if(tagName.equals("region")){
                            System.out.println("s.addRegion(r);");
                            System.out.println("r = null;");
                        }else if(tagName.equals("district")){
                            System.out.println("r.addDistrict(d);");
                            System.out.println("d = null;");
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
