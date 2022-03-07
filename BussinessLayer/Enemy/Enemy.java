package BussinessLayer.Enemy;


import BussinessLayer.*;
import BussinessLayer.Player.Player;
import BussinessLayer.Tiles.EmptyTile;
import BussinessLayer.Tiles.Point;
import BussinessLayer.Tiles.Unit;
import BussinessLayer.Tiles.Wall;

import static BussinessLayer.Player.Player.random;

public abstract class Enemy extends Unit {

    protected Integer enemyExp;
    //constructor
    public Enemy(String name, Point position, Integer healthAmount, Integer defensePoints, Integer attackPoints, Integer exp, char type){
        super(name,type,position,healthAmount,defensePoints,attackPoints);
        this.enemyExp=exp;
    }

    public boolean visit(Player player){
        // rolling defense and attack points
        Integer attackerRoll = random(0,this.getAttackPoints());
        this.messageHandler.Print(this.printer()+" attack with " + attackerRoll + " attack points");
        Integer defenderRoll = random(0,player.getDefensePoints());
        this.messageHandler.Print(player.printer()+" defend with " + defenderRoll + " defend points");
        Integer sum = attackerRoll - defenderRoll; // the damage
        if (attackerRoll - defenderRoll > 0) {
            player.loseHealth(sum);
            this.messageHandler.Print(player.printer()+" damaged with "+sum+" and now remain with "+player.getHealthAmount()+" health amount");
            if (player.getHealthAmount() <= 0) {
                player.setTileType('X');
                player.SetIsDead();
            }
        }
        return false;
    }
    public boolean visit(Enemy enemy){return false;} // enemy cant step into an enemy tile
    public boolean visit(Wall wall){return false;}// enemy cant step into a wall
    public boolean visit(EmptyTile empty){
        return true;
    } // enemy step into an empty tile
    public boolean accept(visitor v){return v.visit(this);}
    public Integer getExpValue()
    {
        return this.enemyExp;
    }
    public abstract Integer tick(Player player);
    public abstract String printer();








}