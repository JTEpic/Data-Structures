import java.util.Queue;
import java.util.LinkedList;

/**
 * Write a description of class Que here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Que<T> implements QueueInterface<T>
{
    private Queue<T> x;
    
    public Que()
    {
        x=new LinkedList();
    }
    
    public int size(){
        return x.size();
    }
    
    // tests if this queue is empty
    public boolean empty(){
        return x.isEmpty();
    }
    
    // adds an item onto the rear of this queue
    public T add(T item){
        x.add(item);
        return item;
    }
        
    // looks at the object at the front of this queue
    // without removing it from the queue
    public T peek() throws QueueUnderflowException{
        if(empty())
        throw new QueueUnderflowException();
        return x.peek();
    }
    
    // removes the object at the front of this queue 
    // and returns that object as the value of this function
    public T remove() throws QueueUnderflowException{
        if(empty())
        throw new QueueUnderflowException();
        return x.remove();
    }
    
    // removes all of the elements from this stack
    public void clear(){
        x=new LinkedList();
    }
}
