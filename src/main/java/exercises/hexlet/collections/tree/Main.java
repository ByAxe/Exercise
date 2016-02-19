package exercises.hexlet.collections.tree;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final Random random = new Random();
        INode rootMutable = new NodeMutable(0);
        INode rootImmutable = new NodeImmutable(0, null, null);

        for (int i = 0; i < 1_000; i++) {
            rootMutable.add(random.nextInt() % 500);
            rootImmutable.add(random.nextInt() % 500);
        }
//        rootMutable.print();
        rootImmutable.print();
        System.out.println("Count: " + rootImmutable.count());
    }
}
