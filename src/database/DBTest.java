package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {
    private static DBTest mDB;
    
    public static DBTest getInstance() {
        if (mDB == null) {
            mDB = new DBTest();
        }
        return mDB;
    }
    
    private DBTest() {
    }
    
    public Connection getConnection() {
        Connection con = null;  //创建用于连接数据库的Connection对象  
        try {  
            Class.forName("com.mysql.jdbc.Driver");// 加载Mysql数据驱动  
              
            con = DriverManager.getConnection(  
                    "jdbc:mysql://192.168.100.105:3306/scn", "root", "");// 创建数据连接  
              
        } catch (Exception e) {  
            System.out.println("数据库连接失败" + e.getMessage());  
        }  
        return con; //返回所建立的数据库连接  
    }
    
    public void getEncryptedPasswordByUsername(String username) {
        Connection conn = getConnection();
        Statement st;
        ResultSet rs;
        String sql = "SELECT * FROM scn.user WHERE username = '" + username + "'";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            rs.beforeFirst();
            while(rs.next()) {
                String u = rs.getString("username");
                String p = rs.getString("password");
                String g = rs.getString("group");
                System.out.println("username:"+u);
                System.out.println("password:"+p);
                System.out.println("group:"+g);
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
        }
    }

}
