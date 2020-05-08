package 物业管理系统窗体框架;

import SQLConnection.SQLBaseConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
/*
软件名：物业管理系统
类名：主窗体类
作用：用户登录成功时被Login类调用，显示主窗体
     调用RightFrameXXX类用于实现各个按钮的功能
 */
public class MainFrame extends JFrame {
    JSplitPane splitPane ;//split面板
    JPanel p1 = new JPanel();//左面板
    Font f,f1;//设置字体
    JLabel jl1,jl2;//标签
    JButton jb1,jb2,jb3,jb4;//左面板的按钮
    Connection conn;//创建数据库连接对象

    public MainFrame() {

        //调用SQLBaseConnection类，获得连接数据库后的对象conn
        conn = SQLBaseConnection.getConnection();

        //设置关闭窗体同时关闭程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //设置绝对布局（自定义）
        p1.setLayout(null);

        //设置左面板凸出边框
        p1.setBorder(BorderFactory.createRaisedSoftBevelBorder());

        //设置字体
        f=new Font("宋体",Font.BOLD,25);//标签字体
        f1=new Font("宋体",Font.PLAIN,20);//按钮字体

        //设置窗体名称
        setTitle("物业管理系统窗体框架");

        //“基本功能”标签
        jl1 = new JLabel("基本功能");
        jl1.setBounds(100, 0, 150, 50);
        jl1.setFont(f);
        p1.add(jl1);

        //调用几个按钮的方法，否则按钮将无法被创建
        add();
        delete();
        update();
        select();

        //将左右面板加到split面板
        splitPane = new JSplitPane();
        splitPane.setLeftComponent(p1);
        splitPane.setRightComponent(new RightShowNull());
        //splitPane.setRightComponent(new RightFrameAdd(splitPane,new RightShowNull()));

        //设置分隔条不能拖动
        splitPane.setEnabled(false);
        //分隔条上显示快速 折叠/展开 两边组件的小按钮
        splitPane.setOneTouchExpandable(true);
        //设置分隔条的初始位置
        splitPane.setDividerLocation(300);
        //设置窗体显示的面板
        setContentPane(splitPane);

        //设置JFrame的属性
        setResizable(false);//设置不可以改变大小
        pack();//自动调整
        //setSize(900,450);
        setSize(1200,700);

        //设置运行时窗口的位置
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        //设置各种组件状态为可见
        setVisible(true);
    }

    public void add() {
        //“添加住户”功能
        jb1 = new JButton("添加住户");
        jb1.setBounds(10, 50, 130, 50);
        jb1.setFont(f1);
        p1.add(jb1);
        jb1.addActionListener((e)-> {
            splitPane.setDividerLocation(300);
            //把分割面板，右空面板，数据库连接对象传递到RightFrameAdd类中
            splitPane.setRightComponent(new RightFrameAdd(splitPane,new RightShowNull(),conn));
        });
    }

    public void delete() {
        //“删除住户”功能
        jb2 = new JButton("删除住户");
        jb2.setBounds(160, 50, 130, 50);
        jb2.setFont(f1);
        p1.add(jb2);
        jb2.addActionListener((e)->{
            splitPane.setDividerLocation(300);
            splitPane.setRightComponent(new RightFrameDelete(splitPane,new RightShowNull()));
        });
    }

    public void update() {
        //“修改住户”功能
        jb3 = new JButton("修改住户");
        jb3.setBounds(10, 120, 130, 50);
        jb3.setFont(f1);
        p1.add(jb3);
    }

    public void select() {
        //“查询住户”功能
        jb4 = new JButton("查询住户");
        jb4.setBounds(160, 120, 130, 50);
        jb4.setFont(f1);
        p1.add(jb4);
        jb4.addActionListener((e)->{
            splitPane.setDividerLocation(300);
            splitPane.setRightComponent(new RightFrameSelect(splitPane,new RightShowNull()));
        });
    }


}
