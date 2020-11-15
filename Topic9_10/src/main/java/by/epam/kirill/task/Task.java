package by.epam.kirill.task;

public class Task <T> implements Comparable<Task>{
    private Category category;
    private String name;
    private Priority priority;
    private String[][] deadline;// вот я без понятия оставить или поменять на string
    //ведь форматы ввода разные бывают: 21.12.2020, 12.21.2020 . Как быть
    private T id;

    public Task(){

    }

    public int compareTo(Task o) {
           
    }

    public boolean equals(Task task2) {
        if(this==task2 || this.getId().equals(task2.getId()) )return true;// если id уникален для каждого объкта
        if(!this.getCategory().equals(task2.getCategory())||
                !this.getName().equals(task2.getName()) ||
                !this.getPriority().equals(task2.getPriority())
        )return false;
        for(int i=0;i<this.getDeadline().length;i++){
            for(int j=0;j<task2.getDeadline().length;j++){
                if(this.getDeadline()[i][0].equals(task2.getDeadline()[j][0]) &&
                        !this.getDeadline()[i][1].equals(task2.getDeadline()[j][1])
                )return false;
            }
        }
        return true;
    }
    /*
    public boolean equals(Task task2){
        return this.toString().equals(task2.toString());
    }
     */

    @Override
    public int hashCode() {
        return super.hashCode();
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

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }



    public static class Builder<T>{
        private Task<T> newTask;
        public Builder(){
            newTask=new Task<T>();
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
        public Builder withId(T id){
            newTask.id=id;
            return this;
        }
        public Task<T> build(){
            return newTask;
        }
    }
}