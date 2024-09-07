/**
 * Write a description of class Count here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Count implements Comparable<Count>
{
    private String one,two;
    private int num;

    public Count(String one,String two,int num)
    {
        this.one=one;
        this.two=two;
        this.num = num;
    }
    
    public String getOne(){
        return one;
    }
    
    public String getTwo(){
        return two;
    }
    
    public int getNum(){
        return num;
    }
    
    public int compareTo(Count other){
        return other.num-num;
    }
}