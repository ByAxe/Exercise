package exercises.java8.in.actions.task1;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Write a prettyPrintApple method that takes a List of Apples
 * and that can be parametrized with multiple ways to generate
 * a String output from an apple
 */
public class Farm {

    public static List<Apple> map(List<Integer> list, BiFunction<Integer, String, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for (Integer e : list) {
            result.add(f.apply(e, "red"));
        }
        return result;
    }

    static Map<String, Function<Integer, Apple>> functionMap = new HashMap<>();

    static {
        functionMap.put("apple", Apple::new);
        functionMap.put("apple", Apple::new);
        functionMap.put("apple", Apple::new);
    }

    public static Apple fruit(String fruit, Integer weight) {
        return functionMap.get(fruit.toLowerCase()).apply(weight);
    }

    public static void main(String[] args) {

        List<Integer> weights = Arrays.asList(7, 3, 4, 10);

//        List<Apple> apples = map(weights, Apple::new);

        BiFunction<Integer, String, Apple> c3 = Apple::new;
        Apple apple = c3.apply(87, "red");

        TriFunction<Integer, Integer, Integer, Apple>  colorFactory = Apple::new;

        Function<Integer, Integer> f = x -> x+1;
        Function<Integer, Integer> g = x -> x+2;
        Function<Integer, Integer> h = f.andThen(g); /*g(f(x))*/
        Function<Integer, Integer> k = f.compose(g); /*f(g(x))*/

        int result = h.apply(10);
    }
}
