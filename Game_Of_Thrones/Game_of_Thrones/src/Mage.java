public class Mage extends Player {
    String specialAbility = "Blizzard";
    int manaPool;
    int currentMana;
    int manaCost;
    int spellPower;
    int hitsCount;
    int abilityRange;
    protected Mage(char tile,Pos position, String name, int healthPool, int healthAmount, int attackPoints, int defencePoints,int manaPool,int spellPower,int manaCost,int hitsCount,int abilityRange) {
        super(tile,position, name, healthPool, healthAmount, attackPoints, defencePoints);
        this.manaPool = manaPool;
        this.spellPower = spellPower;
        this.manaCost = manaCost;
        this.hitsCount = hitsCount;
        this.abilityRange = abilityRange;
        currentMana = manaPool/4;
    }

    @Override
    protected void levelUp() {
        super.levelUp();
        manaPool = manaPool+ 25*level;
        currentMana = Math.min(currentMana+(manaPool/4),manaPool);
        spellPower = spellPower + 10*level;
    }

    private void onGameTick(){
        currentMana = currentMana-manaCost;
        int hits = 0;
        while (hits<hitsCount){}
    }
}
