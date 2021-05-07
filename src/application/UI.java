package application;

import chess.ChessPiece;
/*
 * A classe UI (User interface) será responsável po imprimir o tabuleiro.
 * 
 */
public class UI {
	
	/*
	 * Este primeiro método recebe a matriz e monta ela de acordo com a quantidade de 
	 * linhas e colunas.
	 */
	public static void printBoard(ChessPiece[][] pieces) {
		for(int line=0;line < pieces.length;line++) {
			System.out.print((8 - line) + " ");
			for(int column=0;column < pieces.length;column++) {
				printPiece(pieces[line][column]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
		
	}
	
	/*
	 * Este método auxiliar é responsável por fazer a impressão da peça, caso ela seja nula, faz a impressão o traço "-"
	 */
	private static void printPiece(ChessPiece piece) {
		if(piece == null) {
			System.out.print("-");
		}else {
			System.out.print(piece);
		}
		System.out.print(" ");
	}

}
