package exercises.olimp.olimp3;

public class Farm {

    private final double expressionsNecessaryNumber2 = 2;
    private final double expressionsNecessaryNumber3 = 3;
    private int days;
    private int chickens;
    private double eggs;

    public void input(int chickens, int days) {
        this.days = days;
        this.chickens = chickens;
    }

    public void calculate() {
        eggs = days * chickens;
        eggs *= expressionsNecessaryNumber2;
        eggs /= expressionsNecessaryNumber3;
        eggs *= 100;
        eggs = (int) eggs / 100;
    }

    public void output() {
        System.out.println("Count of eggs = " + eggs);
    }
}
