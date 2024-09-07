import java.util.Queue;
import java.util.LinkedList;

/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String args[]){
    Queue queue=new LinkedList();
    int element1 = 4;
    int element3 = 0;
    int element2 = element1 + 1;
    queue.add(element2);
    queue.add(element2 + 1);
    queue.add(element1);
    element2 = queue.remove();
    element1 = element2 + 1;
    queue.add(element1);
    queue.add(element3);
    while (!queue.empty())
    {
       element1 = queue.remove();
       System.out.print(element1 + " ");
    }
    System.out.print("\n" + element1 + " " + element2 + " " + element3);
   }
}
