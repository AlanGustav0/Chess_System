package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

//Esta classe representa a pe�a Torre do jogo

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);
		
	}
	
	//Aqui ser� o retorno desta pe�a no tabuleiro, a forma como ela aparece no tabuleiro
	@Override
	public String toString() {
		return "R";
	}

}
