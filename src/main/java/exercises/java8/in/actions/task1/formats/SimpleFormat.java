package exercises.java8.in.actions.task1.formats;

import exercises.java8.in.actions.task1.Apple;

public class SimpleFormat implements IFormat {

    public String view(Apple apple) {
        return "An apple of" + apple.getWeight() + "g";
    }
}
