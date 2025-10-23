package chess;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Game game = new Game("White", "Black");

        while (true) {
            game.printBoard();
            Player player = game.getCurrentPlayer();
            System.out.println(player.getName() + "'s turn (" + (player.isWhite() ? "White" : "Black") + ")");
            System.out.print("Enter move (e.g., e2 e4): ");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("exit")) break;

            String[] parts = input.split(" ");
            if (parts.length != 2) {
                System.out.println("Invalid input. Format: e2 e4");
                continue;
            }

            int fromCol = parts[0].charAt(0) - 'a';
            int fromRow = parts[0].charAt(1) - '1';
            int toCol = parts[1].charAt(0) - 'a';
            int toRow = parts[1].charAt(1) - '1';

            if (!game.move(fromRow, fromCol, toRow, toCol)) {
                System.out.println("Invalid move. Try again.");
            }
        }

        sc.close();
        System.out.println("Game over.");
    }
}
