package ��ҵ����ϵͳ������;

import javax.swing.*;
import java.awt.*;

public class RightShowNull extends JPanel {
    //��̬�û��������룬���ڽ���Login���д������û��������벢������ʼ���������ʾ
    static String name,password;

    static JLabel jl1;
    Font f;
    public RightShowNull() {
        this.setLayout(null);
        f=new Font("����",Font.BOLD,20);
        jl1 = new JLabel("��ǰ�û���"+name+"  "+"���룺"+password);
        jl1.setBounds(10,0, 300, 50);
        jl1.setFont(f);
        add(jl1);
    }

}
