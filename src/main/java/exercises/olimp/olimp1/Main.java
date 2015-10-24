package exercises.olimp.olimp1;

import interfaces.IDeclare;

public class Main implements IDeclare{

    public static void main(String[] args) {
        System.out.println("Enter value form 3 to 1000");
        Handler handler = new Handler(scan.nextInt());
        handler.runLoop();
    }
}
