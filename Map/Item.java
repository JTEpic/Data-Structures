/**
 * Write a description of class jh here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item<K, V> implements MapItem<K, V>
{
    private K k;
    private V v;
    public Item(K k, V v)
    {
        this.k=k;
        this.v=v;
    }
    
    public K getKey(){
        return k;
    }

    public V getValue(){
        return v;
    }

    public String toString(){
        return null;
    }
}
