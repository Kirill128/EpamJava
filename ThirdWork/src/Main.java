import java.sql.SQLOutput;
import java.util.Random;

public class Main {
    public static void main(String[] args ){
        boolean play=true;
        while(play){
            System.out.println("Input num:");
            switch (){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    break;

            }

        }
    }
    public static String task1(){
        Random rand =new Random();
        StringBuilder str=new StringBuilder(200);
        for(int i=0;i<100;i++){
            str.append(rand.nextInt()+" ");
        }
        return str.toString();
    }
}
