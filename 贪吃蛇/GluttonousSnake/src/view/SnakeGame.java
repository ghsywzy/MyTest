package view;

import control.Controller;
import entities.Food;
import entities.Gound;
import entities.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SnakeGame {
    public static void main(String[] args) {
        //创建蛇类对象
        //Snake snake; //= new Snake();

        JFrame jf1 = new JFrame("贪吃蛇");
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width-global.CANVAS_WIDTH)/2 ;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height-global.CANVAS_HEIGHT) /2;
        int width = global.CANVAS_WIDTH+19;//19;
        int height = global.CANVAS_HEIGHT+49;
        jf1.setBounds(x, y, width, height);



        Font f = new Font(null, Font.BOLD, 15);
        // 创建三个单选按钮
        JRadioButton jb3 = new JRadioButton("简单");
        JRadioButton jb4 = new JRadioButton("困难");
        JRadioButton jb5 = new JRadioButton("地狱");
        jb3.setBounds(300,200,100,100);
        jb4.setBounds(400,200,100,100);
        jb5.setBounds(500,200,100,100);
        jb3.setFont(f);
        jb4.setFont(f);
        jb5.setFont(f);
        jb3.setSelected(true);




        JPanel jp = new JPanel(null);
        JButton jb1 = new JButton("开始游戏");
        jb1.setBounds(300,10,100,100);
        JButton jb2 = new JButton("游戏说明");
        jb2.setBounds(500,10,100,100);
        JButton jb6 = new JButton("关于");
        jb6.setBounds(400,400,100,100);
        jb1.addActionListener((e)->{//按下按钮调用start方法，启动蛇类线程
            //snake.setFlag(true);
            Snake snake = new Snake();
            if(jb3.isSelected()){
                snake.setSpeed(200);
            }
            else if (jb4.isSelected()){
                snake.setSpeed(80);
            }
            else if (jb5.isSelected()){
                snake.setSpeed(25);
            }
            start(jf1,snake);
            jf1.setVisible(false);//隐藏开始窗口
        });
        jb2.addActionListener((e)->{
            JOptionPane.showMessageDialog(null,"贪吃蛇游戏，当蛇吃到自己或者是碰到上下两边的石头时游戏就会结束，通过上下左右按键控制蛇的移动方向","游戏说明",JOptionPane.INFORMATION_MESSAGE);
        });
        jb6.addActionListener((e -> {
            JOptionPane.showMessageDialog(null,"本游戏由ghsywzy完成，同时感谢我的JAVA老师的帮助！","关于",JOptionPane.INFORMATION_MESSAGE);
        }));



        // 创建按钮组，把两个单选按钮添加到该组
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(jb3);
        btnGroup.add(jb4);
        btnGroup.add(jb5);
        jp.add(jb1);
        jp.add(jb2);
        jp.add(jb3);
        jp.add(jb4);
        jp.add(jb5);
        jp.add(jb6);
        jf1.add(jp);
        jf1.setVisible(true);
        jf1.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                jf1.dispose();
            }
        });

    }

    public static void start(JFrame jf1,Snake snake) {

        //创建窗体对象
        JFrame jf = new JFrame("贪吃蛇");



        GamePanel gp = new GamePanel();

        Gound gd = new Gound();
        Food fd = new Food();

        //Toolkit是JDK中的一个工具箱，获取屏幕大小
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width-global.CANVAS_WIDTH) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height-global.CANVAS_HEIGHT) / 2;
        int width = global.CANVAS_WIDTH+99;//19;
        int height = global.CANVAS_HEIGHT+49;

        //设置窗体显示位置
        jf.setBounds(x, y, width, height);

        /*
        设置分数模块，通过jl1显示分数，分数的更新操作在controller类中完成
         */
        Font f = new Font(null, Font.BOLD, 15);

        JLabel jl = new JLabel("得分：");
        jl.setBounds(910,0,60,40);
        jl.setFont(f);

        JLabel jl1 = new JLabel("0");
        jl1.setBounds(960,0,40,40);
        jl1.setFont(f);
        gp.add(jl);
        gp.add(jl1);

        //关闭窗体时结束程序
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        /*//窗口监听，当关闭窗口时结束程序
        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                jf.dispose();
                snake.setFlag(false);
            }
        });*/

        //把面板添加到框架上
        jf.add(gp);

        //设置窗体可见
        jf.setVisible(true);

        //创建控制类对象
        Controller controller = new Controller(snake,gp,gd,fd,jf,jf1,jl1);
        //控制类是SnakeListener接口的实现类，同时继承了按键监听类，所以在蛇类监听器和按键监听器中可以直接传递
        jf.addKeyListener(controller);
        snake.addSnakeListener(controller);
        gp.setController(controller);


        //启动蛇类线程
        snake.start();

    }


}
