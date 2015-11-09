package exercises.college.arrays.exercise1;

import interfaces.IDeclare;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Array implements IDeclare {

    private int[][] array;
    private int columns;
    private int rows;
    private String message;
    private boolean lock = false;
    private List<Integer> tempData = new ArrayList<>();
    private List<Integer> tempData2 = new ArrayList<>();

    public Array(int columns, int rows) {
        this.columns = columns;
        this.rows = rows;
        array = new int[columns][rows];
    }

    public void fillRand() {
        if (!lock) {
            Random r = new Random(System.currentTimeMillis());
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    array[i][j] = r.nextInt(100) - 50;
                }
            }
            lock = true;
        } else {
            System.out.println("Array is already filled by random numbers.\n");
        }
    }

    private void questionAboutRewriting(String currentOperation) {
        System.out.println("Collection is already filled by operation:\n\t"
                + message + ".");
        System.out.print("Do you want to rewrite it on:\n\t" +
                currentOperation + " ?... (yes/no) ");
    }

    private boolean checkOnFill() {
        return tempData.stream().findFirst() != null; /*TODO I'm not sure in .findfirst()*/
    }

    private boolean answerAboutRewriting() {
        String answer;
        answer = scan.next();
        return "yes".equalsIgnoreCase(answer); /* TODO rewrite it with RegExp*/
    }

    private boolean listHandler(String currentOperation) {
        if (checkOnFill()) {
            questionAboutRewriting(currentOperation);
            return answerAboutRewriting();
        }
        return false;
    }

    public void sumOfRow() {
        String currentOperation = "Sum of row";
        this.message = currentOperation;
        int tempSum;
        if (listHandler(currentOperation)) {
            for (int i = 0; i < rows; i++) {
                tempSum = 0;
                for (int j = 0; j < columns; j++) {
                    tempSum += array[i][j];
                }
                tempData.add(tempSum);
            }
            this.message = "Sum of row";
        }
    }

    public void averageOfRow() {
        int tempValue;
        for (int i = 0; i < rows; i++) {
            tempValue = 0;
            for (int j = 0; j < columns; j++) {
                tempValue += array[i][j];
            }
            tempData.add(tempValue / columns);
        }
    }

    public void sumAndAverageOfNegativeNumbersInRow() {
        int tempAverage;
        int tempSum;

        for (int i = 0; i < rows; i++) {
            tempAverage = 0;
            tempSum = 0;
            for (int j = 0; j < columns; j++) {

            }
        }
    }

    public void outputOfArray() {
        tempData.stream().forEach(System.out::println);
        tempData.clear();
        if (tempData2.stream().findFirst() != null) {   /*TODO Here I may get exception */
            tempData2.stream().forEach(System.out::println);
        }
    }

}
