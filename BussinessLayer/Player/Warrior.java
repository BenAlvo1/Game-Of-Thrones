package BussinessLayer.Player;

import BussinessLayer.Enemy.Enemy;
import BussinessLayer.Tiles.Point;
import BussinessLayer.Level;

import java.util.List;

public class Warrior extends Player {

    protected Integer abilityCooldown; // number of rounds between using this ability
    protected Integer remainingCooldown; // amount of rounds until using again
    protected Integer abilityRange;
    //constructor
    public Warrior(String name, int abilityCooldown, Point position,Level level, Integer healthAmount, Integer defensePoints, Integer attackPoints){
        super(name,position,level,healthAmount,defensePoints,attackPoints);
        this.abilityCooldown=abilityCooldown;
        setAbilityRange(2);
        remainingCooldown=0;
    }

    public void tick(){
        if (remainingCooldown>0)
            this.remainingCooldown--;
    }
    public void setExp(Integer exp1){
        this.exp=exp1;
        this.LevelUp(); // check if the player level should be increase
    }
    public void castAbility(List<Enemy> enemiesToKill){
        //Warrior specialability
        if (this.remainingCooldown>0){
            this.messageHandler.Print("cant cast ability yet");
        }
        else {
            remainingCooldown=abilityCooldown;
            this.health.setHealthAmount(Math.min(health.getHealthAmount()+(10*this.defensePoints),health.getHealthPool()));
            if (enemiesToKill!=null) {
                int ran = random(0, enemiesToKill.size() - 1);
                Enemy toHit = enemiesToKill.get(ran);
                int damage = this.health.getHealthPool() / 10;
                toHit.loseHealth(damage);
                this.messageHandler.Print(this.printer()+" use Avenger’s Shield, and now have "+remainingCooldown+" remaining cool down,new health amount:"+this.getHealthAmount()+" and damage "+toHit.printer()+ "by "+damage);
            }
            else
                this.messageHandler.Print(this.printer()+" perform cast ability and now have "+remainingCooldown+" remaining cool down,new health amount:"+this.getHealthAmount());

        }
    }
    public String printer() {
        String ans="";
        ans = ans + "Player: "+ this.getName()+" health: "+this.health.HealthAmount+"/"+this.health.getHealthPool()+" attack points: "+this.attackPoints+" defense points: "+this.defensePoints+ " level: "+this.playerLevel+" experience: "+this.exp+" remain cool down:"+remainingCooldown+"/"+abilityCooldown;
        return ans;
    }
    public void LevelUp(){
        if (exp>=playerLevel*50) {
            this.levelup();
            remainingCooldown = 0;
            this.health.setHealthPool(health.getHealthPool() + (5 * getlevel()));
            this.attackPoints = attackPoints + (2 * getlevel());
            this.defensePoints = defensePoints + getlevel();
        }
    }



}
