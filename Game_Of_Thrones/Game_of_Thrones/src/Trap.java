public class Trap extends Enemy {
    int visibilityTime;
    int invisibilityTime;
    int tickCount;
    boolean visible;
    protected Trap(char tile,Pos position, String name, int healthPool, int healthAmount, int attackPoints, int defencePoints, int experienceValue,int visibilityTime,int invisibilityTime) {
        super(tile,position,name, healthPool, healthAmount, attackPoints, defencePoints, experienceValue);
        this.visibilityTime = visibilityTime;
        this.invisibilityTime = invisibilityTime;
        tickCount = 0;
        visible = true;
    }
}
