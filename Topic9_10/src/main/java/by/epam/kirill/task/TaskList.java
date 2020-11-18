package by.epam.kirill.task;

import java.util.Comparator;
import java.util.LinkedList;

public class TaskList implements Sortable {
    private LinkedList<Task> Tasks;

    public TaskList(LinkedList<Task> tasks){
        this.Tasks=tasks;
    }
    public TaskList(){
        Tasks=new LinkedList<Task>();
    }

    public void deleteAll(){
        Tasks=new LinkedList<Task>();//а в c++ я бы тут ещё указатель удалял, эх...
    }
    public void add(Task task){
        Tasks.addLast(task);
    }

    public void remove(Task task){
        Tasks.remove(task);
    }

    public void sort(Comparator<Task> comparator){//  ничего, что я встроенной пользуюсь?
        this.Tasks.sort(comparator);
    }

    public void showAllListInTerminal(){
        for(Task t : Tasks){
            System.out.println(t.toString());
        }
    }

    public String  getAllTasksString(){
        StringBuilder builder=new StringBuilder();
        for(Task t : Tasks){
            builder.append(t.toString());
            builder.append('\n');
        }
        return builder.toString();
    }


}
