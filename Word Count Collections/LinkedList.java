import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class BinarySearchArray here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LinkedList<T extends Comparable<T>> implements WordCountCollection<T>
{
    private int size;
    LLNode<T> node;
    LLNode<T> back;
    /**
     * Constructor for objects of class BinarySearchArray
     */
    public LinkedList()
    {
        size = 0;
        node=null;
        back=null;
    }
    
    // Returns the number of elements in this collection.
    public int size(){
        return size;
    }
    
    // Returns true if this collection is empty; otherwise, returns false.
    public boolean isEmpty(){
        return (size==0);
    }

    // Adds element to this collection.
    // Precondition: element is not already in the collection
    public void add (T element){
        size++;
        if(node==null){
        node=new LLNode(element);
        back=node;
        }
        else{
        back.setLink(new LLNode(element));
        back=back.getLink();
        }
    }
    
    // Returns the element of this colletion if contains an element e such that
    // e.compareTo(element) == 0; otherwise, returns null.
    public T fetch(T element){
        LLNode<T> temp=node;
        while(temp!=null){
            if(temp.getInfo().compareTo(element)==0)
            return temp.getInfo();
            temp=temp.getLink();
        }
        return null;
    }

    // Removes all elements in this collection
    public void clear(){
        size=0;
        node=null;
        back=null;
    }
    
    // generates a list of the elements in the collection
    // Postcondion: list is independant (deep copy) of original collection
    public List<T> createList(){
        List<T> total=new ArrayList<T>();
        LLNode<T> temp=node;
        while(temp!=null){
            total.add(temp.getInfo());
            temp=temp.getLink();
        }
        return total;
    }
}
