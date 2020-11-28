package by.epam.kirill.client;
import by.epam.kirill.exception.ConvertException;
import by.epam.kirill.exception.InputLibraryException;
import by.epam.kirill.task.*;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

    public static void main(String [] args){
        TaskList tasks=new TaskList();
        boolean wantToWork = true;
        while(wantToWork) {
            System.out.println("Choose action:\n1 - Add Task\n2 - Show all Tasks\n3 - Remove Task using Id\n4 - Sort");
            int numOfTask = getIntConsoleInput();
            switch(numOfTask) {
                case 1:
                    tasks.add(getNewTaskConsoleInput());
                    break;
                case 2:
                    tasks.showAllListInTerminal();
                    break;
                case 3:
                    System.out.println("Input task's id to remove:");
                    try {
                        tasks.remove(getStringConsoleInput());
                    }catch (InputLibraryException e){
                        System.out.println("Check input library.");
                    }

                    break;
                case 4:
                    System.out.println("Sort by :\n 1 - Name\n2 - Priority\n3 - Category\n4 - Dead line");
                    switch (getIntConsoleInput())
                    {
                        case 1:
                            tasks.sort((Task o,Task w)->o.getName().compareTo(w.getName()));
                            break;
                        case 2:
                            tasks.sort((Task o,Task w)->o.getPriority().compareTo(w.getPriority()));
                            break;
                        case 3:
                            tasks.sort((Task o,Task w)->o.getCategory().compareTo(w.getCategory()));
                            break;
                        case 4:
                            tasks.sort((Task o,Task w)->o.getDeadline().compareTo(w.getDeadline()));
                            break;
                    }
                    break;
                default:
                    wantToWork = false;
                    break;
            }
        }

    }

    public static Task getNewTaskConsoleInput(){
        return new Task.Builder<String>()
                .withCategory(chooseCategoryInConsole())
                .withDeadLine(getDeadLineConsole())
                .withName(getNameConsole())
                .withPriority(getPriorityConsole())
                .withId(getIdConsole())
                .build();
    }
    public static Category chooseCategoryInConsole(){
        System.out.println("Choose category:\1-HOMEWORK\n2-PROGRAMMING\n3-MEETING\n4-MUSIC");
        switch (getIntConsoleInput()){
            case 1:
                return Category.HOMEWORK;
            case 2:
                return Category.PROGRAMMING;
            case 3:
                return Category.MEETING;
            case 4:
            default:
                return Category.MUSIC;
        }
    }
    public static GregorianCalendar getDeadLineConsole(){
        System.out.println("Input day of deadline:");
        int day=getIntConsoleInput();
        System.out.println("Input month of deadline:");
        int month=getIntConsoleInput();
        System.out.println("Input day of deadline:");
        int year=getIntConsoleInput();
        return new GregorianCalendar(year,month,day);
    }
    public static String getNameConsole(){
        System.out.println("Input name of task:");
        try {
            return getStringConsoleInput();
        }catch(InputLibraryException e){
            System.out.println("Input Library problems!");
            return null;
        }
    }
    public static Priority getPriorityConsole(){
        System.out.println("Choose category:\1-S\n2-A\n3-B\n4-C");
        switch (getIntConsoleInput()){
            case 1:
                return Priority.S;
            case 2:
                return Priority.A;
            case 3:
                return Priority.B;
            case 4:
            default:
                return Priority.C;
        }
    }
    public static String getIdConsole(){
        System.out.println("Input Id:");
        try {
            return getStringConsoleInput();
        }catch(InputLibraryException e){
            System.out.println("Input Library problems!");
            return null;
        }
    }


    public static int getIntConsoleInput(){
        while (true) {
            try {
                int a=convertStringToInt(getStringConsoleInput());
                return a;
            } catch (InputLibraryException ine) {
                System.out.println("Chek your input libraries.");
                return 0;
            } catch (ConvertException ce) {
                System.out.println("Incorrect Input.Try again.");
                return 0;
            }
        }
    }
    public static int convertStringToInt(String s ) throws ConvertException{
        try{
            int a =Integer.parseInt(s);
            return a;

        }
        catch (Exception e ){
            throw new ConvertException();
        }
    }
    public static String getStringConsoleInput()throws InputLibraryException {
            try (Scanner in = new Scanner(System.in)){
                String s=in.nextLine();
                return s;
            } catch (Exception e) {
                throw new InputLibraryException();
            }
    }



}