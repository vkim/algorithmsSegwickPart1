import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
		
		ArrayList<Point> buff = new ArrayList<Point>();
		
		for(int j = 1; j<tmpPoints.length;j++) {
			
			//look behind
			if(i.slopeTo(tmpPoints[j-1]) == i.slopeTo(tmpPoints[j])) {
				if(buff.isEmpty()) {
					buff.add(tmpPoints[j-1]);
					buff.add(tmpPoints[j]); 
				}
				else {
					buff.add(tmpPoints[j]);
				}
				
			}
			else {
				
				//more than 3 adjacent points
				if(buff.size() > 2 ) {
					
					buff.add(i);
					
					Collections.sort(buff);
					
					//if i is the first in the line
					if(buff.get(0) == i) {
						printLine(buff);
					}
				}
				
				buff.clear();
			}
		}
		
		//more than 3 adjacent points
		if(buff.size() > 2 ) {
			
			buff.add(i);
			
			Collections.sort(buff);
			
			//if i is the first in the line
			if(buff.get(0) == i) {
				printLine(buff);
			}
		}
	}

	private static void printLine(ArrayList<Point> line) {

		for(int i = 0; i< line.size()-1;i++) {
			StdOut.print(line.get(i) + " -> ");
		}
		
		StdOut.println(line.get(line.size()-1));
		
		line.get(0).drawTo(line.get(line.size()-1));	
	}
	
	
}


