package chess.pieces;

import chess.Cell;
import chess.Board;

public class Rook extends Piece {

    public Rook(boolean isWhite, Cell cell) {
        super(isWhite, cell);
    }

    @Override
    public boolean isValidMove(Cell newCell, Board board) {
        if (currentCell.getRow() != newCell.getRow() && currentCell.getCol() != newCell.getCol()) {
            return false; // must move in straight line
        }

        // Check for obstacles
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

        // Can capture opponent
        return !newCell.isOccupied() || newCell.getPiece().isWhite() != isWhite;
    }

    @Override
    public String toString() {
        return isWhite ? "R" : "r";
    }
}
