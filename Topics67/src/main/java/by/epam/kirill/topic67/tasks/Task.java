package by.epam.kirill.topic67.tasks;

public abstract class Task {

    private String category;
    private String name;
    private String priority;
    private String[][] deadline;

    public Task(String category, String name, String priority, String[][] deadlineData) {// Просто так захотелось,не ругайся)))) в нормальном проекте трижды подумаю
        this.category = category;
        this.name = name;
        this.priority = priority;
        this.deadline = deadlineData;
    }



    @Override
    public String toString() {
        return "category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", priority='" + priority + '\'' +
                ", deadline:'" + deadline[0][0]+":"+deadline[0][1]+" , "+deadline[1][0]+":"+deadline[1][1]+" , "+deadline[2][0]+":"+deadline[2][1] +'\''
                ;//Можно будет  и перечислением сделать, если успею
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

    public String[][] getDeadline() {
        return deadline;
    }

    public void setDeadline(String[][] deadline) {
        this.deadline = deadline;
    }


}
