package application;

import chess.ChessPiece;
/*
 * A classe UI (User interface) ser� respons�vel po imprimir o tabuleiro.
 * 
 */
public class UI {
	
	/*
	 * Este primeiro m�todo recebe a matriz e monta ela de acordo com a quantidade de 
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
	 * Este m�todo auxiliar � respons�vel por fazer a impress�o da pe�a, caso ela seja nula, faz a impress�o o tra�o "-"
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
