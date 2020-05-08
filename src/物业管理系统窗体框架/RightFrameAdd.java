package 物业管理系统窗体框架;

import SQLConnection.SQLOperation;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.sql.Connection;
/*
软件名：物业管理系统
类名：右面板添加住户类
作用：用户点击“添加住户”时被MainFrame类调用，显示右面板
 */
public class RightFrameAdd extends JPanel {
    JLabel jl,jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8;
    JButton jb1,jb2;
    Font f,f1;
    JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8;
    BufferedWriter bw;//创建字符输出流对象(匿名内部类)
    BufferedReader br;//创建字符输入流对象(匿名内部类)
    String sql;//数据库语句
    Connection conn;//数据库连接对象

    //把主框架的JSplitPane和右面板的RightShowNull传进来，否则无法实现“取消”按钮的功能
    public RightFrameAdd(JSplitPane splitPane,RightShowNull right,Connection conn) {

        //用conn接收MainFrame传递的conn对象
        this.conn = conn;
        this.setLayout(null);

        f=new Font("宋体",Font.BOLD,25);
        f1=new Font("宋体",Font.PLAIN,20);

        //“添加住户”标签
        jl = new JLabel("添加住户");
        jl.setBounds(250, 0, 150, 50);
        jl.setFont(f);
        add(jl);

        //“住房编号”输入框
        jl1 = new JLabel("住房编号");
        jl1.setBounds(150, 70, 150, 50);
        jl1.setFont(f);
        jtf1 = new JTextField(10);
        jtf1.setBounds(260,81,150,30);
        jtf1.setFont(f1);
        add(jl1);
        add(jtf1);

        //“用户姓名”输入框
        jl2 = new JLabel("用户姓名");
        jl2.setBounds(150, 120, 150, 50);
        jl2.setFont(f);
        jtf2 = new JTextField(10);
        jtf2.setBounds(260,131,150,30);
        jtf2.setFont(f1);
        add(jl2);
        add(jtf2);

        //“用户性别”输入框
        jl3 = new JLabel("用户性别");
        jl3.setBounds(150, 170, 150, 50);
        jl3.setFont(f);
        jtf3 = new JTextField(10);
        jtf3.setBounds(260,181,150,30);
        jtf3.setFont(f1);
        add(jl3);
        add(jtf3);

        //“用户年龄”输入框
        jl4 = new JLabel("用户年龄");
        jl4.setBounds(150, 220, 150, 50);
        jl4.setFont(f);
        jtf4 = new JTextField(10);
        jtf4.setBounds(260,231,150,30);
        jtf4.setFont(f1);
        add(jl4);
        add(jtf4);

        //“所住单元”输入框
        jl5 = new JLabel("所住单元");
        jl5.setBounds(150, 270, 150, 50);
        jl5.setFont(f);
        jtf5 = new JTextField(10);
        jtf5.setBounds(260,281,150,30);
        jtf5.setFont(f1);
        add(jl5);
        add(jtf5);

        //“所住楼”输入框
        jl6 = new JLabel("所住楼");
        jl6.setBounds(150, 320, 150, 50);
        jl6.setFont(f);
        jtf6 = new JTextField(10);
        jtf6.setBounds(260,331,150,30);
        jtf6.setFont(f1);
        add(jl6);
        add(jtf6);

        //“所住房号”输入框
        jl7 = new JLabel("所住房号");
        jl7.setBounds(150, 370, 150, 50);
        jl7.setFont(f);
        jtf7 = new JTextField(10);
        jtf7.setBounds(260,381,150,30);
        jtf7.setFont(f1);
        add(jl7);
        add(jtf7);

        //“所住房屋平方数”输入框
        jl8 = new JLabel("所住房号");
        jl8.setBounds(150, 420, 150, 50);
        jl8.setFont(f);
        jtf8 = new JTextField(10);
        jtf8.setBounds(260,431,150,30);
        jtf8.setFont(f1);
        add(jl8);
        add(jtf8);

        //设置“确认”按钮
        jb1 = new JButton("确认");
        jb1.setBounds(160, 500, 130, 50);
        add(jb1);
        jb1.addActionListener((e)->{
            //获取输入框的内容
            sql = "insert into EMP(ID,NAME,AGE)" + " values ('"+jtf1.getText()+"','"+jtf2.getText()+"','"+jtf3.getText()+"')";
            //把sql语句和conn对象传入SQLOperation类，用于操作数据库
            SQLOperation.add(conn,sql);
            //sql="insert into EMP(HNO,HNAME,HSEX,HAGE,HUNIT,HRESIDENCE,HNUMBER,HSQUARE)" + " values ('0006','happy','14')";
        });

        //设置“取消”按钮，按下取消按钮时右边面板显示RightShowNull页面
        jb2 = new JButton("取消");
        jb2.setBounds(310, 500, 130, 50);
        add(jb2);
        jb2.addActionListener((e)-> {
            splitPane.setDividerLocation(300);
            splitPane.setRightComponent(right);
        });


    }
}
