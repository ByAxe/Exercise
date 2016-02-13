package exercises.olimp.olimp5;

import java.util.ArrayList;
import java.util.List;

/*
* Нужно взвесить груз произвольной массы M, пользуясь следующим набором гирек: 2, 4, 8, 16...
* С использованием минимально возможножного количества гирь
* */

public class Weighing {

    private final int[] dumbbells_set;

    public Weighing() {
        dumbbells_set = new int[36];
        dumbbells_set[0] = 1;
        for (int i = 1; i < dumbbells_set.length; i++) {
            dumbbells_set[i] = dumbbells_set[i - 1] * 2;
        }
    }

    public List<Integer> weighing(int sackWeight) {
        List<Integer> dumbbells_list = new ArrayList<>();

        for (int dumbbellNumber = dumbbells_set.length - 1; dumbbellNumber >= 0; dumbbellNumber--) {

            int currentDumbbell = dumbbells_set[dumbbellNumber];

            if ((sackWeight - currentDumbbell) >= 0) {

                dumbbells_list.add(currentDumbbell);
                sackWeight -= currentDumbbell;
            }
        }

        return dumbbells_list;
    }

}