/*
 * UE06
 * Geometric Shapes, main
 * Author: Susanne Jandl
 * Last change: 2022-02-19
 */

import java.util.Scanner;
import java.util.Locale;

public class UE06_GeometricShapes {

    // print line
    public static void printLine() {
        System.out.println("-".repeat(80));
    }

    // print menu
    public static void printMenu() {
        printLine();
        System.out.println("Available commands:");
        System.out.println("  \"New rectangle\" - create new rectangle");
        System.out.println("  \"New circle\" - create new circle");
        System.out.println("  \"Quit\" - quit program");
        printLine();
        System.out.print("> ");
    }

    // read coordinates:
    public static int readInput(Scanner scanner, int coordinate, String text) {
        try {
            System.out.print(text);
            coordinate = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            readInput(scanner, coordinate, text);
        }
        return coordinate;
    }

    // rectangle input and output
    public static void completeRectangle(Scanner scanner, int coordinate) {
        Rectangle rectangle = new Rectangle();
        System.out.printf("Rectangle #%d:%n", Rectangle.getRectangleNo());
        rectangle.setFirstPoint(readInput(scanner, coordinate, "First point:  x coordinate: "), readInput(scanner, coordinate, "First point:  y coordinate: "));
        rectangle.setSecondPoint(readInput(scanner, coordinate, "Second point: x coordinate: "), readInput(scanner, coordinate, "Second point: y coordinate: "));
        rectangleOutput(rectangle);
    }

    //circle input and output
    public static void completeCircle(Scanner scanner, int coordinate) {
        Circle circle = new Circle();
        System.out.printf("Circle #%d:%n", Circle.getCircleNo());
        circle.setCenterPoint(readInput(scanner, coordinate, "Center point: x coordinate: "),readInput(scanner, coordinate, "Center point: y coordinate: "));
        circle.setRadius(readInput(scanner, coordinate, "Radius: "));
        circleOutput(circle);
    }

    // circle output
    public static void circleOutput(Circle circle) {
        System.out.printf("  Center: (%d,%d)%n", circle.getCenterPoint().getXCoordinate(), circle.getCenterPoint().getYCoordinate());
        System.out.printf("  Radius: %d%n", circle.getRadius());
        System.out.printf("  Area:   %.2f%n", circle.circleArea());
        circle.drawCircle();
    }

    public static void rectangleOutput(Rectangle rectangle) {
        System.out.printf("  Width:  %d%n", rectangle.rectangleWidth());
        System.out.printf("  Height: %d%n", rectangle.rectangleHeight());
        System.out.printf("  Area:   %d%n", rectangle.rectangleArea());
        rectangle.drawRectangle();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale.setDefault(new Locale("en", "US"));

        int coordinate = 0;
        String selection = "";
        do {
            printMenu();
            selection = scanner.nextLine().toLowerCase();
            switch (selection) {
                case ("new rectangle"):
                    completeRectangle(scanner, coordinate);
                    break;
                case ("new circle"):
                    completeCircle(scanner, coordinate);
                    break;
            }
        } while (!selection.equals("quit"));
    }
}