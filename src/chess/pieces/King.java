package chess.pieces;

import chess.Cell;
import chess.Board;

public class King extends Piece {

    public King(boolean isWhite, Cell cell) {
        super(isWhite, cell);
    }

    @Override
    public boolean isValidMove(Cell newCell, Board board) {
        int rowDiff = Math.abs(newCell.getRow() - currentCell.getRow());
        int colDiff = Math.abs(newCell.getCol() - currentCell.getCol());

        // King moves one square in any direction
        if ((rowDiff <= 1 && colDiff <= 1) &&
            (!newCell.isOccupied() || newCell.getPiece().isWhite() != isWhite)) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return isWhite ? "K" : "k";
    }
}
