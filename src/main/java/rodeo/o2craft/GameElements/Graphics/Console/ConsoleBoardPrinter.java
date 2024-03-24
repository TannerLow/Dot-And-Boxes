package rodeo.o2craft.GameElements.Graphics.Console;

import rodeo.o2craft.GameElements.Objects.Board;
import rodeo.o2craft.GameElements.Objects.Tile;

import java.util.List;

public class ConsoleBoardPrinter {
    private Board board;

    public ConsoleBoardPrinter(Board board) {
        this.board = board;
    }

    private String wallAsString(boolean horizontal, boolean hasWall) {
        String wall = " ";
        if(horizontal && hasWall) {
            wall = "-";
        }
        else if(hasWall) {
            wall = "|";
        }
        return wall;
    }

    private String tileToString(Tile tile, int line) {
        String text = null;
        if(line == 0) {
            text = "+" + wallAsString(true, tile.getWallState(Tile.Side.TOP));
        }
        else if(line == 1) {
            text = wallAsString(false, tile.getWallState(Tile.Side.LEFT)) + tile.getOwner();
        }
        else if(line ==2) {
            text = "+" + wallAsString(true, tile.getWallState(Tile.Side.BOTTOM));
        }
        return text;
    }

    public String toString() {
        String text = "  ";

        List<List<Tile>> tiles = board.getTiles();

        for(int col = 0; col < tiles.get(0).size(); col++) {
            text += " " + Integer.toString(col);
        }
        text += "\n";

        for(int rowIndex = 0; rowIndex < tiles.size(); rowIndex++) {
            List<Tile> row = tiles.get(rowIndex);
            for(int line = 0; line < 2; line++) {
                if(line == 1) {
                    text += Integer.toString(rowIndex) + " ";
                }
                else {
                    text += "  ";
                }

                for (Tile tile : row) {
                    text += tileToString(tile, line);
                }
                if (line == 1) {
                    Tile tile = row.get(row.size() - 1);
                    text += wallAsString(false, tile.getWallState(Tile.Side.RIGHT));
                } else {
                    text += "+";
                }
                text += "\n";
            }
        }

        // final row's bottom
        text += "  ";
        for(Tile tile : tiles.get(tiles.size() - 1)) {
            text += tileToString(tile, 2);
        }
        text += "+";
        return text;
    }
}
