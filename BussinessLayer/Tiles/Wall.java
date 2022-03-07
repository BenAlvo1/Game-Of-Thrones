package BussinessLayer.Tiles;

import BussinessLayer.Tiles.Point;
import BussinessLayer.Tiles.Tile;
import BussinessLayer.visitor;

public class Wall extends Tile {

    public Wall(Point position){
        super(position,'#');
    }

    public boolean accept(visitor v){return v.visit(this);}
}
