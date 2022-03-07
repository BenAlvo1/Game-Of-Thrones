package BussinessLayer;

public class Main {

    /*public static void main(String[] args) {
        Point pp = new Point(1,1);
        List enemeis = new LinkedList<Enemy>();
        Tile[][] board = new Tile[6][6];
        Level currlevel = new Level(board,enemeis);

        Player player = new Rogue("arya",40,pp,10,10,10);
        Wall wall1 = new Wall(new Point(0,0));
        Wall wall2= new Wall(new Point(1,0));
        Wall wall3 = new Wall(new Point(2,0));
        Wall wall4 = new Wall(new Point(3,0));
        Wall wall5 = new Wall(new Point(4,0));
        Wall wall6 = new Wall(new Point(5,0));
        Wall wall7 = new Wall(new Point(0,5));
        Wall wall8 = new Wall(new Point(1,5));
        Wall wall9 = new Wall(new Point(2,5));
        Wall wall10 = new Wall(new Point(3,5));
        Wall wall11 = new Wall(new Point(4,5));
        Wall wall12 = new Wall(new Point(5,5));
        Wall wall13 = new Wall(new Point(0,1));
        Wall wall14 = new Wall(new Point(0,2));
        Wall wall15 = new Wall(new Point(0,3));
        Wall wall16 = new Wall(new Point(0,4));
        Wall wall17 = new Wall(new Point(5,1));
        Wall wall18 = new Wall(new Point(5,2));
        Wall wall19 = new Wall(new Point(5,3));
        Wall wall20 = new Wall(new Point(5,4));

        EmptyTile empty1=new EmptyTile(new Point(1,1));
        EmptyTile empty2=new EmptyTile(new Point(2,1));
        EmptyTile empty3=new EmptyTile(new Point(3,1));
        EmptyTile empty4=new EmptyTile(new Point(4,1));
        EmptyTile empty5=new EmptyTile(new Point(1,2));
        EmptyTile empty6=new EmptyTile(new Point(2,2));
        EmptyTile empty7=new EmptyTile(new Point(3,2));
        EmptyTile empty8=new EmptyTile(new Point(4,2));
        EmptyTile empty9=new EmptyTile(new Point(1,3));
        EmptyTile empty10=new EmptyTile(new Point(2,3));
        EmptyTile empty11=new EmptyTile(new Point(3,3));
        EmptyTile empty12=new EmptyTile(new Point(4,3));
        EmptyTile empty13=new EmptyTile(new Point(1,4));
        EmptyTile empty14=new EmptyTile(new Point(2,4));
        EmptyTile empty15=new EmptyTile(new Point(3,4));
        EmptyTile empty16=new EmptyTile(new Point(4,4));







        board[0][0]= wall1;
        board[1][0]=wall2;
        board[2][0]=wall3;
        board[3][0]=wall4;
        board[4][0]=wall5;
        board[5][0]=wall6;
        board[0][5]= wall7;
        board[1][5]=wall8;
        board[2][5]=wall9;
        board[3][5]=wall10;
        board[4][5]=wall11;
        board[5][5]=wall12;
        board[0][1]= wall13;
        board[0][2]=wall14;
        board[0][3]=wall15;
        board[0][4]=wall16;
        board[5][1]=wall17;
        board[5][2]=wall18;
        board[5][3]= wall19;
        board[5][4]=wall20;

        board[1][1]=player;
        board[2][1]=empty2;
        board[3][1]=empty3;
        board[4][1]=empty4;
        board[1][2]= empty5;
        board[2][2]=empty6;
        board[3][2]=empty7;
        board[4][2]=empty8;
        board[1][3]=empty9;
        board[2][3]=empty10;
        board[3][3]= empty11;
        board[4][3]=empty12;
        board[1][4]=empty13;
        board[2][4]=empty14;
        board[3][4]=empty15;
        board[4][4]=empty16;


        currlevel.setBoardGame(board);
        currlevel.print();
        currlevel.print();



        /*monster1 = new Monster("Lannister Solider", 's', 80, 3, 8, 25, 3);
        trap1 = new Trap("Death Trap", 'D', 500, 20, 100, 250, 1, 10);
        player1= new Mage("Melisandre", 100, 1,5,300,30,15,5,6);
        player1.setPosition(new Position(2,2));
        monster1.setPosition(new Position(1,2));
        trap1.setPosition(new Position(0,2));
        enemeis = new LinkedList<Enemy>();
        enemeis.add(trap1);
        enemeis.add(monster1);
        board = new Tile[3][3];
        board[0][0]=wall1;
        board[0][1]=wall2;
        board[0][2]=wall3;
        board[1][0]= empty1;
        board[1][1]= empty2;
        board[1][2]= empty3;
        board[2][0]= trap1;
        board[2][1]=monster1;
        board[2][2]= player1;
        first = new Level(board,enemeis,player1,cli);
        monster1.setEdcb((Enemy e)->first.UponEnemyDeath(e));
        trap1.setEdcb((Enemy e)->first.UponEnemyDeath(e));*/

}
