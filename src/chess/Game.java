



public class Game {
    private Board board;
    private Player whitePlayer;
    private Player blackPlayer;
    private Player currentPlayer;

    public Game(String whiteName,String blackName){
        board = new Board();
        whitePlayer = new Player(whiteName, true);
        blackPlayer = new Player(blackName, false);
        currentPlayer = whitePlayer;

        setupPieces();
    }

    private void setupPieces(){
        for(int i=0;i<8;i++){
            board.placePiece(new Pawn(true,null), 1, i);
            board.placePiece(new Pawn(false,null), 6, i);
        }
        board.placePiece(new Rook(true, null), 0, 0);
        board.placePiece(new Rook(true, null), 0, 7);
        board.placePiece(new Rook(false, null), 7, 0);
        board.placePiece(new Rook(false, null), 7, 7);
    }
    public boolean move(int fromRow, int fromCol, int toRow, int toCol) {
        Cell from = board.getCell(fromRow, fromCol);
        Cell to = board.getCell(toRow, toCol);
        if (from != null && to != null && from.getPiece() != null &&
                from.getPiece().isWhite() == currentPlayer.isWhite() &&
                board.movePiece(from, to)) {
            switchPlayer();
            return true;
        }
        return false;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == whitePlayer) ? blackPlayer : whitePlayer;
    }

    public void printBoard() {
        board.printBoard();
    }
}