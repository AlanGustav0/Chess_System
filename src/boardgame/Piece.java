package boardgame;

public class Piece {
	
	//A posi��o � de uso interno do pacote de tabuleiro
	protected Position position;
	//Aqui temos um tabuleiro, afinal, as pe�as possuem acesso ao tabuleiro para poder se locomoverem sobre ele.
	private Board board;
	
	
	public Piece(Board board) {
		this.board = board;
	}


	//Somente classes e subclasses de pe�as podem acessar o tabuleiro de uma pe�a
	protected Board getBoard() {
		return board;
	}


	
	

}
