/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Main
{
    public static void main (String args[]) throws ThirteenException{
        while(true){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter:");
        String x=scan.nextLine();
        if(x.length()==13){
            throw new ThirteenException("nooo");
        }
        }
    }
}