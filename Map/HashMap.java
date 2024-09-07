
/**
 * Write a description of class hash here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HashMap<K, V> implements Map<K, V>, Hashable<K, V>
{
    private Map<K,V> table[];
    private int size;

    public HashMap(int cap)
    {
        table=new LinkedMap[cap];
        size = 0;
        for(int x=0;x<table.length;x++){
            table[x]=new LinkedMap();
        }
    }
    
    /**
     * returns a hash index for a given key
     */
    public int hashIndex(K key){
        return (key.hashCode() & 0x7fffffff) % table.length;
    }
    
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    /**
     * Returns true if an entry in this Map with key exists;
     * Returns false otherwise.
     * @throws IllegalArgumentException if key is null
     */
    public boolean containsKey(K key){
        if(key==null)
        throw new IllegalArgumentException("hmm");
        Map<K, V> list = table[hashIndex(key)];
        return list.containsKey(key);
    }

    /**
     * Returns true if an entry in this Map with value exists;
     * Returns false otherwise.
     */
    public boolean containsValue(V value){
        for(Map<K, V> list:table){
            if(list.containsValue(value))
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
        throw new IllegalArgumentException("hmm");
        Map<K, V> list = table[hashIndex(key)];
        return list.get(key);
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
        throw new IllegalArgumentException("hmm");
        Map<K, V> list = table[hashIndex(key)];
        V temp=(V)list.put(key,value);
        if(temp==null)
        size++;
        return temp;
    }

    /**
     * If an entry in this map with key exists then the entry is removed
     * from the map and the value associated with that entry is returned;
     * otherwise null is returned.
     * @throws IllegalArgumentException if key is null
     */
    public V remove(K key){
        if(key==null)
        throw new IllegalArgumentException("hmm");
        Map<K, V> list = table[hashIndex(key)];
        V temp=(V)list.remove(key);
        if(temp!=null)
        size--;
        return temp;
    }

    /**
     * Removes all of the mappings from this map. The map will be empty 
     * after this call returns.
     */
    public void clear(){
        table=new LinkedMap[table.length];
        size=0;
        for(int x=0;x<table.length;x++){
            table[x]=new LinkedMap();
        }
    }
}
