/**
 * Write a description of class mapnode here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MapNode<K, V> extends Item<K, V> implements DoublyLinkedNode<K, V>{
    private DoublyLinkedNode<K, V> l,r;
    public MapNode(K key, V value, DoublyLinkedNode<K, V> previous, DoublyLinkedNode<K, V> next){
        super(key,value);
        l=previous;
        r=next;
    }
    
    /**
     * Returns the previous (upstream) node.
     */
    public DoublyLinkedNode<K, V> getPrevious(){
        return l;
    }

    /**
     * Sets the previous node.
     */
    public void setPrevious(DoublyLinkedNode<K, V> node){
        l=node;
    }

    /**
     * Returns the next (downstream) node.
     */
    public DoublyLinkedNode<K, V> getNext(){
        return r;
    }

    /**
     * Sets the next (downstream) node.
     */
    public void setNext(DoublyLinkedNode<K, V> node){
        r=node;
    }
}
