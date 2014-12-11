public class Triangle {
	public static void main(String[] args) {
		Point p1, p2, p3;
		int numPoints = 0;
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		
		p1 = new Point(scanner.nextDouble(), scanner.nextDouble());
		p2 = new Point(scanner.nextDouble(), scanner.nextDouble());
		p3 = new Point(scanner.nextDouble(), scanner.nextDouble());
		numPoints = scanner.nextInt();
		
		for(int i = 0; i < numPoints; i++) {
			System.out.println(
				(pointInTriangle(
					new Point(scanner.nextDouble(), scanner.nextDouble()), 
					p1, 
					p2, 
					p3)) ? "YES" : "NO");
		}
	}
	
	private static double sign (Point p1, Point p2, Point p3) {
		return (p1.x - p3.x) * (p2.y - p3.y) - (p2.x - p3.x) * (p1.y - p3.y);
	}

	private static boolean pointInTriangle (Point pt, Point v1, Point v2, Point v3) {
		boolean b1, b2, b3;

		b1 = sign(pt, v1, v2) < 0.0f;
		b2 = sign(pt, v2, v3) < 0.0f;
		b3 = sign(pt, v3, v1) < 0.0f;

		return ((b1 == b2) && (b2 == b3));
	}
}

class Point {
		public double x;
		public double y;
		
		public Point() {
			this(0, 0);
		}
		
		public Point(double a, double b) {
			x = a;
			y = b;
		}
	}