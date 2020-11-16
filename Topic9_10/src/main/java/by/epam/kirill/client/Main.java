package by.epam.kirill.client;
import by.epam.kirill.task.*;
import sun.awt.image.ImageWatched;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Main {

    public static void main(String [] args){
        Task<String> task1=new Task.Builder<String>()
                .withCategory(Category.HOMEWORK)
                .withDeadLine(new GregorianCalendar(2020, Calendar.NOVEMBER,22))
                .withName("TO clean room")
                .withPriority(Priority.B)
                .withId("ewil")
                .build();
        Task<String> task2=new Task.Builder<Integer>()
                .withCategory(Category.HOMEWORK)
                .withDeadLine(new GregorianCalendar(2020, Calendar.NOVEMBER,22))
                .withName("TO clean room")
                .withPriority(Priority.B)
                .withId(12123)
                .build();
        Task<String> task3=new Task.Builder<Integer>()
                .withCategory(Category.HOMEWORK)
                .withDeadLine(new GregorianCalendar(2020, Calendar.NOVEMBER,22))
                .withName("TO clean room")
                .withPriority(Priority.B)
                .withId("absd")
                .build();
        TaskList tasks=new TaskList(new LinkedList<Task>(task1,task2,task3));


    }
}