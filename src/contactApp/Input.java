package contactApp;

import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in);


    public String getString() {
        return scanner.nextLine();
    }

    public boolean yesNo(String c) {
        String userInput = getString();

        return userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes");
    }

    public int getInt() {
        try {
            return Integer.parseInt(getString());
        } catch (NumberFormatException e) {
            System.out.println("Input is not a valid integer.");
            System.out.println("Enter an integer: ");
        }
        return getInt();
    }

    public int getInt(int min, int max, String prompt) {
        System.out.print(prompt);
        int userInt = getInt();

        if (userInt < min || userInt > max) {
            System.out.println("Int is not between " + min + " and " + max);
            userInt = getInt(min, max, prompt);
        }
        return userInt;
    }

    public double getDouble() {
        try {
            return Double.parseDouble(getString());
        } catch (NumberFormatException e) {
            System.out.println("Input is not a valid double.");
            System.out.println("Enter an double: ");
        }
        return getDouble();
    }

    public double getDouble(double min, double max) {
        double userDouble = getDouble();

        if (userDouble < min || userDouble > max) {
            System.out.println("Double is not between " + min + " and " + max + ". Enter another double: ");
            userDouble = getDouble(min, max);
        }
            return userDouble;
    }

    public String getBinary() {
        try {
            System.out.println("Enter integer to convert to binary: ");
            return Integer.toBinaryString(getInt());
        } catch (NumberFormatException e) {
            System.out.println("Input is not a valid integer.");
            System.out.println("Enter an integer: ");
            return getBinary();
        }
    }

    public String getHex() {
        try {
            System.out.println("Enter integer to convert to hexidecimal: ");
            return Integer.toHexString(getInt());
        } catch (NumberFormatException e) {
            System.out.println("Input is not a valid integer.");
            System.out.println("Enter an integer: ");
            return getHex();
        }
    }

}
