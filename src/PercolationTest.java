import static org.junit.Assert.*;

import org.junit.Test;


public class PercolationTest {

	@Test
	public void xyTo1D() {
		
		Percolation p = new Percolation(2);
		
		assertEquals(3, p.xyTo1D(1, 1));
		assertEquals(0, p.xyTo1D(0, 0));
		assertEquals(1, p.xyTo1D(0, 1));
		assertEquals(2, p.xyTo1D(1, 0));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void validateRange() {
		
		Percolation p = new Percolation(2);
				
		p.validatIndices(2,2);		
	}
	
	
	@Test
	public void openSite_shouldBe_open() {
		
		Percolation p = new Percolation(2);
		
		p.open(2, 2);
		
		assertTrue(p.isOpen(2, 2));
		assertFalse(p.isOpen(1, 1));
		assertFalse(p.isOpen(1, 2));
		assertFalse(p.isOpen(2, 1));
	}
	
	@Test
	public void should_percolate() {
		
		Percolation p = new Percolation(2);
		
		p.open(1, 2);
		p.open(2, 2);
		
		assertTrue(p.percolates());		
	}
	
	@Test
	public void should_not_percolate() {
		
		Percolation p = new Percolation(2);
		
		p.open(1, 1);
		p.open(1, 2);
		
		assertFalse(p.percolates());		
	}
	
	
	

}
