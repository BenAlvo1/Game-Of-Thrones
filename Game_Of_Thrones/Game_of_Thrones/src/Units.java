abstract class Units extends Tiles {
    String name;
    int healthPool;
    int healthAmount;
    int attackPoints;
    int defencePoints;

    protected Units(char tile,Pos position,String name, int healthPool, int healthAmount, int attackPoints, int defencePoints) {
        super(tile,position);
        this.name = name;
        this.healthPool = healthPool;
        this.healthAmount = healthAmount;
        this.attackPoints = attackPoints;
        this.defencePoints = defencePoints;
    }
    protected void Move(String c){
        if(c=="w")
            position.setY(position.getY()+1);
        else if(c=="s")
            position.setY(position.getY()-1);
        else if(c=="a")
            position.setX(position.getX()-1);
        else   position.setX(position.getX()+1);

    }
}
