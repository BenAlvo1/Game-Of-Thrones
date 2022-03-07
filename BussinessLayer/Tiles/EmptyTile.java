package BussinessLayer.Tiles;

import BussinessLayer.visitor;

public class EmptyTile extends Tile {
    //constructor
    public EmptyTile(Point position){
        super(position,'.');
    }
    public boolean accept(visitor v){return v.visit(this);}

}
