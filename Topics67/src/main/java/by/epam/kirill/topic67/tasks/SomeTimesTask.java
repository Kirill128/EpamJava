
package by.epam.kirill.topic67.tasks;

public class SomeTimesTask extends Task {
    public int howManyTimesRepeat;
    private boolean wasDone;

    public SomeTimesTask(String category, String name, String priority, String deadline, int repeatingTimes) {
        super(category, name, priority, deadline);
        this.howManyTimesRepeat=repeatingTimes;
    }


    public int getHowManyTimesRepeat() {
        return howManyTimesRepeat;
    }

    public void setHowManyTimesRepeat(int howManyTimesRepeat) {
        this.howManyTimesRepeat = (howManyTimesRepeat>0)?howManyTimesRepeat:0;
    }

    public boolean getWasDone(){
        return getHowManyTimesRepeat()==0;
    }

}


