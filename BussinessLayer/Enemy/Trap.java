package BussinessLayer.Enemy;


import BussinessLayer.Player.Player;
import BussinessLayer.Tiles.Point;

public class Trap extends Enemy {

    private Integer visibilityTime;
    private Integer invisibilityTime;
    private Integer ticksCount;
    private boolean visible;
    private char type;
    //constructor
    public Trap(String name, Integer visibilityTime, Integer invisibilityTime, Point position, Integer healthAmount, Integer defensePoints, Integer attackPoints, Integer exp, char type){
        super(name,position,healthAmount,defensePoints,attackPoints,exp,type);
        this.ticksCount=0;
        this.visibilityTime=visibilityTime;
        this.invisibilityTime=invisibilityTime;
        this.visible=true;
        this.type=type;
    }

    public Integer tick(Player player){
        //Trap visibility method
        this.visible=this.ticksCount<this.visibilityTime;
        if (ticksCount==(visibilityTime+invisibilityTime)){
            ticksCount=0;
        }
        else {
            ticksCount++;

        }
        if (this.range(player)<2){
            player.accept(this);

        }
        return -1;
    }
    public String printer() {
        //Trap details
        String ans="";
        ans = ans + "The Enemy "+ this.getName()+" Health: "+this.getHealthAmount()+ " Experience: "+this.enemyExp + " Attack Points: "+this.attackPoints+" Defense Points: "+this.defensePoints+" ticks count:"+ticksCount+" visibility time: "+" invisibility time: "+invisibilityTime+" visible:"+visible;
        return ans;
    }
    public char getTileType() {
        if (visible)
            return this.type;
        else return '.';
    }

}
