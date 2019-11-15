package by.epam.tasks.library.user_interface;

import by.epam.tasks.library.books.Library;
import by.epam.tasks.library.view.View;

import java.util.Scanner;

public class UserInterface {

    public void start(Library library){

        View view = new View();
        UserInterface command = new UserInterface();

        boolean flag = true;
        Scanner scan = new Scanner(System.in);
        String userCommand;

        while (flag) {
            System.out.print(">");
            userCommand = scan.nextLine();
            if(!userCommand.toUpperCase().equals("EXIT")){
                command.execute(userCommand, library);
            }else{
                flag = false;
            }
        }

    }

    public void execute(String command, Library library){

        command = command.toUpperCase();

        View view = new View();

        if(command != null){

            switch (command.toUpperCase()){
                case "HELP":{
                    view.printHelp();
                    break;
                }
                case "CATALOG":{
                    view.showCatalog(library.getBooks());
                    break;
                }
                default:{
                    System.out.println("Unknown command");
                }
            }
        }else{
            System.out.println("There is no command");
        }
    }


}
