package ��ҵ����ϵͳ������;

import javax.swing.*;
import java.io.*;
/*
���������ҵ����ϵͳ
��������¼�����
���ã���Login����ã����ں˶��û���¼��Ϣ���ҷ��ض�Ӧ��ֵ
    flag�Ǳ�־������
    0���ʾ��¼�ɹ�
    1���¼��Ϣ����,��¼ʧ��
    2��ʾ�û�δ�����κε�¼��Ϣ
    3��ʾ�û�������û����а������֣���¼ʧ��
 */
public class CheckLogin {
    static BufferedReader br;
    static BufferedWriter bw;
    {
        try {
            bw = new BufferedWriter(new FileWriter("D:\\1111\\IDEA\\basic-code\\day01-code\\src\\��ҵ����ϵͳ������\\Login.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int check(JTextField jtf1, JPasswordField jpf1) throws IOException {

        br = new BufferedReader(new FileReader("D:\\1111\\IDEA\\basic-code\\day01-code\\src\\��ҵ����ϵͳ������\\Login.txt"));

        //flag�����ж��û��������Ϣ�Ƿ���ȷ������������false�����ص�¼ʧ����Ϣ
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
                        //���û��������봫��RightShowNull()��
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
