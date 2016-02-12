package exercises.hexlet.collections;

//import org.openjdk.jmh.annotations.Benchmark;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectionTest {

//    @Benchmark
    public void testArrayListAddMethod() {
        final List<Integer> intList = new ArrayList();

        for (int i = 0; ++i < 1_000_000; )
            intList.add(i);
    }

//    @Benchmark
    public void testLinkedListAddMethod() {
        final List<Integer> intList = new LinkedList<>();

        for (int i = 0; ++i < 1_000_000; )
            intList.add(i);
    }

}
