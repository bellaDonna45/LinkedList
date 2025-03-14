package linkedpackage;


import java.util.*;


public class BasicDoubleLinkedList<T> implements Iterable<T> {
    protected Node head, tail;
    protected int size;

    protected class Node {
        T data;
        Node next, prev;

        Node(T data) {
            this.data = data;
        }
    }

    public BasicDoubleLinkedList() {
        head = tail = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }
    public void addToFront(T data) {
        Node newNode = new Node(data);
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addToEnd(T data) {
        Node newNode = new Node(data);
        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public T getFirst() {
        if (size == 0) return null;
        return head.data;
    }

    public T getLast() {
        if (size == 0) return null;
        return tail.data;
    }

    public T retrieveFirstElement() {
        if (size == 0) return null;
        T data = head.data;
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
        size--;
        return data;
    }

    public T retrieveLastElement() {
        if (size == 0) return null;
        T data = tail.data;
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null;
        size--;
        return data;
    }

    public ArrayList<T> toArrayList() {
        ArrayList<T> list = new ArrayList<>();
        Node current = head;
        while (current != null) {
            list.add(current.data);
            current = current.next;
        }
        return list;
    }

    public ListIterator<T> iterator() {
        return new DoubleLinkedListIterator();
    }
    public void remove(T targetData, Comparator<T> comparator) {
        Node current = head;
        
        while (current != null) {
            if (comparator.compare(current.data, targetData) == 0) {
                if (current == head) {
                    retrieveFirstElement(); // to remove first element
                } else if (current == tail) {
                    retrieveLastElement(); // removes last element
                } else {
                	
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    size--;
                }
                return;
            }
            current = current.next;
        }
    }


    private class DoubleLinkedListIterator implements ListIterator<T> {
        private Node current = head;
        
        public boolean hasNext() { return current != null; }
        public boolean hasPrevious() { return current != head; }
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T data = current.data;
            current = current.next;
            return data;
        }
        public T previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            current = (current == null) ? tail : current.prev;
            return current.data;
        }
        public void remove() { throw new UnsupportedOperationException(); }
        public void set(T e) { throw new UnsupportedOperationException(); }
        public void add(T e) { throw new UnsupportedOperationException(); }
        public int nextIndex() { throw new UnsupportedOperationException(); }
        public int previousIndex() { throw new UnsupportedOperationException(); }
    }
}


