public class Rogue extends Player {
    String specialAbility = "Fan of Knives";
    int cost;
    int currentEnergy;

    protected Rogue(char tile,Pos position, String name, int healthPool, int healthAmount, int attackPoints, int defencePoints,int cost) {
        super(tile,position, name, healthPool, healthAmount, attackPoints, defencePoints);
        this.cost = cost;
        currentEnergy = 100;
    }

    @Override
    protected void levelUp() {
        super.levelUp();
        currentEnergy =100;
        attackPoints = attackPoints + 3*level;
    }

    private void onGameTick(){
        currentEnergy = Math.min(currentEnergy+10,100);
    }

    public void onAbilityCast(){
        currentEnergy = currentEnergy-cost;

    }
}
