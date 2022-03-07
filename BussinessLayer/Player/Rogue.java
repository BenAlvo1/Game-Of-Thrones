package BussinessLayer.Player;

import BussinessLayer.Enemy.Enemy;
import BussinessLayer.Tiles.Point;
import BussinessLayer.Resource.Energy;
import BussinessLayer.Level;
import java.util.List;

public class Rogue extends  Player {

    protected Energy myEnergy;
    protected Integer Abilitycost;
    protected Integer abilityRange;
    //constructor
    public Rogue(String name, Integer cost, Point position,Level level, Integer healthAmount, Integer defensePoints, Integer attackPoints){
        super(name,position,level,healthAmount,defensePoints,attackPoints);
        this.myEnergy = new Energy(cost);
        setAbilityRange(2);
        this.Abilitycost =cost;
    }

    public void LevelUp(){
        if (exp>=playerLevel*50) {
            this.levelup();
            myEnergy.LevelUp();
            attackPoints = attackPoints + (3 * getlevel());
        }
    }
    public void tick(){
        myEnergy.Tick();
    }
    public void setExp(Integer exp1){
        this.exp=exp1;
        this.LevelUp(); // check if the player level should be increase
    }
    public void castAbility(List<Enemy> enemiesToKill){
        //Rogue specialability
        if (!myEnergy.readyToCast()){
            this.messageHandler.Print(" cant cast ability yet");
        }
        else {
            myEnergy.SpecialAttack();
            if (enemiesToKill!=null) {
                for (Enemy enemy : enemiesToKill) {
                    this.fight(enemy, this.attackPoints);
                }
            }
            this.messageHandler.Print(this.printer()+" use Fan of Knives and now has current energy : "+myEnergy.getEnergy());
        }
    }
    public String printer() {
        String ans="";
        ans = ans + "Player: "+ this.getName()+" health: "+this.health.HealthAmount+"/"+this.health.getHealthPool()+" attack points: "+this.attackPoints+" defense points: "+this.defensePoints+ " level: "+this.playerLevel+" experience: "+this.exp+" cost:"+Abilitycost+" current energy:"+myEnergy.getEnergy();
        return ans;
    }

}
