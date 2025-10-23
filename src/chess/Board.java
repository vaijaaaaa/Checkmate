import java.time.format.SignStyle;

import pieces.Piece;

public class Board {
    public static final int SIZE = 8;
    private Cell[][] cells;

    public Board(){
        cells = new Cell[SIZE][SIZE];
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    public Cell getCell(int row , int col){
        if(row < 0 || row >= SIZE || col < 0 || col >= SIZE){
            return null;
        }
        return cells[row][col];
    }


    public void placePiece(Piece piece, int row , int col){
        Cell cell = getCell(row, col);
        if(cell != null){
            cell.setPiece(piece);
            piece.setCurrentCell(cell);
        }
    }


    public boolean movePiece(Cell from, Cell to){
        Piece piece = from.getPiece();
        if(piece != null && piece.isVaildMove(to, this)){
            to.setPiece(piece);
            from.setPiece(null);
            return true;
        }
        return false;
    }

    public void printBoard(){
        for(int i= SIZE - 1 ; i >=0 ;i--){
            System.out.println((i+1) + " ");
            for(int j=0;j<SIZE;j++){
                System.out.println(cells[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(" a b c d e f g h");
    }
}
