package rodeo.o2craft.Input;

import rodeo.o2craft.GameElements.Objects.Board;
import rodeo.o2craft.GameElements.Objects.Tile;

import java.util.Scanner;

public class ConsoleInputParser {

    public ConsoleInputParser() {

    }

    public Board.Position parsePosition(String input) {
        Board.Position position = new Board.Position(null, null);
        Scanner scanner = new Scanner(input);
        if(scanner.hasNext()) {
            if(scanner.hasNextInt()) {
                position.col = scanner.nextInt();
            }
            if(scanner.hasNextInt()) {
                position.row = scanner.nextInt();
            }
        }
        return position;
    }

    public Tile.Side parseSide(String input) {
        Tile.Side side = null;

        if(input.equalsIgnoreCase("top")) {
            side = Tile.Side.TOP;
        }
        if(input.equalsIgnoreCase("right")) {
            side = Tile.Side.RIGHT;
        }
        if(input.equalsIgnoreCase("left")) {
            side = Tile.Side.LEFT;
        }
        if(input.equalsIgnoreCase("bottom")) {
            side = Tile.Side.BOTTOM;
        }

        return side;
    }
}
