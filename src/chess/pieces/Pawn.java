package chess.pieces;

import board.Board;
import board.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] possibleMoves = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		// movimento das brancas
		if (getColor() == Color.WHITE) {
			// casa a frente
			p.setValues(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				possibleMoves[p.getRow()][p.getColumn()] = true;
				// 2 casas a frente
				p.setValues(p.getRow() - 1, p.getColumn());
				if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0) {
					possibleMoves[p.getRow()][p.getColumn()] = true;
				}
			}

			// diagonal esquerda
			p.setValues(position.getRow() - 1, position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				possibleMoves[p.getRow()][p.getColumn()] = true;
			}
			
			// diagonal direita
			p.setValues(position.getRow() - 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				possibleMoves[p.getRow()][p.getColumn()] = true;
			}
		}
		else {			
			// casa a frente
			p.setValues(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				possibleMoves[p.getRow()][p.getColumn()] = true;
				// 2 casas a frente
				p.setValues(p.getRow() + 1, p.getColumn());
				if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0) {
					possibleMoves[p.getRow()][p.getColumn()] = true;
				}
			}

			// diagonal esquerda
			p.setValues(position.getRow() + 1, position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				possibleMoves[p.getRow()][p.getColumn()] = true;
			}
			
			// diagonal direita
			p.setValues(position.getRow() + 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				possibleMoves[p.getRow()][p.getColumn()] = true;
			}
			
		}

		return possibleMoves;
	}

	@Override
	public String toString() {
		return "P";
	}
	
	

}
