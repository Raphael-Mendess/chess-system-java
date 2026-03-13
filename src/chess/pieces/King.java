package chess.pieces;

import boardgame.Position;
import boardgame.SkateBoard;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	private ChessMatch chessMatch;

	public King(SkateBoard board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(Position position) {
		ChessPiece pieceObject = (ChessPiece) getBoard().piece(position);
		return pieceObject == null || pieceObject.getColor() != getColor();
	}

	private boolean testRookCastling(Position x) {
		ChessPiece y = (ChessPiece) getBoard().piece(x);
		return y != null && y instanceof Rook && y.getColor() == getColor() && y.getMoveCount() == 0;
	}

	@Override // This was hard working kkkkkkkkkkk
	public boolean[][] possibleMoves() {
		boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position positionOfPiece = new Position(0, 0);

		// above
		positionOfPiece.setValues(position.getRow() - 1, position.getColumn());
		if (getBoard().positionExists(positionOfPiece) && canMove(positionOfPiece)) {
			matrix[positionOfPiece.getRow()][positionOfPiece.getColumn()] = true;
		}

		// below
		positionOfPiece.setValues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExists(positionOfPiece) && canMove(positionOfPiece)) {
			matrix[positionOfPiece.getRow()][positionOfPiece.getColumn()] = true;
		}

		// left
		positionOfPiece.setValues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExists(positionOfPiece) && canMove(positionOfPiece)) {
			matrix[positionOfPiece.getRow()][positionOfPiece.getColumn()] = true;
		}

		// right
		positionOfPiece.setValues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExists(positionOfPiece) && canMove(positionOfPiece)) {
			matrix[positionOfPiece.getRow()][positionOfPiece.getColumn()] = true;
		}

		// North(nw)
		positionOfPiece.setValues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExists(positionOfPiece) && canMove(positionOfPiece)) {
			matrix[positionOfPiece.getRow()][positionOfPiece.getColumn()] = true;
		}

		// North East(ne)
		positionOfPiece.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExists(positionOfPiece) && canMove(positionOfPiece)) {
			matrix[positionOfPiece.getRow()][positionOfPiece.getColumn()] = true;
		}

		// South West(sw)
		positionOfPiece.setValues(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExists(positionOfPiece) && canMove(positionOfPiece)) {
			matrix[positionOfPiece.getRow()][positionOfPiece.getColumn()] = true;
		}

		// South East(se)
		positionOfPiece.setValues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExists(positionOfPiece) && canMove(positionOfPiece)) {
			matrix[positionOfPiece.getRow()][positionOfPiece.getColumn()] = true;
		}

		// $specialmove castling
		if (getMoveCount() == 0 && !chessMatch.getCheck()) {
			// specialmove castling kingside rook
			Position rookOne = new Position(position.getRow(), position.getColumn() + 3);
			if (testRookCastling(rookOne)) {
				Position x1 = new Position(position.getRow(), position.getColumn() + 1);
				Position x2 = new Position(position.getRow(), position.getColumn() + 2);
				if (getBoard().piece(x1) == null && getBoard().piece(x2) == null) {
					matrix[position.getRow()][position.getColumn() + 2] = true;
				}
			}
			// specialmove castling queenside rook
			Position rookTwo = new Position(position.getRow(), position.getColumn() + 3);
			if (testRookCastling(rookTwo)) {
				Position x1 = new Position(position.getRow(), position.getColumn() - 1);
				Position x2 = new Position(position.getRow(), position.getColumn() - 2);
				Position x3 = new Position(position.getRow(), position.getColumn() - 3);
				if (getBoard().piece(x1) == null && getBoard().piece(x2) == null && getBoard().piece(x3) == null) {
					matrix[position.getRow()][position.getColumn() - 2] = true;
				}
			}	
		}
		return matrix;
	}
}
