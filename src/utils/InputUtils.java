package utils;

import java.util.Scanner;

public class InputUtils {

    public static int readInt(Scanner sc, String message) {

        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer. Try again.");
            }
        }
    }

    public static double readDouble(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    public static String readString(Scanner sc, String message) {
        System.out.print(message);
        return sc.nextLine();

    }
}
