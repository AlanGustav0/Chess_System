package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	private ChessMatch chessmatch;

	public King(Board board, Color color, ChessMatch chessmatch) {
		super(board, color);
		this.chessmatch = chessmatch;
	}

	@Override
	public String toString() {
		return "K";
	}

	// Verifica se o rei pode se mover para determinada posição
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}

	// Método responsável por verificar se a torre está apta para realizar a jogada
	// especial Roque
	private boolean testRookCastling(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		// acima
		p.setValues(position.getRow() - 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// abaixo
		p.setValues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// esquerda
		p.setValues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// direita
		p.setValues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// Noroeste
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// Nordeste
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// Sudoeste
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// Sudeste
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// Movimento especial Roque pequeno
		if (getMoveCount() == 0 && !chessmatch.getCheck()) {
			Position rightPosition = new Position(position.getRow(), position.getColumn() + 3); // Obtendo a posição que
																								// a torre deve estar
			if (testRookCastling(rightPosition)) {
				Position positionOne = new Position(position.getRow(), position.getColumn() + 1);
				Position positionTwo = new Position(position.getRow(), position.getColumn() + 2);

				if (getBoard().piece(positionOne) == null && getBoard().piece(positionTwo) == null) {
					mat[position.getRow()][position.getColumn() + 2] = true;
				}
			}
		}

		// Movimento especial Roque grande (lado da Rainha)
		if (getMoveCount() == 0 && !chessmatch.getCheck()) {
			Position leftPosition = new Position(position.getRow(), position.getColumn() - 4); // Obtendo a posição que
																								// a torre deve estar
			if (testRookCastling(leftPosition)) {
				Position positionOne = new Position(position.getRow(), position.getColumn() - 1);
				Position positionTwo = new Position(position.getRow(), position.getColumn() - 2);
				Position positionThree = new Position(position.getRow(), position.getColumn() - 3);

				if (getBoard().piece(positionOne) == null && getBoard().piece(positionTwo) == null
						&& getBoard().piece(positionThree) == null) {
					mat[position.getRow()][position.getColumn() - 2] = true;
				}
			}
		}

		return mat;
	}

}
