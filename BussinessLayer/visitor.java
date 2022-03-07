package BussinessLayer;

import BussinessLayer.Enemy.Enemy;
import BussinessLayer.Player.Player;
import BussinessLayer.Tiles.EmptyTile;
import BussinessLayer.Tiles.Wall;

public interface visitor {
    public boolean visit(Player player);
    public boolean visit(Enemy enemy);
    public boolean visit(Wall wall);
    public boolean visit(EmptyTile empty);
}
