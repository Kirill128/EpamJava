package by.epam.kirill.hometask3.app;

import by.epam.kirill.hometask3.tasksdecision.TasksMethods;
import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        boolean play=true;
        String task1Str=new String("");
        while(play){
            System.out.println("Input num of task:");
            switch (getInputInt()){
                case 1:
                    task1Str=TasksMethods.task1StrBuilder(100,0,1000);
                    System.out.println("StringBuilder answer:"+ task1Str);
                    task1Str=TasksMethods.task1Str(100,0,1000);
                    System.out.println("String answer:"+task1Str);
                    break;
                case 2:
                    if(task1Str.isEmpty())task1Str=TasksMethods.task1StrBuilder(100,0,1000);
                    System.out.println("Res 1 :"+TasksMethods.replaceAllInStrByReg(task1Str," \\d\\d ", " -1 "));
                    System.out.println("Res 2: "+task1Str.replaceAll(" \\d\\d "," -1 "));
                    break;
                case 3:
                    System.out.printf("Input name:");
                    String name=getInputLine();
                    System.out.printf("Input age:");
                    int age=getInputInt();
                    System.out.println(String.format("Hello %s, you're %d",name,age));
                    break;
                case 4:
                    System.out.printf("Input line:");
                    for(String s : TasksMethods.countUniqueWords(getInputLine())){
                        System.out.println(s);
                    }
                    break;
                default:
                    play=false;
                    break;

            }

        }
    }
    public static String getInputLine(){
        Scanner scan=new Scanner(System.in);
        return scan.nextLine();
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
