/**
 * Write a description of class ne here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LinkedMap<K, V> implements Map<K, V>{
    private MapNode<K, V> root;
    private int size;
    public LinkedMap(){
        root=null;
        size=0;
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
        throw new IllegalArgumentException("noo");
        DoublyLinkedNode temp=root;
        while(temp!=null){
            if(temp.getKey().equals(key))
            return true;
            temp=temp.getNext();
        }
        return false;
    }

    /**
     * Returns true if an entry in this Map with value exists;
     * Returns false otherwise.
     */
    public boolean containsValue(V value){
        DoublyLinkedNode temp=root;
        while(temp!=null){
            if(temp.getValue().equals(value))
            return true;
            temp=temp.getNext();
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
        throw new IllegalArgumentException("noo");
        DoublyLinkedNode temp=root;
        while(temp!=null){
            if(temp.getKey().equals(key))
            return (V)temp.getValue();
            temp=temp.getNext();
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
        throw new IllegalArgumentException("noo");
        if(root==null){
            root=new MapNode(key,value,null,null);
            size++;
            return null;
        }
        DoublyLinkedNode temp=root;
        boolean done=false;
        while(!done){
            if(temp.getKey().equals(key)){
            V val=(V)temp.getValue();
            
            if(temp.equals(root))
            root=new MapNode(key,value,null,temp.getNext());
            temp=new MapNode(key,value,temp.getPrevious(),temp.getNext());
            if(temp.getNext()!=null)
            temp.getNext().setPrevious(temp);
            if(temp.getPrevious()!=null)
            temp.getPrevious().setNext(temp);
            
            return val;
            }
            
            if(temp.getNext()==null)
            done=true;
            else
            temp=temp.getNext();
        }
        temp.setNext(new MapNode(key,value,temp,null));
        size++;
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
        throw new IllegalArgumentException("noo");
        DoublyLinkedNode temp=root;
        while(temp!=null){
            if(temp.getKey().equals(key)){
            V val=(V)temp.getValue();
            
            if(temp.equals(root))
            root=(MapNode)root.getNext();
            if(temp.getNext()!=null)
            temp.getNext().setPrevious(temp.getPrevious());
            if(temp.getPrevious()!=null)
            temp.getPrevious().setNext(temp.getNext());

            size--;
            return val;
            }
            temp=temp.getNext();
        }
        return null;
    }

    /**
     * Removes all of the mappings from this map. The map will be empty 
     * after this call returns.
     */
    public void clear(){
        size=0;
        root=null;
    }
}
