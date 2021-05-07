package boardgame;

public class Position {
	
	/*
	 * Esta classe � a entidade posi��o, com sesu atributos de linha e coluna.
	 */
	private int row;
	private int column;
	
	public Position(int row,int column) {
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	@Override
	public String toString() {
		return row + "," + column;
	}
	
	

}
