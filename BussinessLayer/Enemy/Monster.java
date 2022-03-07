package BussinessLayer.Enemy;
import BussinessLayer.Player.Player;
import BussinessLayer.Tiles.Point;

import static BussinessLayer.Player.Player.random;

public class Monster extends Enemy {
    private Integer visionRange;
    //constructor
    public Monster(String name, Integer visionRange, Point position, Integer healthAmount, Integer defensePoints, Integer attackPoints, Integer exp, char type){
        super(name,position,healthAmount,defensePoints,attackPoints,exp,type);
        this.visionRange=visionRange;
    }

    public Integer tick(Player player) {
        //Monster moves towards the player
        int dx=0;
        int dy=0;
        Point place;
        Integer direction;
        Point playerPosition=player.getPosition();
        if (this.range(player) < this.visionRange)
        {
            dy = this.getPosition().getX() - playerPosition.getX();
            dx = this.getPosition().getY() - playerPosition.getY();
            if (Math.abs(dx) > Math.abs(dy))
            {
                if (dx > 0)
                { // moving left
                    direction = 2;
                }
                else
                { // moving right
                    direction = 1;
                }
            }
            else
            {
                if (dy>0)
                { // moving up
                    direction = 3;
                }
                else
                { // moving down
                    direction = 4;
                }
            }
        }
        else
        {
            //Monster randomly moves
            Integer ran = random(1,5);
            direction = ran;

        }
        return direction;

    }
    public String printer() {
        //Details on the monster
        String ans="";
        ans = ans + " The Enemy "+ this.getName()+" Health: "+this.getHealthAmount()+ " Enemy Experience: "+this.enemyExp + " Attack Points: "+this.attackPoints+" Defense Points: "+this.defensePoints+" Vision Range: "+visionRange;
        return ans;
    }
}
