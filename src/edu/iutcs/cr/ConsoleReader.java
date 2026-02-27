package edu.iutcs.cr;

import java.util.Scanner;

/**
 * YOUR utility class with single static scanner
 */
public class ConsoleReader {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String readMandatoryString(String prompt) {
        String value = null;
        while (value == null || value.isBlank()) {
            System.out.print(prompt);
            value = SCANNER.nextLine();
            if (value == null || value.isBlank()) {
                System.out.println("This field is mandatory!");
            }
        }
        return value;
    }

    public static String readString(String prompt) {
        System.out.print(prompt);
        return SCANNER.nextLine();
    }

    public static int readInt(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return Integer.parseInt(SCANNER.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }

    public static int readIntInRange(String prompt, int min, int max) {
        int value;
        while (true) {
            value = readInt(prompt);
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("Please enter a value between " + min + " and " + max + "!");
        }
    }

    public static double readDouble(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return Double.parseDouble(SCANNER.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }

    public static boolean readBoolean(String prompt) {
        System.out.print(prompt + " (true/false): ");
        while (true) {
            String input = SCANNER.nextLine().trim().toLowerCase();
            if (input.equals("true")) return true;
            if (input.equals("false")) return false;
            System.out.print("Please enter true or false: ");
        }
    }

    public static void waitForInput(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                int val = Integer.parseInt(SCANNER.nextLine().trim());
                if (val == 0) return;
                System.out.print("Enter 0 to continue: ");
            } catch (NumberFormatException e) {
                System.out.print("Enter 0 to continue: ");
            }
        }
    }

    // Optional: only if you need to close at app exit
    public static void close() {
        SCANNER.close();
    }
}