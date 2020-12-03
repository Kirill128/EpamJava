package by.epam.kirill.task;

import java.util.Calendar;

public class Task <T> implements Comparable<Task>{
    private Category category;
    private String name;
    private Priority priority;
    private Calendar deadline;
    private T id;

    public Task(){

    }

    public int compareTo(Task o) {// по дефолту сравниваю по дедлайнам
        if(this.getDeadline().getTime().after(o.getDeadline().getTime()))return 1;
        if(this.getDeadline().getTime().before(o.getDeadline().getTime()))return -1;
        return 0;
    }

    public boolean equals(Task task2) {// сравниваю по всем параметрам
        return this.getName().equals(task2.getName()) ;
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
        return "category='" + category.name() + '\'' +
                ", name='" + name + '\'' +
                ", priority='" + priority.name() + '\'' +
                ", deadline:'" + deadline.getTime()+'\''+
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

    public Calendar getDeadline() {
        return deadline;
    }

    public void setDeadline(Calendar deadline) {
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
        public Builder withDeadLine(Calendar deadLine){
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