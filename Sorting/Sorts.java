/**
 * This Sorts object represents a class that perform
 * Bubble, Selection, Insertion, Merge, Quick, and Heap sorts
 * 
 * @author  
 * @version 
 */
public class Sorts extends SortUtilities
{

    public Sorts(String[] array)
    {
        super(array);
    }

    // The array to be sorted is a String array called 'array'

    // Whenever you need to swap two elements in 'array', call the 'swap(int a, int b)' method 
    // where a and b are the indices of the elements in 'array' that need to be swapped.  Every
    // time 'swap' is called, a snapshot of the array is taken, which is later used to 
    // compare against an exemplar (test example) to see if all of the swaps are correct.

    // All of your sorting methods should utilize 'in-place' sorting, meaning that elements
    // are always swapped, rather than being copied out to a temporary variable, and then copied 
    // back later.

    // Feel free to write any private helper methods you wish to use

    public void bubbleSort()    // ascending, bubbling up from beginning to end
    {
        int n=array.length,temp=0;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(array[j-1].compareTo(array[j])>0){
                    swap(j-1,j);
                }
            }
        }
    }

    public void selectionSort() // ascending, selecting the maximum values
    {
        int n=array.length;
        for (int i=n-1;i>0;i--)
        {
            int max=0;
            for (int j=0;j<=i;j++){
                if (array[j].compareTo(array[max])>0)
                    max=j;
            }
            if(i!=max)
            swap(i,max);
        }
    }

    public void insertionSort() // ascending, inserting values on the front end
    {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if(array[j - 1].compareTo(array[j])>0) {
                    swap(j,j-1);
                }
            }
        }
    }

    public void mergeSort() // ascending, working from front to back
    {
        mergesort(0,array.length-1);
    }
    
    public void mergesort(int front,int back){
        if(front<back){
            int middle=(front+back)/2;
            mergesort(front,middle);
            mergesort(middle+1,back);
            merge(front,middle,middle+1,back);
        }
    }
    
    public void merge(int leftFirst,int leftLast,int rightFirst,int rightLast){
        if(array[rightFirst].compareTo(array[leftLast])>0)
        return;
        while(leftFirst <= leftLast && rightFirst <= rightLast)
        if(array[rightFirst].compareTo(array[leftFirst])>0)
        leftFirst++;
        else{
        for(int i = rightFirst; i > leftFirst; i--)
        swap(i, i - 1);
        leftFirst++;
        leftLast++;
        rightFirst++;
        }
    }

    public void quickSort() // ascending, working from front to back
    {
        quickSort(0,array.length-1);
    }
    
    public void quickSort(int first,int last){
        if(first<last){
            int split=split(first,last);
            quickSort(first,split-1);
            quickSort(split+1,last);
        }
    }
    
    public int split(int first,int last){
        String splitVal=array[first];
        int saveFirst=first;
        first++;
        while(first<=last){
            boolean onCorrectSide=true;
            while(onCorrectSide){
                if(array[first].compareTo(splitVal)>0)
                onCorrectSide=false;
                else{
                    first++;
                    onCorrectSide=(first<=last);
                }
            }
            onCorrectSide=(first<=last);
            while(onCorrectSide){
                if(array[last].compareTo(splitVal)<0)
                onCorrectSide=false;
                else{
                    last--;
                    onCorrectSide=(first<=last);
                }
            }
            if(first<last){
                swap(first,last);
                first++;
                last--;
            }
        }
        if(saveFirst!=last)
        swap(saveFirst,last);
        
        return last;
    }

    public void heapSort()  // ascending
    {
        // Note that the 'reheapDown' and 'newHole' methods are already provided
        // in the abstract parent class (SortUtilities) for your use.
        for(int index=array.length-1;index>=0;index--)
        reheapDown(array[index],index,array.length-1);
        
        for(int index=array.length-1;index>0;index--){
        swap(0,index);
        reheapDown(array[0],0,index-1);
        }
    }
}
