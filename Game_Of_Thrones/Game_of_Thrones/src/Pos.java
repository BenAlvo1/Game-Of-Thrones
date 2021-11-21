import javax.swing.text.Position;

public class Pos {
    int x;
    int y;
    public Pos(int x,int y){
        this.x = x;
        this.y = y;
    }
    public int Range(Position position){
        return (int)Math.sqrt(Math.pow(this.x-x,2)+Math.pow(this.y-y,2));
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
