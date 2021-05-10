package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

/*
 * Esta classe � respons�vel por montar o jogo.
 */

public class ChessMatch {

	private Board board;

	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}

	/*
	 * No tabuleiro n�s temos as pe�as de xadrez, como estamos na camada de Xadrez e
	 * para a aplica��o principal n�s n�o queremos retornar as pe�as do tipo Piece,
	 * mas sim do tipo "ChessPiece", para que o programa tenha acesso apenas at�
	 * essa camada do jogo, ficando a camada interna de tabuleiro restrita apenas as
	 * pe�as em si.
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

	/*
	 * Este m�todo ser� o respons�vel por receber as posi��es, enviar para o
	 * ChessPosition Que faz a convers�o de posi��o de matriz, para posi��o de
	 * tabuleiro.
	 */
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}

	// M�todo respons�vel por inserir as pe�as no tabuleiro e iniciar o jogo

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
