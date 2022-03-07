package BussinessLayer.Resource;

import static java.lang.Math.*;

public class Mana {
    Integer ManaPool;
    Integer ManaCost;
    Integer currentMana;
    Integer PlayerLevel;

    public Mana(Integer ManaPool,Integer ManaCost) {
        //constructor
        this.ManaPool = ManaPool;
        this.ManaCost = ManaCost;
        this.currentMana = ManaPool / 4;
        this.PlayerLevel = 1;
    }
    public void Tick() {
        this.currentMana = min(ManaPool,currentMana + PlayerLevel);
    }
    public void LevelUp() {
        ManaPool = ManaPool + (25 * PlayerLevel);
        currentMana = Math.min(currentMana + ManaPool / 4, ManaPool);
        PlayerLevel++;
    }
    public void SpecialAttack(){
        currentMana = currentMana - ManaCost;
    }
    public boolean readyToCast(){
        return currentMana > ManaCost;
    }
    public Integer getManaPool(){
        return ManaPool;
    }
    public Integer getCurrMana() {
        return currentMana;
    }
    public void setPlayerLevel(Integer newLevel){
        PlayerLevel = newLevel;
    }
}
