package BussinessLayer.Resource;

public class Energy {
    Integer EnergyCost;
    Integer currentEnergy;
    Integer PlayerLevel;

    public Energy ( Integer EnergyCost) {
        //constructor
        this.EnergyCost = EnergyCost;
        this.currentEnergy = 100;
        this.PlayerLevel = 1;
    }
    public void Tick() {
        this.currentEnergy=Math.min(currentEnergy+10,100);
    }
    public void LevelUp() {
        currentEnergy = 100;
    }
    public void SpecialAttack(){
        currentEnergy = currentEnergy - EnergyCost;
    }
    public boolean readyToCast(){
        return currentEnergy > EnergyCost;
    }
    public Integer getEnergy(){
        return currentEnergy;
    }
}
