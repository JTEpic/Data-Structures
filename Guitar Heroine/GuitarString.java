/**
 * This GuitarString object . . .
 * 
 * @author  
 * @version 
 */
public class GuitarString 
{
    private RingBuffer buffer;
    private int count;
    public GuitarString(double frequency) 
    {
        buffer = new RingBuffer(44100/(int)Math.round(frequency));
        count=0;
    }

    public GuitarString(double[] array) 
    {
        buffer = new RingBuffer(array.length);
        for(int x=0;x<array.length;x++)
        buffer.add(array[x]);
        count=0;
    }

    public void pluck() 
    {
        while(!buffer.isEmpty())
        buffer.remove();
        while(!buffer.isFull())
        buffer.add(Math.random()-.5);
    }

    // advance the simulation one time step
    public void tic() 
    {
        double av=((buffer.remove()+buffer.peek())/2)*.994;
        buffer.add(av);
        count++;
    }

    // return the current sample
    public double sample() 
    {
        return buffer.peek();
    }

    // return number of times tic was called
    public int time() 
    {
        return count;
    }

    public static void main(String[] args) 
    {
        double[] samples = { .2, .4, .5, .3, -.2, .4, .3, .0, -.1, -.3 };  
        GuitarString testString = new GuitarString(samples);
        for (int i = 0; i < 25; i++) 
        {
            int t = testString.time();
            double sample = testString.sample();
            System.out.printf("%6d %8.4f\n", t, sample);
            testString.tic();
        }
    }
}
