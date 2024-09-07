/**
 * Write a description of interface PairInterface here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface PairInterface<T>
{
    abstract void setFirst(T x);
    abstract void setSecond(T x);
    abstract T getFirst();
    abstract T getSecond();
}
