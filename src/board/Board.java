package board;

public class Board {
	private int rows;
	private int columns;
	protected Piece[][] pieces;

	public Board(Integer rows, Integer columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece piece(int row, int column) {
		return pieces[row][column];
	}

	public Piece piece(Position position) {
		return piece(position.getRow(), position.getColumn());
	}
	
	public void placePiece (Piece piece, Position position) {
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
}
