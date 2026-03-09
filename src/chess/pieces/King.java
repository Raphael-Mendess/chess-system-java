package chess.pieces;

import boardgame.SkateBoard;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
	public King(SkateBoard board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(Position position) {
		ChessPiece pieceObject = (ChessPiece) getBoard().piece(position);
		return pieceObject == null || pieceObject.getColor() != getColor();
	}

	@Override  //This was hard working kkkkkkkkkkk 
	public boolean [][] possibleMoves(){
		boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position positionOfPiece = new Position(0, 0);
		
		//above
		positionOfPiece.setValues(position.getRow() - 1, position.getColumn());
		if(getBoard().positionExists(positionOfPiece) && canMove(positionOfPiece)) {
			matrix[positionOfPiece.getRow()] [positionOfPiece.getColumn()] = true;
		}
		
		//below
		positionOfPiece.setValues(position.getRow() + 1, position.getColumn());
		if(getBoard().positionExists(positionOfPiece) && canMove(positionOfPiece)) {
			matrix[positionOfPiece.getRow()] [positionOfPiece.getColumn()] = true;
		}
		
		//left
		positionOfPiece.setValues(position.getRow(), position.getColumn() - 1);
		if(getBoard().positionExists(positionOfPiece) && canMove(positionOfPiece)) {
			matrix[positionOfPiece.getRow()] [positionOfPiece.getColumn()] = true;
		}

		//right
		positionOfPiece.setValues(position.getRow(), position.getColumn() + 1);
		if(getBoard().positionExists(positionOfPiece) && canMove(positionOfPiece)) {
			matrix[positionOfPiece.getRow()] [positionOfPiece.getColumn()] = true;
		}
		
		//North(nw)
		positionOfPiece.setValues(position.getRow() - 1, position.getColumn() - 1);
		if(getBoard().positionExists(positionOfPiece) && canMove(positionOfPiece)) {
			matrix[positionOfPiece.getRow()] [positionOfPiece.getColumn()] = true;
		}
		
		//North East(ne)
		positionOfPiece.setValues(position.getRow() - 1, position.getColumn() + 1);
		if(getBoard().positionExists(positionOfPiece) && canMove(positionOfPiece)){
			matrix[positionOfPiece.getRow()] [positionOfPiece.getColumn()] = true;
		}
		
		//South West(sw)
		positionOfPiece.setValues(position.getRow() + 1, position.getColumn() - 1);
		if(getBoard().positionExists(positionOfPiece) && canMove(positionOfPiece)){
			matrix[positionOfPiece.getRow()] [positionOfPiece.getColumn()] = true;
		}
		
		//South East(se)
		positionOfPiece.setValues(position.getRow() + 1, position.getColumn() + 1);
		if(getBoard().positionExists(positionOfPiece) && canMove(positionOfPiece)){
		  matrix[positionOfPiece.getRow()] [positionOfPiece.getColumn()] = true;
		}
		
		return matrix;
	}
}
