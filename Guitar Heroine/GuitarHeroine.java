/**
 * This GuitarHeroine object . . .
 * 
 * @author  
 * @version 
 */
public class GuitarHeroine
{
    public static void main(String[] args) 
    {
        GuitarString[] array=new GuitarString[37];
        for(int x=0;x<37;x++){
            array[x]=new GuitarString(440*(Math.pow(1.05956,x-24)));
        }
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

        // the main input loop
        while (true) 
        {
            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) 
            {
                // the user types this character
                char key = StdDraw.nextKeyTyped();

                // pluck the corresponding string
                if(keyboard.indexOf(key)!=-1)
                array[keyboard.indexOf(key)].pluck();
            }

            // compute the superposition of the samples
            double sample=0.0;
            for(int x=0;x<37;x++){
                sample+=array[x].sample();
            }
            // send the result to standard audio
            StdAudio.play(sample);
            // advance the simulation of each guitar string by one step
            for(int x=0;x<37;x++){
                array[x].tic();
            }
        }
    }
}
