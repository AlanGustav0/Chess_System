package boardgame;

public class Board {

	/*
	 * O tabuleiro possui linhas e colunas, além de uma matriz que será definida de
	 * acordo com a quantidade de linhas e colunas do tabuleiro.
	 */

	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumn(int columns) {
		this.columns = columns;
	}

	//Método para retornar a matriz na linha e coluna indicada
	public Piece piece(int row, int column) {
		return pieces[row][column];
	}
	
	//Sobrecarga do método anterior retornando a peça pela posição indicada
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}

}
