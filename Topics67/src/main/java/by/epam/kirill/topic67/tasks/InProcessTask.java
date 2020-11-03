package by.epam.kirill.topic67.tasks;

public class InProcessTask extends Task  implements Processible {
    private int madePercent;
    public InProcessTask(String category, String name, String priority, String[][] deadline,int madePercent) {
        super(category, name, priority, deadline);
        this.madePercent=madePercent;
    }
    public void taskProgress(){
        System.out.println("Task in process, already done "+madePercent+" percent!");
    }
    @Override
    public String toString() {
        return "InProcessTask{" +
                "madePercent=" + madePercent +
                ", "+super.toString()+
                '}';
    }

    public int getMadePercent() {
        return madePercent;
    }

    public void setMadePercent(int madePercent) {
        this.madePercent = madePercent;
    }
}
