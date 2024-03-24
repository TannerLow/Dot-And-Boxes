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
        Board board = new Board(8, 5);
        ConsoleBoardPrinter boardPrinter = new ConsoleBoardPrinter(board);

        boolean gameOver = false;
        while(!gameOver) {
            output.printLine(boardPrinter);

            output.print("\nSelect a tile> ");
            String inputString = input.getInput();
            Board.Position position = inputParser.parsePosition(inputString);

            while(!board.isValidPosition(position)) {
                output.printLine("Position invalid. Try again.");
                output.print("\nSelect a tile> ");
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

            board.play(position, side);
        }
    }
}