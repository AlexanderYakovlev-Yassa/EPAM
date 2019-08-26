import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_3_3_2_1 {

    String name;
    String openTag;
    String closeTag;
    int tagID;
    int parentTagID;
    String[] attributes;
    int openTagStart;
    int openTagEnd;
    int closeTagStart;
    int closeTagEnd;
    String value;

    public Task_3_3_2_1(int id, String Tag, int start, int end) {
        this.tagID = id;
        //this.parentTagID = parentID;
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

        /*String text = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<module type=\"JAVA_MODULE\" version=\"4\">\n" +
                "  <component name=\"NewModuleRootManager\" inherit-compiler-output=\"true\">\n" +
                "    <exclude-output />\n" +
                "    <content url=\"file://$MODULE_DIR$\">\n" +
                "      <sourceFolder url=\"file://$MODULE_DIR$/src\" isTestSource=\"false\" />\n" +
                "    </content>\n" +
                "    <orderEntry type=\"inheritedJdk\" />\n" +
                "    <orderEntry type=\"sourceFolder\" forTests=\"false\" />\n" +
                "  </component>\n" +
                "</module>";*/

                nodes(text);
    }

    public static void nodes(String str) {
        Task_3_3_2_1[] nodes = new Task_3_3_2_1[0];
        Task_3_3_2_1 node;
        Pattern p = Pattern.compile("[<][/]?[. &[^<>]]+[>]");
        Matcher m = p.matcher(str);
        int[] parents = new int[1];
        parents[0] = -1;
        int level = 0;
        int i = 0;
        int parent = -1;
        int tagType;

        //defining of nodes
        while (m.find()) {
            tagType = typeOfTag(m.group());
            System.out.println("tag " + m.group() + " tag type " + typeOfTag(m.group()));//********************************
            if ((tagType == 0) || (tagType == 2)) {
                //level++;
                /*if (level > parents.length - 1) {
                    parents = appendToArray(parents, i);
                } else {
                    parents[level] = i;
                }*/
                node = new Task_3_3_2_1(i, m.group(), m.start(), m.end());
                nodes = appendToArray(nodes, node);
                i++;
                if (tagType == 2){
                    nodes[parents[level + 1]].closeTagStart = m.start();
                    nodes[parents[level + 1]].closeTagEnd = m.end();
                }
            } else {
                /*level--;
                if (takeTagName(m.group()).equals(nodes[parents[level + 1]].name)) {
                    nodes[parents[level + 1]].closeTag = m.group();
                    nodes[parents[level + 1]].closeTagStart = m.start();
                    nodes[parents[level + 1]].closeTagEnd = m.end();
                    nodes[parents[level + 1]].value = takeValueOfNode(str, nodes[parents[level + 1]]);
                } else {
                    nodes[parents[level + 1]].closeTag = "Error of node";
                    nodes[parents[level + 1]].value = "Error of node";
                }*/
            }
        }

        for (int j = 0; j < nodes.length; j++) {
           printNod(nodes[j]);
        }

    }

    public  static String takeValueOfNode(String text, Task_3_3_2_1 node){
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
        //System.out.println("tag " + tag + " tag type " + typeOfTag(tag));
        int start = (typeOfTag(tag) == 1) ? 2 : 1;
        int spacePosition = tag.indexOf(' ');
        int finish;
        if (typeOfTag(tag) == 2){
            finish = tag.length() - 2;

        } else if (typeOfTag(tag) == 1){
            finish = tag.length() - 1;
        } else {
            finish = spacePosition > 0 ? spacePosition : tag.length() - 1;
        }
        name = tag.substring(start, finish).trim();
        return name;
    }

    //returns attributes of the node if they exist and put in string array.
    //odd element is a name of the attribute and even element is a value
    public static String[] takeAttributes(String tag) {
        String[] attributes = new String[0];
        Pattern attr = Pattern.compile("[\\s][\\w]+[\\s]?[=][\\s]?[\"][\\w]+[\"]");
        Matcher attrM = attr.matcher(tag);
        Pattern attrName = Pattern.compile("[\\s][\\w]+[\\s]?[=]");
        Matcher attrNameM;
        Pattern attrValue = Pattern.compile("[\"][\\w]+[\"]");
        Matcher attrValueM;
        String currentAttribute;

        while (attrM.find()) {
            currentAttribute = tag.substring(attrM.start(), attrM.end());
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
    public static int typeOfTag(String teg) {
        int res;
        Pattern p1 = Pattern.compile("^[<][/][\\w\\s=\"\\.]+[>]$");
        Matcher m1 = p1.matcher(teg);
        Pattern p2 = Pattern.compile("^[<][\\w\\s=\"\\.]+[/][>]$");
        Matcher m2 = p1.matcher(teg);
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
    public static Task_3_3_2_1[] appendToArray(Task_3_3_2_1[] array, Task_3_3_2_1 node) {
        Task_3_3_2_1[] newArray = new Task_3_3_2_1[array.length + 1];
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
    public static void printNod(Task_3_3_2_1 node) {
        System.out.println("Node: " + node.tagID);
        System.out.println("Opening tag: " + node.openTag);
        System.out.println("Closing tag: " + node.closeTag);
        System.out.println("Name of node: \"" + node.name + "\"");
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