package boardgame;

public class Board {
	
	/*
	 * O tabuleiro possui linhas e colunas, al�m de uma matriz que ser� definida de acordo com a 
	 * quantidade de linhas e colunas do tabuleiro.
	 */

	private int rows;
	private int column;
	private Piece[][] pieces;

	public Board(int rows, int column) {
		this.rows = rows;
		this.column = column;
		pieces = new Piece[rows][column];
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

}
