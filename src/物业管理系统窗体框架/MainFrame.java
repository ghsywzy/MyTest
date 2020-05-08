package ��ҵ����ϵͳ������;

import SQLConnection.SQLBaseConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
/*
���������ҵ����ϵͳ
��������������
���ã��û���¼�ɹ�ʱ��Login����ã���ʾ������
     ����RightFrameXXX������ʵ�ָ�����ť�Ĺ���
 */
public class MainFrame extends JFrame {
    JSplitPane splitPane ;//split���
    JPanel p1 = new JPanel();//�����
    Font f,f1;//��������
    JLabel jl1,jl2;//��ǩ
    JButton jb1,jb2,jb3,jb4;//�����İ�ť
    Connection conn;//�������ݿ����Ӷ���

    public MainFrame() {

        //����SQLBaseConnection�࣬����������ݿ��Ķ���conn
        conn = SQLBaseConnection.getConnection();

        //���ùرմ���ͬʱ�رճ���
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //���þ��Բ��֣��Զ��壩
        p1.setLayout(null);

        //���������͹���߿�
        p1.setBorder(BorderFactory.createRaisedSoftBevelBorder());

        //��������
        f=new Font("����",Font.BOLD,25);//��ǩ����
        f1=new Font("����",Font.PLAIN,20);//��ť����

        //���ô�������
        setTitle("��ҵ����ϵͳ������");

        //���������ܡ���ǩ
        jl1 = new JLabel("��������");
        jl1.setBounds(100, 0, 150, 50);
        jl1.setFont(f);
        p1.add(jl1);

        //���ü�����ť�ķ���������ť���޷�������
        add();
        delete();
        update();
        select();

        //���������ӵ�split���
        splitPane = new JSplitPane();
        splitPane.setLeftComponent(p1);
        splitPane.setRightComponent(new RightShowNull());
        //splitPane.setRightComponent(new RightFrameAdd(splitPane,new RightShowNull()));

        //���÷ָ��������϶�
        splitPane.setEnabled(false);
        //�ָ�������ʾ���� �۵�/չ�� ���������С��ť
        splitPane.setOneTouchExpandable(true);
        //���÷ָ����ĳ�ʼλ��
        splitPane.setDividerLocation(300);
        //���ô�����ʾ�����
        setContentPane(splitPane);

        //����JFrame������
        setResizable(false);//���ò����Ըı��С
        pack();//�Զ�����
        //setSize(900,450);
        setSize(1200,700);

        //��������ʱ���ڵ�λ��
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        //���ø������״̬Ϊ�ɼ�
        setVisible(true);
    }

    public void add() {
        //�����ס��������
        jb1 = new JButton("���ס��");
        jb1.setBounds(10, 50, 130, 50);
        jb1.setFont(f1);
        p1.add(jb1);
        jb1.addActionListener((e)-> {
            splitPane.setDividerLocation(300);
            //�ѷָ���壬�ҿ���壬���ݿ����Ӷ��󴫵ݵ�RightFrameAdd����
            splitPane.setRightComponent(new RightFrameAdd(splitPane,new RightShowNull(),conn));
        });
    }

    public void delete() {
        //��ɾ��ס��������
        jb2 = new JButton("ɾ��ס��");
        jb2.setBounds(160, 50, 130, 50);
        jb2.setFont(f1);
        p1.add(jb2);
        jb2.addActionListener((e)->{
            splitPane.setDividerLocation(300);
            splitPane.setRightComponent(new RightFrameDelete(splitPane,new RightShowNull()));
        });
    }

    public void update() {
        //���޸�ס��������
        jb3 = new JButton("�޸�ס��");
        jb3.setBounds(10, 120, 130, 50);
        jb3.setFont(f1);
        p1.add(jb3);
    }

    public void select() {
        //����ѯס��������
        jb4 = new JButton("��ѯס��");
        jb4.setBounds(160, 120, 130, 50);
        jb4.setFont(f1);
        p1.add(jb4);
        jb4.addActionListener((e)->{
            splitPane.setDividerLocation(300);
            splitPane.setRightComponent(new RightFrameSelect(splitPane,new RightShowNull()));
        });
    }


}
