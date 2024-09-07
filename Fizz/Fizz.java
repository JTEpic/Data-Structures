/**
 * Write a description of class Fizz here.
 *
 * @author JTEpic
 * @version (a version number or a date)
 */
public class Fizz{
public static void main (String args[])
{
for(int x=1;x<=100;x++){
if(x%3==0&&x%5==0)
System.out.println("Fizz-Buzz");
else if(x%3==0)
System.out.println("Fizz");
else if(x%5==0)
System.out.println("Buzz");
else
System.out.println(x);
}
}
}
