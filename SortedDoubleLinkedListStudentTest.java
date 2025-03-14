package linkedpackage;

import static org.junit.Assert.*;
import java.util.Comparator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.Comparator;
import org.junit.Before;
import org.junit.Test;

public class SortedDoubleLinkedListStudentTest {
    private SortedDoubleLinkedList<String> sortedList;

    @Before
    public void setUp() {
        sortedList = new SortedDoubleLinkedList<>(new StringComparator());
        sortedList.add("B");
        sortedList.add("A");
        sortedList.add("C");
    }

    @Test
    public void testAdd() {
        assertEquals("A", sortedList.getFirst());
        assertEquals("C", sortedList.getLast());
    }

    @Test
    public void testAddToFrontNotAllowed() {
        try {
            sortedList.addToFront("D");
            fail("Expected UnsupportedOperationException was not thrown");
        } catch (UnsupportedOperationException e) {
            assertEquals("Invalid operation for sorted list", e.getMessage());
        }
    }

    @Test
    public void testAddToEndNotAllowed() {
        try {
            sortedList.addToEnd("D");
            fail("Expected UnsupportedOperationException was not thrown");
        } catch (UnsupportedOperationException e) {
            assertEquals("Invalid operation for sorted list", e.getMessage());
        }
    }

    private static class StringComparator implements Comparator<String> {
        public int compare(String s1, String s2) {
            return s1.compareTo(s2);
        }
    }
}


