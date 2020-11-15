package by.epam.kirill.client;
import by.epam.kirill.task.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String [] args){
        Task<String> taskStr=new Task.Builder<String>()
                .withCategory(Category.HOMEWORK)
                .withDeadLine(new GregorianCalendar(2020, Calendar.NOVEMBER,22))
                .withName("TO clean room")
                .withPriority(Priority.B)
                .withId("skfdlfjs1323123")
                .build();
        Task<String> taskInt=new Task.Builder<Integer>()
                .withCategory(Category.HOMEWORK)
                .withDeadLine(new GregorianCalendar(2020, Calendar.NOVEMBER,22))
                .withName("TO clean room")
                .withPriority(Priority.B)
                .withId(12123)
                .build();

        System.out.println("TaskStr: "+taskStr.toString());
        System.out.println("TaskStr: "+taskInt.toString());

    }
}