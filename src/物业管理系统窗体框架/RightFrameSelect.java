package 物业管理系统窗体框架;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class RightFrameSelect extends JPanel{
    JLabel jl,jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8;
    JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9;
    Font f,f1;
    JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8;
    //创建字符输出流对象(匿名内部类)
    BufferedWriter bw;
    //创建字符输入流对象(匿名内部类)
    BufferedReader br;

    //把主框架的JSplitPane和右面板的RightShowNull传进来，否则无法实现“取消”按钮的功能
    public RightFrameSelect(JSplitPane splitPane,RightShowNull right) {
        this.setLayout(null);

        f=new Font("宋体",Font.BOLD,25);
        f1=new Font("宋体",Font.PLAIN,20);

        //“查询住户”标签
        jl = new JLabel("查询住户");
        jl.setBounds(250, 0, 150, 50);
        jl.setFont(f);
        add(jl);

        //“住房编号”输入框
        jl1 = new JLabel("通过住房编号查询:");
        jl1.setBounds(50, 70, 260, 50);
        jl1.setFont(f);
        jtf1 = new JTextField(10);
        jtf1.setBounds(270,81,260,30);
        jtf1.setFont(f1);
        add(jl1);
        add(jtf1);

        //“用户姓名”输入框
        jl2 = new JLabel("通过用户姓名查询:");
        jl2.setBounds(50, 120, 260, 50);
        jl2.setFont(f);
        jtf2 = new JTextField(10);
        jtf2.setBounds(270,131,260,30);
        jtf2.setFont(f1);
        add(jl2);
        add(jtf2);

        //“用户性别”输入框
        jl3 = new JLabel("通过用户性别查询：");
        jl3.setBounds(50, 170, 260, 50);
        jl3.setFont(f);
        jtf3 = new JTextField(10);
        jtf3.setBounds(270,181,260,30);
        jtf3.setFont(f1);
        add(jl3);
        add(jtf3);

        //“用户年龄”输入框
        jl4 = new JLabel("通过用户年龄查询:");
        jl4.setBounds(50, 220, 260, 50);
        jl4.setFont(f);
        jtf4 = new JTextField(10);
        jtf4.setBounds(270,231,260,30);
        jtf4.setFont(f1);
        add(jl4);
        add(jtf4);

        //“所住单元”输入框
        jl5 = new JLabel("通过所住单元查询:");
        jl5.setBounds(50, 270, 260, 50);
        jl5.setFont(f);
        jtf5 = new JTextField(10);
        jtf5.setBounds(270,281,260,30);
        jtf5.setFont(f1);
        add(jl5);
        add(jtf5);

        //“所住楼”输入框
        jl6 = new JLabel("通过所住楼查询:");
        jl6.setBounds(50, 320, 260, 50);
        jl6.setFont(f);
        jtf6 = new JTextField(10);
        jtf6.setBounds(270,331,260,30);
        jtf6.setFont(f1);
        add(jl6);
        add(jtf6);

        //“所住房号”输入框
        jl7 = new JLabel("通过所住房号查询:");
        jl7.setBounds(50, 370, 260, 50);
        jl7.setFont(f);
        jtf7 = new JTextField(10);
        jtf7.setBounds(270,381,260,30);
        jtf7.setFont(f1);
        add(jl7);
        add(jtf7);

        //“所住房屋平方数”输入框
        jl8 = new JLabel("通过房屋面积查询:");
        jl8.setBounds(50, 420, 260, 50);
        jl8.setFont(f);
        jtf8 = new JTextField(10);
        jtf8.setBounds(270,431,260,30);
        jtf8.setFont(f1);
        add(jl8);
        add(jtf8);

        //设置“确认”按钮
        jb1 = new JButton("确认");
        jb1.setBounds(550, 80, 130, 30);
        add(jb1);

        jb3 = new JButton("确认");
        jb3.setBounds(550, 130, 130, 30);
        add(jb3);

        jb4 = new JButton("确认");
        jb4.setBounds(550, 180, 130, 30);
        add(jb4);

        jb5 = new JButton("确认");
        jb5.setBounds(550, 230, 130, 30);
        add(jb5);

        jb6 = new JButton("确认");
        jb6.setBounds(550, 280, 130, 30);
        add(jb6);

        jb7 = new JButton("确认");
        jb7.setBounds(550, 330, 130, 30);
        add(jb7);

        jb8 = new JButton("确认");
        jb8.setBounds(550, 380, 130, 30);
        add(jb8);

        jb9 = new JButton("确认");
        jb9.setBounds(550, 430, 130, 30);
        add(jb9);

        //设置“取消”按钮，按下取消按钮时右边面板显示RightShowNull页面
        jb2 = new JButton("取消");
        jb2.setBounds(310, 500, 130, 50);
        add(jb2);
        jb2.addActionListener((e)-> {
            splitPane.setDividerLocation(300);
            splitPane.setRightComponent(right);
        });
    }

    //用于实现点击“确定”按钮时进行的操作
    public static void Confirm(){
        //暂定弹出一个窗体，用于显示查询结果
    }
}
