import java.util.*;

public class GraphNode
{
    private String label;
    private Object value;
    private LinkedList adjList;
    private boolean visited;

    GraphNode(String inLabel, Object inVal)
    {
        label   = inLabel;
        value   = inVal;
        adjList = new LinkedList();
        visited = false;
    }

    public String getLabel()
    {
        return label;
    }

    public Object getValue()
    {
        return value;
    }

    public LinkedList getList()
    {
        return adjList;
    }

    public void addLink(GraphNode inNode)
    {
        adjList.insertLast(inNode);
    }

    public void setVisited()
    {
        visited = true;
    }

    public void clearVisited()
    {
        visited = false;
    }

    public boolean getVisited()
    {
        return visited;
    }

    public GraphNode newVertex()
    {
        GraphNode vertex = null;
        Iterator list = adjList.iterator();
        while(list.hasNext() && vertex == null)
        {
            GraphNode currentVertex = (GraphNode)list.next();
            if(!currentVertex.getVisited())
            {
                vertex = currentVertex;
            }
        }

        return vertex;
    }

    public int getDegree()
    {
        int count = 0;
        for (Object o : adjList)
        {
            count++;
        }

        return count;
    }
}
