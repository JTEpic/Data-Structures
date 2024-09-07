import kareltherobot.*;
import java.awt.Color;

public class SmartBot extends Robot
{
    // pass parameters to parent constructor
    public SmartBot(int street, int avenue, Direction direction, int beepers, Color color)
    {
        super(street, avenue, direction, beepers, color);
    }
    
    // Robots already know how to . . .
    //  turnLeft()
    //  move()
    //  putBeeper()
    //  pickBeeper()
    //  turnOff()
    
    // Robots also can determine if . . .
    //  frontIsClear()
    //  nextToABeeper()

    // turn around to face opposite direction
    public void turnAround()
    {
        turnLeft();
        turnLeft();
    }
    
    // two wrongs don't make a right, but three lefts do!
    public void turnRight()
    {
        turnAround();
        turnLeft();
    }
    
    // prevents from moving through a wall
    public void move()
    {
        if(frontIsClear())
            super.move();
    }
    
    // determines if a wall is to the left
    public boolean wallToLeft()
    {
        turnLeft();
        boolean flag = !frontIsClear(); 
        turnRight();
        return flag;
    }

    // picks up all beepers on corner
    public void pickAll()
    {
        if(nextToABeeper()){
            pickBeeper();
            pickAll();
        }
    }

    // moves forward multiple times
    public void move(int numSteps)  // rewrite this method recursively
    {
        if(numSteps>0){
            move();
            move(numSteps-1);
        }
    }

    // moves forward until finds beeper, then returns home
    public void findBeeper()        // rewrite this method recursively
    {
        int step=0;
        if(nextToABeeper()){
            pickBeeper();
            turnAround();
        } else{
            move();
            findBeeper();
            move();
        }
    }
    
    // counts number of beepers in a pile, and puts them back
    public int countPile()          // rewrite this method recursively
    {
        int count = 0;
        if(nextToABeeper())
        {
            pickBeeper();
            count++;
            countPile();
            putBeeper();
        }
        return count;
    }
}
