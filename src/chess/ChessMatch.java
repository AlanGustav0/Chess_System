package chess;

import boardgame.Board;
import boardgame.Position;
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
	
	//Método responsável por inserir as peças no tabuleiro e iniciar o jogo
	
	private void initialSetup() {
		board.placePiece(new Rook(board,Color.WHITE), new Position(2,1));
		board.placePiece(new King(board,Color.BLACK), new Position(0,4));
		board.placePiece(new King(board,Color.WHITE), new Position(7,4));
		
	}

}
