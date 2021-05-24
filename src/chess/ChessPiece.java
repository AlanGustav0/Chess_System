package chess;

import boardgame.Board;
import boardgame.Piece;

/*
 * Esta � a classe pe�a de xadrez, que pode ser Preta ou branca, al�m de ser uma subclasse
 * da classe Piece, pois tamb�m possui acesso ao tabuleiro, locomovendo-se por ele.
 */

public abstract class ChessPiece extends Piece{
	
	private Color color;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	//A cor de uma pe�a pode apenas ser acessada.
	public Color getColor() {
		return color;
	}

	
	
	
	

}
