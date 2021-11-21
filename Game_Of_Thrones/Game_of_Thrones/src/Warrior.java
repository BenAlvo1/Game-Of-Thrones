public class Warrior extends Player {
    String specialAbility = "Avenger's Shield";
    int abilityCoolDown;
    int remainingCoolDown;
    public Warrior(char tile,Pos position, String name, int healthPool, int healthAmount, int attackPoints, int defencePoints, int abilityCoolDown) {
        super(tile,position, name, healthPool, healthAmount, attackPoints, defencePoints);
        this.abilityCoolDown = abilityCoolDown;
        remainingCoolDown = 0;
    }

    @Override
    protected void levelUp() {
        super.levelUp();
        remainingCoolDown = 0;
        healthPool += 5*level;
        attackPoints += 2*level;
        defencePoints += level;
    }

    private void onGameTick(){
        if (remainingCoolDown>0)
            remainingCoolDown-=1;
    }

    public void onAbilityCast(){
        remainingCoolDown = abilityCoolDown;
        healthAmount = Math.min(healthAmount+(10*defencePoints),healthPool);
    }
}
