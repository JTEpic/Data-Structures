import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class BinarySearchArray here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BinarySearchTree<T extends Comparable<T>> implements WordCountCollection<T>
{
    private BinaryNode<T> root;
    private int size;
    /**
     * Constructor for objects of class BinarySearchArray
     */
    public BinarySearchTree()
    {
        root=null;
        size=0;
    }
    
    public int size(){
        return size;
    }
    
    // Returns true if this collection is empty; otherwise, returns false.
    public boolean isEmpty(){
        return (root==null);
    }
    
    // Adds element to this BST. The tree retains its BST property.
    public void add (T element)
    {
        root=add(element,root);
        size++;
    }
    public BinaryNode add (T element,BinaryNode<T> tree)
    {
        if(tree==null)
        tree=new BinaryNode(element);
        else if(element.compareTo(tree.getInfo())<=0)
        tree.setLeft(add(element,tree.getLeft()));
        else
        tree.setRight(add(element,tree.getRight()));
        return tree;
    }
    
    // Returns the element of this colletion if contains an element e such that
    // e.compareTo(element) == 0; otherwise, returns null.
    public T fetch(T element){
        return contains(element,root);
    }
    
    public T contains(T element,BinaryNode<T> tree)
    {
        if(tree==null)
        return null;
        else if(element.compareTo(tree.getInfo())<0)
        return contains(element,tree.getLeft());
        else if(element.compareTo(tree.getInfo())>0)
        return contains(element,tree.getRight());
        else
        return tree.getInfo();
    }
    // Removes all elements in this collection
    public void clear(){
        root=null;
        size=0;
    }
    // Returns a list of elements from an inorder traversal
    public List<T> inorderTraverse()
    {
       List<T> list = new ArrayList<T>();
       inorderTraverse(root, list);
       return list;
    }
    private void inorderTraverse(BinaryNode<T> tree, List<T> list){
     if(tree!=null){
        inorderTraverse(tree.getLeft(),list);
        list.add(tree.getInfo());
        inorderTraverse(tree.getRight(),list);
     }
    }
    // generates a list of the elements in the collection
    // Postcondion: list is independant (deep copy) of original collection
    public List<T> createList(){
        List<T> temp=new ArrayList<T>();
        return inorderTraverse();
    }
}
