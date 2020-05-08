package 物业管理系统窗体框架;

import javax.swing.*;
import java.awt.*;
import java.io.*;
/*
软件名：物业管理系统
类名：注册类
作用：显示注册窗体，核对用户注册信息，并返回对应的值给Login类
flag为返回值
0为注册成功
1为注册失败（用户名重复）
2为注册失败（用户名包含数字）
3为注册失败（注册信息填写不全）
4为注册失败（两次输入的密码不同）
 */
public class Register extends JFrame{
    //创建面板
    JPanel jp1;

    //设置字体
    Font f1;

    //创建标签
    JLabel jl1;
    JLabel jl2;
    JLabel jl3;

    //创建输入框
    JTextField jt1;
    JPasswordField jt2,jt3;

    //创建两个按钮
    JButton jb1,jb2;

    //创建缓冲输入流和输出流
    static BufferedReader br;
    static BufferedWriter bw;
    {
        try {
            bw = new BufferedWriter(new FileWriter("D:\\1111\\IDEA\\basic-code\\day01-code\\src\\物业管理系统窗体框架\\Login.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Register(JFrame jf) throws HeadlessException, FileNotFoundException {
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("注册界面");

        f1 = new Font(null, Font.BOLD, 25);

        //登录面板
        jp1 = new JPanel(null);

        //注册页面
        jl1 = new JLabel("用户名");
        jl1.setFont(f1);
        jl1.setBounds(70,10,100,50);
        jt1 = new JTextField(10);
        jt1.setBounds(160,23,150,30);

        jl2 = new JLabel("密    码");
        jl2.setFont(f1);
        jl2.setBounds(70,100,100,50);
        jt2 = new JPasswordField(15);
        jt2.setBounds(160,113,150,30);

        jl3 = new JLabel("确认密码");
        jl3.setFont(f1);
        jl3.setBounds(50,190,110,50);
        jt3 = new JPasswordField(15);
        jt3.setBounds(160,203,150,30);

        jb1 = new JButton("注册");
        jb1.setBounds(70,280,100,60);
        jb1.addActionListener((e)->{
            try {
                if(register()==0){
                    JOptionPane.showMessageDialog(this, "注册成功！");
                }else if(register()==1){
                    JOptionPane.showMessageDialog(this, "注册失败！该用户名已被使用！");
                }else if(register()==2){
                    JOptionPane.showMessageDialog(this, "注册失败！用户名不允许使用数字！");
                }else if(register()==3){
                    JOptionPane.showMessageDialog(this, "注册失败！请填写完整的注册信息！");
                }else if(register()==4){
                    JOptionPane.showMessageDialog(this, "注册失败！两次输入的密码不相同！");
                }
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        });

        jb2 = new JButton("重置");
        jb2.setBounds(200,280,100,60);
        jb2.addActionListener((e)->{
            jt1.setText("");
            jt2.setText("");
            jt3.setText("");
        });

        jp1.add(jl1);
        jp1.add(jt1);
        jp1.add(jl2);
        jp1.add(jt2);
        jp1.add(jl3);
        jp1.add(jt3);
        jp1.add(jb1);
        jp1.add(jb2);


        setContentPane(jp1);



    }

    public int register() throws FileNotFoundException {
        int flag = 0;
        br = new BufferedReader(new FileReader("D:\\1111\\IDEA\\basic-code\\day01-code\\src\\物业管理系统窗体框架\\Login.txt"));
        String name = jt1.getText();
        String password = new String(jt2.getPassword());
        String password1 = new String(jt3.getPassword());
        String line = null;
        String[] check1 ;

        char[] namecheck = name.toCharArray();
        for(char a :namecheck){
            if(Character.isDigit(a)){
                //注册失败！用户名不允许使用数字！
                flag = 2;
                return flag;
            }
        }
        if(name.equals("")||password.equals("")||password1.equals("")){
            //注册失败！请填写完整的注册信息！
            flag = 3;
            return flag;
        }

        try {
            while ((line = br.readLine()) != null) {
                check1 = line.split("=");
                if (check1[0].equals(name)) {
                    //注册失败！该用户名已被使用！
                    flag = 1;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(flag==0){
           if(password.equals(password1)){
               try {
                   bw.write(name+"="+password);
                   bw.newLine();
                   bw.flush();
                   //bw.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           else{
               //注册失败！两次输入的密码不相同！
               flag = 4;
           }
        }

        return flag;
    }

}
