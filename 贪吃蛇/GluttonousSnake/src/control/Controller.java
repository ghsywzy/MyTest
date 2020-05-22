package control;

import entities.Food;
import entities.Gound;
import entities.Snake;
import view.global;
import view.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;


public class Controller extends KeyAdapter implements SnakeListener {

    Snake snake;
    GamePanel gp;
    Gound gound;
    Food food;
    JFrame jf,jf1;
    JLabel jl1;
    //记录分数
    int count = 0;

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Controller() {
    }

    public Controller(Snake snake,GamePanel gp,Gound gound,Food food,JFrame jf,JFrame jf1,JLabel jl1) {
        this.snake = snake;
        this.gp = gp;
        this.gound = gound;
        this.food = food;
        this.jf = jf;
        this.jf1 = jf1;
        this.jl1 = jl1;
        //初始化一个食物点
        food.setFoodPoint(newFoodPoint());
    }

    //除了初始化被调用之外，其他新食物都是在snakeMove方法中被调用
    private Point newFoodPoint() {
        /*int x = (int)(Math.random()*global.WIDHT);
        int y = (int)(Math.random()*global.HEIGHT);*//*

        //蛋的随机坐标
        int x=((int)(Math.random()*(29-0+1))+0);
        int y=((int)(Math.random()*(18-1+1))+1);
        return new Point(x,y);*/
        boolean flag =true;
        Point foodPoint;
        do{
            flag = false;
            int x = (int)(Math.random()*global.WIDHT);
            int y = (int)(Math.random()* global.HEIGHT);
            foodPoint = new Point(x,y);
            if(gound.getRocks()[x][y]==1) {
                flag = true;
                continue;
            }
            for(Point p:snake.getSnakeList()) {
                if(p.equals(foodPoint)) {
                    flag = true;
                    break;
                }
            }
        }while(flag);
        return foodPoint;

    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Gound getGound() {
        return gound;
    }

    public void setGound(Gound gound) {
        this.gound = gound;
    }

    //按键监听，当按下上下左右时调用该方法
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                System.out.println("left Pressd");
                snake.setDirection(global.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("Right Pressd");
                snake.setDirection(global.RIGHT);
                break;
            case KeyEvent.VK_UP:
                System.out.println("Up Pressd");
                snake.setDirection(global.UP);
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("Down Pressd");
                snake.setDirection(global.DOWN);
                break;
            default:
                System.out.println("Wrong KEY pressd");
                break;
        }
    }

    //判断蛇是否撞到了石头
    public boolean isEatGound(){
        int[][] rocks = gound.getRocks();
        LinkedList<Point> snakeList = snake.getSnakeList();
        Point snakeHead = snakeList.getFirst();
        return rocks[snakeHead.x][snakeHead.y]==1;
    }

    //判断蛇是否吃了食物
    public boolean isEatFood(){
        Point foodPoint = food.getFoodPoint();
        Point snakeHead = snake.getSnakeList().getFirst();
        return foodPoint.equals(snakeHead);
    }

    //实现蛇类接口的方法
    public void snakeMoved(Snake snake) {
        if (isEatGound()){
            snake.setFlag(false);
            JOptionPane.showMessageDialog(null,"撞到了石头哦，游戏结束！","游戏结束",JOptionPane.INFORMATION_MESSAGE);
            jf.dispose();
            jf1.setVisible(true);
            return;
        }

        if (snake.isEatBody()){
            snake.setFlag(false);
            JOptionPane.showMessageDialog(null,"撞到了石头哦，游戏结束！","游戏结束",JOptionPane.INFORMATION_MESSAGE);
            jf.dispose();
            jf1.setVisible(true);
            return;
        }

        //
        if (isEatFood()){
            snake.eatFood();
            food.setFoodPoint(newFoodPoint());
            count ++;
            jl1.setText(String.valueOf(count));
        }
        //System.out.println("Snake Moved");
        gp.display();
    }
}