package boardgame;

public abstract class Piece {

	// A posição é de uso interno do pacote de tabuleiro
	protected Position position;
	// Aqui temos um tabuleiro, afinal, as peças possuem acesso ao tabuleiro para
	// poder se locomoverem sobre ele.
	private Board board;

	public Piece(Board board) {
		this.board = board;
	}

	// Somente classes e subclasses de peças podem acessar o tabuleiro de uma peça
	protected Board getBoard() {
		return board;
	}

	/*
	 * Aqui implementamos o método abstrato para saber os movimentos possíveis de
	 * uma peça, ele é abstrato porque sabemos as casas que a peça pode se
	 * locomover, mas sabemos quantas casas essa peça vai se locomover ao certo.
	 * 
	 * O método possibleMovie é um método concreto que utiliza um método abstrato,
	 * possível de se fazer na OO. é o chamado padrão Template Mathod.
	 */
	public abstract boolean[][] possibleMoves();

	public boolean possibleMovie(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}

	/*
	 * Este método irá varrear as posições da matriz e encontrar se há pelo menos
	 * uma posição "verdadeira" na matriz, ou seja, uma posição livre.
	 */
	public boolean isThereAnyPossibleMovie() {
		boolean[][] mat = possibleMoves();
		for (int line = 0; line < mat.length; line++) {
			for (int column = 0; column < mat.length; column++) {
				if (mat[line][column]) {
					return true;
				}
			}
		}

		return false;
	}

}
