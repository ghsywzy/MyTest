package ��ҵ����ϵͳ������;

import javax.swing.*;
import java.awt.*;
import java.io.*;
/*
���������ҵ����ϵͳ
������ע����
���ã���ʾע�ᴰ�壬�˶��û�ע����Ϣ�������ض�Ӧ��ֵ��Login��
flagΪ����ֵ
0Ϊע��ɹ�
1Ϊע��ʧ�ܣ��û����ظ���
2Ϊע��ʧ�ܣ��û����������֣�
3Ϊע��ʧ�ܣ�ע����Ϣ��д��ȫ��
4Ϊע��ʧ�ܣ�������������벻ͬ��
 */
public class Register extends JFrame{
    //�������
    JPanel jp1;

    //��������
    Font f1;

    //������ǩ
    JLabel jl1;
    JLabel jl2;
    JLabel jl3;

    //���������
    JTextField jt1;
    JPasswordField jt2,jt3;

    //����������ť
    JButton jb1,jb2;

    //���������������������
    static BufferedReader br;
    static BufferedWriter bw;
    {
        try {
            bw = new BufferedWriter(new FileWriter("D:\\1111\\IDEA\\basic-code\\day01-code\\src\\��ҵ����ϵͳ������\\Login.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Register(JFrame jf) throws HeadlessException, FileNotFoundException {
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("ע�����");

        f1 = new Font(null, Font.BOLD, 25);

        //��¼���
        jp1 = new JPanel(null);

        //ע��ҳ��
        jl1 = new JLabel("�û���");
        jl1.setFont(f1);
        jl1.setBounds(70,10,100,50);
        jt1 = new JTextField(10);
        jt1.setBounds(160,23,150,30);

        jl2 = new JLabel("��    ��");
        jl2.setFont(f1);
        jl2.setBounds(70,100,100,50);
        jt2 = new JPasswordField(15);
        jt2.setBounds(160,113,150,30);

        jl3 = new JLabel("ȷ������");
        jl3.setFont(f1);
        jl3.setBounds(50,190,110,50);
        jt3 = new JPasswordField(15);
        jt3.setBounds(160,203,150,30);

        jb1 = new JButton("ע��");
        jb1.setBounds(70,280,100,60);
        jb1.addActionListener((e)->{
            try {
                if(register()==0){
                    JOptionPane.showMessageDialog(this, "ע��ɹ���");
                }else if(register()==1){
                    JOptionPane.showMessageDialog(this, "ע��ʧ�ܣ����û����ѱ�ʹ�ã�");
                }else if(register()==2){
                    JOptionPane.showMessageDialog(this, "ע��ʧ�ܣ��û���������ʹ�����֣�");
                }else if(register()==3){
                    JOptionPane.showMessageDialog(this, "ע��ʧ�ܣ�����д������ע����Ϣ��");
                }else if(register()==4){
                    JOptionPane.showMessageDialog(this, "ע��ʧ�ܣ�������������벻��ͬ��");
                }
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        });

        jb2 = new JButton("����");
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
        br = new BufferedReader(new FileReader("D:\\1111\\IDEA\\basic-code\\day01-code\\src\\��ҵ����ϵͳ������\\Login.txt"));
        String name = jt1.getText();
        String password = new String(jt2.getPassword());
        String password1 = new String(jt3.getPassword());
        String line = null;
        String[] check1 ;

        char[] namecheck = name.toCharArray();
        for(char a :namecheck){
            if(Character.isDigit(a)){
                //ע��ʧ�ܣ��û���������ʹ�����֣�
                flag = 2;
                return flag;
            }
        }
        if(name.equals("")||password.equals("")||password1.equals("")){
            //ע��ʧ�ܣ�����д������ע����Ϣ��
            flag = 3;
            return flag;
        }

        try {
            while ((line = br.readLine()) != null) {
                check1 = line.split("=");
                if (check1[0].equals(name)) {
                    //ע��ʧ�ܣ����û����ѱ�ʹ�ã�
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
               //ע��ʧ�ܣ�������������벻��ͬ��
               flag = 4;
           }
        }

        return flag;
    }

}
