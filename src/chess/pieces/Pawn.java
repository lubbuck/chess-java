package chess.pieces;

import board.Board;
import board.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	private ChessMatch chessMatch;

	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	public ChessMatch getChessMatch() {
		return chessMatch;
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

			// passant
			if (position.getRow() == 3) {
				// à esquerda
				Position leftOfPawn = new Position(position.getRow(), position.getColumn() - 1);
				if (getBoard().positionExists(leftOfPawn) && isThereOpponentPiece(leftOfPawn)
						&& getBoard().piece(leftOfPawn) == chessMatch.getEnPassantVulnerable()) {
					possibleMoves[leftOfPawn.getRow() - 1][leftOfPawn.getColumn()] = true;
				}

				// à direita
				Position rightOfPawn = new Position(position.getRow(), position.getColumn() + 1);
				if (getBoard().positionExists(rightOfPawn) && isThereOpponentPiece(rightOfPawn)
						&& getBoard().piece(rightOfPawn) == chessMatch.getEnPassantVulnerable()) {
					possibleMoves[rightOfPawn.getRow() - 1][rightOfPawn.getColumn()] = true;
				}
			}
		} else {
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

			// passant
			if (position.getRow() == 4) {
				// à esquerda
				Position leftOfPawn = new Position(position.getRow(), position.getColumn() - 1);
				if (getBoard().positionExists(leftOfPawn) && isThereOpponentPiece(leftOfPawn)
						&& getBoard().piece(leftOfPawn) == chessMatch.getEnPassantVulnerable()) {
					possibleMoves[leftOfPawn.getRow() + 1][leftOfPawn.getColumn()] = true;
				}

				// à direita
				Position rightOfPawn = new Position(position.getRow(), position.getColumn() + 1);
				if (getBoard().positionExists(rightOfPawn) && isThereOpponentPiece(rightOfPawn)
						&& getBoard().piece(rightOfPawn) == chessMatch.getEnPassantVulnerable()) {
					possibleMoves[rightOfPawn.getRow() + 1][rightOfPawn.getColumn()] = true;
				}
			}

		}

		return possibleMoves;
	}

	@Override
	public String toString() {
		return "P";
	}

}
