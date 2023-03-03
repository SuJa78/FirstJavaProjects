/*
 * UE04_ChoicesAndLoops
 * Choices and loops
 * Author:       Susanne Jandl
 * Last Change:  06.11.2022
 */

import java.util.Locale;
import java.util.Scanner;

public class ChoicesAndLoops {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("en", "US"));

        float amount = 0;
        int number;
        int sum = 0;
        int minimum = 2147483647;
        int maximum = -2147483647;
        float mean;
        int sumOfNumbers = 0;
        float amean;

        Scanner scanner = new Scanner(System.in);

        while (amount <= 0) {
            System.out.print("Amount: ");
            if (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                if (scanner.nextLine().equals(""))
                    amount = num;
            } else
                scanner.nextLine();
        }

        int i = 1; //numbers
        while (i <= amount) {
            System.out.printf("#%d: ", i);
            if (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                if (scanner.nextLine().equals("")) {
                    number = num;
                    ++i;

                    sum += number; //sum

                    if (number < minimum) //minimum
                        minimum = number;

                    if (number > maximum) //maximum
                        maximum = number;
                }
            } else
                scanner.nextLine();
        }

        mean = sum / amount; //mean

        if (sum / amount < 0) //absolute value of mean
            amean = mean * -1;
        else
            amean = mean;

        for (int counter = maximum; counter >= minimum; counter--) //sum of numbers from minimum to maximum
            sumOfNumbers += counter;

        System.out.println("Sum = " + sum);
        System.out.println("Minimum = " + minimum);
        System.out.println("Maximum = " + maximum);
        System.out.printf("Mean = %.2f \n", mean);
        System.out.printf("Reciprocal of mean = %.2f \n", 1 / mean);
        System.out.printf("Additive inverse of mean = %.2f \n", mean * -1);
        System.out.printf("Absolute value of mean = %.2f \n", amean);
        System.out.printf("Delta of minimum and maximum = %d \n", maximum - minimum);
        System.out.println("Sum of numbers from minimum to maximum = " + sumOfNumbers);

        scanner.close();
    }
}
