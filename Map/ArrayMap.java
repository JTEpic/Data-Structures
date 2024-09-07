import java.util.*;
/**
 * Write a description of class jh here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArrayMap<K, V> implements Map<K, V>, Iterable<MapItem<K, V>>
{
    private ArrayList<MapItem<K, V>> array;
    public ArrayMap(){
        array=new ArrayList();
    }
    
    public Iterator<MapItem<K,V>> iterator(){
        return null;
    }
    
    public int size(){
        return array.size();
    }

    public boolean isEmpty(){
        return (size()==0);
    }

    /**
     * Returns true if an entry in this Map with key exists;
     * Returns false otherwise.
     * @throws IllegalArgumentException if key is null
     */
    public boolean containsKey(K key){
        if(key==null)
        throw new IllegalArgumentException("hmm");
        for(int x=0;x<size();x++){
            if(array.get(x).getKey().equals(key))
            return true;
        }
        return false;
    }

    /**
     * Returns true if an entry in this Map with value exists;
     * Returns false otherwise.
     */
    public boolean containsValue(V value){
        for(int x=0;x<size();x++){
            if(array.get(x).getValue().equals(value))
            return true;
        }
        return false;
    }

    /** 
     * If an entry in this map with a key exists then the value associated 
     * with that entry is returned; otherwise null is returned.
     * @throws IllegalArgumentException if key is null
     */
    public V get(K key){
        if(key==null)
        throw new IllegalArgumentException("AHHHH");
        for(int x=0;x<size();x++){
            if(array.get(x).getKey().equals(key))
            return array.get(x).getValue();
        }
        return null;
    }

    /** 
     * If an entry in this map with key already exists then the value 
     * associated with that entry is replaced by value and the original
     * value is returned; otherwise, adds the (key, value) pair to the map
     * and returns null. 
     * @throws IllegalArgumentException if key is null
     */
    public V put(K key, V value){
        if(key==null)
        throw new IllegalArgumentException("sus");
        for(int x=0;x<size();x++){
            if(array.get(x).getKey().equals(key)){
                V temp=array.get(x).getValue();
                array.set(x,new Item(key,value));
                return temp;
            }
        }
        array.add(new Item(key,value));
        return null;
    }

    /**
     * If an entry in this map with key exists then the entry is removed
     * from the map and the value associated with that entry is returned;
     * otherwise null is returned.
     * @throws IllegalArgumentException if key is null
     */
    public V remove(K key){
        if(key==null)
        throw new IllegalArgumentException("bruhhhhh");
        for(int x=0;x<size();x++){
            if(array.get(x).getKey().equals(key)){
                V temp=array.get(x).getValue();
                array.remove(x);
                return temp;
            }
        }
        return null;
    }

    /**
     * Removes all of the mappings from this map. The map will be empty 
     * after this call returns.
     */
    public void clear(){
        array=new ArrayList();
    }
}