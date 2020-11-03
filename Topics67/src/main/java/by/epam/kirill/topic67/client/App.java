package by.epam.kirill.topic67.client;

import by.epam.kirill.topic67.tasks.AlreadyDoneTask;
import by.epam.kirill.topic67.tasks.InProcessTask;

public class App {
    public static void main(String [] args){
        AlreadyDoneTask task1=new AlreadyDoneTask("HouseWord",
                                                    "TO clean auto",
                                                    "B",
                                                            new String[][]{{"day","21"},{"month","02"},{"year","2020"}},
                                                            new String[][]{{"day","21"},{"month","02"},{"year","2020"}});
        InProcessTask task2=new InProcessTask("HouseWord",
                                                "TO clean auto",
                                                "B",
                                                        new String[][]{{"day","21"},{"month","02"},{"year","2020"}},
                                                        40);
        System.out.print(task1+"\ntask1:");
        task1.taskProgress();
        System.out.print(task2+"\ntask2:");
        task2.taskProgress();
    }
}
