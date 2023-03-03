/*
 * UE07_Encryption
 * Class to read text from scanner
 * Author:       Susanne Jandl
 * Last Change:  17.12.2022
 */

import java.util.Scanner;

public class TextToEncrypt {
    private String text;

    // constructor
    public TextToEncrypt() {
        this.text = enterTextToEncrypt();
    }

    // setter: not used because of scanner input, but should always be included for private variable
    public void setText() {
        this.text = text;
    }

    // getter:
    public String getText() {
        return text;
    }

    // method: write request and read text from scanner

    static String enterTextToEncrypt() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("  Enter text to encrypt: ");
        String text = scanner.nextLine();
        return text;
    }
}