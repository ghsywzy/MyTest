package SQLConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
/*
软件名：物业管理系统
类名：数据库操作类
作用：被各个RightMainFrameXXX类调用，实现操作数据库的功能
 */
public class SQLOperation {
    private static Statement sm;
    private static ResultSet rs;
    //private static String sql;

    //数据库查询
    public static void query(Connection conn,String sql) {
        //sql = "select * from EMP";
        String cs = "ID";
        try {
            sm = conn.createStatement();
            rs = sm.executeQuery(sql);
            System.out.println("查询结果：");
            while (rs.next()) {
                /*System.out.println("ID: " + rs.getString(1) + "\tNAME： "
                        + rs.getString(2) + "\tAGE： " + rs.getString(3));*/
                System.out.println(rs.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //新增数据
    public static void add(Connection conn,String sql) {
        //sql = "insert into EMP(ID,NAME,AGE)" + " values ('0005','lucyyyy','14')";
        try {
            sm = conn.createStatement();
            sm.executeUpdate(sql);
            System.out.println("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //删除数据
    public void delete(Connection conn,String sql) {
        //sql = "delete from EMP " + "where ID='0005'";
        try {
            sm = conn.createStatement();
            sm.executeUpdate(sql);
            System.out.println("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //修改数据
    public void update(Connection conn,String sql) {
        //sql = "update EMP set ID='2' where NAME='lucy'";
        try {
            sm = conn.createStatement();
            sm.executeUpdate(sql);
            System.out.println("更新成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //释放资源
    public void close(Connection conn) {// 6.释放资源
        try { // 捕捉异常
            try {
                if (rs != null) { // 当ResultSet对象的实例rs不为空时
                    rs.close(); // 关闭ResultSet对象
                }
            } finally {
                try {
                    if (sm != null) { // 当Statement对象的实例stmt不为空时
                        sm.close(); // 关闭Statement对象
                    }
                } finally {
                    if (conn != null) { // 当Connection对象的实例conn不为空时
                        conn.close(); // 关闭Connection对象
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.err); // 输出异常信息
        }
    }

}
