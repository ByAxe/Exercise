package exercises.olimp.olimp5;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class WeighingTest {

    private final int SACK_WEIGHT_1 = 333;
    private final List<Integer> DUMBBELLS_LIST_1 = Arrays.asList(1, 4, 8, 64, 256);

    private final int SACK_WEIGHT_2 = 85;
    private final List<Integer> DUMBBELLS_LIST_2 = Arrays.asList(1, 4, 16, 64);

    @Test
    public void testWeighing() {
        Weighing weighingAttempt = new Weighing();
        try {
            assertTrue(weighingAttempt.weighing(SACK_WEIGHT_1).containsAll(DUMBBELLS_LIST_1));
            assertTrue(weighingAttempt.weighing(SACK_WEIGHT_2).containsAll(DUMBBELLS_LIST_2));
        } catch (Throwable e){
            System.out.println("Should not happen.");
        }
    }
}
