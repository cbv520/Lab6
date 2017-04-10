public class Test
{
    public static void main(String[] args)
    {
        testGraph("Activity3_A.graph");
        testGraph("Activity3_B.graph");
    }

    public static void testGraph(String file)
    {
        String startNode = "D";

        DSAGraph graph = new DSAGraph(file);
        System.out.println("================================");
        System.out.println("Testing graph: " + file);
        System.out.println("================================");
        graph.display();
        System.out.println("");
        System.out.println("Starting node: " + startNode);
        System.out.println("dfs: " + graph.depthFirstSearch(startNode));
        LinkedList list = graph.getVertices();
        for (Object o : list)
        {
            GraphNode n = (GraphNode)o;
            n.clearVisited();
        }

        System.out.println("bfs: " + graph.breadthFirstSearch(startNode));
        System.out.println("");
    }
}
