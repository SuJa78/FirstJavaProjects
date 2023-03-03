/*
 * UE09
 * Hangmen main class
 * Author: Susanne Jandl
 * Last change: 2023-02-21
 */

import java.io.*;
import java.util.*;

public class Hangmen {

    // print line
    public static void printLine(String line) {
        System.out.println(line.repeat(80));
    }

    // print hangman
    public static void printHangman(String[] hangman) {
        for (int i = 0; i <= 5; i++)
            System.out.print(hangman[i]);
        System.out.println();
    }

    // update hangman drawing according to number of misses
    public static String[] setHangman(String[] hangman, int missNo) {
        switch (missNo) {
            case 0:
                Arrays.fill(hangman, "");
                break;
            case 1:
                hangman[5] = "===";
                break;
            case 2:
                for (int i = 1; i <= 4; i++) {
                    hangman[i] = " |\n";
                }
                break;
            case 3:
                hangman[0] = "  ____\n";
                break;
            case 4:
                hangman[1] = " |/\n";
                break;
            case 5:
                hangman[1] = " |/    |\n";
                break;
            case 6:
                hangman[2] = " |     O\n";
                break;
            case 7:
                hangman[3] = " |     |\n";
                break;
            case 8:
                hangman[4] = " |    /\n";
                break;
            case 9:
                hangman[4] = " |    / \\\n";
                break;
            case 10:
                hangman[3] = " |    /|\n";
                break;
            case 11:
                hangman[3] = " |    /|\\\n";
                break;
        }
        return hangman;
    }

    // count and store words from file in list
    public static int wordCount(BufferedReader readWords, List<String> words) throws IOException {
        int i = 0;
        String word = "";
        while ((word = readWords.readLine()) != null) {
            words.add(i, word);
            i++;
        }
        return i;
    }

    // print header
    public static void printHeader(final int WORD_NO) {
        printLine("=");
        System.out.printf("HANGMEN (%d Word(s))%n", WORD_NO);
        printLine("-");
    }

    // check if exactly 1 letter entered
    public static String checkLetterNo(String guessedLetter) {
        String letterOK = "yes";
        try {
            if (guessedLetter.length() > 1)
                throw new IOException();
        } catch (IOException e) {
            System.out.println("Error: Invalid input!");
            letterOK = "no";
        }
        return letterOK;
    }



    // check if entered letter was already guessed
    public static String checkForGuessedChar(String guessedLetter, int rightNo, int missNo, char[] rightGuess, char[] wrongGuess) {
        String letterOK = "yes";
        for (int i = 0; i < rightNo; i++) {
            try {
                if (guessedLetter.toUpperCase().charAt(0) == rightGuess[i])
                    throw new IOException();
            } catch (IOException e) {
                System.out.println("Character already guessed!");
                letterOK = "no";
                break;
            }
        }
        for (int j = 0; j < missNo; j++) {
            try {
                if (guessedLetter.charAt(0) == wrongGuess[j])
                    throw new IOException();
            } catch (IOException e) {
                System.out.println("Character already guessed!");
                letterOK = "no";
                break;
            }
        }
        return letterOK;
    }


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // create words.txt and enter words in file
//        Writer.writer(scanner);


        List<String> words = new ArrayList<>();
        int wordNo = 0;
        String fileOK = "yes";
        try (BufferedReader readWords = new BufferedReader(new FileReader(args[0]))) {
            wordNo = wordCount(readWords, words);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: No file name given!");
            fileOK = "no";
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
            fileOK = "no";
        }

        try {
            for (int i = 0; i < 5; i++) {
                if (words.isEmpty() || (words.get(i).equals(""))) {
                    throw new IOException();
                }
            }
        } catch (IOException e) {
            System.out.println("Error: Empty file!");
            fileOK = "no";
        } catch (IndexOutOfBoundsException e) {
        }
        for (int i = 0; i < 5; i++) {
            try {
                fileOK = Writer.checkForLetters(words.get(i), "Error: Corrupt file!", fileOK);
            } catch (IndexOutOfBoundsException e) {
            }
        }


        if (fileOK.equals("yes")) {
            // define variables
            int missNo = 0;
            int wrongFlag = 1;
            int rightNo = 0;
            String guessedLetter = "";
            String[] hangman = new String[6];
            Arrays.fill(hangman, "");
            char[] wrongGuess = new char[11];

            printHeader(wordNo);

            for (int j = 1; j <= wordNo; j++) {
                // define variables
                missNo = 0;
                rightNo = 0;
                char[] guessedWord = new char[words.get(j - 1).length() * 2];
                for (int i = 0; i < (words.get(j - 1).length() * 2); i += 2)
                    guessedWord[i] = ' ';
                for (int i = 1; i < (words.get(j - 1).length() * 2); i += 2)
                    guessedWord[i] = '_';
                char[] rightGuess = new char[words.get(j - 1).length()];
                Arrays.fill(wrongGuess, ' ');

                // print word number when next word
                System.out.printf("Word #%d:%n", j);

                while (missNo <= 11 && rightNo <= words.get(j - 1).length()) {
                    wrongFlag = 1;                            // set wrong flag for new letter
                    hangman = setHangman(hangman, missNo);
                    printHangman(hangman);
                    System.out.print("Word:");
                    for (int i = 0; i < words.get(j - 1).length() * 2; i++)
                        System.out.print(" " + guessedWord[i]);
                    System.out.printf("%nMisses (%d/11)", missNo);
                    int k = 1;
                    if (missNo > 0)
                        System.out.print(":");
                    while (k <= missNo) {
                        System.out.printf(" %c", wrongGuess[k - 1]);
                        k++;
                    }
                    System.out.println();
                    if (missNo == 11) {
                        System.out.println("YOU LOSE!\n");
                        break;
                    } else if (rightNo == words.get(j - 1).length()) {
                        System.out.println("YOU WIN!\n");
                        break;
                    } else {
                        System.out.print("Next guess: ");
                        guessedLetter = (scanner.nextLine());
                        if (checkLetterNo(guessedLetter).equals("no") || Writer.checkForLetters(guessedLetter, "Error: Invalid character!", "yes").equals("no") || checkForGuessedChar(guessedLetter, rightNo, missNo, rightGuess, wrongGuess).equals("no"))
                            continue;
                         for (int i = 0; i < words.get(j - 1).length(); i++) {
                            if (guessedLetter.toUpperCase().charAt(0) == words.get(j - 1).toUpperCase().charAt(i)) {
                                guessedWord[i * 2 + 1] = guessedLetter.charAt(0);
                                rightNo++;
                                rightGuess[rightNo - 1] = guessedLetter.charAt(0);
                                wrongFlag = 0;
                            }
                        }
                    }
                    if (wrongFlag == 1) {
                        missNo++;
                        wrongGuess[missNo - 1] = guessedLetter.toUpperCase().charAt(0);
                    }
                }
            }
        }
    }
}