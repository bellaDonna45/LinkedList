package linkedpackage;

import static org.junit.Assert.*;
import java.util.ListIterator;
import org.junit.Before;
import org.junit.Test;

public class BasicDoubleLinkedListStudentTest {
    private BasicDoubleLinkedList<String> list;

    @Before
    public void setUp() {
        list = new BasicDoubleLinkedList<>();
        list.addToFront("A");
        list.addToEnd("B");
    }

    @Test
    public void testAddToFront() {
        list.addToFront("C");
        assertEquals("C", list.getFirst());
    }

    @Test
    public void testAddToEnd() {
        list.addToEnd("D");
        assertEquals("D", list.getLast());
    }

    @Test
    public void testRetrieveFirstElement() {
        assertEquals("A", list.retrieveFirstElement());
        assertEquals("B", list.getFirst());
    }

    @Test
    public void testRetrieveLastElement() {
        assertEquals("B", list.retrieveLastElement());
        assertEquals("A", list.getLast());
    }

    @Test
    public void testIterator() {
        ListIterator<String> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("A", iterator.next());
        assertEquals("B", iterator.next());
    }
}
