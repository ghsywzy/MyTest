package ��ҵ����ϵͳ������;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
/*
���������ҵ����ϵͳ
��������¼��
���ã���ʾ��¼���壬�û�������Ϣ�����CheckLogin��˶���Ϣ���û����ע��ʱ����Register������ע��
 */
public class Login extends JFrame {
    //���������
    JPanel jp1;

    //��������
    Font f1;

    //������ǩ
    JLabel jl1,jl2;

    //���������
    JTextField jt1;
    JPasswordField jt2;

    //����������ť
    JButton jb1,jb2,jb3;

    public Login() throws HeadlessException {

        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setTitle("��¼����");

        //��¼���
        jp1 = new JPanel(null);

        setContentPane(jp1);

        //�趨�����ʽ
        f1 = new Font(null, Font.BOLD, 25);

        //jl1���û�����ǩ
        jl1 = new JLabel("�û���");
        jl1.setFont(f1);
        jl1.setBounds(70,10,100,50);
        jt1 = new JTextField(10);
        jt1.setBounds(160,23,150,30);

        //jl2�������ǩ
        jl2 = new JLabel("��    ��");
        jl2.setFont(f1);
        jl2.setBounds(70,100,100,50);
        jt2 = new JPasswordField(10);
        jt2.setBounds(160,113,150,30);

        //Ԥ����д�û��������룬������Թ��ܺ�����Ҫɾ��
        jt1.setText("ghsy");
        jt2.setText("1234");

        //jb1,��¼��ť������ʹ��Lambda���ʽʵ�ְ�ť����
        jb1 = new JButton("��¼");
        jb1.setBounds(20,280,100,60);
        jb1.addActionListener((e)->{
            try {
                if(CheckLogin.check(jt1,jt2)==0){//CheckLogin��Ϊ����࣬���ں˶��û��ĵ�¼��Ϣ�������ض�Ӧ��ֵ
                    JOptionPane.showMessageDialog(this, "��¼�ɹ���");

                    //��¼�ɹ�����������
                    new MainFrame();

                    //�رյ�¼����
                    dispose();
                }else if(CheckLogin.check(jt1,jt2)==1){
                    JOptionPane.showMessageDialog(this, "��¼ʧ�ܣ������������¼��Ϣ��");
                }else if(CheckLogin.check(jt1,jt2)==2){
                    JOptionPane.showMessageDialog(this, "�����������ĵ�¼��Ϣ��");
                }else if(CheckLogin.check(jt1,jt2)==3){
                    JOptionPane.showMessageDialog(this, "�û���������������֣����������룡");
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        //jb2��ע�ᰴť����ʵ�ֹ���
        jb2 = new JButton("ע��");
        jb2.setBounds(140,280,100,60);
        jb2.addActionListener((e)->{
            try {
                new Register(this);//RegisterΪע���࣬�û����ע�ᰴťʱ����
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            setVisible(false);//����ע����ʱ���ص�¼����
        });

        //���ð�ť��������������������
        jb3 = new JButton("����");
        jb3.setBounds(260,280,100,60);
        jb3.addActionListener((e)->{
            jt1.setText("");
            jt2.setText("");
        });

        //�Ѹ��������ӵ������jp1
        jp1.add(jb1);
        jp1.add(jb2);
        jp1.add(jb3);
        jp1.add(jl1);
        jp1.add(jl2);
        jp1.add(jt1);
        jp1.add(jt2);

        //���ô��弰��������ɼ�
        setVisible(true);
    }
}
