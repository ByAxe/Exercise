package exercises.java8.in.actions.task1.formats;

import exercises.java8.in.actions.task1.Apple;

public class FullFormat implements IFormat {

    public String view(Apple apple) {
        return "A" +
                (apple.getWeight() > 150 ? "heavy" : "light") +
                "" + apple.getColor() + "apple";
    }

}
