public class Queue
{
    private LinkedList list;

    Queue()
    {
        list = new LinkedList();
    }

    public void enqueue(Object inObject)
    {
        list.insertLast(inObject);
    }

    public Object dequeue()
    {
        return list.removeFirst();
    }

    public Object front()
    {
        return list.peekFirst();
    }

    public boolean isEmpty()
    {
        return list.isEmpty();
    }
}
