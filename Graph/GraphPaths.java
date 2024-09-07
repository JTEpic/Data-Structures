import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class GraphPaths
{
    public static boolean isPathDF(WeightedGraphInterface<String> graph, 
                                   String startVertex, String endVertex)
    // Returns true if a path exists on graph, from startVertex to endVertex; 
    // otherwise returns false. Uses depth-first search algorithm.
    {
        boolean found=false;
        Stack<String> s=new Stack();
        graph.clearMarks();
        s.push(startVertex);
        while(!s.isEmpty()&&!found){
            String ver=s.pop();
            if(ver.equals(endVertex))
            found=true;
            else if(!graph.isMarked(ver)){
                graph.markVertex(ver);
                QueueInterface<String> q=graph.getAdjacentVertices(ver);
                while(!q.empty()){
                    s.push(q.remove());
                }
            }
        }
        return found;
    }

    public static boolean isPathBF(WeightedGraphInterface<String> graph, 
                                   String startVertex, String endVertex    )
    // Returns true if a path exists on graph, from startVertex to endVertex; 
    // otherwise returns false. Uses breadth-first search algorithm.
    {
        boolean found=false;
        Queue<String> q=new LinkedList();
        graph.clearMarks();
        q.add(startVertex);
        while(!q.isEmpty()&&!found){
            String ver=q.remove();
            if(ver.equals(endVertex))
            found=true;
            else if(!graph.isMarked(ver)){
            graph.markVertex(ver);
            QueueInterface<String> q2=graph.getAdjacentVertices(ver);
            while(!q2.empty()){
                q.add(q2.remove());
            }
            }
        }
        return found;
    }

    public static QueueInterface<Flight> shortestPaths(WeightedGraphInterface<String> graph, 
                                                       String startVertex)
    // Determines the shortest distance from startVertex to every other reachable vertex in graph.
    {
        QueueInterface<Flight> result=new Que();
        QueueInterface<String> ver;
        Queue<Flight> priority=new PriorityQueue();
        graph.clearMarks();
        Flight f=new Flight(startVertex,startVertex,0);
        priority.add(f);
        while(!priority.isEmpty()){
            Flight f2=priority.remove();
            String toVertex=f2.getToVertex();
            if(!graph.isMarked(toVertex)){
                graph.markVertex(toVertex);
                result.add(f2);
                f2.setFromVertex(toVertex);
                int min=f2.getDistance();
                System.out.println(min);
                ver=graph.getAdjacentVertices(f2.getFromVertex());
                while(!ver.empty()){
                    String vertex=ver.remove();
                    if(!graph.isMarked(vertex)){
                        int d=min+graph.weightIs(f2.getFromVertex(),vertex);
                        System.out.println(d);
                        f=new Flight(f2.getFromVertex(),vertex,d);
                        priority.add(f);
                    }
                }
            }
        }
        return result;
    }
}