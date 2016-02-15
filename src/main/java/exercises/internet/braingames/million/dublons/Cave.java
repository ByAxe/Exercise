package exercises.internet.braingames.million.dublons;

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
    private final List<Integer> primeNumbers;
    private final int TOP_BORDER = 1000;

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
}
