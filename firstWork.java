import java.util.Scanner;
public class firstWork{
	public static void main(String [] args){
		int numOfTask;
		boolean wantToWork=true;
		while(wantToWork){
			System.out.println("Input num of task:");
			numOfTask=getInt();
			switch(numOfTask){
				case 1:{
					firstTask();
				}break;
				case 2:{
					secondTask();
				}break;
				case 3:{
					thirdTask();
				}break;
				case 4:{
					System.out.println("Input a:");
					int a=getInt();
					System.out.println("Input b:");
					int b=getInt();
					if(nearNum(a,b))
						System.out.println("Yes,it's near!");
					else 	
						System.out.println("No,it's far away!");
				}break;
			}
		}

	}
	public static boolean nearNum(int a,int b){
		return (max(a,b)*0.9)<=min(a,b);// быстерее работало было бы  через один цикл, но и кода больше 
	}					// да и кому это тут нужно

	public static void thirdTask(){
		System.out.println("INput firstNum:");
		int firstNum=getInt();
		System.out.println("Input secondNum:");
		int secondNum=getInt();
		System.out.println("Input thirdNum:");
		int thirdNum=getInt();
		System.out.println("Min:"+min(min(firstNum,secondNum),thirdNum));
		System.out.println("Max:"+max(max(firstNum,secondNum),thirdNum));
		System.out.println("Average:"+averageInThreeNums(firstNum,secondNum,thirdNum));
	}
	public static int min(int a,int b){
		if(a<b)
			return a;
		return b;
	}
	public static int max(int a,int b){
		if(a>b)
			return a;
		return b;//при одинаковых а и б всё равно ,что вернуть
	}
	public static int averageInThreeNums(int a,int b,int c){
		return (a+b+c)/3;
	}
	public static void secondTask(){
		System.out.println("Input leftNum:");
		int leftNum=getInt();
		System.out.println("Input rightNum:");
		int rightNum=getInt();
		System.out.println("Input userNum:");
		int userNum=getInt();
		if(userNum<=leftNum){
			System.out.println(userNum+"<="+leftNum);
		}else{
			if(userNum>=rightNum)
				System.out.println(userNum+">="+rightNum);
			else
				System.out.println(leftNum+"<"+userNum+"<"+rightNum);
		}
	} 
	public static void firstTask(){
		switch(getInt()){
			case 1:{
				       System.out.println("This is Monday!");
			}break;
			case 2:{
				       System.out.println("This is Tuesday!");
			}break;
			case 3:{
					 System.out.println("This is Wenesday!");
			}break;
			case 4:{
					 System.out.println("This is Thursday!");
			}break;
			case 5:{
					 System.out.println("This is Friday!");
			}break;
			case 6:{
					 System.out.println("This is Saturday!");
			}break;
			case 7:{
					 System.out.println("This is Sunday!");
			}break;
			default:
				System.out.println("This day doesn't exist !");
			break;
		}	
	}
	public static int getInt(){
		int numOfDay=-1;
		boolean correspond=false;
		while(!correspond){
			try{
				Scanner in =new Scanner(System.in);
				numOfDay=in.nextInt();
				correspond=true;
			}catch(Exception e){
				System.out.println("Input error!!  Try again ");
			}
		}
		return numOfDay;
	}
}
