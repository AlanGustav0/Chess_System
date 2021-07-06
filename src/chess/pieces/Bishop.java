package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

//Esta classe representa a pe�a Torre do jogo

public class Bishop extends ChessPiece {

	public Bishop(Board board, Color color) {
		super(board, color);

	}

	// Aqui ser� o retorno desta pe�a no tabuleiro, a forma como ela aparece no
	// tabuleiro
	@Override
	public String toString() {
		return "B";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		//-------------------- Posi��o na diagonal esquerda acima
		p.setValues(position.getRow() - 1, position.getColumn()-1);

		// Este la�o vai ser verdedairo enquanto existir posi��o no tabuleiro e enquanto
		// n�o possuir pe�as no caminho.
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() - 1,p.getColumn()-1);
		}

		// Aqui, ap�s finalizar o percurso, ainda verificamos se a pr�xima casa possui
		// pe�a de um oponente.
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		//-------------------- Posi��o na diagonal direita acima
		p.setValues(position.getRow() -1, position.getColumn() + 1);

		// Este la�o vai ser verdedairo enquanto existir posi��o no tabuleiro e enquanto
		// n�o possuir pe�as no caminho.
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() - 1,p.getColumn() + 1);
		}

		// Aqui, ap�s finalizar o percurso, ainda verificamos se a pr�xima casa possui
		// pe�a de um oponente.
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		//----------------------- Posi��o na diagonal direita abaixo
		p.setValues(position.getRow() + 1, position.getColumn() + 1);

		// Este la�o vai ser verdedairo enquanto existir posi��o no tabuleiro e enquanto
		// n�o possuir pe�as no caminho.
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() +1, p.getColumn() + 1);
		}

		// Aqui, ap�s finalizar o percurso, ainda verificamos se a pr�xima casa possui
		// pe�a de um oponente.
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//----------------------- Posi��o da diagonal esquerda abaixo
				p.setValues(position.getRow() + 1, position.getColumn() - 1);

				// Este la�o vai ser verdedairo enquanto existir posi��o no tabuleiro e enquanto
				// n�o possuir pe�as no caminho.
				while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
					mat[p.getRow()][p.getColumn()] = true;
					p.setValues(p.getRow() + 1,p.getColumn() - 1);
				}

				// Aqui, ap�s finalizar o percurso, ainda verificamos se a pr�xima casa possui
				// pe�a de um oponente.
				if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}

		return mat;
	}

}
