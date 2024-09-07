
/**
 * This ArrayStack object represents a Stack ADT implemented as
 * an array using the StackInterface
 * 
 * @author  
 * @version 
 */
public class ArrayStack<T> implements StackInterface<T>
{
    private int size;
    private T[] stack;

    public ArrayStack()
    {
        // cannot create a generic array object, so has to be cast
        // from an Object back into the generic in order to compile
        stack = (T[]) new Object[1];
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
        if(empty()){
            throw new StackUnderflowException("AHHHH");
        }
        return stack[size-1];
    }

    // removes the object at the top of this stack
    // and returns that object as the value of this function
    public T pop()
    {
        if(empty()){
            throw new StackUnderflowException("UHHH");
        }
        T top=stack[size-1];
        stack[size-1]=null;
        size--;
        checkSize();
        return top;
    }

    // pushes an item onto the top of this stack
    public T push(T item)
    {
        stack[size]=item;
        size++;
        checkSize();
        return item;
    }

    // removes all of the elements from this stack
    public void clear()
    {
        while(!empty())
        pop();
    }

    // returns the 1 based position where an object is on this stack
    // note: when the method ends, the stack is the same as it was at the start
    public int search(Object o)
    {
        for(int x=0;x<size;x++)
            if(((T)o).equals(stack[x]))
                return size-x;
        return -1;
    }
    
    private void checkSize(){
        int newSize;
        if(size==stack.length)
        newSize=stack.length*2;
        else if(size<stack.length/4)
        newSize=stack.length/2;
        else
        return;
        T[] temp=(T[]) new Object[newSize];
        for(int x=0;x<size;x++)
        temp[x]=stack[x];
        stack=temp;
    }
}
