package by.epam.kirill.client;
import by.epam.kirill.task.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Main {

    public static void main(String [] args){
        Task<String> task1=new Task.Builder<String>()
                .withCategory(Category.PROGRAMMING)
                .withDeadLine(new GregorianCalendar(2015, Calendar.NOVEMBER,23))
                .withName("TO clean room")
                .withPriority(Priority.S)
                .withId("ewil")
                .build();
        Task<String> task2=new Task.Builder<Integer>()
                .withCategory(Category.HOMEWORK)
                .withDeadLine(new GregorianCalendar(2020, Calendar.NOVEMBER,21))
                .withName("TO clean room")
                .withPriority(Priority.C)
                .withId(12123)
                .build();
        Task<String> task3=new Task.Builder<Integer>()
                .withCategory(Category.MEETING)
                .withDeadLine(new GregorianCalendar(2010, Calendar.NOVEMBER,22))
                .withName("TO clean room")
                .withPriority(Priority.A)
                .withId("absd")
                .build();
        TaskList tasks=new TaskList();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);

        System.out.println(tasks.getAllTasksString());
        tasks.showAllListInTerminal();

        System.out.println("Sort by date:");
        tasks.sort((Task a,Task b)->a.getDeadline().compareTo(b.getDeadline()));
        System.out.println(tasks.getAllTasksString());
        System.out.println("Sort by priority:");
        tasks.sort((Task a,Task b)->a.getPriority().compareTo(b.getPriority()));
        System.out.println(tasks.getAllTasksString());
        System.out.println("Sort by Category:");
        tasks.sort((Task a,Task b)->a.getCategory().compareTo(b.getCategory()));
        System.out.println(tasks.getAllTasksString());
    }
}