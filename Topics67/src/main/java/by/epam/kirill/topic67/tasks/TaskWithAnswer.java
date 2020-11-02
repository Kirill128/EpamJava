package by.epam.kirill.topic67.tasks;

public class TaskWithAnswer extends Task {
    private String userAnswer;
    private String rightAnswer;
    public TaskWithAnswer(String category, String name, String priority, String deadline) {
        super(category, name, priority, deadline);
    }
}
