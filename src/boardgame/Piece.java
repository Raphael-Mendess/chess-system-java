package boardgame;

public abstract class Piece {
	protected Position position;
	private SkateBoard board;

	public Piece(SkateBoard board) {
		this.board = board;
		position = null;
	}

	protected SkateBoard getBoard() {
		return board;
	}
	
	public abstract boolean [][] possibleMoves();
	
	public boolean possibleMoves(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	public boolean isThereAnyPossibleMove() {
		boolean [][] matriz = possibleMoves();
		
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz.length; j++) {
				if(matriz[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
}
