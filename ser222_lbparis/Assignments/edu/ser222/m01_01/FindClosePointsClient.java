package edu.ser222.m01_01;
import java.awt.geom.Point2D;

public class FindClosePointsClient {

	public static void main(String[] args) {

		Point2D array[] =
			{
					new Point2D.Double(3, 12),
					new Point2D.Double(1, 3),
					new Point2D.Double(8, 4.2),
					new Point2D.Double(12, 5.1),
					new Point2D.Double(11, 6.8),
					new Point2D.Double(5.5, 7),
					new Point2D.Double(8.9, 8),
					new Point2D.Double(12, 9)};
		FindClosePoints.findClosePoints(array);
	}
}
