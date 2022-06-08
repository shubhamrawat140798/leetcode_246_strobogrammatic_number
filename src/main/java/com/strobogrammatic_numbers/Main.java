package com.strobogrammatic_numbers;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * for taking input for user.
 */
final class Main {
    /**
     * for taking input from user.
     * @param args for taking input from command line.
     */
    public static void main(final String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Strobogrammatic strobogrammatic = new Strobogrammatic();
            System.out.print(
                    "\nEnter digits you want strobogrammatic number series: ");
            List<String> strobogrammicSeries =
                    strobogrammatic.findStrobogrammatic(scanner.nextInt());
            System.out.println("strobogrammatic: " + strobogrammicSeries);
        } catch (InputMismatchException exception) {
            System.out.println(
                    "Given input is not an integer: Enter an integer.");
            System.out.println("Exception Log: " + exception);
        } catch (Exception exception) {
            System.out.println("Exception occur: " + exception);
        }
    }
    private Main() {
        // for removing.
        // Utility classes should not have a public or default constructor.
    }
}
