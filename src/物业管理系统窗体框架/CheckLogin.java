package 物业管理系统窗体框架;

import javax.swing.*;
import java.io.*;
/*
软件名：物业管理系统
类名：登录检查类
作用：被Login类调用，用于核对用户登录信息并且返回对应的值
    flag是标志，返回
    0则表示登录成功
    1则登录信息错误,登录失败
    2表示用户未输入任何登录信息
    3表示用户输入的用户名中包含数字，登录失败
 */
public class CheckLogin {
    static BufferedReader br;
    static BufferedWriter bw;
    {
        try {
            bw = new BufferedWriter(new FileWriter("D:\\1111\\IDEA\\basic-code\\day01-code\\src\\物业管理系统窗体框架\\Login.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int check(JTextField jtf1, JPasswordField jpf1) throws IOException {

        br = new BufferedReader(new FileReader("D:\\1111\\IDEA\\basic-code\\day01-code\\src\\物业管理系统窗体框架\\Login.txt"));

        //flag用于判断用户输入的信息是否正确，若错误则是false，返回登录失败信息
        int flag = 1;
        String name = jtf1.getText();
        String password = new String(jpf1.getPassword());
        String line = null;
        char[] namecheck = name.toCharArray();
        for(char a :namecheck){
            if(Character.isDigit(a)){
                flag = 3;
                return flag;
            }
        }
        if(name.equals("")&&password.equals("")){
            flag = 2;
        }else{
            try {
                while ((line = br.readLine()) != null) {
                    if (line.equals(name + "=" + password)) {
                        //把用户名和密码传到RightShowNull()里
                        new RightShowNull().name = name;
                        new RightShowNull().password = password;
                        flag = 0;
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}
