package entities;

import control.Controller;
import control.SnakeListener;
import view.global;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

import static view.global.*;

public class Snake {

    Point tail;
    //蛇类监听器对象，用于接收控制类的对象
    SnakeListener snakeListener;
    //蛇类线程的启动与停止标志
    boolean flag = true;
    int speed;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    //蛇的新移动方向和旧移动方向
    int direction = -1;
    int oldDirection = direction;

    //集合，用于存放蛇移动的点
    LinkedList<Point> snakeList = new LinkedList<>();

    public LinkedList<Point> getSnakeList() {
        return snakeList;
    }

    public void setSnakeList(LinkedList<Point> snakeList) {
        this.snakeList = snakeList;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    //设置标志的状态
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }

    //接收控制类对象
    public void addSnakeListener(Controller sl) {//control.SnakeListener
        snakeListener = sl;
    }



    //空参构造方法
    public Snake() {

        super();
        snakeList.add(HEAD_POINT);
        for (int i = 1; i < FIRST_LENGTH ; i++) {
            snakeList.add(new Point(HEAD_POINT.x+i, HEAD_POINT.y));
        }

    }

    //线程的启动方法，该方法的作用是：创建一个新线程并启动该线程
    public void start() {
        Thread th = new Thread(new Snakedriver());
        th.start();
    }

    //内部类，实现线程接口，实现run方法
    private class Snakedriver implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (flag) {
                move();
                snakeListener.snakeMoved(Snake.this);
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean isEatBody(){
        Point head = snakeList.getFirst();
        for (Point p:snakeList.subList(1,snakeList.size())){
            if (head.equals(p)){
                return true;
            }
        }
        return false;
    }

    public void eatFood(){
        snakeList.addLast(tail);
    }

    private void move(){
        Point oldHead = snakeList.getFirst();
        Point newHead = new Point();

        //用于解决蛇可以反方向移动的问题，当旧方向与新方向相加等于0时表明蛇要往反方向移动，这时把新方向改为旧方向
        //蛇就无法向反方向移动了
        if(oldDirection+direction==0){
            direction = oldDirection;
        }else{
            oldDirection = direction;
        }

        //用来响应按键监听，当按下不同方向时蛇会往对应方向移动
        //未按时则根据旧方向继续移动,direction默认起始为-1,即向左动
        switch(direction){
            case global.LEFT:
                newHead.x = (oldHead.x-1+global.WIDHT)%global.WIDHT;
                newHead.y = oldHead.y;
                break;
            case global.RIGHT:
                newHead.x = (oldHead.x+1)%global.WIDHT;
                newHead.y = oldHead.y;
                break;
            case global.UP:
                newHead.y = (oldHead.y-1+global.HEIGHT)%global.HEIGHT;
                newHead.x = oldHead.x;
                break;
            case global.DOWN:
                newHead.y = (oldHead.y+1)%global.HEIGHT;
                newHead.x = oldHead.x;
                break;
            default:
                break;
        }

        /*
        蛇移动原理：在对应要移动的方向新画一个蛇头，并且添加到snakeList的第一个
        也就是把新画的点变成蛇头，旧蛇头会变成身体的一部分，同时舍弃最后一个点，就完成了蛇的移动
         */
        snakeList.addFirst(newHead);
        tail = snakeList.removeLast();
    }
}
