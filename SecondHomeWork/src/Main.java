import java.util.Random;
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
                    showArray(firstTask(getInputInt()));
                    break;
                case 2:
                    if(secondTask())
                        System.out.println("Yes");
                    else
                        System.out.println("N0");
                    break;
                case 3:
                    thirdTask();
                    break;
                case 4:
                    System.out.println("Input num >= 0  and <=100:");
                    int a=getInputInt();
                    if(a>=0 && a<=100)
                        System.out.println("Tries:"+getNumOfTrys(a));
                    else
                        System.out.println("Out of range!");
                    break;
                default:
                    wantToWork = false;
            }
        }
    }
    public static void showArray(int [][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int getNumOfTrys(int userNum){
        Random rand =new Random();
        int resTrys=0;
        while(userNum!=rand.nextInt()%101){
            resTrys++;
        }
        return resTrys+1;
    }
    public static boolean secondTask(){
        int [] daysInMonths=new int[]{31,29,31,30,31,30,31,31,30,31,30,31};
        System.out.printf("Input month:");
        int month=getInputInt();
        System.out.printf("Input day:");
        int day=getInputInt();
        return (month>0 &&  month<13 && daysInMonths[month-1]>=day && day>0);
    }
    public static void thirdTask(){

        int numOfTry=3,trueAnswer=-3;
        for(int i=0;i<numOfTry;i++){
            System.out.println("Input res of 3-3*2  , you have only " +(numOfTry-i)+ " tries:");
            if(getInputInt()==-3){
                System.out.printf("True! You won !");
                return;
            }
            System.out.println("False!\nMay be you want to exit?");
            if(getInputString()=="yes")break;
        }
        System.out.println("You lose!");
    }
    public static int[][] firstTask(int length){
        int [][] arr =new int[length][length];
        length--;
        for(int i=0;i<=length;i++){
            for(int j=i;j<=length;j++){
                arr[i][j]=i+1;
                arr[j][i]=i+1;
                arr[length][j]=i+1;
                arr[j][length]=i+1;
            }
            length--;
        }
        return arr;
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
