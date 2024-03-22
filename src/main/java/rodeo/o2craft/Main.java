package rodeo.o2craft;

import rodeo.o2craft.GameElements.Graphics.Console.Board;
import rodeo.o2craft.Input.ConsoleInput;
import rodeo.o2craft.Input.TextInput;
import rodeo.o2craft.Output.ConsoleOutput;
import rodeo.o2craft.Output.TextOutput;

public class Main {
    public static void main(String[] args) {
        TextInput input = new ConsoleInput();
        TextOutput output = new ConsoleOutput();
        Board board = new Board(8, 8);

        String userInput = input.getInput();
        output.printLine(userInput);
        output.printLine(board.getTile(5,7));
    }
}