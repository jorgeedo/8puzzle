
public class Board {
	//private final int[][] blocks;
	private final int[] blocks;
	private final int N;
	private final int NxN;
	
	// construct a board from an N-by-N array of blocks
    // (where blocks[i][j] = block in row i, column j)
	public Board(int[][] blocks){
		int ii;
		this.N = blocks.length;
		this.NxN = this.N * this.N;
		
		this.blocks = new int[N*N];
		
		ii = 0;		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++){
				//StdOut.println(blocks[i][j]);
				this.blocks[ii++] = blocks[i][j];
			}
				//this.blocks[i][j] = blocks[i][j];
		}
	}
	
	// board dimension N
    public int dimension() {
    	return N;
    }
    
 // number of blocks out of place
    /*public int hamming() {
    	
    }*/
    
 // sum of Manhattan distances between blocks and goal
    /*public int manhattan() {
    	
    }*/
    
 // is this board the goal board?
    public boolean isGoal() {
    	int i = 0;
    	
    	while (i < NxN && blocks[i] == i+1) i++;
    	
    	StdOut.println("Break: " + i + " block " + blocks[i]);
    	
    	if (i >= NxN - 1) return true;
    	else return false;    			
    	
    }
    
    private Board(int [] blocks, int N) {
    	this.N = N;
    	this.NxN = N*N;
    	
    	this.blocks = new
    	for (int i = 0; i < this.N; i++)
    		
    }
    
    // a board obtained by exchanging two adjacent blocks in the same row
    public Board twin() {
    	Board twinBoard = new Board();
    	
    }
    
    // does this board equal y?
    public boolean equals(Object y) {
    	Board that = (Board)y;
    
    	if (this == y) return true;
    	
    	int i = 0;
    	while (i < NxN && blocks[i] == that.blocks[i]) i++;

    	if (i == NxN) return true;
    	else return false;
      	
    }
    
    // all neighboring boards
    /*public Iterable<Board> neighbors() {
    	
    	
    }*/
    
    // string representation of the board (in the output format specified below)
    public String toString() {
    	StringBuilder s = new StringBuilder();
        s.append(N + "\n");
        int ii = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", blocks[ii++]));
            }
            s.append("\n");
        }
        return s.toString();
    }
    
    public static void main(String[] args) {
    	int N = 3;
    	int [][] blocks = {{1,2,3},{4,5,6},{7,8,0}};
    	
    	Board myBoard = new Board(blocks);
    	
    	int [][] blocks2 = {{1,2,3},{4,5,6},{8,7,0}};
    	Board myBoard2 = new Board(blocks2);
    	
    	StdOut.println(myBoard);
    	
    	StdOut.println(myBoard.isGoal());
    	
    	StdOut.println(myBoard.equals(myBoard));
    	StdOut.println(myBoard.equals(myBoard2));
    	
    	
    	
    }
}
