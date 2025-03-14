package linkedpackage;

import java.util.*;


public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
    private Comparator<T> comparator;

    public SortedDoubleLinkedList(Comparator<T> comparator) {
        
        this.comparator = comparator;
    }

    public void add(T data) {
        Node newNode = new Node(data);
        if (size == 0) {
            head = tail = newNode;
        }
        else {
            Node current = head;
            while (current != null && comparator.compare(current.data, data) < 0) {
                current = current.next;
            }
         
            if (current == head) {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
          
            } else if (current == null) {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
           
            
            } else {
                newNode.next = current;
                newNode.prev = current.prev;
                current.prev.next = newNode;
                current.prev = newNode;
            }
        }
        size++;
    }

    public void addToFront(T data) { 
    	throw new UnsupportedOperationException("Invalid operation for sorted list"); 
    	}
    public void addToEnd(T data) {
    	throw new UnsupportedOperationException("Invalid operation for sorted list");
    	}
}

