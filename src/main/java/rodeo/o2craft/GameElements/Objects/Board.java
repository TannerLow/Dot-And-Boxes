package rodeo.o2craft.GameElements.Objects;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Tile>> tiles;

    public Board(int width, int height) {
        tiles = new ArrayList<>();
        for(int row = 0; row < height; row++) {
            tiles.add(new ArrayList<>());
            for(int col = 0; col < width; col++) {
                Tile tile = new Tile();
                tiles.get(row).add(tile);
            }
        }
    }

    public void play(Position position, Tile.Side side) {
        getTile(position).setWallState(side, true);

        int rowSize = tiles.get(0).size();

        if(side == Tile.Side.LEFT && position.col - 1 >= 0) {
            Position adjacentPosition = new Position(position.col - 1, position.row);
            getTile(adjacentPosition).setWallState(Tile.Side.RIGHT, true);
        }
        else if(side == Tile.Side.RIGHT && position.col + 1 < rowSize) {
            Position adjacentPosition = new Position(position.col + 1, position.row);
            getTile(adjacentPosition).setWallState(Tile.Side.LEFT, true);
        }
        else if(side == Tile.Side.TOP && position.row - 1 >= 0) {
            Position adjacentPosition = new Position(position.col, position.row - 1);
            getTile(adjacentPosition).setWallState(Tile.Side.BOTTOM, true);
        }
        else if(side == Tile.Side.BOTTOM && position.row + 1 < tiles.size()) {
            Position adjacentPosition = new Position(position.col, position.row + 1);
            getTile(adjacentPosition).setWallState(Tile.Side.TOP, true);
        }
    }

    public boolean isValidPosition(Position position) {
        boolean isValid = false;

        if(position.row >= 0 && position.row < tiles.size()) {
            if(position.col >= 0 && position.col < tiles.get(0).size()) {
                isValid = true;
            }
        }

        return isValid;
    }

    public Tile getTile(int row, int col) throws IndexOutOfBoundsException {
        return tiles.get(row).get(col);
    }

    public Tile getTile(Position position) throws IndexOutOfBoundsException {
        return tiles.get(position.row).get(position.col);
    }

    public List<List<Tile>> getTiles() {
        List<List<Tile>> tilesCopy = new ArrayList<>();
        for(int row = 0; row < tiles.size(); row++) {
            tilesCopy.add(new ArrayList<>(tiles.get(row)));

            List<Tile> copiedRow = tilesCopy.get(row);
            for(int i = 0; i < copiedRow.size(); i++) {
                copiedRow.set(i, copiedRow.get(i).copy());
            }
        }
        return tilesCopy;
    }

    public static class Position {
        public int col;
        public int row;

        public Position(Integer col, Integer row) {
            if(col == null) {
                this.col = -1;
            }
            else {
                this.col = col;
            }

            if(row == null) {
                this.row = -1;
            }
            else {
                this.row = row;
            }
        }

        public String toString() {
            return "Col: " + col + ", Row: " + row;
        }
    }
}
