package exercises.college.arrays.exercise1;

import interfaces.IDeclare;

/**
 * Формируется и выводится прямоугольный массив (n строк и m столбцов)
 * целых чисел от -50 до 50, Вычисляется и выводится:
 * а)Сумма чисел в каждой строке
 * б)Среднее арифметическое чисел в каждой строке
 * в)Сумма и среднее арифметическое отрицательных чисел в каждой строке
 * г)Сумма и среднее арифметическое положительных четных чисел в каждой строке
 * д)Сумма и среднее арифметическое всех чисел
 */

public class Main implements IDeclare {
    public static void main(String[] args) {
        int row, col;
        Array array;
        System.out.print("Enter how many rows will be in array? - ");
        row = scan.nextInt();
        System.out.print("Enter how many cols will be in array? - ");
        col = scan.nextInt();
        array = new Array(row, col);

        array.fillRand();
        array.averageOfRow();
        array.sumOfRow();
        array.outputOfArray();
    }
}
