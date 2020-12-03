package by.epam.kirill.task;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TaskList implements Sortable {
    private LinkedList<Task> Tasks;

    public TaskList(LinkedList<Task> tasks){
        this.Tasks=tasks;
    }
    public TaskList(){
        Tasks=new LinkedList<Task>();
    }

    public void deleteAll(){
        Tasks=new LinkedList<Task>();
    }
    public void add(Task task){
        Tasks.addLast(task);
    }

    public void remove(Task task){
        Tasks.remove(task);
    }
    public void remove(String Id){
        for (Task t:
             Tasks) {
            if(Id.equals(t.getId()))remove(t);
        }
    }

    public void sort(Comparator<Task> comparator){
        Tasks=Tasks.stream()
                .sorted(comparator)
                .collect(Collectors.toCollection(LinkedList::new));
    }
    public static LinkedList<Task> filterTasks(LinkedList<Task> Tasks, Predicate<Task> t){
        return (LinkedList<Task>) Tasks.stream()
                .filter(t)
                .collect(Collectors.toCollection(LinkedList::new));
    }
    public static LinkedList<String> getUniqueNames(LinkedList<Task> Tasks){
        LinkedList<String> names=new LinkedList<String>();
        for (Task t:
             Tasks) {
            names.addLast(t.getName());
        }
        return names.stream()
                .distinct()
                .collect(Collectors.toCollection(LinkedList::new));
    }
    public  void removeSameTasks(){
        Tasks=Tasks.stream()
                .distinct()
                .collect(Collectors.toCollection(LinkedList::new));
    }
    public LinkedList<Task> getTasks(){
        return Tasks;
    }

    public void showAllListInTerminal(){
        Tasks.stream().forEach(System.out::println);
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
