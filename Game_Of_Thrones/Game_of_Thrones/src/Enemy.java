public class Enemy extends Units{
    int experienceValue;
    protected Enemy(char tile,Pos position, String name, int healthPool, int healthAmount, int attackPoints, int defencePoints,int experienceValue) {
        super(tile,position, name, healthPool, healthAmount, attackPoints, defencePoints);
        this.experienceValue = experienceValue;
    }
}
