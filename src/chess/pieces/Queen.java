package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

//Esta classe representa a peça Rainha do jogo

public class Queen extends ChessPiece {

	public Queen(Board board, Color color) {
		super(board, color);

	}

	// Aqui será o retorno desta peça no tabuleiro, a forma como ela aparece no
	// tabuleiro
	@Override
	public String toString() {
		return "Q";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		// -------------------- Posição acima da peça
		p.setValues(position.getRow() - 1, position.getColumn());

		// Este laço vai ser verdedairo enquanto existir posição no tabuleiro e enquanto
		// não possuir peças no caminho.
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() - 1);
		}

		// Aqui, após finalizar o percurso, ainda verificamos se a próxima casa possui
		// peça de um oponente.
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// -------------------- Posição a direita da peça
		p.setValues(position.getRow(), position.getColumn() + 1);

		// Este laço vai ser verdedairo enquanto existir posição no tabuleiro e enquanto
		// não possuir peças no caminho.
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() + 1);
		}

		// Aqui, após finalizar o percurso, ainda verificamos se a próxima casa possui
		// peça de um oponente.
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// ----------------------- Posição a esquerda da peça
		p.setValues(position.getRow(), position.getColumn() - 1);

		// Este laço vai ser verdedairo enquanto existir posição no tabuleiro e enquanto
		// não possuir peças no caminho.
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() - 1);
		}

		// Aqui, após finalizar o percurso, ainda verificamos se a próxima casa possui
		// peça de um oponente.
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// ----------------------- Posição abaixo da peça
		p.setValues(position.getRow() + 1, position.getColumn());

		// Este laço vai ser verdedairo enquanto existir posição no tabuleiro e enquanto
		// não possuir peças no caminho.
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() + 1);
		}

		// Aqui, após finalizar o percurso, ainda verificamos se a próxima casa possui
		// peça de um oponente.
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		// -------------------- Posição na diagonal esquerda acima
		p.setValues(position.getRow() - 1, position.getColumn() - 1);

		// Este laço vai ser verdedairo enquanto existir posição no tabuleiro e enquanto
		// não possuir peças no caminho.
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() - 1, p.getColumn() - 1);
		}

		// Aqui, após finalizar o percurso, ainda verificamos se a próxima casa possui
		// peça de um oponente.
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// -------------------- Posição na diagonal direita acima
		p.setValues(position.getRow() - 1, position.getColumn() + 1);

		// Este laço vai ser verdedairo enquanto existir posição no tabuleiro e enquanto
		// não possuir peças no caminho.
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() - 1, p.getColumn() + 1);
		}

		// Aqui, após finalizar o percurso, ainda verificamos se a próxima casa possui
		// peça de um oponente.
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// ----------------------- Posição na diagonal direita abaixo
		p.setValues(position.getRow() + 1, position.getColumn() + 1);

		// Este laço vai ser verdedairo enquanto existir posição no tabuleiro e enquanto
		// não possuir peças no caminho.
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() + 1, p.getColumn() + 1);
		}

		// Aqui, após finalizar o percurso, ainda verificamos se a próxima casa possui
		// peça de um oponente.
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// ----------------------- Posição da diagonal esquerda abaixo
		p.setValues(position.getRow() + 1, position.getColumn() - 1);

		// Este laço vai ser verdedairo enquanto existir posição no tabuleiro e enquanto
		// não possuir peças no caminho.
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() + 1, p.getColumn() - 1);
		}

		// Aqui, após finalizar o percurso, ainda verificamos se a próxima casa possui
		// peça de um oponente.
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		return mat;
	}

}
