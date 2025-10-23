package chess.pieces;

import chess.Cell;
import chess.Board;

public abstract class Piece {
    protected boolean isWhite;
    protected Cell currentCell;

    public Piece(boolean isWhite, Cell currentCell){
        this.isWhite = isWhite;
        this.currentCell = currentCell;
    }

    public boolean isWhite(){
        return isWhite;
    }

    public Cell getCurrentCell(){
        return currentCell;
    }

    public void setCurrentCell(Cell cell){
        this.currentCell = cell;
    }

    public abstract boolean isValidMove(Cell newCell, Board board);

    @Override
    public abstract String toString();
}
