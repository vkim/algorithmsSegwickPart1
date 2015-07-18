import static org.junit.Assert.*;

import org.junit.Test;


public class PercolationStatsTest {

	@Test
	public void test() {
		
		PercolationStats stats = new PercolationStats(200, 100);
		
		System.out.printf("Mean: %s \n", stats.mean());
		System.out.printf("stddev: %s", stats.stddev());
	}

}
