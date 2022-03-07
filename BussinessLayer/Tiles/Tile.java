package BussinessLayer.Tiles;
import BussinessLayer.visited;

public abstract class Tile implements visited {

    private char tileType;
    private Point position;

    // constructors
    public Tile(Point position, char tileType){
        this.position = position;
        this.tileType = tileType;
    }

    public Point getPosition(){ return  position;}
    public void setPosition(Point Position){this.position=Position;}
    public char getTileType() {
        return tileType;
    }
    public void setTileType(char type){
        tileType=type;
    }
    public double range(Tile b){
        double ans;
        double x=Math.pow(this.getPosition().getX()-b.getPosition().getX(),2);
        double y=Math.pow(this.getPosition().getY()-b.getPosition().getY(),2);
        ans=Math.sqrt(x+y);
        return ans;
    }
    public String toString () {
        String ans="";
        return ans+this.tileType;
    }
}
