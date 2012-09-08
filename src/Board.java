
public class Board {
	private final int[][] blocks;
	
	// construct a board from an N-by-N array of blocks
    // (where blocks[i][j] = block in row i, column j)
	public Board(int[][] blocks){
		this.blocks = new int[blocks.length][];
		for (int i = 0; i < blocks.length; i++) {
			this.blocks[i] = new int[blocks[i].length];
			for (int j = 0; j < blocks[i].length; j++)
				this.blocks[i][j] = blocks[i][j];
		}
	}
		
	// board dimension N
    public int dimension() {
    	return blocks.length;
    }
    
 // number of blocks out of place
    public int hamming() {
    	
    }
    
 // sum of Manhattan distances between blocks and goal
    public int manhattan() {
    	
    }
    
 // is this board the goal board?
    public boolean isGoal() {
    	
    	
    }
    
    // a board obtained by exchanging two adjacent blocks in the same row
    public Board twin() {
    	
    }
    
    // does this board equal y?
    public boolean equals(Object y) {
    	
    	
      	
    }
    
    // all neighboring boards
    public Iterable<Board> neighbors() {
    	
    	
    }
    
    // string representation of the board (in the output format specified below)
    public String toString() {
    	
    }
}
