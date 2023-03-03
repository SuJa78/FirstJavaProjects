/*
 * UE07_Encryption
 * Working with classes and strings
 * Author:       Susanne Jandl
 * Last Change:  17.12.2022
 */

import java.util.Scanner;

public class Encryption {

    // prints separator line
    public static void printSeparatorLine() {
        System.out.println("-".repeat(80));
    }

    // prints menu
    static void printMenu() {
        printSeparatorLine();
        System.out.println("1 - Encrypt text");
        System.out.println("2 - Decrypt text");
        System.out.println("9 - Quit");
        printSeparatorLine();
        System.out.print("> ");
    }

    // defines rotation for upper case and lower case letters
    static int rotateLetter(long rotation) {
        rotation = rotation % 26;
        if (rotation == 0)
            rotation = 26;
        int lRotation = (int) rotation;
        return lRotation;
    }

    // defines rotation for numbers
    static int rotateNumber(long rotation) {
        rotation = rotation % 10;
        if (rotation == 0)
            rotation = 10;
        int nRotation = (int) rotation;
        return nRotation;
    }

    // gets number for letter or number rotation
    static long enterRotation() {
        EnterRotation newRotation = new EnterRotation();
        long rotation = newRotation.getRotation();
        return rotation;
    }

    // gets text for encryption
    static String enterTextToEncrypt() {
        TextToEncrypt newText = new TextToEncrypt();
        String text = newText.getText();
        return text;
    }

    // gets text for decryption
    static String enterTextToDecrypt() {
        TextToDecrypt newText = new TextToDecrypt();
        String text = newText.getText();
        return text;
    }


    // encrypts text
    static void encryptText() {
        long rotation = enterRotation();
        int lRotation = rotateLetter(rotation);
        int nRotation = rotateNumber(rotation);
        String input = enterTextToEncrypt();

        String lAbc = "abcdefghijklmnopqrstuvwxyz";
        String uAbc = lAbc.toUpperCase();
        String numbers = "0123456789";
        System.out.print("  Encrypted text: ");
        for (int i = 0; i < input.length(); i++) {
            String selection = String.valueOf(input.charAt(i));
            switch (selection) {
                case "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z":
                    int l = lAbc.indexOf(input.charAt(i)) + lRotation;
                    System.out.print(lAbc.repeat(2).charAt(l));
                    break;
                case "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z":
                    int u = uAbc.indexOf(input.charAt(i)) + lRotation;
                    System.out.print(uAbc.repeat(2).charAt(u));
                    break;
                case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9":
                    int n = numbers.indexOf(input.charAt(i)) + nRotation;
                    System.out.print(numbers.repeat(4).charAt(n));
                    break;
                default:
                    System.out.print(input.charAt(i));
            }
        }
    }

    // decrypts text
    static void decryptText() {
        long rotation = enterRotation();
        int lRotation = rotateLetter(rotation);
        int nRotation = rotateNumber(rotation);

        String text = enterTextToDecrypt();
        String lAbc = "abcdefghijklmnopqrstuvwxyz";
        String uAbc = lAbc.toUpperCase();
        String numbers = "0123456789";
        System.out.print("  Decrypted text: ");
        for (int i = 0; i < text.length(); i++) {
            String selection = String.valueOf(text.charAt(i));
            switch (selection) {
                case "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z":
                    int l = lAbc.indexOf(text.charAt(i)) - lRotation + 26;
                    System.out.print(lAbc.repeat(2).charAt(l));
                    break;
                case "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z":
                    int u = uAbc.indexOf(text.charAt(i)) - lRotation + 26;
                    System.out.print(uAbc.repeat(2).charAt(u));
                    break;
                case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9":
                    int n = numbers.indexOf(text.charAt(i)) - nRotation + 10;
                    System.out.print(numbers.repeat(2).charAt(n));
                    break;
                default:
                    System.out.print(text.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        boolean quit = false;
        while (!quit) {
            printMenu();
            String selection = scanner.nextLine();

            switch (selection) {
                case "1":
                    encryptText();
                    System.out.println();
                    break;
                case "2":
                    decryptText();
                    System.out.println();
                    break;
                case "9":
                    quit = true;
            }
        }
    scanner.close();}
}