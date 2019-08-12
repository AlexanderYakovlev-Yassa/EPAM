/*Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.*/

public class Task_3_1_1 {
    public static void main(String[] args) {
        String[] camelCaseStrings= {"designProcessAndEvaluation",
            "optimizingTheUserExperience",
            "Accessibility",
            "hardwareAndSoftware",
            "theHomePage",
            "pageLayout"};
        MyUtils.printArray(camelCaseStrings);
        System.out.println("");
        MyUtils.printArray(camelsToSnakes(camelCaseStrings));
    }

    public static String[] camelsToSnakes(String[] originalNames){
        String[] newNames = new String[originalNames.length];
        for (int i = 0; i < originalNames.length; i++){
            newNames[i] = camelCaseToSnakeCase(originalNames[i]);
        }
        return newNames;
    }
    
    public static  String camelCaseToSnakeCase(String str){
        String snake = new String();
        char[] sourse = str.toCharArray();
        int numberOfUpperCaseLetter = 0;

        //The counting of upper case letters (accept first)
        for (int i = 1; i < sourse.length; i++){
           numberOfUpperCaseLetter = Character.isUpperCase(sourse[i]) ? numberOfUpperCaseLetter + 1 : numberOfUpperCaseLetter;
        }

        char[] newChars = new char[sourse.length + numberOfUpperCaseLetter];

        //changes the first letter to lower case if it is upper case
        newChars[0] = Character.isUpperCase(sourse[0]) ? Character.toLowerCase(sourse[0]) : sourse[0];

        //forms the new consequence of characters
        int j = 1; //new position of letter
        for (int i = 1; i < sourse.length; i++){
            if (Character.isUpperCase(sourse[i])){
                    newChars[j] = '_';
                    j++;
                    newChars[j] = Character.toLowerCase(sourse[i]);
            } else {
                newChars[j] = sourse[i];
            }
            j++;
        }

        snake = String.copyValueOf(newChars);
        return snake;
    }
}
