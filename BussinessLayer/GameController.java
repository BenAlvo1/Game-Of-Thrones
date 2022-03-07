package BussinessLayer;

import BussinessLayer.Player.Player;

import java.util.List;

public class GameController {

    private Level currLevel;
    private List<Level> levels;
    private Player player;
    private int indexLevel;
    private EventHandler messageHandler;

    public GameController(List<Level> levels, Player player){
        this.levels=levels;
        currLevel=levels.get(0);
        this.player=player;
        player.setLevel(currLevel);
        indexLevel=0;
        this.messageHandler=new EventHandler();
    }

    public void play(){
        boolean gameOver=false;
        while (currLevel.EnemiesAreDead()!=true){

            // Printing
            messageHandler.Print(currLevel.printer()); // Print the board
            messageHandler.Print(player.printer()); // Print player stats

            int direction=messageHandler.inputReciever(); // Scans the player next move
            currLevel.tick(direction); // Gametick


            if (player.isDead()){ // Player lose and finishes the game
                currLevel.getTile(player.getPosition()).setTileType('X');
                messageHandler.Print("You Are Dead - Game Over");
                messageHandler.Print(currLevel.printer());
                gameOver=true;
                break;
            }
        }
        if(!gameOver) {
            // Go to the next level or finish the game upon victory
            indexLevel++;
            if (indexLevel == levels.size()) { // the player wins
                messageHandler.Print("You Are The Winner");

            }
            else
            {
                // Upload the next level map
                player.setPosition(null);
                currLevel = levels.get(indexLevel);
                currLevel.setPlayerInTheBoardGame(player);
                player.setLevel(currLevel);
                this.play(); // play next level
            }
        }
    }

}



