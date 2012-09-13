import java.util.Iterator;


public class Board {
	private final int[][] blocks;
	private final int N;
	
	// construct a board from an N-by-N array of blocks
    // (where blocks[i][j] = block in row i, column j)
	public Board(int[][] blocks){
		this.N = blocks.length;
		
		this.blocks = new int[N][];

		for (int i = 0; i < N; i++) {
			this.blocks[i] = new int[N];
			for (int j = 0; j < N; j++)
				this.blocks[i][j] = blocks[i][j];
		}
	}
	
	// board dimension N
    public int dimension() {
    	return N;
    }
    
 // number of blocks out of place
    public int hamming() {
    	int ii = 1;
    	int sum = 0;
    	for (int i = 0;i < N;i++)
    		for (int j = 0;j < N;j++)
    			if (blocks[i][j] != ii++) sum++;
    	
    	if (blocks[i][j] == 0) sum--;
    	
    	return sum;    	
    	
    }
    
 // sum of Manhattan distances between blocks and goal
    private int manhattan(int x1, int y1, int x2, int y2) {
    	/*StdOut.println("manhattan between (" + x1 + "," + y1 + ") - ("
    			+ x2 + "," + y2 +"): " + (Math.abs(x2 - x1) + Math.abs(y2 - y1)));*/
    	return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }
    
    public int manhattan() {
    	int sum = 0;
    	int goalX, goalY;
    	int cell;
    	
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++) {
    			cell = blocks[i][j]-1;
    			goalX = cell / N;
    			goalY = cell % N; 
    			//StdOut.println(blocks[i][j] + ": " + goalX + "," + goalY);
    			if (cell != -1)
    				sum += manhattan(i, j, goalX, goalY);
    		}
    	}
    	
    	return sum;
    			
    	
    	
    }
    
 // is this board the goal board?
    public boolean isGoal() {
    	int i = 0, j = 0;
    	int ii = 1;
    	int NxN = N * N;
    	
    	while (i < N) {
    		j = 0;
    		while (j < N && ii < NxN) {
    			if (blocks[i][j] != ii) return false;
    			j++;
    			ii++;
    		}
    		i++;
    	}
    	
    	//if (i == N && j == N - 1) return true;
    	if (blocks[N-1][N-1] == 0) return true;
    	else return false;    	
    }
    
    private Board(int [][] blocks, int N) {
    	this.N = N;
    	
    	this.blocks = new int[this.N][];
    	for (int i = 0;i < this.N; i++) {
    		this.blocks[i] = new int[this.N];
    		for (int j = 0;j < this.N; j++)
    			this.blocks[i][j] = blocks[i][j];
    	} 
    		
    }
    
    private void exch(int x1, int y1, int x2, int y2) {
    	int aux = this.blocks[x1][y1];
    	this.blocks[x1][y1] = this.blocks[x2][y2];
    	this.blocks[x2][y2] = aux;
    }
    
    // a board obtained by exchanging two adjacent blocks in the same row
    public Board twin() {
    	Board twinBoard = new Board(this.blocks, this.N);
    	if (this.N > 2)
    		twinBoard.exch(0, 0, 0, 1);
    	
    	return twinBoard;
    	
    }
    
    // does this board equal y?
    public boolean equals(Object y) {
    	Board that = (Board)y;
    
    	if (this == y) return true;
    	
    	int i = 0, j = 0;
    	while (i < N) {
    		j = 0;
    		while (j < N){
    			if (blocks[i][j] != that.blocks[i][j]) return false;
    			j++;
    		}
    		i++;
    	}

    	return true;
      	
    }
    
    // all neighboring boards
    public Iterable<Board> neighbors() { return new NeighborIterable(); }
    
    private class NeighborIterable implements Iterable<Board>{
		@Override
		public Iterator<Board> iterator() {
			// TODO Auto-generated method stub
			return null;
		}    	
		
		private class NeighborIterator implements Iterator<Board> {

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Board next() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				
			}
			
		}
    }
    
    // string representation of the board (in the output format specified below)
    public String toString() {
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
    
    public static void main(String[] args) {
    	int N = 3;
    	int [][] blocks = {{1,2,3},{4,5,6},{7,8,0}};
    	
    	Board myBoard = new Board(blocks);
    	
    	int [][] blocks2 = {{1,2,3},{4,5,7},{8,6,0}};
    	Board myBoard2 = new Board(blocks2);
    	
    	StdOut.println(myBoard);
    	
    	StdOut.println(myBoard.isGoal());
    	
    	StdOut.println(myBoard.equals(myBoard));
    	StdOut.println(myBoard.equals(myBoard2));
    	
    	StdOut.println(myBoard2.manhattan());
    	
    	
    }
}
