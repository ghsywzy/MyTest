package ��ҵ����ϵͳ������;

import SQLConnection.SQLOperation;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.sql.Connection;
/*
���������ҵ����ϵͳ
��������������ס����
���ã��û���������ס����ʱ��MainFrame����ã���ʾ�����
 */
public class RightFrameAdd extends JPanel {
    JLabel jl,jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8;
    JButton jb1,jb2;
    Font f,f1;
    JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8;
    BufferedWriter bw;//�����ַ����������(�����ڲ���)
    BufferedReader br;//�����ַ�����������(�����ڲ���)
    String sql;//���ݿ����
    Connection conn;//���ݿ����Ӷ���

    //������ܵ�JSplitPane��������RightShowNull�������������޷�ʵ�֡�ȡ������ť�Ĺ���
    public RightFrameAdd(JSplitPane splitPane,RightShowNull right,Connection conn) {

        //��conn����MainFrame���ݵ�conn����
        this.conn = conn;
        this.setLayout(null);

        f=new Font("����",Font.BOLD,25);
        f1=new Font("����",Font.PLAIN,20);

        //�����ס������ǩ
        jl = new JLabel("���ס��");
        jl.setBounds(250, 0, 150, 50);
        jl.setFont(f);
        add(jl);

        //��ס����š������
        jl1 = new JLabel("ס�����");
        jl1.setBounds(150, 70, 150, 50);
        jl1.setFont(f);
        jtf1 = new JTextField(10);
        jtf1.setBounds(260,81,150,30);
        jtf1.setFont(f1);
        add(jl1);
        add(jtf1);

        //���û������������
        jl2 = new JLabel("�û�����");
        jl2.setBounds(150, 120, 150, 50);
        jl2.setFont(f);
        jtf2 = new JTextField(10);
        jtf2.setBounds(260,131,150,30);
        jtf2.setFont(f1);
        add(jl2);
        add(jtf2);

        //���û��Ա������
        jl3 = new JLabel("�û��Ա�");
        jl3.setBounds(150, 170, 150, 50);
        jl3.setFont(f);
        jtf3 = new JTextField(10);
        jtf3.setBounds(260,181,150,30);
        jtf3.setFont(f1);
        add(jl3);
        add(jtf3);

        //���û����䡱�����
        jl4 = new JLabel("�û�����");
        jl4.setBounds(150, 220, 150, 50);
        jl4.setFont(f);
        jtf4 = new JTextField(10);
        jtf4.setBounds(260,231,150,30);
        jtf4.setFont(f1);
        add(jl4);
        add(jtf4);

        //����ס��Ԫ�������
        jl5 = new JLabel("��ס��Ԫ");
        jl5.setBounds(150, 270, 150, 50);
        jl5.setFont(f);
        jtf5 = new JTextField(10);
        jtf5.setBounds(260,281,150,30);
        jtf5.setFont(f1);
        add(jl5);
        add(jtf5);

        //����ס¥�������
        jl6 = new JLabel("��ס¥");
        jl6.setBounds(150, 320, 150, 50);
        jl6.setFont(f);
        jtf6 = new JTextField(10);
        jtf6.setBounds(260,331,150,30);
        jtf6.setFont(f1);
        add(jl6);
        add(jtf6);

        //����ס���š������
        jl7 = new JLabel("��ס����");
        jl7.setBounds(150, 370, 150, 50);
        jl7.setFont(f);
        jtf7 = new JTextField(10);
        jtf7.setBounds(260,381,150,30);
        jtf7.setFont(f1);
        add(jl7);
        add(jtf7);

        //����ס����ƽ�����������
        jl8 = new JLabel("��ס����");
        jl8.setBounds(150, 420, 150, 50);
        jl8.setFont(f);
        jtf8 = new JTextField(10);
        jtf8.setBounds(260,431,150,30);
        jtf8.setFont(f1);
        add(jl8);
        add(jtf8);

        //���á�ȷ�ϡ���ť
        jb1 = new JButton("ȷ��");
        jb1.setBounds(160, 500, 130, 50);
        add(jb1);
        jb1.addActionListener((e)->{
            //��ȡ����������
            sql = "insert into EMP(ID,NAME,AGE)" + " values ('"+jtf1.getText()+"','"+jtf2.getText()+"','"+jtf3.getText()+"')";
            //��sql����conn������SQLOperation�࣬���ڲ������ݿ�
            SQLOperation.add(conn,sql);
            //sql="insert into EMP(HNO,HNAME,HSEX,HAGE,HUNIT,HRESIDENCE,HNUMBER,HSQUARE)" + " values ('0006','happy','14')";
        });

        //���á�ȡ������ť������ȡ����ťʱ�ұ������ʾRightShowNullҳ��
        jb2 = new JButton("ȡ��");
        jb2.setBounds(310, 500, 130, 50);
        add(jb2);
        jb2.addActionListener((e)-> {
            splitPane.setDividerLocation(300);
            splitPane.setRightComponent(right);
        });


    }
}
