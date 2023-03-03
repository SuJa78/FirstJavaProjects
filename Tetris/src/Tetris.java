/*
 * UE08_Tetris
 * Working with arrays
 * Author:       Susanne Jandl
 * Last Change:  25.12.2022
 */


public class Tetris {

    // prints 3D-array 4x4x4 (blocks in a row)
    static void printTetris(char[][][] myArray) {
        char del = 8;
        for (int k = 0; k <= 3; k++) {
            for (int j = 0; j <= 3; j++) {
                for (int i = 0; i <= 3; i++) {
                    System.out.print(myArray[j][k][i] + " ");
                }
                System.out.print(" ");
            }
            System.out.println(del + "" + del);
        }
        System.out.println();
    }

    // turns blocks of 3D-array 4x4x4 (blocks in a row) in clockwise direction
    static char[][][] turnTetris(char[][][] myArray) {
        char[][][] myArray1 = new char[4][4][4];

        for (int k = 0; k <= 3; k++) {
            for (int j = 0; j <= 3; j++) {
                for (int i = 0; i <= 3; i++) {
                    int h = 3 - j;

                    myArray1[k][i][j] = myArray[k][h][i];
                }
            }
        }
        return myArray1;
    }

    public static void main(String[] args) {

        char l = 45;
        char o = 111;

        char[][][] myArray = {{
                {l, l, l, l},
                {l, o, l, l},
                {o, o, o, l},
                {l, l, l, l}
        }, {
                {l, l, l, l},
                {l, o, o, l},
                {o, o, l, l},
                {l, l, l, l}
        }, {
                {l, l, l, l},
                {l, o, l, l},
                {l, o, l, l},
                {l, o, o, l}
        }, {
                {l, l, o, l},
                {l, l, o, l},
                {l, l, o, l},
                {l, l, o, l}
        }};

        for (int i = 0; i < 5; i++) {
            printTetris(myArray);
            myArray = turnTetris(myArray);
        }
    }
}
