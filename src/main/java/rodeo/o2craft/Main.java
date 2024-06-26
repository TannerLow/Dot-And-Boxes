package rodeo.o2craft;

import rodeo.o2craft.GameElements.Graphics.Console.ConsoleBoardPrinter;
import rodeo.o2craft.GameElements.Objects.Board;
import rodeo.o2craft.GameElements.Objects.Tile;
import rodeo.o2craft.Input.ConsoleInput;
import rodeo.o2craft.Input.ConsoleInputParser;
import rodeo.o2craft.Input.TextInput;
import rodeo.o2craft.Output.ConsoleOutput;
import rodeo.o2craft.Output.TextOutput;

public class Main {
    public static void main(String[] args) {
        TextInput input = new ConsoleInput();
        TextOutput output = new ConsoleOutput();
        ConsoleInputParser inputParser = new ConsoleInputParser();
        Board board = new Board(3, 2);
        ConsoleBoardPrinter boardPrinter = new ConsoleBoardPrinter(board);

        int currentPlayer = 1;

        boolean gameOver = false;
        while(!gameOver) {
            output.printLine(boardPrinter);

            output.print("\nPlayer " + currentPlayer + " Select a tile> ");
            String inputString = input.getInput();
            Board.Position position = inputParser.parsePosition(inputString);

            while(!board.isValidPosition(position)) {
                output.printLine("Position invalid. Try again.");
                output.print("Player " + currentPlayer + " Select a tile> ");
                inputString = input.getInput();
                position = inputParser.parsePosition(inputString);
            }

            output.print("Select a side> ");
            inputString = input.getInput();
            Tile.Side side = inputParser.parseSide(inputString);
            Tile tile = board.getTile(position);

            while(tile.getWallState(side) != false) {
                output.printLine("Side occupied. Try again.");
                output.print("Select a side> ");
                inputString = input.getInput();
                side = inputParser.parseSide(inputString);
            }

            if(!board.play(position, side, currentPlayer)) {
                currentPlayer = (currentPlayer == 1) ? 2 : 1;
            }

            if(board.isComplete()) {
                int player1Score = board.getCount(1);
                int player2Score = board.getCount(2);
                output.printLine("Player 1 score: " + player1Score);
                output.printLine("Player 2 score: " + player2Score);
                gameOver = true;
            }
        }

        output.printLine(boardPrinter);
    }
}