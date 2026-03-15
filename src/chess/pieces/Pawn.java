package chess.pieces;

import boardgame.Position;
import boardgame.SkateBoard;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
	private ChessMatch chessMatch;

	public Pawn(SkateBoard board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position vanguardPawn = new Position(0, 0);

		if (getColor() == Color.WHITE) {
			vanguardPawn.setValues(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(vanguardPawn) && !getBoard().thereIsAPiece(vanguardPawn)) {
				matrix[vanguardPawn.getRow()][vanguardPawn.getColumn()] = true;
			}
			vanguardPawn.setValues(position.getRow() - 2, position.getColumn());

			Position x2 = new Position(position.getRow() - 1, position.getColumn());

			if (getBoard().positionExists(vanguardPawn) && !getBoard().thereIsAPiece(vanguardPawn)
					&& getBoard().positionExists(x2) && !getBoard().thereIsAPiece(x2) && getMoveCount() == 0) { // FIX
				matrix[vanguardPawn.getRow()][vanguardPawn.getColumn()] = true;
			}
			vanguardPawn.setValues(position.getRow() - 1, position.getColumn() - 1);
			if (getBoard().positionExists(vanguardPawn) && isThereOpponentPiece(vanguardPawn)) {
				matrix[vanguardPawn.getRow()][vanguardPawn.getColumn()] = true;
			}
			vanguardPawn.setValues(position.getRow() - 1, position.getColumn() + 1);
			if (getBoard().positionExists(vanguardPawn) && isThereOpponentPiece(vanguardPawn)) {
				matrix[vanguardPawn.getRow()][vanguardPawn.getColumn()] = true;
			}
			// specialmove En Passant White
			if (position.getRow() == 3) {

				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if (getBoard().positionExists(left) && isThereOpponentPiece(left)
						&& getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {

					matrix[left.getRow() - 1][left.getColumn()] = true;
				}

				Position right = new Position(position.getRow(), position.getColumn() + 1);
				if (getBoard().positionExists(right) && isThereOpponentPiece(right)
						&& getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
					matrix[right.getRow() - 1][right.getColumn()] = true;
				}
			}
		} else {
			vanguardPawn.setValues(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(vanguardPawn) && !getBoard().thereIsAPiece(vanguardPawn)) {
				matrix[vanguardPawn.getRow()][vanguardPawn.getColumn()] = true;
			}
			vanguardPawn.setValues(position.getRow() + 2, position.getColumn());
			Position x2 = new Position(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(vanguardPawn) && !getBoard().thereIsAPiece(vanguardPawn)
					&& getBoard().positionExists(x2) && !getBoard().thereIsAPiece(x2) && getMoveCount() == 0) {
				matrix[vanguardPawn.getRow()][vanguardPawn.getColumn()] = true;
			}
			vanguardPawn.setValues(position.getRow() + 1, position.getColumn() - 1);
			if (getBoard().positionExists(vanguardPawn) && isThereOpponentPiece(vanguardPawn)) {
				matrix[vanguardPawn.getRow()][vanguardPawn.getColumn()] = true;
			}
			vanguardPawn.setValues(position.getRow() + 1, position.getColumn() + 1);
			if (getBoard().positionExists(vanguardPawn) && isThereOpponentPiece(vanguardPawn)) {
				matrix[vanguardPawn.getRow()][vanguardPawn.getColumn()] = true;
			}

			// specialmove En Passant Black
			if (position.getRow() == 4) {
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if (getBoard().positionExists(left) && isThereOpponentPiece(left)
						&& getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
					matrix[left.getRow() + 1][left.getColumn()] = true; // FIX
				}
				Position right = new Position(position.getRow(), position.getColumn() + 1);
				if (getBoard().positionExists(right) && isThereOpponentPiece(right)
						&& getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {

					matrix[right.getRow() + 1][right.getColumn()] = true;
				}
			}
		}
		return matrix;
	}

	@Override
	public String toString() {
		return "P";
	}
}