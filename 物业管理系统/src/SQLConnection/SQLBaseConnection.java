package SQLConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLBaseConnection {
    //url用于连接数据库，@后面要改成本地数据库的IP地址，1521是连接数据库的端口，要改成和本地数据库一致，orcl是对应的数据库名
    private static String url = "jdbc:oracle:thin:@192.168.137.133:1521:orcl";
    //user是连接数据库的用户名
    private static String user = "root";
    //passWord是密码
    private static String password = "root";
    private static Connection conn;

    //连接数据库函数
    public static Connection getConnection() {
        try {
            // 初始化驱动包
            Class.forName("oracle.jdbc.OracleDriver");
            // 根据数据库连接字符，名称，密码给conn
            System.out.println("开始尝试连接数据库！");
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("数据库连接成功！");
        return conn;
    }



}
