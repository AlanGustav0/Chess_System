package chess;

import boardgame.Board;
import boardgame.Piece;

/*
 * Esta é a classe peça de xadrez, que pode ser Preta ou branca, além de ser uma subclasse
 * da classe Piece, pois também possui acesso ao tabuleiro, locomovendo-se por ele.
 */

public abstract class ChessPiece extends Piece{
	
	private Color color;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	//A cor de uma peça pode apenas ser acessada.
	public Color getColor() {
		return color;
	}

	
	
	
	

}
