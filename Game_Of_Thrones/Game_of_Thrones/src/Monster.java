public class Monster extends Enemy{
    int visionRange;
    protected Monster(char tile,Pos position, String name, int healthPool, int healthAmount, int attackPoints, int defencePoints, int experienceValue,int visionRange) {
        super(tile,position, name, healthPool, healthAmount, attackPoints, defencePoints, experienceValue);
        this.visionRange = visionRange;
    }

}
