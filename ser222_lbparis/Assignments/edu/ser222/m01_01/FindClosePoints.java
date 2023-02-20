package edu.ser222.m01_01;
/**
 * This program finds points that are close together using the
 * Point2D abstract data type
 *
 * @author lbparis@asu.edu
 * @version 1.0
 */

import java.awt.geom.Point2D;

public class FindClosePoints
{
	public static void findClosePoints(Point2D points[])
	{
		if (points.length < 2)
		{
			System.out.println("Please enter two points.");
		}
		else {
			Point2D point1 = null, point2 = null;
			for (int i = 0; i < points.length; i++)
			{
				for (int j = i + 1; j < points.length; j++)
				{
					double distance = points[i].distance(points[j]);
					if (distance < 10)
					{
						System.out.printf("The distance between (%.2f, %.2f) and (%.2f, %.2f) is %.5f.\n", points[i].getX(), points[i].getY(), points[j].getX(), points[j].getY(), distance);
					}
//					if (point1 == null || distance < point1.distance(point2))
//					{
//						point1 = points[i];
//						point2 = points[j];
//					}
				}
			}
//			System.out.printf("\nThe closest points are (%.2f, %.2f) and (%.2f, %.2f) with distance %.5f\n", point1.getX(), point1.getY(), point2.getX(), point2.getY(), point1.distance(point2));
		}

	}
}
