public class GraphEdge
{
    private String label;
    private int value;
    private boolean visited;

    GraphEdge(String inLabel, int inVal)
    {
        label   = inLabel;
        value   = inVal;
        visited = false;
    }

    public String getLabel()
    {
        return label;
    }

    public int getValue()
    {
        return value;
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
}
