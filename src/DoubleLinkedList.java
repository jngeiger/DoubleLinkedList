import java.util.function.Function;

public class DoubleLinkedList<T> extends OurList<T> {

    class Node {
        T value;
        Node next;
        Node previous;
        Node(T element)
        { this.value = element; }
    }

    Node head;
    Node tail;

    public void insert(T ele) {
        if (head == null)
        {
            head = new Node(ele);
            tail = head;
        }
        else
        {
            Node temp = head;
            head = new Node(ele);
            head.next = temp;
            temp.previous = head;
        }
    }

    public void insert(T ele, int pos) {
        if (pos == 0 || head == null)
        {
            insert(ele);
        }
        else {
            int idx = 1;
            Node currentNode = head;
            while ((currentNode.next != null) && (idx < pos))
            {
                currentNode = currentNode.next;
                idx++;
            }
            if (currentNode.next == null)
            {
                tail.next = new Node(ele);
                tail.next.previous = tail;
                tail = tail.next;
            }
            else {
                Node temp = new Node(ele);
                temp.previous = currentNode;
                currentNode.next.previous = temp;
                temp.next = currentNode.next;
                currentNode.next = temp;
            }
        }
    }

    public boolean delete(Function<T, Boolean> func) {
        Node currentNode = head;
        while (currentNode != null)
        {
            if (func.apply(currentNode.value)) {
                if (currentNode == head) {
                    head = currentNode.next;
                    currentNode.next.previous = null;
                } else {
                    currentNode.previous.next = currentNode.next;
                    currentNode.next.previous = currentNode.previous;
                }
                return true;
            }
             currentNode = currentNode.next;
        }
        return false;
    }

    public String toString()
    {
        String retVal = "";
        Node currentNode = head;
        while (currentNode != null)
        {
            retVal += String.valueOf(currentNode.value);
            if (currentNode.next != null)
            retVal += ",";
            currentNode = currentNode.next;
        }
        return retVal;
    }
    public String toStringReverse()
    {
        String retVal = "";
        Node currentNode = tail;
        while (currentNode != null)
        {
            retVal += String.valueOf(currentNode.value);
            if (currentNode.previous != null)
                retVal += ",";
            currentNode = currentNode.previous;
        }
        return retVal;
    }

    public static void main(String[] args)
    { }
}
