package boardgame;

public abstract class Piece {

	// A posi��o � de uso interno do pacote de tabuleiro
	protected Position position;
	// Aqui temos um tabuleiro, afinal, as pe�as possuem acesso ao tabuleiro para
	// poder se locomoverem sobre ele.
	private Board board;

	public Piece(Board board) {
		this.board = board;
	}

	// Somente classes e subclasses de pe�as podem acessar o tabuleiro de uma pe�a
	protected Board getBoard() {
		return board;
	}

	/*
	 * Aqui implementamos o m�todo abstrato para saber os movimentos poss�veis de
	 * uma pe�a, ele � abstrato porque sabemos as casas que a pe�a pode se
	 * locomover, mas sabemos quantas casas essa pe�a vai se locomover ao certo.
	 * 
	 * O m�todo possibleMovie � um m�todo concreto que utiliza um m�todo abstrato,
	 * poss�vel de se fazer na OO. � o chamado padr�o Template Mathod.
	 */
	public abstract boolean[][] possibleMoves();

	public boolean possibleMovie(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}

	/*
	 * Este m�todo ir� varrear as posi��es da matriz e encontrar se h� pelo menos
	 * uma posi��o "verdadeira" na matriz, ou seja, uma posi��o livre.
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
