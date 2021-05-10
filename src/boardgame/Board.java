package boardgame;

import boardgame.exceptions.BoardException;

public class Board {

	/*
	 * O tabuleiro possui linhas e colunas, além de uma matriz que será definida de
	 * acordo com a quantidade de linhas e colunas do tabuleiro.
	 */

	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Error creting board there must be at" + " leat 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	// Método para retornar a matriz na linha e coluna indicada
	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException("Position not is on the board");
		}
		return pieces[row][column];
	}

	// Sobrecarga do método anterior retornando a peça pela posição indicada
	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not is on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}

	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}

	/*
	 * Método para sabermos quando uma posição em uma dada linha e coluna existe
	 * Quando a posição está dentro do tabuleiro ou seja:
	 * 
	 * Linha >= 0 E Linha < Quantidade de linhas do tabuleiro (Altura do tabuleiro)
	 * Coluna >= 0 E Coluna < Quantidde de colunas do tabuleiro (Largura do
	 * tabuleiro)
	 */
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}

	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}

	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not is on the board");
		}
		return piece(position) != null;
	}

}
