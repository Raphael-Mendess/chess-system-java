package chess.pieces;

import boardgame.SkateBoard;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {	
	public Bishop(SkateBoard board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "B";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matriz = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position bishopChurch = new Position(0, 0);

		// nw
		bishopChurch.setValues(position.getRow() - 1, position.getColumn()-1);
		while (getBoard().positionExists(bishopChurch) && !getBoard().thereIsAPiece(bishopChurch)) {
			matriz[bishopChurch.getRow()][bishopChurch.getColumn()] = true;
			bishopChurch.setValues(bishopChurch.getRow() - 1, bishopChurch.getColumn() - 1);
		}
		if (getBoard().positionExists(bishopChurch) && isThereOpponentPiece(bishopChurch)) {
			matriz[bishopChurch.getRow()][bishopChurch.getColumn()] = true;
		}		
		// ne
		bishopChurch.setValues(position.getRow() - 1, position.getColumn() + 1);
		while (getBoard().positionExists(bishopChurch) && !getBoard().thereIsAPiece(bishopChurch)) {
			matriz[bishopChurch.getRow()][bishopChurch.getColumn()] = true;
			bishopChurch.setValues(bishopChurch.getRow() - 1, bishopChurch.getColumn() + 1);
		}
		if (getBoard().positionExists(bishopChurch) && isThereOpponentPiece(bishopChurch)) {
			matriz[bishopChurch.getRow()][bishopChurch.getColumn()] = true;
		}
		// se
		bishopChurch.setValues(position.getRow() + 1, position.getColumn() + 1);
		while (getBoard().positionExists(bishopChurch) && !getBoard().thereIsAPiece(bishopChurch)) {
			matriz[bishopChurch.getRow()][bishopChurch.getColumn()] = true;
			bishopChurch.setValues(bishopChurch.getRow() +1, bishopChurch.getColumn() + 1);
		}
		if (getBoard().positionExists(bishopChurch) && isThereOpponentPiece(bishopChurch)) {
			matriz[bishopChurch.getRow()][bishopChurch.getColumn()] = true;
		}
		// sw
		bishopChurch.setValues(position.getRow() + 1, position.getColumn() - 1);
		while (getBoard().positionExists(bishopChurch) && !getBoard().thereIsAPiece(bishopChurch)) {
			matriz[bishopChurch.getRow()][bishopChurch.getColumn()] = true;
			bishopChurch.setValues(bishopChurch.getRow() + 1, bishopChurch.getColumn() - 1);
		}
		if (getBoard().positionExists(bishopChurch) && isThereOpponentPiece(bishopChurch)) {
			matriz[bishopChurch.getRow()][bishopChurch.getColumn()] = true;
		}		
		return matriz;
		}
}
