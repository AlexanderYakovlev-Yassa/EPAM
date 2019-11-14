package by.epam.tasks.library.ui;

public class UICommand {

    public void executeCommand(Command command){

        if (command != null){
            switch (command){
                case SAVE_CATALOG:{
                    System.out.println("save catalog");
                    break;
                }
                case SHOW_CATALOG:{
                    System.out.println("show catalog");
                    break;
                }
                case EXIT:{
                    System.out.println("exit");
                    break;
                }
                default:{
                    System.out.println("default");
                }
            }
        }
    }
}
