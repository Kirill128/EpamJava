package by.epam.kirill.task;

public class Task {
    private Category category;
    private String name;
    private Priority priority;
    private String[][] deadline;
    private String id;

    public Task(){

    }

    @Override
    public String toString() {
        StringBuilder deadlinedate=new StringBuilder();
        for(int i=0;i< deadline.length;i++ )
            deadlinedate.append(deadline[i][0]+":"+deadline[i][1]+" ");
        return "category='" + category.name() + '\'' +
                ", name='" + name + '\'' +
                ", priority='" + priority.name() + '\'' +
                ", deadline:'" + deadlinedate.toString()+'\''+
                ", id:" + id+'\''
                ;

    }
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String[][] getDeadline() {
        return deadline;
    }

    public void setDeadline(String[][] deadline) {
        this.deadline = deadline;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }




    public static class Builder{
        private Task newTask;
        public Builder(){
            newTask=new Task();
        }
        public Builder withCategory(Category category){
            newTask.category=category;
            return this;
        }
        public Builder withName(String name){
            newTask.name=name;
            return this;
        }
        public Builder withPriority(Priority priority){
            newTask.priority=priority;
            return this;
        }
        public Builder withDeadLine(String[][] deadLine){
            newTask.deadline=deadLine;
            return this;
        }
        public Builder withId(String id){
            newTask.id=id;
            return this;
        }
        public Task build(){
            return newTask;
        }
    }
}
