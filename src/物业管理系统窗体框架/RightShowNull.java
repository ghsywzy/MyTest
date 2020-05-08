package 物业管理系统窗体框架;

import javax.swing.*;
import java.awt.*;

public class RightShowNull extends JPanel {
    //静态用户名和密码，用于接收Login类中传来的用户名和密码并且在起始右面板中显示
    static String name,password;

    static JLabel jl1;
    Font f;
    public RightShowNull() {
        this.setLayout(null);
        f=new Font("宋体",Font.BOLD,20);
        jl1 = new JLabel("当前用户："+name+"  "+"密码："+password);
        jl1.setBounds(10,0, 300, 50);
        jl1.setFont(f);
        add(jl1);
    }

}
