package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

/*
 * Esta é a classe peça de xadrez, que pode ser Preta ou branca, além de ser uma subclasse
 * da classe Piece, pois também possui acesso ao tabuleiro, locomovendo-se por ele.
 */

public abstract class ChessPiece extends Piece {

	private Color color;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	// A cor de uma peça pode apenas ser acessada.
	public Color getColor() {
		return color;
	}

	/*Este método verifica se a peça que está no tabuleiro é de um oponente ou não.
	 * Criamos uma variável do tipo ChessPiece e verificamos se a posição é diferente de nula e se a cor da peça é diferente da nossa.
	*/
	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p.getColor() != color;
	}

}
