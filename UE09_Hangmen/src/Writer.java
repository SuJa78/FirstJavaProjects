/*
 * UE09
 * Hangmen, write words to file
 */

import java.io.*;
import java.util.*;

public class Writer {

    public static String checkForLetters(String input, String exceptionText, String OK) {
        int valueA = 'A';
        int valueZ = 'z';
        for (int i = 0; i < input.length(); ++i) {
            int valueAt = input.charAt(i);
            try {
                if (valueA > valueAt || valueAt > valueZ) {
                    input = "";
                    throw new IOException();
                }
            } catch (IOException e) {
                System.out.println(exceptionText);
                OK = "no";
                break;
            }
        }
        return OK;
    }

    public static void writer(Scanner scanner) {
        int wordCount = 1;
        File words = new File("words.txt");
        try {
            words.createNewFile();
        } catch (IOException e) {}
        try {
            BufferedWriter writeInWords = new BufferedWriter(new FileWriter(words.getName()));
            while (wordCount <= 5) {
                System.out.printf("Enter word %d of 5, only letters allowed: ", wordCount);
                String input = scanner.nextLine();
                checkForLetters(input, "Wrong input!", "yes");
                if (!input.equals("")) {
                    writeInWords.append(input + "\n");
                    writeInWords.flush();
                    wordCount++;
                }
            }
        } catch (IOException e) {}
    }
}