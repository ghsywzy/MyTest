package SQLConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLBaseConnection {
    //url�����������ݿ⣬@����Ҫ�ĳɱ������ݿ��IP��ַ��1521���������ݿ�Ķ˿ڣ�Ҫ�ĳɺͱ������ݿ�һ�£�orcl�Ƕ�Ӧ�����ݿ���
    private static String url = "jdbc:oracle:thin:@192.168.137.133:1521:orcl";
    //user���������ݿ���û���
    private static String user = "root";
    //passWord������
    private static String password = "root";
    private static Connection conn;

    //�������ݿ⺯��
    public static Connection getConnection() {
        try {
            // ��ʼ��������
            Class.forName("oracle.jdbc.OracleDriver");
            // �������ݿ������ַ������ƣ������conn
            System.out.println("��ʼ�����������ݿ⣡");
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("���ݿ����ӳɹ���");
        return conn;
    }



}
