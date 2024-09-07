/**
 * Write a description of class ArrayQueue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArrayQueue<T> implements QueueInterface<T>
{
    private int size;
    private T[] queue;
    public ArrayQueue(){
        size=0;
        queue=(T[])new Object[1];
    }
    public int size(){
        return size;
    }
    public boolean empty(){
        return (size==0);
    }
    public T add(T item){
        T[] temp=(T[])new Object[size+1];
        for(int x=1;x<size+1;x++){
            temp[x]=queue[x-1];
        }
        queue=temp;
        temp[0]=item;
        size++;
        return item;
    }
    public T peek() throws QueueUnderflowException{
        if(empty())
        throw new QueueUnderflowException();
        return queue[size-1];
    }
    public T remove() throws QueueUnderflowException{
        if(empty())
        throw new QueueUnderflowException();
        T remove=queue[size-1];
        T[] temp=(T[])new Object[size-1];
        for(int x=0;x<size-1;x++){
            temp[x]=queue[x];
        }
        queue=temp;
        size--;
        return remove;
    }
    public void clear(){
        queue=(T[])new Object[1];
        size=0;
    }
}
