package pieces;


import chess.Cell;
import chess.Board;

public abstract class Piece {
    protected boolean isWhite;
    protected Cell currentcell;

    public Piece(boolean isWhite, Cell currentcell){
        this.isWhite = isWhite;
        this.currentcell = currentcell;
    }

    public Cell getCurrentCell(){
        return currentcell;
    }

    public void setCurrentCell(Cell cell){
        this.currentcell =cell;
    }


    public abstract boolean isVaildMove(Cell newCell, Board board);

    @Override
    public abstract String toString();


}
