package 物业管理系统窗体框架;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameDemo {
    public static void main(String[] args) {
        // 创建窗体对象

        final Frame f = new Frame("更改背景色");

        // 设置窗体属性和布局

        f.setBounds(400, 200, 400, 300);

        f.setLayout(new FlowLayout());

// 创建三个按钮

        Button redButton = new Button("红色");

        Button greenButton = new Button("绿色");

        Button buleButton = new Button("蓝色");

// 添加按钮

        f.add(redButton);

        f.add(greenButton);

        f.add(buleButton);//【1】

// 设置窗体关闭

        f.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {

                System.exit(0);

            }

        });


        redButton.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {

                f.setBackground(Color.red);//【2】

            }

        });



        redButton.addMouseListener(new MouseAdapter() {

            public void mouseExited(MouseEvent e) {//【3】

                f.setBackground(Color.WHITE);

            }

        });



        greenButton.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {

                f.setBackground(Color.GREEN);

            }

        });



        greenButton.addMouseListener(new MouseAdapter() {

            public void mouseExited(MouseEvent e) {

                f.setBackground(Color.WHITE);

            }

        });



        buleButton.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {//【4】

                f.setBackground(Color.BLUE);

            }

        });



        buleButton.addMouseListener(new MouseAdapter() {

            public void mouseExited(MouseEvent e) {

                f.setBackground(Color.WHITE);

            }

        });

    f.setVisible(true);//【5】【6】
    }
}
