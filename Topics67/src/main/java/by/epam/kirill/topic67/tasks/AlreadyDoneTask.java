package by.epam.kirill.topic67.tasks;

public class AlreadyDoneTask extends Task {
    private boolean meetDeadline;
    public AlreadyDoneTask(String category, String name, String priority, String deadline) {
        super(category, name, priority, deadline);
    }
}
