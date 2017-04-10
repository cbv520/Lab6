import java.util.*;

public class Stack
{
    private LinkedList list;

    Stack()
    {
        list = new LinkedList();
    }

    public Object pop()
    {
        return list.removeFirst();
    }

    public void push(Object inObject)
    {
        list.insertFirst(inObject);
    }

    public Object top()
    {
        return list.peekFirst();
    }

    public boolean isEmpty()
    {
        return list.isEmpty();
    }
}
