import java.util.Arrays;

public class Fast {

public static void main(String[] args) {
	   
		// rescale coordinates and turn on animation mode
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);
        StdDraw.setPenRadius(0.01);  // make the points a bit larger

        // read in the input
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        
        Point[] points = new Point[N];
        
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            Point p = new Point(x, y);
            p.draw();
            
            points[i] = p;
        }

       	Arrays.sort(points);
       	
       	for (int i = 0; i < N-1; i++) {

       		Point[] tmpPoints = Arrays.copyOf(points, points.length);
       		
       		Arrays.sort(tmpPoints, points[i].SLOPE_ORDER);
       		
       		checkIfAnyPointsHaveEqualSlopes(points[i], tmpPoints);       		
       	}
       	
     // display to screen all at once
        StdDraw.show(0);
        
        // reset the pen radius
        StdDraw.setPenRadius();
   }

	private static void checkIfAnyPointsHaveEqualSlopes(Point i, Point[] tmpPoints) {
		
		int count=0;
		
		for(int j = 0; j<tmpPoints.length-1;j++) {
			
			if(i.slopeTo(tmpPoints[j]) == i.slopeTo(tmpPoints[j+1])) {
				count++;
			}
			else {
				
				//more than 3 adjacent points
				if(count > 1 ) {
					
					System.out.printf("tmpPoints = %s, j=%s, count=%s", Arrays.toString(tmpPoints), j, count);
					
					Arrays.sort(tmpPoints, j-count-1,j);
					
					//if i is the first in the line
					if(i.compareTo(tmpPoints[j-count-1])>0) {
						printLine(j-count-1, j, tmpPoints, i);
					}
				}
				
				count = 0;
			}
		}
		
	}

	private static void printLine(int i, int j, Point[] tmpPoints, Point first) {
		
		for(int a=i;a<j-1;a++) {
			StdOut.print(tmpPoints[a] + " -> ");
		}
		
		StdOut.println(tmpPoints[j-1]);
		
		first.drawTo(tmpPoints[j-1]);	
	}
	
	
}


