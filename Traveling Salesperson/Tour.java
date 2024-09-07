import java.util.*;
import java.awt.Graphics;

/**
 * This class is a specialized Linked List of Points that represents a
 * Tour of locations attempting to solve the Traveling Salesperson Problem
 * 
 * @JTEpic & APCode
 * @3000
 */

public class Tour implements TourInterface
{
    // instance variables
    private ListNode first;
    private int size;
    // constructor
    public Tour()
    {
        first=null;
        size=0;
    }
        
    //return the number of points (nodes) in the list   
    public int size()
    {
        return size;
    }

    // append Point p to the end of the list
    public void add(Point p)
    {
        if(first==null)
        first=new ListNode(p);
        //adds p to first pos if open
        else{
        ListNode temp=first;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=new ListNode(p);
        //if first not open then goes down list until open pos then adds
        }
        size++;
    } 
    
    // print every node in the list 
    public void print()
    {
        ListNode temp=first;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
    
    // draw the tour using the given graphics context
    public void draw(Graphics g)
    {
        ListNode temp=first;
        while(temp!=null){
            g.fillOval((int)temp.data.getX()-2,(int)temp.data.getY()-2, 5, 5);
            temp=temp.next;
        }
        //puts oval/dot at temp.data point pos using x and y values in every data value of list
        temp=first;
        while(temp.next!=null){
            g.drawLine((int)temp.data.getX(),(int)temp.data.getY(),(int)temp.next.data.getX(),(int)temp.next.data.getY());
            temp=temp.next;
        }
        //adds lines between each similar to adding dots
        g.drawLine((int)first.data.getX(),(int)first.data.getY(),(int)temp.data.getX(),(int)temp.data.getY());
        //connects first and last data point using old temp ListNode
    }
    
    //calculate the distance of the Tour, but summing up the distance between adjacent points
    //NOTE p.distance(p2) gives the distance where p and p2 are of type Point
    public double distance()
    {
        double d=0.0;
        ListNode temp=first;
        while(temp.next!=null){
            d+=temp.data.distance(temp.next.data);
            //adds distance through each data value and its next connection
            temp=temp.next;
        }
        d+=first.data.distance(temp.data);
        //adds first and last data to d to complete
        return d;
    }

    // add Point p to the list according to the NearestNeighbor heuristic
    public void insertNearest(Point p)
    {   
        if(first==null)
        first=new ListNode(p);
        //to ensure no errors first is filled
        else{
        ListNode small=first,temp=first;
        while(temp!=null){
            if(temp.data.distance(p)<small.data.distance(p))
            small=temp;
            //finds smallest distance and sets to small
            temp=temp.next;
        }
        temp=new ListNode(p);
        temp.next=small.next;
        small.next=temp;
        //adds p to list based on small ListNode
        }
        size++;
    }
        
    // add Point p to the list according to the InsertSmallest heuristic
    public void insertSmallest(Point p)
    { 
        if(first==null||first.next==null||first.next.next==null)
        add(p);
        //adds p to start of list for no errors
        else{
        ListNode temp=first,loc=first;
        double small=(first.data.distance(p)+p.distance(first.next.data))-(first.data.distance(first.next.data)),d;
        //finds smallest changes of distance from old 2 points to newly 3 plotted point
        while(temp.next!=null){
            d=(temp.data.distance(p)+p.distance(temp.next.data))-(temp.data.distance(temp.next.data));
            if(d<small){
                small=d;
                loc=temp;
                //if distance is smaller, small is set to number and location is saved
            }
            temp=temp.next;
        }
        if(((temp.data.distance(p)+p.distance(first.data))-(temp.data.distance(first.data)))<small)
        loc=temp;
        //check first and last ListNode as well
        temp=loc.next;
        loc.next=new ListNode(p);
        loc.next.next=temp;
        //adds final location to list
        size++;
        }
    }
    // This is a private inner class, which is a separate class within a class.
    private class ListNode
    {
        private Point data;
        private ListNode next;
        public ListNode(Point p, ListNode n)
        {
            this.data = p;
            this.next = n;
        }
        
        public ListNode(Point p)
        {
            this(p, null);
        }        
    }
}
