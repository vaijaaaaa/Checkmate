package chess.pieces;

import chess.Cell;
import chess.Board;

public class Knight extends Piece {

    public Knight(boolean isWhite, Cell cell) {
        super(isWhite, cell);
    }

    @Override
    public boolean isValidMove(Cell newCell, Board board) {
        int rowDiff = Math.abs(newCell.getRow() - currentCell.getRow());
        int colDiff = Math.abs(newCell.getCol() - currentCell.getCol());

        if ((rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2)) {
            return !newCell.isOccupied() || newCell.getPiece().isWhite() != isWhite;
        }

        return false;
    }

    @Override
    public String toString() {
        return isWhite ? "N" : "n";
    }
}
