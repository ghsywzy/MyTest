package view;

import control.Controller;
import entities.Gound;
import entities.Snake;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class GamePanel extends JPanel{
    Controller controller;

    Snake snake;



    /*//蛋的随机坐标
    int x=((int)(Math.random()*(29-0+1))+0)*global.CELL_SIZE;
    int y=((int)(Math.random()*(19-0+1))+0)*global.CELL_SIZE;

    //蛋是否被吃掉了
    boolean flag =false;*/

    public GamePanel() {
        super();
        setLayout(null);
    }



    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //画背景
        g.setColor(Color.white);
        g.fill3DRect(0,0,global.CANVAS_WIDTH,global.CANVAS_HEIGHT,true);

        //画线
        g.setColor(Color.blue);
        for(int y=0;y<=global.CANVAS_HEIGHT;y+=global.CELL_SIZE){
            g.drawLine(0,y,global.CANVAS_WIDTH,y);
        }

        for(int x=0;x<=global.CANVAS_WIDTH;x+=global.CELL_SIZE){
            g.drawLine(x,0,x,global.CANVAS_HEIGHT);
        }

        //画蛇
        drawSnake(g);
        /*//画蛋
        drawEGG(g);*/
        drawFood(g);

       drawGound(g);

    }

    //画食物
    private void drawFood(Graphics g) {
        Point foodPoint = controller.getFood().getFoodPoint();
        g.setColor(global.FOOD_COLOR);
        g.fill3DRect(foodPoint.x*global.CELL_SIZE,foodPoint.y*global.CELL_SIZE,global.CELL_SIZE,global.CELL_SIZE,true);
    }

    //画石头
    private void drawGound(Graphics g) {
        Gound gound = controller.getGound();
        int[][] rocks = gound.getRocks();
        g.setColor(global.ROCK_COlOR);
        for(int x=0;x<global.WIDHT;x++){
            for (int y=0;y<global.HEIGHT;y++){
                if (rocks[x][y]==1){
                    g.fill3DRect(x*global.CELL_SIZE,y*global.CELL_SIZE,global.CELL_SIZE,global.CELL_SIZE,true);
                }
            }
        }
    }

    //画蛇
    private void drawSnake(Graphics g) {


        Snake snake = controller.getSnake();
        LinkedList<Point> snakeList = snake.getSnakeList();
        Point head = (Point) snakeList.getFirst();

        /*//判断吃蛋，当蛇头坐标等于蛋的坐标时判断吃到蛋了，设置吃蛋标志为true，重新画新的蛋，同时蛇身体长度加一
        if(head.x==x/global.CELL_SIZE&&head.y==y/global.CELL_SIZE){
            snakeList.addLast(new Point(x,y));
            flag = true;
        }*/

        for(Point p : snakeList.subList(1,snakeList.size()))

        g.setColor(global.HEAD_COLOR);
        g.fill3DRect(head.x*global.CELL_SIZE,head.y*global.CELL_SIZE,global.CELL_SIZE,global.CELL_SIZE,true);
        g.setColor(global.BODY_COLOR);
        for (Point p:snakeList.subList(1,snakeList.size())){
            g.fill3DRect(p.x*global.CELL_SIZE,p.y*global.CELL_SIZE,global.CELL_SIZE,global.CELL_SIZE,true);
        }

    }

    /*//画蛋
    private  void drawEGG(Graphics g){
        //
        if(flag == true){//flag == true
            x=((int)(Math.random()*(29-0+1))+0)*global.CELL_SIZE;
            y=((int)(Math.random()*(18-1+1))+1)*global.CELL_SIZE;
            flag = false;
        }
        g.setColor(Color.RED);
        g.fill3DRect(x,y,global.CELL_SIZE,global.CELL_SIZE,true);
    }*/

    public void display(){
        this.repaint();
    }
}
