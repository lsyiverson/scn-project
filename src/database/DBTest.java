package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import utils.Utils;
import bean.ProjectInfo;
import bean.User;
import bean.User.UserGroup;

public class DBTest implements DBInterface{
    private static DBTest mDB;
    private static Hashtable<String, User> usertable = new Hashtable<String, User>();
    
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
    
    @Override
    public String getEncryptedPasswordByUsername(String username) {
        Connection conn = getConnection();
        String encryptedPassword = "";
        Statement st;
        ResultSet rs;
        String sql = "SELECT password FROM scn.user WHERE username = '" + username + "'";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            rs.beforeFirst();
            while(rs.next()) {
                encryptedPassword = rs.getString("password");
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
        }
        return encryptedPassword;
    }
    
    @Override
    public boolean insertExcelData(List<ProjectInfo> excelData){
        //TODO: 实现此方法,用于向数据库中插入excel数据
        Connection conn = getConnection();
        Statement st;
        try {
                String sql = "INSERT INTO projectInfo "  
                       + " VALUES ('hello')";  // 插入数据的sql语句 
                st = (Statement) conn.createStatement();    // 创建用于执行静态sql语句的Statement对象  
                int count = st.executeUpdate(sql);  // 执行插入操作的sql语句，并返回插入数据的个数  
        
                System.out.println("向projectInfo表中插入 " + count + " 条数据"); //输出插入操作的处理结果  

                conn.close();   //关闭数据库连接  

        } catch (SQLException e) {  
                System.out.println("插入数据失败" + e.getMessage());  
        }
        return true;
      }
    
    @Override
    public boolean updateUserPassword(String username, String newEncryptedPassword) {
        //TODO: 实现此方法
        Connection conn = getConnection();
        Statement st;
        String sql = "update scn.user set password = '" + newEncryptedPassword + "' WHERE username = '" + username + "'";
        try {
            st = conn.createStatement();
            st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量  
            st.executeUpdate(sql);// 执行更新操作的sql语句，返回更新数据的个数 
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
        }
        //usertable.get(username).setPassword(newEncryptedPassword);
        return true;
    }

    @Override
    public User getUserByUsername(String username) {
        // TODO Auto-generated method stub
        Connection conn = getConnection();
        Statement st;
        ResultSet rs;
        User user = null;
        String sql = "SELECT * FROM scn.user WHERE username = '" + username + "'";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                String userName = rs.getString("username");
                String password = rs.getString("password");
                int userGroup = rs.getInt("group");
                UserGroup group;
                switch (userGroup) {
                case 0: 
                    group = UserGroup.USER;
                    break;
                case 1:
                    group = UserGroup.ADMIN;
                    break;
                case 2:
                    group = UserGroup.SUPERADMIN;
                    break;
                    default:
                        group = UserGroup.USER;
                }
                user = new User(userName,password,group);
            }
            
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
        }
        return user;
    }

    @Override
    public ArrayList<User> getAllUSERAccounts() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean delUserByUsername(String username) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isAlreadyHaveTheUser(String username) {
        // TODO Auto-generated method stub
        Connection conn = getConnection();
        Statement st;
        ResultSet rs;
        boolean result = false;
        String sql = "SELECT username FROM scn.user WHERE username = '" + username + "'";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                result = true;
            } else {
                result = false;
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
        }
        return result;
    }

    @Override
    public void createUser(String username) {
        // TODO Auto-generated method stub
        String userName =username;
        String password = Utils.hex_md5(username+"123456");
        int userGroup = 0;
        Connection conn = getConnection();
        Statement st;
        String sql = "inset into scn.user values('" + userName + "','" +password+ "','" +userGroup+ "')";
        try {
            st = conn.createStatement();
            st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量  
            st.executeUpdate(sql);// 执行更新操作的sql语句，返回更新数据的个数 
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
        }
    }

}
