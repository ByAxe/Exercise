package exercises.college.arrays.exercise1;

import interfaces.IDeclare;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static regular.experience.RegExp.*;

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
        array = new int[rows][columns];
    }

    public void fillRand() {
        if (!lock) {
            Random r = new Random(System.currentTimeMillis());
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) array[i][j] = r.nextInt(100) - 50;
                /* TODO ArrayIndexOutOfBoundsException when I enter different values in row and col*/
            }
            lock = true;
        } else {
            System.out.println("Array is already filled by random numbers.\n");
        }
    }

    private boolean questionAboutRewriting(String currentOperation) {
        System.out.println("Collection is already filled by method:\n\t"
                + message + ".");
        return ((checkOnCorrectValue("Do you want to rewrite it on:\n\t" +
                currentOperation + " ?... (yes/no)", ANSWER)).equalsIgnoreCase(YES));
    }

    protected boolean checkOnFill() {
        return message != null;
    }

    private boolean listHandler(String currentOperation) {
        return !(checkOnFill() && questionAboutRewriting(currentOperation));
    }

    public void sumOfRow() {
        String currentOperation = "Sum of row";
        int tempSum;
        if (listHandler(currentOperation)) {
            tempData.clear();
            for (int i = 0; i < rows; i++) {
                tempSum = 0;
                for (int j = 0; j < columns; j++) {
                    tempSum += array[i][j];
                }
                tempData.add(tempSum);
            }
            this.message = currentOperation;
        }
    }

    public void averageOfRow() {
        String currentOperation = "Average of row";
        int tempValue;
        if (listHandler(currentOperation)) {
            tempData.clear();
            for (int i = 0; i < rows; i++) {
                tempValue = 0;
                for (int j = 0; j < columns; j++) {
                    tempValue += array[i][j];
                }
                tempData.add(tempValue / columns);
            }
            this.message = currentOperation;
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
        if (tempData2.size() == 0) {   /*TODO It still passes even if there no values  */
            tempData2.stream().forEach(System.out::println);
        }
    }

}
