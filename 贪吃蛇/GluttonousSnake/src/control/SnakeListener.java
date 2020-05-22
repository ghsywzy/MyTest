package control;

import entities.Snake;

public interface SnakeListener {
    //创建一个蛇类监听器接口
    public void snakeMoved(Snake snake);
}
