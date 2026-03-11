package chess.pieces;

import boardgame.SkateBoard;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {

	public Knight(SkateBoard board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "C";
	}

	private boolean canMove(Position position) {
		ChessPiece pieceObject = (ChessPiece) getBoard().piece(position);
		return pieceObject == null || pieceObject.getColor() != getColor();
	}

	@Override //This was hard working kkkkkkkkkkk
	public boolean[][] possibleMoves() {

		boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position deathHorse = new Position(0, 0);

		deathHorse.setValues(position.getRow() - 1, position.getColumn() - 2);
		if (getBoard().positionExists(deathHorse) && canMove(deathHorse)) {
			matrix[deathHorse.getRow()][deathHorse.getColumn()] = true;
		}

		deathHorse.setValues(position.getRow() - 2, position.getColumn() - 1);
		if (getBoard().positionExists(deathHorse) && canMove(deathHorse)) {
			matrix[deathHorse.getRow()][deathHorse.getColumn()] = true;
		}

		deathHorse.setValues(position.getRow() - 2, position.getColumn() + 1);
		if (getBoard().positionExists(deathHorse) && canMove(deathHorse)) {
			matrix[deathHorse.getRow()][deathHorse.getColumn()] = true;
		}

		deathHorse.setValues(position.getRow() - 1, position.getColumn() + 2);
		if (getBoard().positionExists(deathHorse) && canMove(deathHorse)) {
			matrix[deathHorse.getRow()][deathHorse.getColumn()] = true;
		}

		deathHorse.setValues(position.getRow() + 1, position.getColumn() + 2);
		if (getBoard().positionExists(deathHorse) && canMove(deathHorse)) {
			matrix[deathHorse.getRow()][deathHorse.getColumn()] = true;
		}

		deathHorse.setValues(position.getRow() + 2, position.getColumn() + 1);
		if (getBoard().positionExists(deathHorse) && canMove(deathHorse)) {
			matrix[deathHorse.getRow()][deathHorse.getColumn()] = true;
		}

		deathHorse.setValues(position.getRow() + 2, position.getColumn() - 1);
		if (getBoard().positionExists(deathHorse) && canMove(deathHorse)) {
			matrix[deathHorse.getRow()][deathHorse.getColumn()] = true;
		}

		deathHorse.setValues(position.getRow() + 1, position.getColumn() - 2);
		if (getBoard().positionExists(deathHorse) && canMove(deathHorse)) {
			matrix[deathHorse.getRow()][deathHorse.getColumn()] = true;
		}

		return matrix;
	}
}