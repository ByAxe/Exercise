package exercises.hexlet.collections.set;

import org.junit.Test;

import java.util.Set;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class HashSetTest {

    @Test
    public void main(final String... args) throws Exception {
        final Set<String> s = new HashSet<>();

        s.add("1");
        s.add("1");
        assertEquals("set size does not return 1 after adding same element twice", 1, s.size());
        assertTrue("set contains do not return true for the element that was added twice", s.contains("1"));

        s.remove("1");
        assertEquals("set size does not return 0 when all elements are removed from the set", 0, s.size());
        assertTrue("set isEmpty do not return true when the set size is 0", s.isEmpty());

        s.add("2");
        s.add("3");
        assertEquals("set size is not returning the correct size", 2, s.size());
        assertTrue("set contains is not working correctly", s.contains("2"));
        assertTrue("set contains is not working correctly", s.contains("3"));

        final Set<String> s2 = new HashSet<>();
        s2.add("1");

        s.addAll(s2);
        assertEquals("addAll is not working correctly", 3, s.size());
        assertTrue("addAll is not working correctly", s.contains("1"));
    }

}
