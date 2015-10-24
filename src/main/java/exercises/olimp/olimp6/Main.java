package exercises.olimp.olimp6;

import interfaces.IDeclare;

public class Main implements IDeclare{
    public static void main(String[] args) {
        System.out.println("Enter weight of the box");
        Handler handler = new Handler(scan.nextInt());
    }
}