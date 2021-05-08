package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

//Esta classe representa a peça Torre do jogo

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);
		
	}
	
	//Aqui será o retorno desta peça no tabuleiro, a forma como ela aparece no tabuleiro
	@Override
	public String toString() {
		return "R";
	}

}
