/**
 * Write a description of class WordCount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordCount implements WordCountInterface
{
    private String word;
    private int count;
    /**
     * Constructor for objects of class WordCount
     */
    public WordCount(String word)
    {
        this.word=word;
        count = 1;
    }

    // return the word itself
    public String getWord(){
        return word;
    }

    // return the word count value
    public int getCount(){
        return count;
    }

    // increment the word counter for this object
    public void increment(){
        count++;
    }

    // returns a String in the form of "word count"
    public String toString(){
        String str=word+" "+count;
        return str;
    }

    // returns true if both words are identical
    public boolean equals(WordCount other){
        return (word.equals(other.getWord()));
    }
    
    // returns other.count minus this.count
    @Override // (this overrides the method in the Comparable interface)
    public int compareTo(WordCount other){
        return (other.getCount()-count);
    }
}
