package exercises.olimp.olimp4;

public class Child {
    private String name;
    private int age;
    private int id;

    public Child() {

    }

    public Child(int id) {
        this.id = id;
    }

    public Child(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
