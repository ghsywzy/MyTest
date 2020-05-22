package entities;
import view.global;

public class Gound {
    int[][] rocks = new int[global.WIDHT][global.HEIGHT];

    public int[][] getRocks(){
        return rocks;
    }

    public void setRocks(int[][] rocks){
        this.rocks = rocks;
    }

    public Gound() {
        super();
        //默认情况下，最上和最下为石头
        for (int x = 0; x<global.WIDHT;x++){
            rocks[x][0] = 1;//第一行为石头
            rocks[x][global.HEIGHT-1] = 1;//最后一行为石头
        }

    }

    public Gound(int[][] rocks){
        super();
        this.rocks = rocks;
    }
}
