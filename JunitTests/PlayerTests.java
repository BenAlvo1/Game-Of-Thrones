package JunitTests;

import BussinessLayer.Enemy.Enemy;
import BussinessLayer.Enemy.Monster;
import BussinessLayer.Enemy.Trap;
import BussinessLayer.Level;
import BussinessLayer.Player.*;
import BussinessLayer.Tiles.EmptyTile;
import BussinessLayer.Tiles.Point;
import BussinessLayer.Tiles.Tile;
import BussinessLayer.Tiles.Wall;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class PlayerTests {
    Tile[][] board;
    List<Enemy> enemeis;
    Level first;
    Wall wall1;
    Wall wall2;
    Wall wall3;
    EmptyTile empty1;
    EmptyTile empty2;
    EmptyTile empty3;
    Monster monster;
    Trap trap;
    Player player;


    @BeforeEach
    void setUp() {

        wall1 = new Wall(new Point(0,0));
        wall2= new Wall(new Point(0,1));
        wall3 = new Wall(new Point(0,2));
        empty1=new EmptyTile(new Point(1,0));
        empty2 = new EmptyTile(new Point(1,1));
        empty3 = new EmptyTile(new Point(1,2));
        monster = new Monster("Ben",10,new Point(2,0),100,5,50,100,'k');
        trap = new Trap("Azam",20,3,new Point(2,1),50,30,50,1,'S');
        player =new Rogue("Regev",50,new Point(2,2),first,100,50,50);
        enemeis = new LinkedList<Enemy>();
        enemeis.add(trap);
        enemeis.add(monster);
        board = new Tile[3][3];
        board[0][0]=wall1;
        board[0][1]=wall2;
        board[0][2]=wall3;
        board[1][0]= empty1;
        board[1][1]= empty2;
        board[1][2]= empty3;
        board[2][0]= monster;
        board[2][1]=trap;
        board[2][2]= player;
        first = new Level(board,enemeis,player);


    }
    @AfterEach
    void tearDown() {
    }

    @Test

    void HunterSecialAbility() {
        player = new Hunter("Ygritte",6, new Point(2,2),first, 220,2,30);
        first.tick(5);
        boolean flag = trap.getIsDead();
        System.out.println("Hunter specialAbility works");
        Assertions.assertFalse(flag);


    }
    @Test

    void WarriorSecialAbility() {
        player = new Warrior("The Hound", 5,  new Point(2,2),first,  400, 6, 20);
        first.tick(5);
        boolean flag = trap.getIsDead();
        System.out.println("Rogue specialAbility works");
        Assertions.assertFalse(flag);
    }
    @Test

    void RoguesSecialAbility() {
        first.tick(5);
        boolean flag = trap.getIsDead();
        System.out.println("Rogue specialAbility works");
        Assertions.assertFalse(flag);

    }
    @Test

    void MageSecialAbility() {
        player = new Mage("Thoros of Myr", 150, 20, 20, 5, 4, new Point(2,2),first,  250, 4, 25);
        first.tick(5);
        boolean flag = trap.getIsDead();
        System.out.println("Rogue specialAbility works");
        Assertions.assertFalse(flag);

    }
}
