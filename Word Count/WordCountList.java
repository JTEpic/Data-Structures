
/**
 * Write a description of class WordCountList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordCountList implements WordCountListInterface
{
    private WordCount[] array;
    private int size;
    public WordCountList()
    {
        array=new WordCount[0];
        size=0;
    }

    // return the logical size of the list
    public int size(){
        return size;
    }

    // if the word is new to the list, add a new WordCount
    // object to the list, otherwise increment the counter
    // in the existing WordCount object.
    public void add(String word){
        boolean used=false;
        WordCount temp=new WordCount(word);
        for(int x=0;x<array.length;x++){
            if(array[x].equals(temp)){
                array[x].increment();
                used=true;
            }
        }
        if(!used){
            WordCount[] added=new WordCount[array.length+1];
            for(int x=0;x<array.length;x++){
                added[x]=array[x];
            }
            array=added;
            array[size]=temp;
            size++;
        }
    }
    
    // return the WordCount object located at index
    public WordCount get(int index){
        return array[index];
    }
    
    // sort the list in order of most frequent words first}
    public void rank(){
        boolean done=false;
        while(!done){
            done=true;
            for(int x=0;x<array.length-1;x++){
                if(array[x+1].getCount()>array[x].getCount()){
                    WordCount temp=array[x];
                    array[x]=array[x+1];
                    array[x+1]=temp;
                    done=false;
                }
            }
        }
    }
}
