package by.epam.kirill.client;
import by.epam.kirill.task.*;
public class Main {

    public static void main(String [] args){
        Task taskStr=new Task.Builder()
                                                .withCategory(Category.HOMEWORK)
                                                .withDeadLine(new String[][]{{"day","21"},{"month","02"},{"year","2020"}})
                                                .withName("TO clean room")
                                                .withPriority(Priority.B)
                                                .withId("skfdlfjs1323123")
                                                .build();


        System.out.println("TaskStr: "+taskStr.toString());


    }
}


