import java.util.ArrayList;
/**
 * Write a description of class heap here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Heap<T extends Comparable<T>> implements PriorityQueue<T>{
    private ArrayList<T> array;
    public Heap(){
        array=new ArrayList();
    }
    
    // returns the logical size of the priority queue
    public int size(){
        return array.size();
    }
    
    // tests if this priority queue is empty
    public boolean empty(){
        return size()==0;
    }
    
    // adds an item to the priority queue
    public T add(T element){
        array.add(element);
        reheapUp(element);
        return element;
    }
    
    public void reheapUp(T element){
        int h=size()-1;
        //element>
        while (h!=0 && element.compareTo(array.get((h-1)/2))>0) {
            array.set(h,array.get((h-1)/2));
            h = (h-1)/2;
        }
        array.set(h,element);
    }
        
    // looks at the object at the front of this priority queue
    // without removing it from the priority queue
    public T peek() throws PQUnderflowException{
        if(empty())
        throw new PQUnderflowException("bruhhh");
        return array.get(0);
    }
    
    // removes the object at the front of this priority queue 
    // and returns that object as the value of this function
    public T remove() throws PQUnderflowException{
        if(empty())
        throw new PQUnderflowException("bruhhh");
        T root=peek();
        T end=array.remove(size()-1);
        if(!empty())
        reheapDown(end);
        return root;
    }
    
    public void reheapDown(T element){
        int h=0,loc=newHole(h,element);
        while(loc!=h){
            array.set(h,array.get(loc));
            h=loc;
            loc=newHole(h,element);
        }
        array.set(h,element);
    }
    
    public int newHole(int index,T element){
        int l=index*2+1,r=index*2+2;
        if (l > size()-1)
          // hole has no children
          return index;         
        else if (l == size()-1)
          // hole has left child only
          if (element.compareTo(array.get(l)) < 0)             
            // item < left child
            return l;
          else
            // item >= left child
            return index;
        // hole has two children 
        else if (array.get(l).compareTo(array.get(r)) < 0)
          // left child < right child
          if (array.get(r).compareTo(element) <= 0)
            // right child <= item
            return index;
          else
            // item < right child
            return r;
        else
        // left child >= right child
        if (array.get(l).compareTo(element) <= 0)
          // left child <= item
          return index;
        else
          // item < left child
          return l;
    }
    
    // removes all of the elements from this priority queue
    public void clear(){
        array=new ArrayList();
    }
}
