import java.util.Arrays;
import java.util.Comparator;


public class Brute {
   
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
		
        
        for (int i = 0; i < N; i++) {
        	for (int j = i+1; j < N; j++) {
        		for (int k = j+1; k < N; k++) {
        			for (int y = k+1; y < N; y++) {
        			
        				Point a = points[i]; 
        				Point b = points[j]; 
        				Point c = points[k]; 
        				Point d = points[y]; 
        				
        				if(a.slopeTo(b) == a.slopeTo(c) && a.slopeTo(c) == a.slopeTo(d)) {
        					StdOut.println(a + " -> " + b + " -> " + c + " -> " + d);
        					a.drawTo(d);
        				}
        			}
        		}
        	}
        }
    
     // display to screen all at once
        StdDraw.show(0);
        
        // reset the pen radius
        StdDraw.setPenRadius();
   }
}
