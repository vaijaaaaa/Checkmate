package chess.pieces;

import chess.Cell;
import chess.Board;

public class Pawn extends Piece {

    public Pawn(boolean isWhite, Cell cell) {
        super(isWhite, cell);
    }

    @Override
    public boolean isValidMove(Cell newCell, Board board) {
        int direction = isWhite ? 1 : -1;
        int rowDiff = newCell.getRow() - currentCell.getRow();
        int colDiff = newCell.getCol() - currentCell.getCol();

   
        if (colDiff == 0 && rowDiff == direction && !newCell.isOccupied()) {
            return true;
        }

    
        if (colDiff == 0 && rowDiff == 2 * direction && !newCell.isOccupied()) {
            int intermediateRow = currentCell.getRow() + direction;
            Cell intermediate = board.getCell(intermediateRow, currentCell.getCol());
            if (intermediate != null && !intermediate.isOccupied()) {
                return true;
            }
        }

    
        if (Math.abs(colDiff) == 1 && rowDiff == direction && newCell.isOccupied() &&
            newCell.getPiece().isWhite() != isWhite) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return isWhite ? "P" : "p";
    }
}
