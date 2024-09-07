/**
 * Write a description of class ArrayQueue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LinkedQueue<T> implements QueueInterface<T>
{
    private LLNode<T> front;
    private LLNode<T> rear;
    private int size;
    public LinkedQueue(){
        front=null;
        rear=null;
        size=0;
    }
    public int size(){
        return size;
    }
    public boolean empty(){
        return (size()==0);
    }
    public T add(T item){
        LLNode<T> newNode=new LLNode<T>(item);
        if(rear==null)
        front=newNode;
        else
        rear.setLink(newNode);
        rear=newNode;
        size++;
        return item;
    }
    public T peek() throws QueueUnderflowException{
        if(empty())
        throw new QueueUnderflowException();
        return front.getInfo();
    }
    public T remove() throws QueueUnderflowException{
        if(empty())
        throw new QueueUnderflowException();
        T element=front.getInfo();
        front=front.getLink();
        if(front==null)
        rear=null;
        size--;
        return element;
    }
    public void clear(){
        front=null;
        rear=null;
        size=0;
    }
}
