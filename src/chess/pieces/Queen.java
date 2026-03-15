package chess.pieces;

import boardgame.SkateBoard;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {
	public Queen(SkateBoard board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "Q";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matriz = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position queen = new Position(0, 0);

		// above
		queen.setValues(position.getRow() - 1, position.getColumn());
		while (getBoard().positionExists(queen) && !getBoard().thereIsAPiece(queen)) {
			matriz[queen.getRow()][queen.getColumn()] = true;
			queen.setRow(queen.getRow() - 1);
		}
		if (getBoard().positionExists(queen) && isThereOpponentPiece(queen)) {
			matriz[queen.getRow()][queen.getColumn()] = true;
		}
		// below
		queen.setValues(position.getRow() + 1, position.getColumn());
		while (getBoard().positionExists(queen) && !getBoard().thereIsAPiece(queen)) {
			matriz[queen.getRow()][queen.getColumn()] = true;
			queen.setRow(queen.getRow() + 1);
		}
		if (getBoard().positionExists(queen) && isThereOpponentPiece(queen)) {
			matriz[queen.getRow()][queen.getColumn()] = true;
		}
		// left
		queen.setValues(position.getRow(), position.getColumn() - 1);
		while (getBoard().positionExists(queen) && !getBoard().thereIsAPiece(queen)) {
			matriz[queen.getRow()][queen.getColumn()] = true;
			queen.setColumn(queen.getColumn() - 1);
		}
		if (getBoard().positionExists(queen) && isThereOpponentPiece(queen)) {
			matriz[queen.getRow()][queen.getColumn()] = true;
		}
		// right
		queen.setValues(position.getRow(), position.getColumn() + 1);
		while (getBoard().positionExists(queen) && !getBoard().thereIsAPiece(queen)) {
			matriz[queen.getRow()][queen.getColumn()] = true;
			queen.setColumn(queen.getColumn() + 1);
		}
		if (getBoard().positionExists(queen) && isThereOpponentPiece(queen)) {
			matriz[queen.getRow()][queen.getColumn()] = true;
		}
		// nw
		queen.setValues(position.getRow() - 1, position.getColumn() - 1);
		while (getBoard().positionExists(queen) && !getBoard().thereIsAPiece(queen)) {
			matriz[queen.getRow()][queen.getColumn()] = true;
			queen.setValues(queen.getRow() - 1, queen.getColumn() - 1);
		}
		if (getBoard().positionExists(queen) && isThereOpponentPiece(queen)) {
			matriz[queen.getRow()][queen.getColumn()] = true;
		}
		// ne
		queen.setValues(position.getRow() - 1, position.getColumn() + 1);
		while (getBoard().positionExists(queen) && !getBoard().thereIsAPiece(queen)) {
			matriz[queen.getRow()][queen.getColumn()] = true;
			queen.setValues(queen.getRow() - 1, queen.getColumn() + 1);
		}
		if (getBoard().positionExists(queen) && isThereOpponentPiece(queen)) {
			matriz[queen.getRow()][queen.getColumn()] = true;
		}
		// se
		queen.setValues(position.getRow() + 1, position.getColumn() + 1);
		while (getBoard().positionExists(queen) && !getBoard().thereIsAPiece(queen)) {
			matriz[queen.getRow()][queen.getColumn()] = true;
			queen.setValues(queen.getRow() + 1, queen.getColumn() + 1);
		}
		if (getBoard().positionExists(queen) && isThereOpponentPiece(queen)) {
			matriz[queen.getRow()][queen.getColumn()] = true;
		}
		// sw
		queen.setValues(position.getRow() + 1, position.getColumn() - 1);
		while (getBoard().positionExists(queen) && !getBoard().thereIsAPiece(queen)) {
			matriz[queen.getRow()][queen.getColumn()] = true;
			queen.setValues(queen.getRow() + 1, queen.getColumn() - 1);
		}
		if (getBoard().positionExists(queen) && isThereOpponentPiece(queen)) {
			matriz[queen.getRow()][queen.getColumn()] = true;
		}
		return matriz;
	}
}
