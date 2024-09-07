import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class BinarySearchArray here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BinarySearchArray<T extends Comparable<T>> implements WordCountCollection<T>
{
    private List<T> array;
    /**
     * Constructor for objects of class BinarySearchArray
     */
    public BinarySearchArray()
    {
        array=new ArrayList();
    }
    
    // Returns the number of elements in this collection.
    public int size(){
        return array.size();
    }
    
    // Returns true if this collection is empty; otherwise, returns false.
    public boolean isEmpty(){
        return (size()==0);
    }

    // Adds element to this collection.
    // Precondition: element is not already in the collection
    public void add (T element){
        int index = binarySearch(array, element);
        array.add(index, element);
    }
    public int binarySearch(List<T> list, T key) {
        int low = 0;
        int high = list.size()-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            T midVal = list.get(mid);
            if (midVal.compareTo(key) < 0) {
                low = mid + 1;
            } else if (midVal.compareTo(key) > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return low;
    }
    
    // Returns the element of this colletion if contains an element e such that
    // e.compareTo(element) == 0; otherwise, returns null.
    public T fetch(T element){
        int temp=binarySearch(array,element);
        if(temp<size()&&element.compareTo(array.get(temp))==0)
        return array.get(temp);
        else
        return null;
    }

    // Removes all elements in this collection
    public void clear(){
        array=new ArrayList();
    }
    
    // generates a list of the elements in the collection
    // Postcondion: list is independant (deep copy) of original collection
    public List<T> createList(){
        List<T> temp=new ArrayList(array);
        return temp;
    }
}
