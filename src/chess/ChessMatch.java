package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import boardgame.Piece;
import boardgame.Position;
import boardgame.SkateBoard;
import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Rook; 

public class ChessMatch {	
	private int turn;
	private Color currentPlayer;
	private SkateBoard board;
	private boolean check;
	private boolean checkMate;
	
	private List<Piece> piecesOnTheWar = new ArrayList<>();
	private List<Piece> capturedPieces = new ArrayList<>();

	public ChessMatch() {
		board = new SkateBoard(8, 8);
		turn = 1;
		currentPlayer = Color.WHITE;
		check = false;
		initialSetup();
	}
	
	public int getTurn() {
		return turn;
	}
	
	public Color getcurrentPlayer() {
		return currentPlayer;
	}
	
	public boolean getCheck() {
		return check;
	}
	
	public boolean getCheckMate() {
		return checkMate;
	}

	public ChessPiece[][] getPieces() {
		ChessPiece[][] matrix = new ChessPiece[board.getRows()][board.getColumns()];
		
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				matrix[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return matrix;
	}
	
	public boolean[][] possibleMoves(ChessPosition sourcePosition){
		Position position  = sourcePosition.toPosition();
		validateSourcePosition(position);
		return board.piece(position).possibleMoves();
		
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position origin = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(origin); 
		validateTargetPosition(origin, target);
		Piece capturedPiece = makeMove(origin, target);
		
		if(testCheckKing(currentPlayer)) {
			cancelMove(origin,target,capturedPiece);
			throw new ChessException("You can't put yourself in check");
		}
		
		check = (testCheckKing(opponentRival(currentPlayer))) ? true:false;
		
		if(testCheckMate(opponentRival(currentPlayer))) {
			checkMate = true;
		}
		else {
			nextTurn();
		}	
		return (ChessPiece)capturedPiece;
	} 
	
	private Piece makeMove(Position origin, Position target) {
		ChessPiece x = (ChessPiece)board.removePiece(origin);
		x.increaseMoveCount();
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(x, target);
		
		if(capturedPiece != null) {
			piecesOnTheWar.remove(capturedPiece); 
			capturedPieces.add(capturedPiece);
		}
		return capturedPiece;
	}
	
	private void cancelMove(Position origin, Position target, Piece capturedPiece) {
		ChessPiece p = (ChessPiece)board.removePiece(target);
		p.decreaseMoveCount();
		board.placePiece(p,  origin);
		
		if(capturedPiece != null) {
			board.placePiece(capturedPiece, target);
			capturedPieces.remove(capturedPiece);
		}
	}
	
	private void validateSourcePosition(Position position) {
		if(!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece on source position"); 
		}
		if(currentPlayer != ((ChessPiece)board.piece(position)).getColor()) {
			throw new ChessException("The chosen piece is not yours");
		}
		if(!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for the chosen piece");
		}
	}

	private void validateTargetPosition(Position origin, Position target) {
		if(!board.piece(origin).possibleMoves(target)) {
			throw new ChessException("The chosen piece cannot move to target position");
		}
	}
	
	private void nextTurn() {
		turn++;
		currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}
	
	private Color opponentRival(Color color) {
		return (color == color.WHITE) ? Color.BLACK : Color.WHITE;
	}
	
	private ChessPiece kingOfBattle(Color color) {
		List<Piece> list = piecesOnTheWar.stream().filter(x -> ((ChessPiece)x).getColor() == color).collect(Collectors.toList());
		for(Piece p : list) {
			if(p instanceof King) {
				return (ChessPiece) p;
			}
		}
		throw new IllegalStateException("There no " + color + " king on the board");
	}
	
	private boolean testCheckKing(Color color) {
		Position kingPosition = kingOfBattle(color).getChessPosition().toPosition();
		
		List<Piece> opponentPieces = piecesOnTheWar.stream().filter(x -> ((ChessPiece)x).getColor() == opponentRival(color)).collect(Collectors.toList());
		
		for(Piece p : opponentPieces) {
			boolean[][] matrix = p.possibleMoves(); 
			if(matrix[kingPosition.getRow()][kingPosition.getColumn()]) {
				return true;
			}
		}
		return false;
	}
	
	private boolean testCheckMate(Color color) {
		if(!testCheckKing(color)) {
			return false;
		}
		List<Piece> list = piecesOnTheWar.stream()
				.filter(x -> ((ChessPiece)x).getColor() == (color))
				.collect(Collectors.toList());
		for(Piece p : list) {
			boolean[][] matrix = p.possibleMoves();
			for(int i = 0; i < board.getRows(); i++) {
				for(int j = 0; j < board.getColumns(); j++) {
					if(matrix[i][j] ) {
						Position source = ((ChessPiece)p).getChessPosition().toPosition();
						Position target = new Position(i,j);
						Piece capturedPiece = makeMove(source,target); 
						boolean testCheck = testCheckKing(color);
						cancelMove(source,target, capturedPiece);
						if(!testCheck) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
		piecesOnTheWar.add(piece); 
	}

	private void initialSetup() {
		placeNewPiece('a', 1, new Rook(board, Color.WHITE)); 
		placeNewPiece('b', 1, new Knight(board, Color.WHITE));
		placeNewPiece('c', 1, new Bishop(board, Color.WHITE)); 
		placeNewPiece('e', 1, new King(board, Color.WHITE));
        placeNewPiece('f', 1, new Bishop(board, Color.WHITE));        
        placeNewPiece('g', 1, new Knight(board, Color.WHITE));
        placeNewPiece('h', 1, new Rook(board, Color.WHITE));       
        placeNewPiece('a', 2, new Pawn(board, Color.WHITE)); 
        placeNewPiece('b', 2, new Pawn(board, Color.WHITE));   
        placeNewPiece('c', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('d', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('e', 2, new Pawn(board, Color.WHITE));        
        placeNewPiece('f', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('g', 2, new Pawn(board, Color.WHITE)); 
        placeNewPiece('h', 2, new Pawn(board, Color.WHITE));
        
        placeNewPiece('a', 8, new Rook(board, Color.BLACK));
        placeNewPiece('b', 8, new Knight(board, Color.BLACK));
        placeNewPiece('c', 8, new Bishop(board, Color.BLACK));
        placeNewPiece('e', 8, new King(board, Color.BLACK));
        placeNewPiece('f', 8, new Bishop(board, Color.BLACK));
        placeNewPiece('g', 8, new Knight(board, Color.BLACK));
        placeNewPiece('h', 8, new Rook(board, Color.BLACK));        
        placeNewPiece('a', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('b', 7, new Pawn(board, Color.BLACK));   
        placeNewPiece('c', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('d', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('e', 7, new Pawn(board, Color.BLACK));        
        placeNewPiece('f', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('g', 7, new Pawn(board, Color.BLACK)); 
        placeNewPiece('h', 7, new Pawn(board, Color.BLACK));
        
	}
}