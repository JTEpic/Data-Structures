/**
 * This RingBuffer object . . .
 * 
 * @author  
 * @version 
 */
public class RingBuffer 
{
    private double[] ring;
    private int size,r,l;
    public RingBuffer(int capacity)
    {
        ring=new double[capacity];
        size=0;
        l=0;
        r=0;
    }

    public int size()
    {
        return size;
    }
    
    public boolean isEmpty()
    {
        return (size==0);
    }
    
    public boolean isFull()
    {
        return (size==ring.length);
    }
    
    public void add(double value)
    {
        ring[r]=value;
        r++;
        if(!isFull()){
            size++;
        }
        check();
    }
    
    public double peek()
    {
        check();
        return ring[l];
    }
    
    public double remove()
    {
        double temp=ring[l];
        ring[l]=0.0;
        l++;
        size--;
        check();
        return temp;
    }
    
    public void check(){
        if(l>=ring.length)
        l=0;
        if(r>=ring.length)
        r=0;
        if(l<0)
        l=ring.length-1;
        if(r<0)
        r=ring.length-1;
    }
    // a simple test of the constructor and methods in RingBuffer
    public static void main(String[] args) 
    {
        int capacity = 100;
        RingBuffer buffer = new RingBuffer(capacity);  
        for (int i = 1; i <= capacity; i++) 
            buffer.add(i);
      
        double t = buffer.remove();
        buffer.add(t);
        System.out.println("Size after wrap-around is " + buffer.size());
        while (buffer.size() >= 2) 
        {
            double x = buffer.remove();
            double y = buffer.remove();
            buffer.add(x + y);
        }
        System.out.println(buffer.peek());
    }

}
