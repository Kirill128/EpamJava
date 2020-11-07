package by.epam.kirill.hometask3.tasksdecision;


import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TasksMethods {
    public static String task1StrBuilder(int count,int leftBorder,int rightBorder){
        StringBuilder str=new StringBuilder(100000);
        while(count >0){
            str.append((int)(Math.random()*(rightBorder-leftBorder+1))+leftBorder);
            str.append(' ');
            count--;
        }
        return str.toString();
    }
    public static String task1Str(int count,int leftBorder,int rightBorder){
        String str=new String();
        Random random=new Random();
        while(count >0){
            str+=((int)(Math.random()*(rightBorder-leftBorder+1))+leftBorder)+" ";
            count--;
        }
        return str;
    }
    public static String replaceAllInStrByReg(String str,String reg,String sub){
        Pattern pattern=Pattern.compile(reg);
        Matcher matcher=pattern.matcher(str);
        return matcher.replaceAll(sub);
    }
    public static LinkedList<String> countUniqueWords(String str){//голова turn of, ничего лучше в голову не пришло
        String[] allWords=str.split(" ");
        LinkedList<String> uniqueWordsWithCount=new LinkedList<String>();// я ж не знаю сколько элементов повторяется да и проходить надо по всем
        LinkedList<Integer> countSameWords=new LinkedList<Integer>();// можно было сделать linkedlist<string[]>, для будущего было бы лучше, но тут пофиг
        for(int i=0,countSameWord;i<allWords.length;i++){//последнее слово проверять не с чем
            countSameWord=0;
            for(int j=i;j<allWords.length;j++){
                if(allWords[i].equals(allWords[j]))countSameWord++;
            }
            boolean existInList=false;
            ListIterator<String> iter=uniqueWordsWithCount.listIterator();
            while(iter.hasNext()){
                if(allWords[i].equals(iter.next()))existInList=true;
            }
            if(!existInList){
                uniqueWordsWithCount.addLast(allWords[i]);
                countSameWords.addLast(countSameWord);
            }
        }
        ListIterator<Integer> iterCount=countSameWords.listIterator();
        ListIterator<String> iterWords=uniqueWordsWithCount.listIterator();
        while(iterWords.hasNext()){
            iterWords.set(iterWords.next()+" "+iterCount.next());
        }
        return uniqueWordsWithCount;
    }
}
