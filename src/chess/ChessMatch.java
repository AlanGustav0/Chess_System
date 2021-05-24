package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.exceptions.ChessException;
import chess.pieces.King;
import chess.pieces.Rook;

/*
 * Esta classe é responsável por montar o jogo.
 */

public class ChessMatch {

	private Board board;

	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}

	/*
	 * No tabuleiro nós temos as peças de xadrez, como estamos na camada de Xadrez e
	 * para a aplicação principal nós não queremos retornar as peças do tipo Piece,
	 * mas sim do tipo "ChessPiece", para que o programa tenha acesso apenas até
	 * essa camada do jogo, ficando a camada interna de tabuleiro restrita apenas as
	 * peças em si.
	 */
	public ChessPiece[][] getPices() {
		ChessPiece[][] matrixChess = new ChessPiece[board.getRows()][board.getColumns()];

		for (int line = 0; line < board.getRows(); line++) {
			for (int column = 0; column < board.getColumns(); column++) {
				matrixChess[line][column] = (ChessPiece) board.piece(line, column);
			}
		}

		return matrixChess;
	}

	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {

		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		validateTargetPosition(source,target);
		Piece capturedPiece = makeMove(source, target);

		return (ChessPiece) capturedPiece;
	}

	// Este método valida a posição da peça que será movida
	private void validateSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece in source position");
		}
		if (!board.piece(position).isThereAnyPossibleMovie()) {
			throw new ChessException("There is no possible movies for the chosen piece");
		}
	}
	
	//Aqui verificamos se a peça de origem não é uma posição de destino possível, eu não posso mover para lá
	private void validateTargetPosition(Position source,Position target) {
		if(!board.piece(source).possibleMovie(target)) {
			throw new ChessException("The chosen piece can't move to target position");
		}
	}

	private Piece makeMove(Position source, Position target) {
		Piece piece = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(piece, target);

		return capturedPiece;
	}

	/*
	 * Este método será o responsável por receber as posições, enviar para o
	 * ChessPosition Que faz a conversão de posição de matriz, para posição de
	 * tabuleiro.
	 */
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}

	// Método responsável por inserir as peças no tabuleiro e iniciar o jogo

	private void initialSetup() {
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
		placeNewPiece('c', 2, new Rook(board, Color.WHITE));
		placeNewPiece('d', 2, new Rook(board, Color.WHITE));
		placeNewPiece('e', 2, new Rook(board, Color.WHITE));
		placeNewPiece('e', 1, new Rook(board, Color.WHITE));
		placeNewPiece('d', 1, new King(board, Color.WHITE));

		placeNewPiece('c', 7, new Rook(board, Color.BLACK));
		placeNewPiece('c', 8, new Rook(board, Color.BLACK));
		placeNewPiece('d', 7, new Rook(board, Color.BLACK));
		placeNewPiece('e', 7, new Rook(board, Color.BLACK));
		placeNewPiece('e', 8, new Rook(board, Color.BLACK));
		placeNewPiece('d', 8, new King(board, Color.BLACK));

	}

}
