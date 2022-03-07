package BussinessLayer.Player;

import BussinessLayer.Enemy.Enemy;
import BussinessLayer.Tiles.Point;
import BussinessLayer.Resource.Mana;
import BussinessLayer.Level;

import java.util.List;

public class Mage extends Player {
    // ----------------------------------- fields ----------------------------------------------------------------------
    protected Integer manaCost;
    protected Integer spellPower;
    protected Integer hitsCount;
    protected Integer abilityRange;
    protected Mana myMana;
    //constructor
    public Mage(String name, Integer manaPool, Integer manaCost, Integer spellPower, Integer hitsCount, Integer abilityRange, Point position,Level level, Integer healthAmount, Integer defensePoints, Integer attackPoints){
        super(name,position,level,healthAmount,defensePoints,attackPoints);
        this.myMana = new Mana(manaPool,manaCost);
        this.manaCost=manaCost;
        this.spellPower=spellPower;
        this.hitsCount=hitsCount;
        setAbilityRange(abilityRange);

    }
    public void LevelUp(){
        if (exp>=playerLevel*50) {
            this.levelup();
            myMana.LevelUp();
            spellPower = spellPower + (10 * getlevel());
        }
    }
    public void setExp(Integer exp1){
        this.exp=exp1;
        LevelUp(); // check if the player level should be increase
    }
    public void tick(){
        myMana.Tick();
    }
    public void castAbility(List<Enemy> enemiesToKill){
        //Mage specialability
        if (!myMana.readyToCast()){
            this.messageHandler.Print(" cant cast ability yet");
        }
        else {
            if (enemiesToKill==null){
                this.messageHandler.Print(" No Enemies To Attack");
            }
            else{
                myMana.SpecialAttack();
                int hits=0;
                while (((hits<this.hitsCount) && (enemiesToKill.size() > 0))){
                    int ran = random(0, enemiesToKill.size()-1);
                    Enemy toHit = enemiesToKill.get(ran);
                    int damage=this.spellPower;
                    this.fight(toHit,damage);
                    hits++;
                    if (toHit.getIsDead())
                        enemiesToKill.remove(toHit);
                }
                this.messageHandler.Print(this.printer()+" use Blizzard and now have Mana : "+myMana.getCurrMana());
            }

        }
    }
    public String printer() {
        //Mage details
        String ans="";
        ans = ans + "Player: "+ this.getName()+" health: "+this.health.HealthAmount+"/"+this.health.getHealthPool()+" attack points: "+this.attackPoints+" defense points: "+this.defensePoints+ " level: "+this.playerLevel+" experience: "+this.exp+" Mana: "+myMana.getCurrMana()+"/"+myMana.getManaPool()+" mana cost:" + manaCost+ " spell power:"+spellPower+" hits count:"+hitsCount+ " ability range: "+getAbilityRange();
        return ans;
    }


}
