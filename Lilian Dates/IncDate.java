/**
 * Write a description of class IncDate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class IncDate extends Date
{
    public IncDate(int newMonth, int newDay, int newYear){
        super(newMonth,newDay,newYear);
    }
    public void increment(){
        Date x=this.inverseLilian(this.lilian()+1);
        day=x.getDay();
        month=x.getMonth();
        year=x.getYear();
    }
    public void increment(int newDays){
        Date x=this.inverseLilian(this.lilian()+newDays);
        day=x.getDay();
        month=x.getMonth();
        year=x.getYear();
    }
}
