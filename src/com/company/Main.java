package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            String variable = "Hello, World!";

            System.out.println("Private field value before:\t" + variable);
            changeStringValue(variable, "Hello, Human!");
            System.out.println("Private field value after:\t" + variable);

            System.out.println("\nPrivate field value before:\t" + variable);
            var text = getString("Enter text to change value of variable:");
            changeStringValue(variable, text);
            System.out.println("Private field value after:\t" + variable);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void changeStringValue(String variable, String text) throws NoSuchFieldException, IllegalAccessException {
        var field = variable.getClass().getDeclaredField("value");
        field.setAccessible(true);
        field.set(variable, text.getBytes());
    }

    public static String getString(String message) {
        System.out.println(message);
        var inStream = new Scanner(System.in);
        return inStream.nextLine();
    }

    public static void disableWarning() {
        System.err.close();
        System.setErr(System.out);
    }
}
