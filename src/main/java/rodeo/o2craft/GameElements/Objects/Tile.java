package rodeo.o2craft.GameElements.Objects;

import rodeo.o2craft.Utils.Copyable;

public class Tile implements Copyable<Tile> {
    private int owner = 0;
    private boolean hasTopWall = false;
    private boolean hasRightWall = false;
    private boolean hasBottomWall = false;
    private boolean hasLeftWall = false;

    public enum Side {
        TOP, BOTTOM, LEFT, RIGHT
    }

    public Tile() {

    }

    @Override
    public Tile copy() {
        Tile tile = new Tile();
        tile.owner = this.owner;
        tile.hasTopWall = this.hasTopWall;
        tile.hasRightWall = this.hasRightWall;
        tile.hasBottomWall = this.hasBottomWall;
        tile.hasLeftWall = this.hasLeftWall;
        return tile;
    }

    public boolean getWallState(Side side) {
        if(side == Side.TOP)    return hasTopWall;
        if(side == Side.BOTTOM) return hasBottomWall;
        if(side == Side.LEFT)   return hasLeftWall;
        if(side == Side.RIGHT)  return hasRightWall;
        return false;
    }

    public void setWallState(Side side, boolean state) {
        if     (side == Side.TOP)    hasTopWall    = state;
        else if(side == Side.BOTTOM) hasBottomWall = state;
        else if(side == Side.LEFT)   hasLeftWall   = state;
        else if(side == Side.RIGHT)  hasRightWall  = state;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }
}
