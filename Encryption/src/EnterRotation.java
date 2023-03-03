/*
 * UE07_Encryption
 * Class to read rotation from scanner
 * Author:       Susanne Jandl
 * Last Change:  17.12.2022
 */

import java.util.Scanner;

public class EnterRotation {
    private long rotation;

   // constructor:
    public EnterRotation() {
        this.rotation = enterRotation();
    }

   // setter: not used because of scanner input, but should always be included for private variable
    public void setRotation() {
        this.rotation = rotation;
    }

    // getter:
    public long getRotation() {
        return rotation;
    }

    // method: read positive input from scanner
    static long enterRotation() {
        Scanner scanner = new Scanner(System.in);
        long a = 0;
        while (a < 1) {
            System.out.print("  Enter rotation: ");
            if (scanner.hasNextLong()) {
                long num = scanner.nextLong();
                if (scanner.nextLine().equals(""))
                a = num;

            } else
                scanner.nextLine();
        }
        return a;
    }
}
