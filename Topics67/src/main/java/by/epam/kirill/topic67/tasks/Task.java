package by.epam.kirill.topic67.tasks;

public abstract class Task {

    private String category;
    private String name;
    private String priority;
    private String deadlineData;

    public Task(String category, String name, String priority, String deadline) {
        this.category = category;
        this.name = name;
        this.priority = priority;
        this.deadlineData = deadline;
    }

    @Override
    public String toString() {
        return "Task{" +
                "category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", priority='" + priority + '\'' +
                ", deadline='" + deadlineData + '\'' +
                '}';
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDeadline() {
        return deadlineData;
    }

    public void setDeadline(String deadline) {
        this.deadlineData = deadline;
    }


}
