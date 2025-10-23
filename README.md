# Chess Game with GUI

A complete chess game implementation in Java with a graphical user interface using Swing.

## Features

- Full chess board with all pieces (King, Queen, Rook, Bishop, Knight, Pawn)
- Beautiful GUI with Unicode chess symbols
- Valid move checking for all pieces
- Turn-based gameplay
- Visual feedback for selected pieces
- New game option

## How to Compile and Run

### Option 1: Using Batch Files (Windows)
1. Double-click `compile.bat` to compile the project
2. Double-click `run.bat` to start the game

### Option 2: Using Command Line
```bash
# Compile
javac -d bin src/chess/*.java src/chess/pieces/*.java

# Run
java -cp bin chess.Main
```

## How to Play

1. The game starts with White's turn
2. Click on a piece to select it (you can only select your own pieces)
3. Click on a destination square to move the piece
4. The game validates moves according to chess rules
5. Players alternate turns
6. Click "New Game" to restart

## Project Structure

```
src/
  chess/
    Main.java          - Entry point
    ChessGUI.java      - GUI implementation
    Game.java          - Game logic
    Board.java         - Board management
    Cell.java          - Individual cell/square
    Player.java        - Player information
    pieces/
      Piece.java       - Abstract piece class
      King.java        - King piece
      Queen.java       - Queen piece
      Rook.java        - Rook piece
      Bishop.java      - Bishop piece
      Knight.java      - Knight piece
      Pawn.java        - Pawn piece
```

## Controls

- **Left Click**: Select piece / Make move
- **New Game Button**: Start a new game

Enjoy playing chess!
