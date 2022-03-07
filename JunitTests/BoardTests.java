package JunitTests;

import BussinessLayer.*;
import BussinessLayer.Enemy.Enemy;
import BussinessLayer.Enemy.Monster;
import BussinessLayer.Enemy.Trap;
import BussinessLayer.Player.Player;
import BussinessLayer.Player.Warrior;
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

public class BoardTests {
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
        monster = new Monster("ben",10,new Point(2,0),100,5,50,100,'k');
        trap = new Trap("azam",20,3,new Point(2,1),50,30,50,1,'S');
        player =new Warrior("regev",50,new Point(2,2),first,100,50,50);
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

    void TilesSwap1() {
        first.swap(board[0][0],board[1][1]);
        Assertions.assertEquals('.',board[0][0].getTileType());
        Assertions.assertEquals('#',board[1][1].getTileType());
        System.out.println("Tiles changed as expected");


    }
    @Test

    void TilesSwap2() {
        try {
            first.swap(board[0][0], board[3][3]);
        }
        catch (Exception e){
            System.out.println("exception expected, out of bounds");

        }
    }
    @Test

    void EnemiesAreDead1() {
        boolean flag = first.EnemiesAreDead();
        System.out.println("Enemies are alive");
        Assertions.assertFalse(flag);

    }
    @Test

    void EnemiesAreDead2() {
        monster.setIsDead();
        trap.setIsDead();
        boolean flag = first.EnemiesAreDead();
        System.out.println("Enemies are Dead");
        Assertions.assertTrue(flag);

    }
    @Test

    void EnemiesAreDead3() {
        monster.setIsDead();
        boolean flag = first.EnemiesAreDead();
        System.out.println("Not All Enemies are Dead");
        Assertions.assertFalse(flag);

    }
    @Test

    void EnemiesAreDead4() {
        Point pos = monster.getPosition();
        first.enemyDead(monster);
        System.out.println("Dead enemy turns to empty tile");
        Assertions.assertEquals(".",first.getTile(pos).toString());

    }

}
