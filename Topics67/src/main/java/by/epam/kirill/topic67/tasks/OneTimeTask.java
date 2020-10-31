package by.epam.kirill.topic67.tasks;

public class OneTimeTask extends SomeTimesTask {

    public OneTimeTask(String category, String name, String priority, String deadline) {
        super(category, name, priority, deadline, 1);
    }

}
