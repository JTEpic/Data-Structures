
/**
 * This LinkedStack object represents a Stack ADT implemented as
 * a LinkedList using the StackInterface.
 * 
 * @author
 * @version
 */
public class LinkedStack<T> implements StackInterface<T>
{
    private LLNode<T> top;
    private int size;

    public LinkedStack()
    {
        top=null;
        size=0;
    }

    // returns the logical size of the stack
    public int size()    
    {
        return size;
    }

    // tests if this stack is empty
    public boolean empty()
    {
        return (size==0);
    }

    // looks at the object at the top of this stack
    // without removing it from the stack
    public T peek()
    {
        if(empty())
        throw new StackUnderflowException("AHHHHH");
        return top.getInfo();
    }

    // removes the object at the top of this stack 
    // and returns that object as the value of this function
    public T pop()
    {
        T temp;
        if(empty())
        throw new StackUnderflowException("AHHHHH");
        else{
        temp=top.getInfo();
        top=top.getLink();
        }
        size--;
        return temp;
    }

    // pushes an item onto the top of this stack
    public T push(T item)
    {
        LLNode<T> node =new LLNode<T>(item);
        node.setLink(top);
        top=node;
        size++;
        return top.getInfo();
    }

    // removes all of the elements from this stack
    public void clear()
    {
        while(!empty()){
            pop();
        }
    }

    // returns the 1 based position where an object is on this stack
    // note: when the method ends, the stack is the same as it was at the start
    public int search(Object o)
    {
        LLNode<T> temp=top;
        int loc=1;
        while(loc<=size){
            if(temp.getInfo().equals(o))
            return loc;
            temp=temp.getLink();
            loc++;
            
        }
        return -1;
    }
}
