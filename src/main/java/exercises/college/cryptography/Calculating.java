package exercises.college.cryptography;

import static java.lang.Math.*;

public class Calculating {

    private final int A_VALUE = 2;
    private final int B_VALUE = 6;
    private final int C_VALUE = 2;

    public int calc(final int raw) {
        int result = 0;
        if (raw == 0) return 2;
        else result = (int) (A_VALUE * pow(raw, 2) + B_VALUE * raw + C_VALUE);

        if (result > 35) return cutValue(result);
        return result;
    }

    private int cutValue(int value) {
        do {
            value -= 35;
        } while (value > 35);
        return value;
    }
}
