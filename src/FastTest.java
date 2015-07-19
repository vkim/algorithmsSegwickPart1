import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


public class FastTest {

	@Test
	public void test() {
		
		Point p1 = new Point(1,1);
		Point p2 = new Point(2,2);
		Point p3 = new Point(3,3);
		
		Point[] ar = new Point[] {p2, p3};
		
		Arrays.sort(ar, p1.SLOPE_ORDER);
		
		System.out.println(Arrays.toString(ar));
		
		//java -cp "*;bin/" Fast collinear/input6.txt
	}

}
