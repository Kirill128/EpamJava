package by.epam.kirill.task;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.GregorianCalendar;

public class TaskTest extends TestCase {

    public void testCompareTo() {

        Task a=new Task.Builder<String>()
                .withCategory(Category.MEETING)
                .withDeadLine(new GregorianCalendar(2021,1,12))
                .withName("Client meeting")
                .withPriority(Priority.S)
                .withId("123456790")
                .build();
        Task b=new Task.Builder<String>()
                .withCategory(Category.HOMEWORK)
                .withDeadLine(new GregorianCalendar(2021,1 ,2))
                .withName("English")
                .withPriority(Priority.A)
                .withId("fsdfsd12")
                .build();

        Assert.assertEquals(1,a.compareTo(b));
    }

    public void testTestEquals() {
        Task a=new Task.Builder<String>()
                .withCategory(Category.HOMEWORK)
                .withDeadLine(new GregorianCalendar(2021,1 ,2))
                .withName("English")
                .withPriority(Priority.A)
                .withId("fsdfsd12")
                .build();
        Task b=new Task.Builder<String>()
                .withCategory(Category.HOMEWORK)
                .withDeadLine(new GregorianCalendar(2021,1 ,2))
                .withName("English")
                .withPriority(Priority.A)
                .withId("fsdfsd12")
                .build();
        Assert.assertEquals(true,a.equals(b));
    }

    public void testTimeFromNowToDeadLine() {
        Task a=new Task.Builder<String>()
                .withCategory(Category.HOMEWORK)
                .withDeadLine(new GregorianCalendar(2021,0 ,22))
                .withName("English")
                .withPriority(Priority.A)
                .withId("fsdfsd12")
                .build();

        Assert.assertEquals(12,a.timeFromNowToDeadLine().getDays());
        Assert.assertEquals(0,a.timeFromNowToDeadLine().getMonths());
        Assert.assertEquals(0,a.timeFromNowToDeadLine().getYears());
    }

    public void testTestToString() {
        Task a=new Task.Builder<String>()
                .withCategory(Category.HOMEWORK)
                .withDeadLine(new GregorianCalendar(2021,0 ,22))
                .withName("English")
                .withPriority(Priority.A)
                .withId("fsdfsd12")
                .build();
        System.out.println("ToSting:"+a.toString());
    }
}