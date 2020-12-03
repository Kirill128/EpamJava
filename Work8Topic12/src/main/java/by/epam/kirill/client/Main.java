package by.epam.kirill.client;
import by.epam.kirill.exception.ConvertException;
import by.epam.kirill.task.*;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

    static final Priority[] priorities=new Priority[]{Priority.S,Priority.A,Priority.B,Priority.C};
    static final Category[] categories=new Category[]{Category.MUSIC,Category.HOMEWORK,Category.PROGRAMMING,Category.MEETING};

    public static void main(String [] args){
        TaskList tasks=getSomeTasks();
        boolean wantToWork = true;
        while(wantToWork) {
            System.out.println("Choose action:\n1 - Add Task" +
                    "\n2 - Show all Tasks" +
                    "\n3 - Remove Task using Id" +
                    "\n4 - Sort\n5 - Filter" +
                    "\n6 - Show Only Unique Names" +
                    "\n7 - Remove same tasks" +
                    "\n8 - Chek if all names >1 letter");
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
                    tasks.remove(getStringConsoleInput());
                    break;
                case 4:
                    System.out.println("Sort by :\n1 - Name\n2 - Priority\n3 - Category\n4 - Dead line");
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
                    tasks.showAllListInTerminal();
                    break;
                case 5:
                    System.out.println("Filter by :\n1 - Name\n2 - Priority\n3 - Category\n4 - Dead line");
                    switch (getIntConsoleInput())
                    {
                        case 1:
                            System.out.println("Input name:");
                            tasks.filterTasks(tasks.getTasks(), (Task a)-> a.getCategory().equals(getStringConsoleInput())).stream().forEach(System.out::println);
                            break;
                        case 2:
                            System.out.println("Choose priority:\n 1 - S\n 2 - A\n 3 - B\n 4 - C");
                            int numOfPr=getIntConsoleInput();
                            if(numOfPr>=0 && numOfPr<priorities.length) {
                                Priority pr = priorities[numOfPr - 1];
                                tasks.filterTasks(tasks.getTasks(), (Task a) -> a.getPriority().equals(pr)).stream().forEach(System.out::println);
                            }else System.out.println("False input");
                            break;
                        case 3:
                            System.out.println("Choose category:\n 1 - MUSIC\n 2 - HOMEWORK\n 3 - PROGRAMMING\n 4 - MEETING");
                            int numOfCat=getIntConsoleInput();
                            if(numOfCat>=0 && numOfCat<categories.length) {
                                Category cat = categories[numOfCat - 1];
                                tasks.filterTasks(tasks.getTasks(), (Task a) -> a.getCategory().equals(cat)).stream().forEach(System.out::println);
                            }else System.out.println("False input");
                            break;
                        case 4:
                            tasks.filterTasks(tasks.getTasks(), (Task a)-> a.getDeadline().equals(getDeadLineConsole())).stream().forEach(System.out::println);
                            break;
                    }
                    break;
                case 6:
                    tasks.getUniqueNames(tasks.getTasks()).stream().forEach(System.out::println);
                    break;
                case 7:
                    tasks.removeSameTasks();
                    tasks.getTasks().stream().forEach(System.out::println);
                    break;
                case 8:
                    System.out.println("Names Length > 1:"+tasks.getTasks().stream().allMatch(t->t.getName().length()>1));
                    break;
                default:
                    wantToWork = false;
                    break;
            }
        }

    }

    public static TaskList getSomeTasks(){
        TaskList tasks=new TaskList();
        tasks.add(new Task.Builder<String>()
                .withCategory(Category.MEETING)
                .withDeadLine(new GregorianCalendar(2020,12,12))
                .withName("Client meeting")
                .withPriority(Priority.S)
                .withId("123456790")
                .build());
        tasks.add(new Task.Builder<String>()
                .withCategory(Category.HOMEWORK)
                .withDeadLine(new GregorianCalendar(2020,12 ,2))
                .withName("English")
                .withPriority(Priority.A)
                .withId("fsdfsd12")
                .build());
        tasks.add(new Task.Builder<String>()
                .withCategory(Category.MUSIC)
                .withDeadLine(new GregorianCalendar(2020,12,6))
                .withName("Rok and roll")
                .withPriority(Priority.A)
                .withId("hmmmmmmsoooooo")
                .build());
        tasks.add(new Task.Builder<String>()
                .withCategory(Category.HOMEWORK)
                .withDeadLine(new GregorianCalendar(2020,12 ,2))
                .withName("English")
                .withPriority(Priority.A)
                .withId("fsdfsd12")
                .build());
        tasks.add(new Task.Builder<String>()
                .withCategory(Category.MUSIC)
                .withDeadLine(new GregorianCalendar(2020,12,6))
                .withName("Rok and roll")
                .withPriority(Priority.A)
                .withId("hmmmmmmsoooooo")
                .build());
        tasks.add(new Task.Builder<String>()
                .withCategory(Category.MUSIC)
                .withDeadLine(new GregorianCalendar(2020,12,6))
                .withName("R")
                .withPriority(Priority.A)
                .withId("hmmmmmmsoooooo")
                .build());
        return tasks;
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
        System.out.println("Choose category:\n1-HOMEWORK\n2-PROGRAMMING\n3-MEETING\n4-MUSIC");
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
        return getStringConsoleInput();

    }
    public static Priority getPriorityConsole(){
        System.out.println("Choose category:\n1-S\n2-A\n3-B\n4-C");
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
        return getStringConsoleInput();
    }


    public static int getIntConsoleInput(){
        while (true) {
            try {
                int a=convertStringToInt(getStringConsoleInput());
                return a;
            }
            catch (ConvertException ce) {
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
    public static String getStringConsoleInput() {
        Scanner in=new Scanner(System.in);
        return in.next();
    }



}