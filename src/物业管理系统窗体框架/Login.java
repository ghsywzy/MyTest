package 物业管理系统窗体框架;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
/*
软件名：物业管理系统
类名：登录类
作用：显示登录窗体，用户输入信息后调用CheckLogin类核对信息，用户点击注册时调用Register类用于注册
 */
public class Login extends JFrame {
    //创建左面板
    JPanel jp1;

    //设置字体
    Font f1;

    //创建标签
    JLabel jl1,jl2;

    //创建输入框
    JTextField jt1;
    JPasswordField jt2;

    //创建三个按钮
    JButton jb1,jb2,jb3;

    public Login() throws HeadlessException {

        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setTitle("登录界面");

        //登录面板
        jp1 = new JPanel(null);

        setContentPane(jp1);

        //设定字体格式
        f1 = new Font(null, Font.BOLD, 25);

        //jl1，用户名标签
        jl1 = new JLabel("用户名");
        jl1.setFont(f1);
        jl1.setBounds(70,10,100,50);
        jt1 = new JTextField(10);
        jt1.setBounds(160,23,150,30);

        //jl2，密码标签
        jl2 = new JLabel("密    码");
        jl2.setFont(f1);
        jl2.setBounds(70,100,100,50);
        jt2 = new JPasswordField(10);
        jt2.setBounds(160,113,150,30);

        //预先填写用户名和密码，方便测试功能后，期需要删除
        jt1.setText("ghsy");
        jt2.setText("1234");

        //jb1,登录按钮，并且使用Lambda表达式实现按钮功能
        jb1 = new JButton("登录");
        jb1.setBounds(20,280,100,60);
        jb1.addActionListener((e)->{
            try {
                if(CheckLogin.check(jt1,jt2)==0){//CheckLogin类为检查类，用于核对用户的登录信息，并返回对应的值
                    JOptionPane.showMessageDialog(this, "登录成功！");

                    //登录成功，打开主窗口
                    new MainFrame();

                    //关闭登录窗口
                    dispose();
                }else if(CheckLogin.check(jt1,jt2)==1){
                    JOptionPane.showMessageDialog(this, "登录失败，请重新输入登录信息！");
                }else if(CheckLogin.check(jt1,jt2)==2){
                    JOptionPane.showMessageDialog(this, "请输入完整的登录信息！");
                }else if(CheckLogin.check(jt1,jt2)==3){
                    JOptionPane.showMessageDialog(this, "用户名不允许包含数字！请重新输入！");
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        //jb2，注册按钮，并实现功能
        jb2 = new JButton("注册");
        jb2.setBounds(140,280,100,60);
        jb2.addActionListener((e)->{
            try {
                new Register(this);//Register为注册类，用户点击注册按钮时调用
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            setVisible(false);//调用注册类时隐藏登录窗口
        });

        //重置按钮，点击后重置输入框内容
        jb3 = new JButton("重置");
        jb3.setBounds(260,280,100,60);
        jb3.addActionListener((e)->{
            jt1.setText("");
            jt2.setText("");
        });

        //把各个组件添加到左面板jp1
        jp1.add(jb1);
        jp1.add(jb2);
        jp1.add(jb3);
        jp1.add(jl1);
        jp1.add(jl2);
        jp1.add(jt1);
        jp1.add(jt2);

        //设置窗体及所有组件可见
        setVisible(true);
    }
}
