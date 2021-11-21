public class Player extends Units{
    int experience;
    int level;
    protected Player(char tile,Pos position,String name, int healthPool, int healthAmount, int attackPoints, int defencePoints) {
        super(tile,position,name, healthPool, healthAmount, attackPoints, defencePoints);
        experience = 0;
        level = 1;
    }
    protected void levelUp(){
        if(experience == level*50){
            level+=1;
            experience -= 50*level;
            healthPool += 10*level;
            healthAmount = healthPool;
            attackPoints += 4*level;
            defencePoints += level;
        }
    }

    protected void onAbilityCastAttempt(){
    }



}
