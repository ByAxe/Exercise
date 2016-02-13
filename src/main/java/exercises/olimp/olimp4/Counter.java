package exercises.olimp.olimp4;

import java.util.List;

public class Counter {

    public int solution(List<Child> children, final int numberOfSteps) {
        int nextChild = 0;

        while (children.size() != 1) {
            int child = nextChild;
            for (int pointerOnChild = 0; ; ++pointerOnChild) {
                if (child == children.size() - 1) child = 0;
                if (pointerOnChild == numberOfSteps){
                    children.remove(child);
                    nextChild = child;
                    break;
                }
                ++child;
            }
        }

        return children.get(0).getId();
    }

}
