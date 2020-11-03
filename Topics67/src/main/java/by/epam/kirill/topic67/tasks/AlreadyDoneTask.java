package by.epam.kirill.topic67.tasks;

import java.util.Arrays;

public class AlreadyDoneTask extends Task implements Processible{
    private boolean meetDeadline;
    private String[][] postData;
    public AlreadyDoneTask(String category, String name, String priority, String[][] deadline,String[][] postData) {
        super(category, name, priority, deadline);
        this.postData = postData;
        setMeetDeadline();
    }
    public void setMeetDeadline(){//сравнивать можно по чём угодно(хоть по столетиям) и в каком угодно порядке.
        meetDeadline=true;
        for(int i=0;i< getDeadline().length;i++){
            for(int j=0;j<getPostData().length;j++){
                if(getDeadline()[i][0].equalsIgnoreCase(getPostData()[j][0])){
                    if(getDeadline()[i][1].compareTo(getPostData()[j][1])>0) {
                        meetDeadline = false;
                        break;
                    }
                }
            }
        }
    }

    public boolean getMeetDeadline() {
        return meetDeadline;
    }
    public void taskProgress(){
        System.out.println("Task had already done!");
    }
    public String[][] getPostData() {
        return postData;
    }

    public void setPostData(String[][] postData) {
        this.postData = postData;
    }


    @Override
    public String toString() {
        return "AlreadyDoneTask{" +
                "meetDeadline=" + meetDeadline +
                ", postData=" +postData[0][0]+":"+postData[0][1]+" , "+postData[1][0]+":"+postData[1][1]+" , "+postData[2][0]+":"+postData[2][1] +
                ", "+ super.toString()+
                '}';
    }
}
