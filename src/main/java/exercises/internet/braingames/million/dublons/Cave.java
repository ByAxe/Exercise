package exercises.internet.braingames.million.dublons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Два минимозга нашли пещеру с сокровищами, в которой лежит миллион дублонов.
 * Пещера заколдована: за раз из нее можно вынести количество дублонов, равное либо 1,
 * либо натуральной степени любого простого числа, иначе умрешь на месте.
 * Минимозги решили выносить монеты по очереди и заранее договорились,
 * что клад достанется тому, кто возьмет последний дублон. У кого из них есть выигрышная стратегия?
 */
public class Cave {
    /*TODO doesn't fill the list */
    private List<Integer> primeNumbers = new ArrayList<>();
    private final int TOP_BORDER = 1000;
    private final int DOUBLOONS = 1_000_000;

    public Cave() {
        primeNumbers = IntStream.rangeClosed(1, TOP_BORDER)
                .boxed().filter(this::isPrime)
                .collect(Collectors.toList());
    }

    private boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(1, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

    public List<Integer> findSolution() {
        int resultValue = 0;
        int base = 0;
        int pow = 0;

        for (Integer item : primeNumbers) {
            int k = 0;
            for (int j = 1; ; j++) {
                k = (int) Math.pow(item, j);
                int difference = (DOUBLOONS - k);

                if (difference > 0 && !isPrime(difference)) {
                    if (k > resultValue) {
                        base = item;
                        pow = j;
                        resultValue = k;
                    }
                } else break;
            }
        }
        return Arrays.asList(base, pow, resultValue);
    }
}
