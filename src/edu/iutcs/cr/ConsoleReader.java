package edu.iutcs.cr.utils;

import java.util.Scanner;

/**
 * YOUR utility class for reading user input
 */
public class ConsoleReader {
    private final Scanner scanner;

    public ConsoleReader() {
        this.scanner = new Scanner(System.in);
    }

    public String readMandatoryString(String prompt) {
        String value = null;
        while (value == null || value.isBlank()) {
            System.out.print(prompt);
            value = scanner.nextLine();
            if (value == null || value.isBlank()) {
                System.out.println("This field is mandatory!");
            }
        }
        return value;
    }

    public String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int readInt(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }

    public int readIntInRange(String prompt, int min, int max) {
        int value;
        while (true) {
            value = readInt(prompt);
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("Please enter a value between " + min + " and " + max + "!");
        }
    }

    public double readDouble(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }

    public boolean readBoolean(String prompt) {
        System.out.print(prompt + " (true/false): ");
        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("true")) return true;
            if (input.equals("false")) return false;
            System.out.print("Please enter true or false: ");
        }
    }

    public void waitForInput(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                int val = Integer.parseInt(scanner.nextLine().trim());
                if (val == 0) return;
                System.out.print("Enter 0 to continue: ");
            } catch (NumberFormatException e) {
                System.out.print("Enter 0 to continue: ");
            }
        }
    }

    public void close() {
        if (scanner != null) {
            scanner.close();
        }
    }
}