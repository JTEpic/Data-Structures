/**
 * Write a description of interface SquareMatrixInterface here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface SquareMatrixInterface
{
    public int getSize();
    public void setValue(int row,int column,int value);
    public int getValue(int row,int column);
    public void fillValue(int value);
    public void makeZero();
    public String toString();
    public SquareMatrix add(SquareMatrix s);
    public SquareMatrix subtract(SquareMatrix s);
    public SquareMatrix copy();
}