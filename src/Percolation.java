

public class Percolation {
   
	
	private WeightedQuickUnionUF unionF;
	boolean[][] table;
	private int N; 
	int top, bottom;

	public Percolation(int N) { // create N-by-N grid, with all sites blocked
		
		unionF = new WeightedQuickUnionUF(N*N+2);		
		this.N = N;
		table = new boolean[N][N];
		top = N*N;
		bottom = top+1;
		
		//connect top and bottom		
		for(int i=0;i<N;i++) {
			unionF.union(xyTo1D(0, i), top);
			unionF.union(xyTo1D(N-1, i), bottom);
		}
		
	}
	
	int xyTo1D(int x, int y) {
		
		return x * N + y;
	}

	void validatIndices(int x, int y) {
		
		if(! isValid(x, y))  throw new IndexOutOfBoundsException("Indexes out of bounds: x = " + x + ", y = " + y );
	}
	
	private boolean isValid(int x, int y) {
		
		if (x < 0 || x >= N) return false; 
		if (y < 0 || y >= N) return false;
		
		return true;
	}
	
   public void open(int i, int j)  {         // open site (row i, column j) if it is not open already
	   
	   int x = i-1, y = j-1;
	   
	   validatIndices(x, y);
	   
	   //open only if it was closed 
	   if(!isOpen(i, j)) {
	   
	   		table[x][y] = true;
	   
	   		connectFourCorners(x,y); 	
	   }
	   
   }
   
   void connectFourCorners(int x, int y) {
	   
	   if(isValid(x-1, y) && isOpenXY(x-1, y)) {
		   unionF.union(xyTo1D(x-1, y), xyTo1D(x, y));
	   }
	   
	   if(isValid(x+1, y) && isOpenXY(x+1, y)) {
		   unionF.union(xyTo1D(x+1, y), xyTo1D(x, y));
	   }
	   
	   if(isValid(x, y-1) && isOpenXY(x, y-1)) {
		   unionF.union(xyTo1D(x, y-1), xyTo1D(x, y));
	   }
	   
	   if(isValid(x, y+1) && isOpenXY(x, y+1)) {
		   unionF.union(xyTo1D(x, y+1), xyTo1D(x, y));
	   }
	   
   }
   
   
   public boolean isOpen(int i, int j)  {    // is site (row i, column j) open?
	   
	   int x = i-1, y = j-1;
	   
	   return isOpenXY(x, y);
   }
   
   boolean isOpenXY(int x, int y) {
	   validatIndices(x,y);
	   
	   return table[x][y];
   }
   
   public boolean isFull(int i, int j) {     // is site (row i, column j) full?
	   
	   if(! isOpen(i,j)) return false;
	   
	   return unionF.connected(xyTo1D(i-1, j-1), top);
   }
   
   public boolean percolates() {             // does the system percolate?
  
	   return unionF.connected(top, bottom);
   }

   public static void main(String[] args) {   // test client (optional)
	   
   }
}