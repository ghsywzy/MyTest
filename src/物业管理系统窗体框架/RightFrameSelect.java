package ��ҵ����ϵͳ������;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class RightFrameSelect extends JPanel{
    JLabel jl,jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8;
    JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9;
    Font f,f1;
    JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8;
    //�����ַ����������(�����ڲ���)
    BufferedWriter bw;
    //�����ַ�����������(�����ڲ���)
    BufferedReader br;

    //������ܵ�JSplitPane��������RightShowNull�������������޷�ʵ�֡�ȡ������ť�Ĺ���
    public RightFrameSelect(JSplitPane splitPane,RightShowNull right) {
        this.setLayout(null);

        f=new Font("����",Font.BOLD,25);
        f1=new Font("����",Font.PLAIN,20);

        //����ѯס������ǩ
        jl = new JLabel("��ѯס��");
        jl.setBounds(250, 0, 150, 50);
        jl.setFont(f);
        add(jl);

        //��ס����š������
        jl1 = new JLabel("ͨ��ס����Ų�ѯ:");
        jl1.setBounds(50, 70, 260, 50);
        jl1.setFont(f);
        jtf1 = new JTextField(10);
        jtf1.setBounds(270,81,260,30);
        jtf1.setFont(f1);
        add(jl1);
        add(jtf1);

        //���û������������
        jl2 = new JLabel("ͨ���û�������ѯ:");
        jl2.setBounds(50, 120, 260, 50);
        jl2.setFont(f);
        jtf2 = new JTextField(10);
        jtf2.setBounds(270,131,260,30);
        jtf2.setFont(f1);
        add(jl2);
        add(jtf2);

        //���û��Ա������
        jl3 = new JLabel("ͨ���û��Ա��ѯ��");
        jl3.setBounds(50, 170, 260, 50);
        jl3.setFont(f);
        jtf3 = new JTextField(10);
        jtf3.setBounds(270,181,260,30);
        jtf3.setFont(f1);
        add(jl3);
        add(jtf3);

        //���û����䡱�����
        jl4 = new JLabel("ͨ���û������ѯ:");
        jl4.setBounds(50, 220, 260, 50);
        jl4.setFont(f);
        jtf4 = new JTextField(10);
        jtf4.setBounds(270,231,260,30);
        jtf4.setFont(f1);
        add(jl4);
        add(jtf4);

        //����ס��Ԫ�������
        jl5 = new JLabel("ͨ����ס��Ԫ��ѯ:");
        jl5.setBounds(50, 270, 260, 50);
        jl5.setFont(f);
        jtf5 = new JTextField(10);
        jtf5.setBounds(270,281,260,30);
        jtf5.setFont(f1);
        add(jl5);
        add(jtf5);

        //����ס¥�������
        jl6 = new JLabel("ͨ����ס¥��ѯ:");
        jl6.setBounds(50, 320, 260, 50);
        jl6.setFont(f);
        jtf6 = new JTextField(10);
        jtf6.setBounds(270,331,260,30);
        jtf6.setFont(f1);
        add(jl6);
        add(jtf6);

        //����ס���š������
        jl7 = new JLabel("ͨ����ס���Ų�ѯ:");
        jl7.setBounds(50, 370, 260, 50);
        jl7.setFont(f);
        jtf7 = new JTextField(10);
        jtf7.setBounds(270,381,260,30);
        jtf7.setFont(f1);
        add(jl7);
        add(jtf7);

        //����ס����ƽ�����������
        jl8 = new JLabel("ͨ�����������ѯ:");
        jl8.setBounds(50, 420, 260, 50);
        jl8.setFont(f);
        jtf8 = new JTextField(10);
        jtf8.setBounds(270,431,260,30);
        jtf8.setFont(f1);
        add(jl8);
        add(jtf8);

        //���á�ȷ�ϡ���ť
        jb1 = new JButton("ȷ��");
        jb1.setBounds(550, 80, 130, 30);
        add(jb1);

        jb3 = new JButton("ȷ��");
        jb3.setBounds(550, 130, 130, 30);
        add(jb3);

        jb4 = new JButton("ȷ��");
        jb4.setBounds(550, 180, 130, 30);
        add(jb4);

        jb5 = new JButton("ȷ��");
        jb5.setBounds(550, 230, 130, 30);
        add(jb5);

        jb6 = new JButton("ȷ��");
        jb6.setBounds(550, 280, 130, 30);
        add(jb6);

        jb7 = new JButton("ȷ��");
        jb7.setBounds(550, 330, 130, 30);
        add(jb7);

        jb8 = new JButton("ȷ��");
        jb8.setBounds(550, 380, 130, 30);
        add(jb8);

        jb9 = new JButton("ȷ��");
        jb9.setBounds(550, 430, 130, 30);
        add(jb9);

        //���á�ȡ������ť������ȡ����ťʱ�ұ������ʾRightShowNullҳ��
        jb2 = new JButton("ȡ��");
        jb2.setBounds(310, 500, 130, 50);
        add(jb2);
        jb2.addActionListener((e)-> {
            splitPane.setDividerLocation(300);
            splitPane.setRightComponent(right);
        });
    }

    //����ʵ�ֵ����ȷ������ťʱ���еĲ���
    public static void Confirm(){
        //�ݶ�����һ�����壬������ʾ��ѯ���
    }
}
