import kareltherobot.*;
/**
 * Counts the number of beepers in a column and puts the same
 * number of beepers at the base of the column
 * 
 * @author 
 * @version 
 */
public class ColumnPicker extends Robot
{
    public ColumnPicker(int street, int avenue, Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }
    
    public void countColumns()
    {
        turnLeft();
        turnLeft();
        turnLeft();
        move();
        turnLeft();
        next();
        turnOff();
    }
    public void next(){
        if(!nextToABeeper()){
            countAndPlacePile();
            turnLeft();
            move();
            turnLeft();
            next();
        }
    }
    private void countAndPlacePile()
    {
        int total = countColumn(8);
        putNBeepers(total);
    }
    public void putNBeepers(int numToPut){
        if(numToPut!=0){
            putBeeper();
            putNBeepers(numToPut-1);
        }
    }
    public int pickNBeepers(){
        if(!nextToABeeper()){
            return 0;
        }
        pickBeeper();
        int num=1+pickNBeepers();
        putBeeper();
        return num;
    }
    private int countColumn(int streets){
        if(streets==0){
            turnLeft();
            turnLeft();
            return pickNBeepers();
        }
        move();
        int num=countColumn(streets-1);
        move();
        return pickNBeepers()+num;
    }
}