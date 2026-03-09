package chess.pieces;

import boardgame.Position;
import boardgame.SkateBoard;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
	public Pawn(SkateBoard board, Color color) {
		super(board, color);
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position VanguardPawn = new Position(0, 0);

		if (getColor() == Color.WHITE) {
			VanguardPawn.setValues(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(VanguardPawn) && !getBoard().thereIsAPiece(VanguardPawn)){
				matrix[VanguardPawn.getRow()][VanguardPawn.getColumn()] = true;
			}
			VanguardPawn.setValues(position.getRow() - 2, position.getColumn());
			Position x2 = new Position(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(VanguardPawn) && !getBoard().thereIsAPiece(VanguardPawn) && getBoard().positionExists(x2) && !getBoard().thereIsAPiece(VanguardPawn) && getMoveCount() == 0){ 
					matrix[VanguardPawn.getRow()][VanguardPawn.getColumn()] = true;
			}	
			VanguardPawn.setValues(position.getRow() - 1, position.getColumn() - 1);
			if (getBoard().positionExists(VanguardPawn) && isThereOpponentPiece(VanguardPawn)){
				matrix[VanguardPawn.getRow()][VanguardPawn.getColumn()] = true;
			}
			VanguardPawn.setValues(position.getRow() - 1, position.getColumn() + 1);
			if (getBoard().positionExists(VanguardPawn) && isThereOpponentPiece(VanguardPawn)){
				matrix[VanguardPawn.getRow()][VanguardPawn.getColumn()] = true;
		    }
		}
		else {
			VanguardPawn.setValues(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(VanguardPawn) && !getBoard().thereIsAPiece(VanguardPawn)){
				matrix[VanguardPawn.getRow()][VanguardPawn.getColumn()] = true;
			}
			VanguardPawn.setValues(position.getRow() + 2, position.getColumn());
			Position x2 = new Position(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(VanguardPawn) && !getBoard().thereIsAPiece(VanguardPawn) && getBoard().positionExists(x2) && !getBoard().thereIsAPiece(VanguardPawn) && getMoveCount() == 0){ 
					matrix[VanguardPawn.getRow()][VanguardPawn.getColumn()] = true;
			}	
			VanguardPawn.setValues(position.getRow() + 1, position.getColumn() - 1);
			if (getBoard().positionExists(VanguardPawn) && isThereOpponentPiece(VanguardPawn)){
				matrix[VanguardPawn.getRow()][VanguardPawn.getColumn()] = true;
			}
			VanguardPawn.setValues(position.getRow() + 1, position.getColumn() + 1);
			if (getBoard().positionExists(VanguardPawn) && isThereOpponentPiece(VanguardPawn)){
				matrix[VanguardPawn.getRow()][VanguardPawn.getColumn()] = true;
		    }
		} 		
		return matrix;
	}
	
	@Override
	public String toString() {
		return "P";
	}
}