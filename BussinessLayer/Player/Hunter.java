package BussinessLayer.Player;

import BussinessLayer.Enemy.Enemy;
import BussinessLayer.Tiles.Point;
import BussinessLayer.Level;

import java.util.List;

public class Hunter extends Player {
    // ----------------------------------- fields ----------------------------------------------------------------------
    protected Integer range;
    protected Integer arrowsCount;
    protected Integer ticksCount;
    protected Integer abilityRange;
    //constructor
    public Hunter(String name, Integer range, Point position,Level level, Integer healthAmount, Integer defensePoints, Integer attackPoints) {
        super(name, position,level, healthAmount, defensePoints, attackPoints);
        setAbilityRange(range);
        this.ticksCount = 0;
        this.arrowsCount = 10 * this.playerLevel;
    }
    // ----------------------------------- methods ----------------------------------------------------------------------
    public void LevelUp(){
        if (exp>=playerLevel*50) {
            this.levelup();
            arrowsCount=arrowsCount+(10*playerLevel);
            attackPoints=attackPoints+(2*playerLevel);
            defensePoints=defensePoints+(1*playerLevel);
        }
    }
    public void setExp(Integer exp1){
        this.exp=exp1;
        LevelUp(); // check if the player level should be increase
    }
    public void tick(){
        if (ticksCount==10){
            arrowsCount=arrowsCount+playerLevel;
            ticksCount=0;
        }
        else
            ticksCount++;
    }
    public void castAbility(List<Enemy> enemiesToKill){
        //Hunter specialability
        if (this.arrowsCount==0){
            this.messageHandler.Print(" cant cast ability yet");
        }
        if (enemiesToKill==null){
            this.messageHandler.Print(" cant cast ability - there is not enemies in the range");
        }
        if (enemiesToKill!=null){
            Enemy enemy=enemiesToKill.get(0);
            double closestRange=this.range(enemy);
            arrowsCount--;
            // have to find the most closest enemy
            for (Enemy item : enemiesToKill) {
                if (this.range(item)<closestRange){
                    enemy=item;
                    closestRange=this.range(item);
                }
                this.fight(enemy,this.attackPoints);
            }
            this.messageHandler.Print(this.printer()+" perform cast ability and now have Arrows Count : "+arrowsCount);
        }
    }
    public String printer() {
        //Hunter details
        String ans="";
        ans = ans + "Player: "+ this.getName()+" health: "+this.health.HealthAmount+"/"+this.health.getHealthPool()+" attack points: "+this.attackPoints+" defense points: "+this.defensePoints+ " level: "+this.playerLevel+" experience: "+this.exp+" Range: "+getAbilityRange()+" Arrows Count: "+arrowsCount+" Ticks Count: "+ticksCount+" ";
        return ans;
    }
}
