import java.util.*;

public class DSAGraph
{
    private LinkedList vertices;
    private LinkedList edges;

    DSAGraph()
    {
        vertices = new LinkedList();
        edges = new LinkedList();
    }

    DSAGraph(String file)
    {
        vertices = new LinkedList();
        edges = new LinkedList();

        FileIO.readFile(file, this);
    }

    public void addVertex(GraphNode node)
    {
        if(findVertex(node.getLabel()) != null)
        {
            throw new IllegalArgumentException("node \"" + node.getLabel() + "\" already exists in graph");
        }
        vertices.insertLast(node);
    }

    public void addAdjacency(GraphNode node1, GraphNode node2, int weight)
    {
        GraphNode n1 = findVertex(node1.getLabel());
        GraphNode n2 = findVertex(node2.getLabel());

        if(n1 == null)
        {
            vertices.insertLast(node1);
            n1 = node1;
        }
        if(n2 == null)
        {
            vertices.insertLast(node2);
            n2 = node2;
        }

        //undirected graph
        n1.addLink(n2);
        n2.addLink(n1);

        String edgeLabel = n1.getLabel() + "-" + n2.getLabel();
        edges.insertLast(new GraphEdge(edgeLabel, weight));
    }

    public void display()
    {
        System.out.println("Vertices: " + getVertexCount());
        for (Object o1 : vertices)
        {
            GraphNode n1 = (GraphNode)o1;
            System.out.print(n1.getLabel() + ":" + n1.getDegree() + ": ");
            for (Object o2 : n1.getList())
            {
                GraphNode n2 = (GraphNode)o2;
                System.out.print(n2.getLabel() + " ");
            }
            System.out.println("");
        }
        System.out.println("\nEdges: " + getEdgeCount());
        for (Object o : edges)
        {
            GraphEdge e = (GraphEdge)o;
            System.out.println(e.getLabel() + ": " + e.getValue());
        }
    }

    public int getEdgeCount()
    {
       int count = 0;

       for (Object o : edges)
       {
            count++;
       }

       return count;
    }

    public int getVertexCount()
    {
       int count = 0;

       for (Object o : vertices)
       {
            count++;
       }

       return count;
    }

    public String depthFirstSearch(String startNode)
    {
        String graph = "{";
        Stack stack  = new Stack();
        GraphNode nextVertex  = null;
        GraphNode currentNode = null;

        clearVerticesVisited();
        currentNode = findVertex(startNode);
        if(currentNode == null)
        {
            throw new IllegalArgumentException("node \"" + startNode + "\" not found");
        }

        currentNode.setVisited();
        stack.push(currentNode);

        while(!stack.isEmpty())
        {
            nextVertex = currentNode.newVertex();
            if(nextVertex != null)
            {
                graph += "(" + currentNode.getLabel() + nextVertex.getLabel() + ")";
                nextVertex.setVisited();
                stack.push(nextVertex);
                currentNode = nextVertex;
            }
            else
            {
                currentNode = (GraphNode)stack.pop();
            }
        }

        graph += "}";

        return graph;
    }

    public String breadthFirstSearch(String startNode)
    {
        String graph = "{";
        Queue queue = new Queue();
        GraphNode currentNode = null;

        clearVerticesVisited();
        currentNode = findVertex(startNode);
        if(currentNode == null)
        {
            throw new IllegalArgumentException("node \"" + startNode + "\" not found");
        }

        currentNode.setVisited();
        queue.enqueue(currentNode);

        while(!queue.isEmpty())
        {
            currentNode = (GraphNode)queue.dequeue();
            for (Object o : currentNode.getList())
            {
                GraphNode n = (GraphNode)o;
                if(!n.getVisited())
                {
                    graph += "(" + currentNode.getLabel() + n.getLabel() + ")";
                    n.setVisited();
                    queue.enqueue(n);
                }
            }
        }

        graph += "}";

        return graph;
    }

    private void clearVerticesVisited()
    {
        for (Object o : vertices)
        {
            GraphNode n = (GraphNode)o;
            n.clearVisited();
        }
    }

    private void clearEdgesVisited()
    {
        for (Object o : edges)
        {
            GraphEdge e = (GraphEdge)o;
            e.clearVisited();
        }
    }

    private GraphNode findVertex(String label)
    {
        GraphNode node = null;

        for(Object o : vertices)
        {
            GraphNode n = (GraphNode)o;
            if(n.getLabel().equals(label))
            {
               node = n;
            }
        }

        return node;
    }
}
