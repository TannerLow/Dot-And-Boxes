package rodeo.o2craft.GameElements.Graphics.Console;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<List<Integer>> board;

    public Board(int width, int height) {
        board = new ArrayList<>();
        for(int row = 0; row < height; row++) {
            board.add(new ArrayList<>());
            for(int col = 0; col < width; col++) {
                board.get(row).add(row * col);
            }
        }
    }

    public Integer getTile(int row, int col) throws IndexOutOfBoundsException {
        return board.get(row).get(col);
    }
}
