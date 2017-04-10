import java.util.Iterator;

public class LinkedList implements Iterable
{
    private Node head;
    private Node tail;

    LinkedList()
    {
        head = null;
        tail = null;
    }

    public Iterator iterator()
    {
        return new LinkedListIterator(this);
    }

    public void insertFirst(Object inObject)
    {
        Node newNode = new Node(inObject);

        if(isEmpty())
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            head.setPrev(newNode);
            newNode.setNext(head);
            head = newNode;
        }
    }

    public void insertLast(Object inObject)
    {
        Node newNode = new Node(inObject);

        if(isEmpty())
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
    }

    public boolean isEmpty()
    {
        return (head == null && tail == null);
    }

    public Object peekFirst()
    {
        Object firstObj = null;

        if(head != null)
        {
            firstObj = head.getValue();
        }
        return firstObj;
    }

    public Object peekLast()
    {
        Object lastObj = null;

        if(tail != null)
        {
            lastObj = tail.getValue();
        }
        return lastObj;
    }

    public Object removeFirst()
    {
        Object returnObj = null;

        if(isEmpty())
        {
            throw new NullPointerException("Linked list is empty");
        }
        else
        {
            returnObj = head.getValue();
            head = head.getNext();
            if(head == null)
            {
                tail = null;
            }
        }

        return returnObj;
    }

    public Object removeLast()
    {
        Object returnObj = null;

        if(isEmpty())
        {
            throw new NullPointerException("Linked list is empty");
        }
        else
        {
            returnObj = tail.getValue();
            tail = tail.getPrev();
            if(tail == null)
            {
                head = null;
            }
        }

        return returnObj;
    }

    private class Node
    {
        private Object value;
        private Node prev;
        private Node next;

        Node(Object inVal)
        {
            value = inVal;
            prev = null;
            next = null;
        }

        public Object getValue()
        {
            return value;
        }

        public void setValue(Object inVal)
        {
            value = inVal;
        }

        public Node getNext()
        {
            return next;
        }

        public void setNext(Node inNext)
        {
            next = inNext;
        }

        public Node getPrev()
        {
            return prev;
        }

        public void setPrev(Node inPrev)
        {
            prev = inPrev;
        }
    }

    private class LinkedListIterator implements Iterator
    {
        private Node iterNext;

        LinkedListIterator(LinkedList list)
        {
            iterNext = list.head;
        }

        public boolean hasNext()
        {
            return iterNext != null;
        }

        public Object next()
        {
            Object value;
            if(iterNext == null)
            {
                value = null;
            }
            else
            {
                value = iterNext.getValue();
                iterNext = iterNext.getNext();
            }
            return value;
        }

        public void remove()
        {
            throw new UnsupportedOperationException("Not supported");
        }

    }
}
