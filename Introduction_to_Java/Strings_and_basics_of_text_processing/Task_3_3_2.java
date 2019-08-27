/*Дана строка, содержащая следующий текст (xml-документ):
        <notes>
        <note id = "1">
        <to>Вася</to>
        <from>Света</from>
        <heading>Напоминание</heading>
        <body>Позвони мне завтра!</body>
        </note>
        <note id = "2">
        <to>Петя</to>
        <from>Маша</from>
        <heading>Важное напоминание</heading>
        <body/>
        </note>
        </notes>
Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа
и его тип (открывающий тег, закрывающий тег, содержимое тега, тег без тела).
Пользоваться готовыми парсерами XML для решения данной задачи нельзя.*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_3_3_2 {

    String name;
    String openTag;
    String closeTag;
    int tagID;
    String[] attributes;
    int openTagStart;
    int openTagEnd;
    int closeTagStart;
    int closeTagEnd;
    String value;

    public Task_3_3_2(int id, String Tag, int start, int end) {
        this.tagID = id;
        this.openTag = Tag;
        this.name = takeTagName(Tag);
        this.attributes = takeAttributes(Tag);
        this.openTagStart = start;
        this.openTagEnd = end;
    }

    public static void main(String[] args) {
        String text = "<notes>\n" +
                "<note id = \"1\">\n" +
                "<to>Вася</to>\n" +
                "<from>Света</from>\n" +
                "<heading>Напоминание</heading>\n" +
                "<body>Позвони мне завтра!</body>\n" +
                "</note>\n" +
                "<note id = \"2\">\n" +
                "<to>Петя</to>\n" +
                "<from>Маша</from>\n" +
                "<heading>Важное напоминание</heading>\n" +
                "<body/>\n" +
                "</note>\n" +
                "</notes>";

        nodes(text);
    }

    public static void nodes(String str) {
        Task_3_3_2[] nodes = new Task_3_3_2[0];
        Task_3_3_2 node;
        Pattern p = Pattern.compile("[<][/]?[. &[^<>]]+[>]");
        Matcher m = p.matcher(str);
        int[] parents = new int[1];
        parents[0] = -1;
        int i = 0;
        int tagType;

        //defining of nodes
        while (m.find()) {
            tagType = typeOfTag(m.group());
            if ((tagType == 0) || (tagType == 2)) {
                node = new Task_3_3_2(i, m.group(), m.start(), m.end());
                nodes = appendToArray(nodes, node);
                if (tagType == 2){
                    nodes[i].closeTag = m.group();
                    nodes[i].value = "";
                }
                i++;
            } else {
                int j = nodes.length - 1;
                while (j >= 0){
                    if (nodes[j].name.equals(takeTagName(m.group()))){
                        nodes[j].closeTag = m.group();
                        nodes[j].closeTagStart = m.start();
                        nodes[j].closeTagEnd = m.end();
                        nodes[j].value = takeValueOfNode(str,nodes[j]);
                        break;
                    }
                    j--;
                }
            }
        }



        for (int j = 0; j < nodes.length; j++) {
            printNod(nodes[j]);
        }

    }

    public  static String takeValueOfNode(String text, Task_3_3_2 node){
        String value = "";
        Pattern p = Pattern.compile("[<>]+");
        Matcher m = p.matcher(text.substring(node.openTagEnd, node.closeTagStart));
        if(!m.find()){
            value = text.substring(node.openTagEnd, node.closeTagStart);
        }

        return value;
    }

    //returns a name of the tag
    public static String takeTagName(String tag) {
        String name;
        Pattern pName = Pattern.compile("[^</]?[\\w-]+[^\\s/>]?");
        Matcher mName = pName.matcher(tag);
        name = mName.find() ? mName.group() : "NameNotFound";
        return name;
    }

    //returns attributes of the node if they exist and put in string array.
    //odd element is a name of the attribute and even element is a value
    public static String[] takeAttributes(String tag) {
        String[] attributes = new String[0];
        Pattern attr = Pattern.compile("[\\s][\\w-]+[\\s]?[=][\\s]?[\"][\\w-:/\\.\\$]+[\"]");//[\\w-/\\.\\$]
        Matcher attrM = attr.matcher(tag);
        Pattern attrName = Pattern.compile("[\\s][\\w-]+[\\s]?[=]");
        Matcher attrNameM;
        Pattern attrValue = Pattern.compile("[\"][\\w-:/\\.\\$]+[\"]");
        Matcher attrValueM;
        String currentAttribute;

        while (attrM.find()) {
            currentAttribute = attrM.group();//tag.substring(attrM.start(), attrM.end());
            attrNameM = attrName.matcher(currentAttribute);
            attrValueM = attrValue.matcher(currentAttribute);
            attrNameM.find();
            attrValueM.find();
            attributes = appendToArray(attributes, currentAttribute.substring(attrNameM.start(), attrNameM.end() - 1).trim());
            attributes = appendToArray(attributes, currentAttribute.substring(attrValueM.start() + 1, attrValueM.end() - 1));
        }
        return attributes;
    }

    //returns a type of the tag: 0-opening tag; 1-closing tag; 2-self-closing tag.
    public static int typeOfTag(String tag) {
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

    //appends String to the array of Strings
    public static String[] appendToArray(String[] array, String str) {
        String[] newArray = new String[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = str;
        return newArray;
    }

    //appends node to the array of nodes
    public static Task_3_3_2[] appendToArray(Task_3_3_2[] array, Task_3_3_2 node) {
        Task_3_3_2[] newArray = new Task_3_3_2[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = node;
        return newArray;
    }

    //appends int to the array of int
    public static int[] appendToArray(int[] array, int n) {
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = n;
        return newArray;
    }

    //prints node info
    public static void printNod(Task_3_3_2 node) {
        System.out.println("Node: " + node.tagID);
        System.out.println("Opening tag: " + node.openTag);
        System.out.println("Closing tag: " + node.closeTag);
        System.out.println("Type of node: \"" + node.name + "\"");
        if (node.attributes.length > 0) {
            System.out.println("Node attributes:");
            for (int i = 0; i < node.attributes.length; i += 2) {
                System.out.println("\t" + node.attributes[i] + " = " + node.attributes[i + 1]);
            }
        }
        System.out.println("Value of node: \"" + node.value + "\"");
        System.out.println("");
    }
}