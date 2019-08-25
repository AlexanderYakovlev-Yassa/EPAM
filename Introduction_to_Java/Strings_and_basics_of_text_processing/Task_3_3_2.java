import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_3_3_2 {

    String tagName;
    boolean closeTag;
    String valueOfTag;
    int tagID;
    int parentTagID;
    String[] attributes;
    int openPosition;
    int closePosition;

    //private static boolean matches;

    public Task_3_3_2(int id, int parentID, boolean closeTag ) {
        this.tagName = "NoName";
        this.tagID = id;
        this.parentTagID = parentID;
        this.attributes = new String[0];
        this.closeTag = closeTag;
        this.valueOfTag = "";
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public void setValueOfTag(String valueOfTag) {
        this.valueOfTag = valueOfTag;
    }

    public void setOpenPosition(int openPosition) {
        this.openPosition = openPosition;
    }

    public void setClosePosition(int closePosition) {
        this.closePosition = closePosition;
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
        Pattern p = Pattern.compile("[<][/]?[\\w\\s=\"]+[>]");
        Matcher m = p.matcher(str);
        int[] nestingLevels = new int[1];
        nestingLevels[0] = -1;
        int currentLevelOfNesting = 0;
        int i = 0;
        int parent = -1;
        boolean tegClosing;
        while (m.find()) {
            tegClosing = isTegClose(m.group());
            if (tegClosing){
                currentLevelOfNesting--;
            } else {
                currentLevelOfNesting++;
                if (currentLevelOfNesting > nestingLevels.length-1){
                    nestingLevels = appendToArray(nestingLevels,i);
                } else {
                    nestingLevels[currentLevelOfNesting] = i;
                }
            }
            parent = nestingLevels[currentLevelOfNesting];
            Task_3_3_2 node = new Task_3_3_2(i,  parent, tegClosing);
            node.setValueOfTag(m.group());
            nodes = appendToArray(nodes, node);
            i++;
        }

        for (int j = 0; j < nodes.length; j++) {
            System.out.print(nodes[j].valueOfTag + "  ");
            System.out.println("ID =" + nodes[j].tagID + " close = " + nodes[j].closeTag + " parent " + nodes[j].parentTagID);

        }
    }

    //returns a name of the tag
    public static String takeTagName(String tag) {
        String name;
        int start = isTegClose(tag) ? 2 : 1;
        int spacePosition = tag.indexOf(' ');
        int finish = spacePosition > 0 ? spacePosition : tag.length() - 1;
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

    //checks whether tag is the closing or not
    public static boolean isTegClose(String teg) {
        boolean res;
        Pattern p = Pattern.compile("^[<][/]{1}[\\w\\s=\"]+[>]$");
        Matcher m = p.matcher(teg);
        res = m.find();
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
}
