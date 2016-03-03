package exercises.college.cryptography;

import java.util.Scanner;

public class Tritemius {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculating calc = new Calculating();
        final int n = 1;
        while (true) {
            System.out.println("Enter value\n");
            System.out.println(calc.calc(scanner.nextInt()));
        }
    }
}
