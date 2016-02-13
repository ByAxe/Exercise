package exercises.olimp.olimp4;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CounterTest {

    private List<Child> children;

    private final int NUMBER_OF_STEPS = 4;
    private final int NUMBER_OF_CHILDREN = 6;

    @Before
    public void data() {
        children = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_CHILDREN; i++) children.add(new Child(i));
    }

    @Test
    public void testSolution() {
        int realWinner = 5;

        assertEquals(realWinner, new Counter().solution(children, NUMBER_OF_STEPS));
    }

}
