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

            line = br.readLine();
            lineSplit = line.split(" ");
            while(line != null)
            {
                lineSplit = line.split(" ");

                GraphNode node1 = new GraphNode(lineSplit[0], lineSplit[0]);
                GraphNode node2 = new GraphNode(lineSplit[1], lineSplit[1]);

                if(lineSplit.length == 2)
                {
                    graph.addVertex(node1, node2 , 1);
                }
                else if(lineSplit.length == 3)
                {
                    graph.addVertex(node1, node2 , Integer.parseInt(lineSplit[2]));
                }
                else
                {
                    throw new IllegalArgumentException("file format error");
                }
                line = br.readLine();
            }
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
