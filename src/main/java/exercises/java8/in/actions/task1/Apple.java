package exercises.java8.in.actions.task1;

public class Apple {

    private int weight;
    private String color;

    public Apple() {
    }

    public Apple(int weight) {
        this.weight = weight;
    }

    public Apple(String color) {
        this.color = color;
    }

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Apple(Integer integer, Integer integer1, Integer integer2) {
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
