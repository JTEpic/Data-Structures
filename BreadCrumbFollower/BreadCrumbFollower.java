import kareltherobot.*;

public class BreadCrumbFollower extends Robot
{
    public BreadCrumbFollower(int s, int a, Direction d, int b)
    {
        super(s,a,d,b);
    }

    // complete the following method (plus others as needed)
    public void travel()
    {
        while(nextToABeeper()){
            if(frontIsClear())
            move();
            else{
                break;
            }
        }
        check();
    }
    public void back(){
        turnLeft();
        turnLeft();
        move();
    }
    public void check(){
        if(!frontIsClear()&&nextToABeeper()){
            turnLeft();
            turnLeft();
        }else
        back();
        turnLeft();
        if(frontIsClear()){
            move();
            if(nextToABeeper())
            travel();
            else{
                back();
                if(frontIsClear()){
                move();
                if(nextToABeeper())
                travel();
                }
            }
        } else{
            turnLeft();
            turnLeft();
            if(frontIsClear()){
            move();
            if(nextToABeeper())
            travel();
            }
        }
    }
}