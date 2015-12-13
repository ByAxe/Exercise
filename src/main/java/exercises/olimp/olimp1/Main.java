package exercises.olimp.olimp1;

import interfaces.IDeclare;

import static regular.experience.RegExp.NUMERIC;
import static regular.experience.RegExp.checkOnCorrectValue;

public class Main implements IDeclare{

    public static void main(String[] args) {
        Handler handler = new Handler(Integer.parseInt(checkOnCorrectValue("Enter value form 3 to 1000 ", NUMERIC)));
        handler.runLoop();
    }
}
