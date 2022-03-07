package BussinessLayer.Tiles;

import BussinessLayer.EventHandler;
import BussinessLayer.Resource.Health;
import BussinessLayer.Tiles.Point;
import BussinessLayer.Tiles.Tile;
import BussinessLayer.visitor;

// have to change package
public abstract class Unit extends Tile implements visitor {

    protected String name;
    protected Integer attackPoints;
    protected Integer defensePoints;
    protected Health health;
    protected boolean isDead;
    protected BussinessLayer.EventHandler messageHandler;

    //constructor
    public Unit(String name, char type, Point position, Integer healthAmount, Integer defensePoints, Integer attackPoints){
        super(position,type); // for Tile class
        this.name=name;
        this.isDead=false;
        this.health=new Health(healthAmount);
        this.defensePoints=defensePoints;
        this.attackPoints=attackPoints;
        this.messageHandler=new EventHandler();
    }

    public void loseHealth(Integer toLose) {
        Integer healthNew = this.getHealthAmount() - toLose;
        if (healthNew <= 0) { // if the new health is lesser then 0 -> put 0
            this.health.setHealthAmount(0);
            this.isDead = true;
        } else
            this.health.setHealthAmount(healthNew);
    }
    public Integer getHealthAmount() {
        return this.health.getHealthAmount();
    }
    public Integer getDefensePoints() {
        return defensePoints;
    }
    public Integer getAttackPoints() {
        return attackPoints;
    }
    public boolean isDead(){ return this.isDead;}
    public String getName() {
        return name;
    }
    public abstract String printer();

    public void setIsDead(){
        this.isDead=true;
    }
    public boolean getIsDead(){
        return isDead;
    }
}