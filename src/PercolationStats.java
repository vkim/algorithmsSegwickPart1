import java.util.Arrays;


public class PercolationStats {
	
	double[] x;
	int N, T;
	
   public PercolationStats(int N, int T) {     // perform T independent experiments on an N-by-N grid
	   
	   if(N <= 0) throw new java.lang.IllegalArgumentException("Out of bound range");
	   if(T <= 0) throw new java.lang.IllegalArgumentException("Out of bound range");
	   
	   this.N = N;
	   this.T = T;
	   
	   x = new double[T];
	   
	   
	   for(int i=0;i<T;i++) {
	   	
	   		x[i] = (double)runExperiment() / (N*N);
   		}
   		
   		StdRandom.setSeed(1);
   		System.out.println("x: " + Arrays.toString(x));	   
   }
   
   int runExperiment() {
   	
   		Percolation percolation = new Percolation(N);
   		
   		int counter = 0;
   	
   		while(!percolation.percolates()) {
   			
   			int i = StdRandom.uniform(1, N+1);
   			int j = StdRandom.uniform(1, N+1);
   			
   			if(!percolation.isOpen(i, j)) {

   				percolation.open(i, j);
   				
   				counter++;
   			}  			
   		}
   		
   		return counter;   	
   }
   
   public double mean() {                      // sample mean of percolation threshold
	   
	   double sum = 0;
	   for(double i : x) {
		   sum += i;
	   }
	   
	   return sum/x.length;
   }
   
   public double stddev() {                    // sample standard deviation of percolation threshold
	   
	   double sum = 0d;
	   
	   double m = mean();
	   
	  for(double i : x) {
		  sum += Math.pow(i-m, 2);
	  }

	  return Math.sqrt(sum/(T-1));
   }
   
   public double confidenceLo() {              // low  endpoint of 95% confidence interval

	   return mean() - ((1.96d*stddev()) / Math.sqrt(T));
   }
   
   public double confidenceHi() {              // high endpoint of 95% confidence interval
	   return mean() + ((1.96d*stddev()) / Math.sqrt(T));
   }

   public static void main(String[] args) {   // test client (described below)
	   
   }
}