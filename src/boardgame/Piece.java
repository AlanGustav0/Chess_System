package boardgame;

public class Piece {
	
	//A posição é de uso interno do pacote de tabuleiro
	protected Position position;
	//Aqui temos um tabuleiro, afinal, as peças possuem acesso ao tabuleiro para poder se locomoverem sobre ele.
	private Board board;
	
	
	public Piece(Board board) {
		this.board = board;
	}


	//Somente classes e subclasses de peças podem acessar o tabuleiro de uma peça
	protected Board getBoard() {
		return board;
	}


	
	

}
