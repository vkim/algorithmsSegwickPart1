import java.util.Arrays;



public class Board {
	
	private int[][] blocks;
	int movesMade = 0;
	int N;
	
	/**
	 * 
	 * int[][] - x - first dimention, y - second
	 * (where blocks[i][j] = block in row i, column j)
	 * 
	 * @param blocks
	 */
    public Board(int[][] blocks) {           // construct a board from an N-by-N array of blocks
    	 this.blocks = blocks;
    	 this.N = blocks[0].length;
    }
                                           
    public int dimension() {                 // board dimension N
    	return blocks[0].length;
    }
    
    public int hamming() {                   // number of blocks out of place
    	
    	int count=0, index=1;
    	for(int i=0;i<blocks[0].length;i++) {
    		for(int j=0;j<blocks[0].length;j++) {
    			
    			if(blocks[i][j] != index) count++;
    			
    			index++;    			
    		}
    	}
    	
    	return count;
    }
    
    public int manhattan() {                 // sum of Manhattan distances between blocks and goal
    	
    	int count=0;
    	
    	for(int i=0;i<blocks[0].length;i++) {
    		for(int j=0;j<blocks[0].length;j++) {
    			
    			
    			int x = Math.abs(i - ((blocks[i][j]-1) / dimension()));
    			
    			int y = Math.abs(j - ((blocks[i][j]-1) % dimension()));
    			
    			count += x + y;
    		}
    	}
    	
    	return count + movesMade;    	
    }
    
    public boolean isGoal() {                // is this board the goal board?
    	
    	
    	return hamming() == 0;    	
    }
    
    public Board twin() {                    // a board that is obtained by exchanging two adjacent blocks in the same row
    	
    	int[][] tBoard = new int[dimension()][dimension()];  
    	
    	for(int i=0;i<dimension();i++) {
    		tBoard[i] = Arrays.copyOf(blocks[i], dimension());
    	}
    	
    	int temp = tBoard[0][0]; 
    	tBoard[0][0] = tBoard[0][1];
    	tBoard[0][1] = temp;
    	
    	return new Board(tBoard);
    }
    
    public boolean equals(Object x) {        // does this board equal y?
    	
    	if (x == this) return true;
        if (x == null) return false;
        if (x.getClass() != this.getClass()) return false;
        
        Board that = (Board) x;
        
        if(that.blocks[0].length != this.blocks[0].length) return false;
    	if(that.blocks.length != this.blocks.length) return false;
        
    	
    	for(int i=0;i<blocks[0].length;i++) {
    		for(int j=0;j<blocks[0].length;j++) {
    			if(blocks[i][j] != that.blocks[i][j]) return false;
    		}
    	}
    	
    	return true;       
    }
    
    public Iterable<Board> neighbors() {     // all neighboring boards
    	
    	
    	return new Stack<Board>();   	
    }
    
    public String toString()  {              // string representation of this board (in the output format specified below)
    	
    	StringBuilder s = new StringBuilder();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", blocks[i][j]));
            }
            s.append("\n");
        }
        
        return s.toString();  	
    }

    public static void main(String[] args)  {// unit tests (not graded)
    	
    }
    
}