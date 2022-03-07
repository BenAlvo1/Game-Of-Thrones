package BussinessLayer;

import BussinessLayer.Player.Player;
import BussinessLayer.Tiles.Point;

import java.util.Scanner;

import static BussinessLayer.Starter.createPlayers;

public class EventHandler {
    //using Singleton pattern
    private static EventHandler eventHandler;

    public static EventHandler create(){
        if (eventHandler==null){
            eventHandler=new EventHandler();
        }
        return eventHandler;

    }

    public void Print(String message){
        System.out.println(message);
    }
    public Player chosePlayer(Point position, Level firstLevel) {
        Player[] characters = createPlayers(position,firstLevel);
        this.Print("Choose a player");
        for (int i = 0; i < characters.length; i++) {
            this.Print("Choose "+(i+1) +" for "+characters[i].printer() );
        }
        Scanner scan = new Scanner(System.in);
        int index = scan.nextInt();
        while ((index<1 | index>characters.length))
        {
            this.Print("no such player, please choose again");
            index = scan.nextInt();

        }
        Player chosen = characters[index - 1];
        return chosen;


    }
    public int inputReciever() {
        this.Print("please press a bottun");

        Scanner scan = new Scanner(System.in);
        char function = scan.next().charAt(0);
        if ((function == 'w') | (function=='W'))
            return 1;
        if ((function == 's') | (function=='S'))
            return 2;
        if ((function == 'd') | (function=='D'))
            return 3;
        if ((function == 'a') | (function=='A'))
            return 4;
        if ((function == 'e') | (function=='E'))
            return 5;
        if ((function == 'q') | (function=='Q'))
            return 6;
        else {
            this.Print("Please use the game buttons");
            return 7;
        }
    }
}
