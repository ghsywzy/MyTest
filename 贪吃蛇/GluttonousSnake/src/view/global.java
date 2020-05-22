package view;

import java.awt.*;

public class global {
    //画布的逻辑长宽
    public static final int WIDHT = 30;
    public static final int HEIGHT = 20;

    //画布像素点
    public static final int CELL_SIZE = 30;
    public static final int CANVAS_WIDTH = WIDHT*CELL_SIZE;
    public static final int CANVAS_HEIGHT = HEIGHT*CELL_SIZE;

    //蛇的初始信息
    public static final int FIRST_LENGTH = 3;
    public static final Color HEAD_COLOR = Color.BLUE;
    public static final Color BODY_COLOR = Color.CYAN;
    public static final Point HEAD_POINT = new Point(WIDHT/2-1,HEIGHT/2-1);

    //方向信息
    public static final int LEFT=-1;
    public static final int RIGHT=1;
    public static final int UP=-2;
    public static final int DOWN=2;

    //石头颜色
    public static final Color ROCK_COlOR = Color.BLACK;

    //食物信息
    public static final Color FOOD_COLOR = Color.BLUE;

}
