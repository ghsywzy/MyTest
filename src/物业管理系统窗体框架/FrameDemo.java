package ��ҵ����ϵͳ������;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameDemo {
    public static void main(String[] args) {
        // �����������

        final Frame f = new Frame("���ı���ɫ");

        // ���ô������ԺͲ���

        f.setBounds(400, 200, 400, 300);

        f.setLayout(new FlowLayout());

// ����������ť

        Button redButton = new Button("��ɫ");

        Button greenButton = new Button("��ɫ");

        Button buleButton = new Button("��ɫ");

// ��Ӱ�ť

        f.add(redButton);

        f.add(greenButton);

        f.add(buleButton);//��1��

// ���ô���ر�

        f.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {

                System.exit(0);

            }

        });


        redButton.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {

                f.setBackground(Color.red);//��2��

            }

        });



        redButton.addMouseListener(new MouseAdapter() {

            public void mouseExited(MouseEvent e) {//��3��

                f.setBackground(Color.WHITE);

            }

        });



        greenButton.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {

                f.setBackground(Color.GREEN);

            }

        });



        greenButton.addMouseListener(new MouseAdapter() {

            public void mouseExited(MouseEvent e) {

                f.setBackground(Color.WHITE);

            }

        });



        buleButton.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {//��4��

                f.setBackground(Color.BLUE);

            }

        });



        buleButton.addMouseListener(new MouseAdapter() {

            public void mouseExited(MouseEvent e) {

                f.setBackground(Color.WHITE);

            }

        });

    f.setVisible(true);//��5����6��
    }
}
