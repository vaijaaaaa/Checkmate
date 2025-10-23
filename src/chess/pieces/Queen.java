package chess.pieces;

import chess.Cell;
import chess.Board;

public class Queen extends Piece {

    public Queen(boolean isWhite, Cell cell) {
        super(isWhite, cell);
    }

    @Override
    public boolean isValidMove(Cell newCell, Board board) {
        int rowDiff = Math.abs(newCell.getRow() - currentCell.getRow());
        int colDiff = Math.abs(newCell.getCol() - currentCell.getCol());

        // Queen moves like Rook or Bishop
        boolean straight = currentCell.getRow() == newCell.getRow() || currentCell.getCol() == newCell.getCol();
        boolean diagonal = rowDiff == colDiff;

        if (!straight && !diagonal) return false;

        int rowStep = Integer.compare(newCell.getRow(), currentCell.getRow());
        int colStep = Integer.compare(newCell.getCol(), currentCell.getCol());

        int r = currentCell.getRow() + rowStep;
        int c = currentCell.getCol() + colStep;

        while (r != newCell.getRow() || c != newCell.getCol()) {
            Cell cell = board.getCell(r, c);
            if (cell.isOccupied()) return false;
            r += rowStep;
            c += colStep;
        }

        return !newCell.isOccupied() || newCell.getPiece().isWhite() != isWhite;
    }

    @Override
    public String toString() {
        return isWhite ? "Q" : "q";
    }
}
