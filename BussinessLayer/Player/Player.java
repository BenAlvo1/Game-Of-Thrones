package BussinessLayer.Player;
import BussinessLayer.*;
import BussinessLayer.Enemy.Enemy;
import BussinessLayer.Tiles.EmptyTile;
import BussinessLayer.Tiles.Point;
import BussinessLayer.Tiles.Unit;
import BussinessLayer.Tiles.Wall;

import java.util.List;

public abstract class Player extends Unit {
    protected Integer playerLevel;
    protected Integer exp;
    protected Integer abilityRange;
    protected Level level;
    //constructor
    public Player(String name, Point position, Level level, Integer healthAmount, Integer defensePoints, Integer attackPoints){
        super(name, '@', position, healthAmount,defensePoints,attackPoints);
        this.level = level;
        playerLevel=1;
        exp=0;
    }

    public boolean visit(Player player){return false;}
    public boolean visit(Enemy enemy){
        // rolling defense and attack points
        Integer attackerRoll = random(0,this.getAttackPoints());
        this.messageHandler.Print(" "+this.printer()+" attack with " + attackerRoll + " attack points");
        Integer defenderRoll = random(0,enemy.getDefensePoints());
        this.messageHandler.Print(" "+enemy.printer()+"  defend with " + defenderRoll + " defense points");
        Integer sum = attackerRoll - defenderRoll; // the damage
        if (sum > 0) { // player wins
            enemy.loseHealth(sum);
            this.messageHandler.Print(enemy.printer()+" damaged with "+sum+" and now remain with "+enemy.getHealthAmount()+" health amount");
            if (enemy.isDead()) {
                this.setExp(this.getExp() + enemy.getExpValue()); // player earn the enemy's exp,this method are responsible to check about the level
                this.messageHandler.Print(this.printer()+" gained "+enemy.getExpValue()+" experience");
                this.messageHandler.Print(enemy.printer()+" is dead");
                this.messageHandler.Print(this.printer());
                level.enemyDead(enemy);


            }
        }
        return isDead;
    } // player attack enemy
    public boolean visit(Wall wall){
        messageHandler.Print(" cant move into a wall");
        return false;} // player cant step into a wall
    public boolean visit(EmptyTile empty){
        return true;
    } // player step into an empty tile
    public boolean accept(visitor v){return v.visit(this);}
    public abstract void tick();
    public Integer getlevel(){return this.playerLevel;} // player level - not game level
    public Integer getExp(){return exp;}
    public abstract void setExp(Integer exp1);
    public void levelup() {
        exp = exp - (50 * playerLevel);
        playerLevel++;
        this.health.setHealthPool(this.health.getHealthPool() + (10 * playerLevel));
        this.health.setHealthAmount(this.health.getHealthPool()); //have to check what is current health
        attackPoints = attackPoints + (4 * playerLevel);
        defensePoints = defensePoints + playerLevel;
        this.messageHandler.Print(this.printer()+" is level up to "+this.playerLevel+" level");
    } // for all the players(to override)
    public abstract void castAbility(List<Enemy> enemiesToKill);

    public abstract String printer();
    public void SetIsDead() {
        this.isDead=true;
    }
    public boolean fight(Enemy enemy,Integer attackerRoll){ // player attack enemy - for the cast ability only, when the attack points determine
        this.messageHandler.Print(" "+this.printer()+" attack with " + attackerRoll + " attack points");
        Integer defenderRoll = random(0,enemy.getDefensePoints());
        this.messageHandler.Print(" "+enemy.printer()+"  defend with " + defenderRoll + " defense points");
        Integer sum = attackerRoll - defenderRoll;
        if (sum > 0) { // player wins
            enemy.loseHealth(sum);
            this.messageHandler.Print(enemy.printer()+" damaged with "+sum+" and now remain with "+enemy.getHealthAmount()+" health amount");

            if (enemy.isDead()) {
                this.setExp(this.getExp() + enemy.getExpValue()); // player earn the enemy's exp,this method are responsible to check about the level
                this.messageHandler.Print(this.printer()+" gained "+enemy.getExpValue()+" experience");
                this.messageHandler.Print(enemy.printer()+" is dead");
                this.messageHandler.Print(this.printer());
                level.enemyDead(enemy);
            }
        }
        return isDead;
    }
    public Integer getAbilityRange(){
        return this.abilityRange;
    }
    public void setAbilityRange(Integer range){
        this.abilityRange = range;
    }
    public void setLevel(Level level){
        this.level = level;
    }
    public static Integer random(Integer lower,Integer higher){
        //Method for the damage roll
        double r =  (Math.random()*(higher-lower+1))+lower;
        return (int)r;
    }
}