package exercises.java8.in.actions.task1;

public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
