package by.epam.kirill.topic67.tasks;

public class AlreadyDoneTask extends Task {
    private boolean meetDeadline;
    private String postData;

    public AlreadyDoneTask(String category, String name, String priority, String deadline) {
        super(category, name, priority, deadline);
    }
}
