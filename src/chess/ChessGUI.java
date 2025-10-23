package chess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import chess.pieces.Piece;

public class ChessGUI extends JFrame {
    private static final int BOARD_SIZE = 8;
    private static final int SQUARE_SIZE = 80;
    private Game game;
    private JButton[][] squares;
    private Cell selectedCell = null;
    private JLabel statusLabel;

    public ChessGUI() {
        game = new Game("White Player", "Black Player");
        initializeGUI();
    }

    private void initializeGUI() {
        setTitle("Chess Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        squares = new JButton[BOARD_SIZE][BOARD_SIZE];

        for (int row = BOARD_SIZE - 1; row >= 0; row--) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                JButton square = new JButton();
                square.setPreferredSize(new Dimension(SQUARE_SIZE, SQUARE_SIZE));
                square.setFont(new Font("Sans-serif", Font.PLAIN, 40));
                square.setFocusPainted(false);

                Color lightColor = new Color(240, 217, 181);
                Color darkColor = new Color(181, 136, 99);
                square.setBackground((row + col) % 2 == 0 ? lightColor : darkColor);

                final int r = row;
                final int c = col;
                square.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        handleSquareClick(r, c);
                    }
                });

                squares[row][col] = square;
                boardPanel.add(square);
            }
        }

        statusLabel = new JLabel("White's turn", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Sans-serif", Font.BOLD, 18));
        statusLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel controlPanel = new JPanel();
        JButton newGameButton = new JButton("New Game");
        newGameButton.addActionListener(e -> {
            game = new Game("White Player", "Black Player");
            selectedCell = null;
            updateBoard();
            updateStatus();
        });
        controlPanel.add(newGameButton);

        add(boardPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        updateBoard();
        updateStatus();
    }

    private void handleSquareClick(int row, int col) {
        Cell clickedCell = game.getBoard().getCell(row, col);

        if (selectedCell == null) {
            if (clickedCell.getPiece() != null && 
                clickedCell.getPiece().isWhite() == game.getCurrentPlayer().isWhite()) {
                selectedCell = clickedCell;
                highlightSquare(row, col, true);
            }
        } else {
            int fromRow = selectedCell.getRow();
            int fromCol = selectedCell.getCol();

            if (game.move(fromRow, fromCol, row, col)) {
                updateBoard();
                updateStatus();
                selectedCell = null;
            } else {
                highlightSquare(fromRow, fromCol, false);
                
                if (clickedCell.getPiece() != null && 
                    clickedCell.getPiece().isWhite() == game.getCurrentPlayer().isWhite()) {
                    selectedCell = clickedCell;
                    highlightSquare(row, col, true);
                } else {
                    selectedCell = null;
                    JOptionPane.showMessageDialog(this, "Invalid move!", 
                        "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }

    private void highlightSquare(int row, int col, boolean highlight) {
        Color lightColor = new Color(240, 217, 181);
        Color darkColor = new Color(181, 136, 99);
        Color selectedColor = new Color(186, 202, 68);

        if (highlight) {
            squares[row][col].setBackground(selectedColor);
        } else {
            squares[row][col].setBackground((row + col) % 2 == 0 ? lightColor : darkColor);
        }
    }

    private void updateBoard() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                Cell cell = game.getBoard().getCell(row, col);
                Piece piece = cell.getPiece();

                Color lightColor = new Color(240, 217, 181);
                Color darkColor = new Color(181, 136, 99);
                squares[row][col].setBackground((row + col) % 2 == 0 ? lightColor : darkColor);

                if (piece != null) {
                    squares[row][col].setText(getPieceUnicode(piece));
                } else {
                    squares[row][col].setText("");
                }
            }
        }
    }

    private String getPieceUnicode(Piece piece) {
        boolean isWhite = piece.isWhite();
        String symbol = piece.toString().toUpperCase();

        switch (symbol) {
            case "K": return isWhite ? "\u2654" : "\u265A";
            case "Q": return isWhite ? "\u2655" : "\u265B";
            case "R": return isWhite ? "\u2656" : "\u265C";
            case "B": return isWhite ? "\u2657" : "\u265D";
            case "N": return isWhite ? "\u2658" : "\u265E";
            case "P": return isWhite ? "\u2659" : "\u265F";
            default: return "";
        }
    }

    private void updateStatus() {
        Player current = game.getCurrentPlayer();
        String color = current.isWhite() ? "White" : "Black";
        statusLabel.setText(color + "'s turn - " + current.getName());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChessGUI gui = new ChessGUI();
            gui.setVisible(true);
        });
    }
}
