/*
 * UE06
 * Geometric Shapes, Rectangle
 * Author: Susanne Jandl
 * Last change: 2022-02-19
 */

public class Rectangle {
    private Point firstPoint = new Point();
    private Point secondPoint = new Point();

    private static int rectangleNo = 0;

    // constructor
    public Rectangle() {
        rectangleNo++;
    }

    // setter
    public void setFirstPoint(int xCoordinate, int yCoordinate) {
        this.firstPoint.setXCoordinate(xCoordinate);
        this.firstPoint.setYCoordinate(yCoordinate);
    }

    // getter
    public Point getFirstPoint() {
        return firstPoint;
    }

    // setter
    public void setSecondPoint(int xCoordinate, int yCoordinate) {
        this.secondPoint.setXCoordinate(xCoordinate);
        this.secondPoint.setYCoordinate(yCoordinate);
    }

    // getter
    public Point getSecondPoint() {
        return secondPoint;
    }

    // METHODS
    // get number of rectangles
    public static int getRectangleNo() {
        return rectangleNo;
    }

    // compute width
    public int rectangleWidth() {
        return firstPoint.getXCoordinate() > secondPoint.getXCoordinate() ?
               firstPoint.getXCoordinate() - secondPoint.getXCoordinate() :
               secondPoint.getXCoordinate() - firstPoint.getXCoordinate();
    }

    // compute width
    public int rectangleHeight() {
        return firstPoint.getYCoordinate() > secondPoint.getYCoordinate() ?
               firstPoint.getYCoordinate() - secondPoint.getYCoordinate() :
               secondPoint.getYCoordinate() - firstPoint.getYCoordinate();
    }

    // compute area
    public int rectangleArea() {
        return rectangleHeight() * rectangleWidth();
    }

    // draw rectangle width
    public void drawRectangleWidth() {
        System.out.println(" ".repeat(3) + "-".repeat(rectangleWidth() * 2));
    }

    // draw rectangle
    public void drawRectangle() {
        if (rectangleWidth() > 0 && rectangleHeight() > 0) {
            drawRectangleWidth();
            for (int i = 0; i < rectangleHeight(); i++) {
                System.out.println(" ".repeat(2) + "|" + " ".repeat(rectangleWidth() * 2) + "|");
            }
            drawRectangleWidth();
        }
    }
}