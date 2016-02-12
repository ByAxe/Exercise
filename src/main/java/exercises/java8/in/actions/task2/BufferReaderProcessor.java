package exercises.java8.in.actions.task2;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferReaderProcessor {
    String process(BufferedReader b) throws IOException;
}
