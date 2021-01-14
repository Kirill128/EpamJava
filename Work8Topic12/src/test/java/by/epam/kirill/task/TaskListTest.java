package by.epam.kirill.task;

import by.epam.kirill.client.Main;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.experimental.theories.*;
import org.junit.runner.RunWith;

import java.util.GregorianCalendar;
import java.util.LinkedList;

@RunWith(Theories.class)
public class TaskListTest extends TestCase {

    @DataPoint("Some tasks")
    public static TaskList data() {
        return Main.getSomeTasks();
    }

    public void testDeleteAll() {
        TaskList tasks= Main.getSomeTasks();
        tasks.deleteAll();
        Assert.assertEquals(0,tasks.getTasks().size());
    }
    @Theory
    public void testAdd(@FromDataPoints("Some tasks") TaskList tasks) {
        int startLength=tasks.getTasks().size();
        tasks.add(new Task.Builder<String>()
                .withCategory(Category.MUSIC)
                .withDeadLine(new GregorianCalendar(2021,1,6))
                .withName("R")
                .withPriority(Priority.A)
                .withId("hmmmmmmsoooooo")
                .build());
        Assert.assertEquals(startLength+1,tasks.getTasks().size());
    }
    @Theory
    public void testRemove(@FromDataPoints("Some tasks") TaskList tasks) {
        Task t= new Task.Builder<String>()
                .withCategory(Category.MUSIC)
                .withDeadLine(new GregorianCalendar(2021,1,6))
                .withName("R")
                .withPriority(Priority.A)
                .withId("hmmmmmmsoooooo")
                .build();
        tasks.add(t);
        int startLength=tasks.getTasks().size();
        tasks.remove(t);
        Assert.assertEquals(startLength-1,tasks.getTasks().size());

    }
    @Theory
    public void testSort(@FromDataPoints("Some tasks") TaskList tasks) {
        tasks.sort((Task a,Task b)->a.getName().compareTo(b.getName()));
        StringBuilder build=new StringBuilder();
        for(Task t : tasks.getTasks())build.append(t.getName());
        Assert.assertEquals("Client meetingEnglishEnglishRRok and rollRok and roll",build.toString());
    }
    @Theory
    public void testFilterTasks(@FromDataPoints("Some tasks") TaskList tasks) {

        StringBuilder build=new StringBuilder();
        LinkedList<Task> t =TaskList.filterTasks(tasks.getTasks(), (Task a) -> a.getCategory().equals(Category.HOMEWORK));
        for(Task tas : t){
            build.append(tas.getName());
        }
        Assert.assertEquals("EnglishEnglish",build.toString());
    }
    @Theory
    public void testGetUniqueNames(@FromDataPoints("Some tasks") TaskList tasks) {
        StringBuilder build=new StringBuilder();
        for(String s : TaskList.getUniqueNames(tasks.getTasks()))build.append(s);
        Assert.assertEquals("Client meetingEnglishRok and rollR",build.toString());
    }
    @Theory
    public void testGetAllTasksString(@FromDataPoints("Some tasks") TaskList tasks) {
        StringBuilder build=new StringBuilder();
        build.append("category='MEETING', name='Client meeting', priority='S', deadline:'Fri Feb 12 00:00:00 MSK 2021', id:123456790'\n");
        build.append("category='HOMEWORK', name='English', priority='A', deadline:'Tue Feb 02 00:00:00 MSK 2021', id:fsdfsd12'\n");
        build.append("category='MUSIC', name='Rok and roll', priority='A', deadline:'Sat Feb 06 00:00:00 MSK 2021', id:hmmmmmmsoooooo'\n");
        build.append("category='HOMEWORK', name='English', priority='A', deadline:'Tue Feb 02 00:00:00 MSK 2021', id:fsdfsd12'\n");
        build.append("category='MUSIC', name='Rok and roll', priority='A', deadline:'Sat Feb 06 00:00:00 MSK 2021', id:hmmmmmmsoooooo'\n");
        build.append("category='MUSIC', name='R', priority='A', deadline:'Sat Feb 06 00:00:00 MSK 2021', id:hmmmmmmsoooooo'\n");
        Assert.assertEquals(build.toString(),tasks.getAllTasksString());
    }


}