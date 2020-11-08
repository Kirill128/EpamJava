package by.epam.kirill.client;
import by.epam.kirill.task.*;
public class Main {

    public static void main(String [] args){
        Task<String> taskStr=new Task<String>.Builder<String>()
                                                .withCategory(Category.HOMEWORK)
                                                .withDeadLineDate(new String[][]{{"day","21"},{"month","02"},{"year","2020"}})
                                                .withName("TO clean room")
                                                .withPriority(Priority.B)
                                                .build();

        Task<String> taskInt=new Task<Integer>.Builder<Integer>()
                                                .withCategory(Category.HOMEWORK)
                                                .withDeadLineDate(new String[][]{{"day","21"},{"month","02"},{"year","2020"}})
                                                .withName("TO clean room")
                                                .withPriority(Priority.B)
                                                .build();
        System.out.println("TaskStr: "+taskStr.toString());
        System.out.println("TaskInt:"+taskInt.toString());

    }
}


