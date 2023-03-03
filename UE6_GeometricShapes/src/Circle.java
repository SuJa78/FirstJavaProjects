/*
 * UE06
 * Geometric shapes, circle
 * Author: Susanne Jandl
 * Last change: 2022-02-19
 */

public class Circle{
    private int radius;
    private Point centerPoint = new Point();

    private static int circleNo = 0;

    // constructor
    public Circle() {
        circleNo++;
    }

    // setter
    public void setRadius(int radius) {
        this.radius = radius;
    }

    // getter
    public int getRadius() {
        return radius;
    }

    // setter
    public void setCenterPoint(int xCoordinate, int yCoordinate) {
        this.centerPoint.setXCoordinate(xCoordinate);
        this.centerPoint.setYCoordinate(yCoordinate);
    }

    public Point getCenterPoint() {
        return centerPoint;
    }

    // METHODS
    // get number of circles
    public static int getCircleNo() {
        return circleNo;
    }

    // compute area
    public double circleArea() {
        return radius * Math.PI;
    }

    // draw circle
    public void drawCircle(){
        if (radius > 0) {
            System.out.println(" ".repeat(radius * 2 + 3) + "--" +
                    "\n".repeat(radius) +
                    " ".repeat(2) + "|" + " ".repeat(radius * 2) + "::" + " ".repeat(radius * 2) + "|" +
                    "\n".repeat(radius) +
                    " ".repeat(radius * 2 + 3) + "--");
        }
    }
}