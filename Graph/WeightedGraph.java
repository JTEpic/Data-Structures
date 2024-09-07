import java.util.Queue;
import java.util.LinkedList;

/**
 * Write a description of class WeightedGraph here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WeightedGraph<T> implements WeightedGraphInterface<T>
{
    public static final int NULL_EDGE=0;
    private static final int DEFCAP=50;
    private int numVertices, maxVertices;
    private T[] vertices;
    private int[][] edges;
    private boolean[] marks;

    public WeightedGraph(int maxV)
    {
        numVertices=0;
        maxVertices=maxV;
        vertices=(T[])new Object[maxV];
        marks=new boolean[maxV];
        edges=new int[maxV][maxV];
    }
    public WeightedGraph(){
        this(DEFCAP);
    }
    
    // tests if graph is empty
    public boolean empty(){
        return numVertices==0;
    }
    
    // tests if graph is full
    public boolean full(){
        return numVertices==maxVertices;
    }
    
    // Precondition: Vertex is not already in graph
    // Precondition: Vertex is not null
    // adds vertex to graph
    public void addVertex(T vertex){
        vertices[numVertices]=vertex;
        for(int x=0;x<numVertices;x++){
            edges[numVertices][x]=NULL_EDGE;
            edges[x][numVertices]=NULL_EDGE;
        }
        numVertices++;
    }
        
    // returns true if graph contains vertex
    public boolean hasVertex(T vertex){
        for(int x=0;x<numVertices;x++){
            if(vertices[x].equals(vertex))
            return true;
        }
        return false;
    }
    
    // adds an edge with the specified weight from fromVertex to toVertex
    public void setEdge(T fromVertex, T toVertex,int weight){
        int row=-1,col=-1;
        for(int x=0;x<numVertices;x++){
            if(vertices[x].equals(fromVertex))
            row=x;
            if(vertices[x].equals(toVertex))
            col=x;
        }
        edges[row][col]=weight;
    }
    
    // if edge from fromVertex to toVertex exists, return the weight of
    // the edge; otherwise, returns a special "null-edge" value.
    public int weightIs(T fromVertex, T toVertex){
        int from=-1,to=-1;
        for(int x=0;x<numVertices;x++){
            if(vertices[x].equals(fromVertex))
            from=x;
            if(vertices[x].equals(toVertex))
            to=x;
        }
        return edges[from][to];
    }
    
    // returns a queue of the vertices that are adjacent to the vertex
    public QueueInterface<T> getAdjacentVertices(T vertex){
        int from=-1;
        for(int x=0;x<numVertices;x++){
            if(vertices[x].equals(vertex))
            from=x;
        }
        QueueInterface temp=new Que();
        for(int x=0;x<numVertices;x++){
            if(edges[from][x]!=NULL_EDGE)
            temp.add(vertices[x]);
        }
        return temp;
    }
    
    // sets marks for all vertices to false
    public void clearMarks(){
        for(int x=0;x<marks.length;x++){
            marks[x]=false;
        }
    }
    
    // sets mark for vertex to true
    public void markVertex(T vertex){
        for(int x=0;x<numVertices;x++){
            if(vertices[x].equals(vertex))
            marks[x]=true;
        }
    }
    
    // returns true if vertex is marked
    public boolean isMarked(T vertex){
        for(int x=0;x<numVertices;x++){
            if(vertices[x].equals(vertex))
            return marks[x];
        }
        return false;
    }
    
    // returns an unmarked vertex if any exist, otherwise returns null
    public T getUnmarked(){
        for(int x=0;x<numVertices;x++){
            if(vertices[x]!=null&&marks[x]==false)
            return vertices[x];
        }
        return null;
    }
    
    // return a String representation of this graph
    public String toString(){
    String result = "\nGraph representation:\n\t";
    for(int i = 0; i < vertices.length; i++)
    if(vertices[i] != null)
    result += ((String)vertices[i]).substring(0, 3) + "\t";
    result += "\n";
    
    for(int r = 0; r < vertices.length; r++)
    if(vertices[r] != null){
    result += ((String)vertices[r]).substring(0, 3) + "\t";
    for(int c = 0; c < vertices.length; c++)
    if(vertices[c] != null)
    result += edges[r][c] + "\t";
    result += "\n";
    }
    return result;
    }
}
