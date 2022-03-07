package BussinessLayer;

import BussinessLayer.Enemy.Enemy;
import BussinessLayer.Player.Player;
import BussinessLayer.Tiles.EmptyTile;
import BussinessLayer.Tiles.Point;
import BussinessLayer.Tiles.Tile;

import java.util.LinkedList;
import java.util.List;

public class Level {

    private Tile[][] boardGame;
    public List<Enemy> enemyList;
    private EventHandler messageHandler;
    private Player player;
    //constructor
    public Level(Tile[][] board, List<Enemy> enemies,Player player){
        this.boardGame=board;
        this.enemyList=enemies;
        this.messageHandler=new EventHandler();
        this.player = player;
    }
    //tiles swap
    public void swap(Tile a,Tile b){ // a move forward to b
        Point aPosition = a.getPosition();
        Point bPosition = b.getPosition();
        a.setPosition(b.getPosition());
        b.setPosition(aPosition);
        boardGame[a.getPosition().getX()][a.getPosition().getY()]=a;
        boardGame[b.getPosition().getX()][b.getPosition().getY()]=b;

    }
    //will trigger uploading the next level
    public boolean EnemiesAreDead() {
        for (Enemy enemy : enemyList)
        {
            if (!enemy.isDead())
                return false;
        }
        return true;
    }
    //Removes a dead enemy from the board
    public void enemyDead(Tile a) {
        Point pos = a.getPosition();
        EmptyTile toEnter = new EmptyTile(pos);
        boardGame[pos.getX()][pos.getY()]=toEnter;
        enemyList.remove(a);

    }
    public Tile getTile (Point position)
    {
        return boardGame[position.getX()][position.getY()];
    }
    //checks if the tile is withing the board boundary
    public boolean isValidPoint(Point toMove) {
        int x = toMove.getX();
        int y=toMove.getY();
        if (x<0 | x>this.boardGame.length | y<0 | y>this.boardGame[0].length)
        {
            messageHandler.Print("cant move outside the board");
            return false;
        }
        return true;
    }
    public Point up(Tile tile) {

        Point toReturn = new Point(tile.getPosition().getX()-1, tile.getPosition().getY());
        if (isValidPoint(toReturn))
            return toReturn;
        else
            return null;
    }
    public Point down(Tile tile) {

        Point toReturn = new Point(tile.getPosition().getX()+1, tile.getPosition().getY());
        if (isValidPoint(toReturn))
            return toReturn;
        else
            return null;
    }
    public Point left(Tile tile) {
        Point toReturn = new Point(tile.getPosition().getX(), tile.getPosition().getY()-1);
        if (isValidPoint(toReturn))
            return toReturn;
        else
            return null;

    }
    public Point right(Tile tile) {
        Point toReturn = new Point(tile.getPosition().getX(), tile.getPosition().getY()+1);
        if (isValidPoint(toReturn))
            return toReturn;
        else
            return null;
    }
    public void updateEnemies(){
        for (Enemy enemy : enemyList){
            if (enemy.getIsDead()) {
                Point pos = enemy.getPosition();
                EmptyTile toEnter = new EmptyTile(pos);
                boardGame[pos.getX()][pos.getY()] = toEnter;
            }
        }
    }
    //A game tick, Player tick first and then the enemy
    public void tick(int direction) {
        if (direction==1) { // move up
            Point place = up(player);
            Tile tile = getTile(place);
            if (tile.accept(player)){
                swap(player,tile);
                this.messageHandler.Print(this.printer()+" moves up");
            }
        }
        if (direction==2) { // move down
            Point place = this.down(player);
            Tile tile = getTile(place);
            if (tile.accept(player)){
                swap(player,tile);
                this.messageHandler.Print(this.printer()+" moves down");
            }
        }
        if (direction==3) { // move right
            Point place = this.right(player);
            Tile tile = getTile(place);
            if (tile.accept(player)){
                swap(player,tile);
                this.messageHandler.Print(this.printer()+" moves right");
            }
        }
        if (direction==4) { // move left
            Point place = left(player);
            Tile tile = getTile(place);
            if (tile.accept(player)){
                swap(player,tile);
                this.messageHandler.Print(this.printer()+" moves left");
            }
        }
        if (direction==5) { // cast ability
            List<Enemy> enemiesToKill = LivingEnemyAtRange();
            player.castAbility(enemiesToKill);
        }

        for (Enemy enemy : enemyList)
        {

            Integer enemyDirection = enemy.tick(player);
            if (enemyDirection == 1){
                Point place = this.right(enemy);
                Tile tile = getTile(place);
                if(tile.accept(enemy)){
                    swap(enemy,tile);
                }
            }
            if (enemyDirection == 2){
                Point place = this.left(enemy);
                Tile tile = getTile(place);
                if(tile.accept(enemy)) {
                    swap(enemy, tile);
                }
            }
            if (enemyDirection == 3){
                Point place = this.up(enemy);
                Tile tile = getTile(place);
                if(tile.accept(enemy)) {
                    swap(enemy, tile);
                }
            }
            if (enemyDirection == 4){
                Point place = this.down(enemy);
                Tile tile = getTile(place);
                if(tile.accept(enemy)) {
                    swap(enemy, tile);
                }
            }
        }
        player.tick();
    }
    public List<Enemy> LivingEnemyAtRange(){
        //takes the ability Range from the player and returns list of enemies within range
        List<Enemy> enemyAtRange = new LinkedList<>(); // return null if there is no enemies in range
        int counter=0;
        Integer playerAbilityRange = player.getAbilityRange();
        List<Enemy> enemies = getEnemies();
        for (Enemy enemy : enemies)
        {
            if (player.range(enemy) <= playerAbilityRange) {
                enemyAtRange.add(enemy);
                counter++;
            }
        }
        if (counter==0)
            return null;
        else
            return enemyAtRange;

    }
    public List<Enemy> getEnemies() {
        return enemyList;
    }
    public Point getPlayerPosition() {
        for (int i=0;i<boardGame.length;i++){
            for (int j=0;j<boardGame[i].length;j++){
                if (boardGame[i][j].getTileType()=='@'){
                    int x=i;
                    int y=j;
                    Point toReturn = new Point(x,y);
                    return toReturn;
                }
            }
        }
        return null;
    }
    public String printer() {
        //board printer
        String answer="";
        for (int i=0;i<boardGame.length;i++){
            for (int j=0;j<boardGame[i].length;j++){
                answer=answer+" "+boardGame[i][j].getTileType();
            }
            answer=answer+"\n";
        }
        return answer;
    }
    public void setPlayerInTheBoardGame(Player player) {
        Point position = this.getPlayerPosition();
        boardGame[position.getX()][position.getY()]=player;
        player.setPosition(position);

    }
    public void setBoardGame(Tile[][] boardGame) {
        this.boardGame = boardGame;
    }
    public void setEnemyList(List<Enemy> enemyList) {
        this.enemyList = enemyList;
    }
    public void print(){
        //used for tests
        for(int i = 0; i < 6; i++)
        {
            for(int j = 0; j < 6; j++)
            {
                String type = boardGame[i][j].toString();
                System.out.printf(type);
            }
            System.out.println();
        }
    }
}
