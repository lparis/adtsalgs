package edu.ser222.m01_01;
//ClosestPointsFinder.java

import java.awt.geom.Point2D;

public class ClosestPointsFinder {
    //this method analyzes a given array of Point2D objects, and finds the closest pair of points
    //the closest pair of points will be displayed at the end.
    //if you want, you can change the method to return the closest pair of points
    public static void findClosestPoints(Point2D points[]) {
        //if there is not enough points to find a closest pair, printing a message
        if (points.length < 2) {
            System.out.println("Not enough points");
        } else {
            //else initializing two variables to store the closest pair of points
            Point2D p1 = null, p2 = null;
            //looping from i=0 to points.length - 1
            for (int i = 0; i < points.length; i++) {
                //looping from j=i+1 to points.length - 1 (in this way, we iterate through each pair of points once)
                for (int j = i + 1; j < points.length; j++) {
                    //finding the distance between the points at index i and j
                    double distance = points[i].distance(points[j]);
                    //printing points and the distance between them, only if distance is less than 10
                    if (distance < 10) {
                        System.out.printf("The distance between (%.2f, %.2f) and (%.2f, %.2f) is %.5f.\n", points[i].getX(),
                                points[i].getY(), points[j].getX(), points[j].getY(), distance);
                    }
                    //if p1 is null or if the distance between the points at index i and j is less than the distance
                    // between p1 and p2, updating p1 and p2
                    if (p1 == null || distance < p1.distance(p2)) {
                        p1 = points[i];
                        p2 = points[j];
                    }
                }
            }
            //at the end, printing the closest pair of points,and the distance between them
            System.out.printf("\nClosest points are (%.2f, %.2f) and (%.2f, %.2f) with distance: %.5f\n", p1.getX(),
                    p1.getY(), p2.getX(), p2.getY(), p1.distance(p2));
        }
    }

    public static void main(String[] args) {
        Point2D array[] = {
                new Point2D.Double(3, 12),
                new Point2D.Double(1, 23),
                new Point2D.Double(8, 4.2),
                new Point2D.Double(12, 5.1),
                new Point2D.Double(11, 6.8),
                new Point2D.Double(5.5, 7),
                new Point2D.Double(8.9, 8),
                new Point2D.Double(12, 9)};
        findClosestPoints(array);
    }
}