import java.io.*;

public class FileIO
{
    public static void readFile(String file, DSAGraph graph)
    {
        try
        {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader rdr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(rdr);
            String line = null;
            String[] lineSplit = null;
            GraphNode node1 = null;
            GraphNode node2 = null;

            line = br.readLine();
            lineSplit = line.split(" ");
            while(line != null)
            {
                lineSplit = line.split(" ");

                if(lineSplit.length == 1)
                {
                    node1 = new GraphNode(lineSplit[0], lineSplit[0]);
                    graph.addVertex(node1);
                }
                else if(lineSplit.length == 2)
                {
                    node1 = new GraphNode(lineSplit[0], lineSplit[0]);
                    node2 = new GraphNode(lineSplit[1], lineSplit[1]);
                    graph.addAdjacency(node1, node2 , 100);
                }
                else if(lineSplit.length == 3)
                {
                    node1 = new GraphNode(lineSplit[0], lineSplit[0]);
                    node2 = new GraphNode(lineSplit[1], lineSplit[1]);
                    graph.addAdjacency(node1, node2 , Integer.parseInt(lineSplit[2]));
                }
                else
                {
                    throw new IllegalArgumentException("file format error");
                }
                line = br.readLine();
            }

            fis.close();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
