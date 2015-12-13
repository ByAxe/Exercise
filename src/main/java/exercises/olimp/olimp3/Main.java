package exercises.olimp.olimp3;

/*
* Каждые полторы курицы за полтора дня сносят полтора яйца.
* Написать программу, которая позволяет рассчитать,сколько яиц (без десятых долей) снесут N кур
*/

import static regular.experience.RegExp.NUMERIC;
import static regular.experience.RegExp.checkOnCorrectValue;

public class Main {
    public static void main(String[] args) {
        Farm farm;
        farm = new Farm();
        farm.input(Integer.parseInt(checkOnCorrectValue("Enter the count of chickens: ", NUMERIC)),
                Integer.parseInt(checkOnCorrectValue("Enter the count of days: ", NUMERIC)));
        farm.calculate();
        farm.output();
    }
}