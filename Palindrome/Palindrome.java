import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Write a description of class Palindrome here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Palindrome
{
    public static boolean isPalindrome(String str){
        String temp1="",temp2="";
        Stack t1=new Stack();
        Queue t2=new LinkedList();
        for(int x=0;x<check(str).length();x++){
            t1.push(check(str).substring(x,x+1));
        }
        for(int x=0;x<check(str).length();x++){
            t2.add(check(str).substring(x,x+1));
        }
        while(t1.size()!=0)
        temp1+=t1.pop();
        while(t2.size()!=0)
        temp2+=t2.remove();
        return temp1.equals(temp2);
    }
    public static String check(String str){
        String temp=str.replaceAll("[^a-zA-Z0-9]", "");
        temp=temp.toLowerCase();
        return temp;
    }
}