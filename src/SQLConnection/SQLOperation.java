package SQLConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
/*
���������ҵ����ϵͳ
���������ݿ������
���ã�������RightMainFrameXXX����ã�ʵ�ֲ������ݿ�Ĺ���
 */
public class SQLOperation {
    private static Statement sm;
    private static ResultSet rs;
    //private static String sql;

    //���ݿ��ѯ
    public static void query(Connection conn,String sql) {
        //sql = "select * from EMP";
        String cs = "ID";
        try {
            sm = conn.createStatement();
            rs = sm.executeQuery(sql);
            System.out.println("��ѯ�����");
            while (rs.next()) {
                /*System.out.println("ID: " + rs.getString(1) + "\tNAME�� "
                        + rs.getString(2) + "\tAGE�� " + rs.getString(3));*/
                System.out.println(rs.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //��������
    public static void add(Connection conn,String sql) {
        //sql = "insert into EMP(ID,NAME,AGE)" + " values ('0005','lucyyyy','14')";
        try {
            sm = conn.createStatement();
            sm.executeUpdate(sql);
            System.out.println("��ӳɹ�");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //ɾ������
    public void delete(Connection conn,String sql) {
        //sql = "delete from EMP " + "where ID='0005'";
        try {
            sm = conn.createStatement();
            sm.executeUpdate(sql);
            System.out.println("ɾ���ɹ�");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //�޸�����
    public void update(Connection conn,String sql) {
        //sql = "update EMP set ID='2' where NAME='lucy'";
        try {
            sm = conn.createStatement();
            sm.executeUpdate(sql);
            System.out.println("���³ɹ�");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //�ͷ���Դ
    public void close(Connection conn) {// 6.�ͷ���Դ
        try { // ��׽�쳣
            try {
                if (rs != null) { // ��ResultSet�����ʵ��rs��Ϊ��ʱ
                    rs.close(); // �ر�ResultSet����
                }
            } finally {
                try {
                    if (sm != null) { // ��Statement�����ʵ��stmt��Ϊ��ʱ
                        sm.close(); // �ر�Statement����
                    }
                } finally {
                    if (conn != null) { // ��Connection�����ʵ��conn��Ϊ��ʱ
                        conn.close(); // �ر�Connection����
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.err); // ����쳣��Ϣ
        }
    }

}
