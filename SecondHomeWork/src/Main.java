import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        boolean wantToWork = true;

        while(wantToWork) {
            System.out.println("Input num of task:");
            int numOfTask = getInputInt();
            switch(numOfTask) {
                case 1:
                    System.out.println("Input length:");
                    firstTask(getInputInt());
                    break;
                case 2:
                    if(secondTask())
                        System.out.printf("Yes");
                    else
                        System.out.printf("N0");
                    break;
                case 3:
                    thirdTask();
                    break;
                case 4:

                    break;
                default:
                    wantToWork = false;
            }
        }
    }
    public static void showArray(int [][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.println(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean secondTask(){
        int [] daysInMonths=new int[]{};
        System.out.printf("Input month:");
        int month=getInputInt();
        System.out.printf("Input day:");
        int day=getInputInt();
        return (month>0 && daysInMonths[month-1]>=day && day>0);
    }
    public static void thirdTask(){
        System.out.println("Input res of 3-3*2  , you have only 3 tries:");
        int numOfTry=3,trueAnswer=-3;
        for(int i=1;i<=numOfTry;i++){
            if(getInputInt()==-3){
                System.out.printf("True! You won !");
                return;
            }
            System.out.println("False!\nMay be you want to exit?");
            if(getInputString()=="yes")break;
        }
        System.out.println("You lose!");
    }
    public static void firstTask(int length){
        for(int i=0;i<length;i++){
            for(int j=i;j<length-i;j++){


            }
        }
    }
    public static String getInputString(){
        Scanner in =new Scanner(System.in);
        return in.next();
    }
    public static int getInputInt() {
        int num = -1;
        boolean correspond = false;
        while(!correspond) {
            try {
                Scanner in = new Scanner(System.in);
                num = in.nextInt();
                correspond = true;
            } catch (Exception e) {
                System.out.println("Input error!!  Try again ");
            }
        }
        return num;
    }
}
