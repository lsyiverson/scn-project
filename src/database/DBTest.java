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
        int location = 0;
        while (location <= excelData.size())
        {
            try {
                    String sql = "INSERT INTO projectInfo "  
                           + " VALUES ("+excelData.get(location).getNumber()+",'"+excelData.get(location).getNumber()+"',"+excelData.get(location).getItemDate()
                           +",'"+excelData.get(location).getItemName()+"','"+excelData.get(location).getProNumber()+"','"+excelData.get(location).getProName()
                           +"','"+excelData.get(location).getProPropertyGroup()+"','"+excelData.get(location).getProTypeGroup()+"','"+excelData.get(location).getProAddress()
                           +"',"+excelData.get(location).getA_MaterialCST()+",'"+excelData.get(location).getA_MaterialBill()+"',"+excelData.get(location).getB_MaterialCST()
                           +",'"+excelData.get(location).getB_MaterialBill()+"',"+excelData.get(location).getLaborCost()+",'"+excelData.get(location).getLaborCstBill()
                           +"',"+excelData.get(location).getCoordinationFee()+","+excelData.get(location).getTotalFee()+",'"+excelData.get(location).getMaterialQua()
                           +"','"+excelData.get(location).getConsMethodGroup()+"',"+excelData.get(location).getProOADate()+","+excelData.get(location).getProPaperDate()
                           +","+excelData.get(location).getDispatchDate()+","+excelData.get(location).getAuditRecordDate()+",'"+excelData.get(location).getContractNumber()
                           +"',"+excelData.get(location).getContractAccount()+","+excelData.get(location).getFirstPaymentAmount()+","+excelData.get(location).getSecondPaymentAmount()
                           +",'"+excelData.get(location).getApproachTime()+"','"+excelData.get(location).getApproachExpectMaterial()+"','"+excelData.get(location).getProLeader() 
                           +"','"+excelData.get(location).getConstructionUnit()+"','"+excelData.get(location).getMonthProgress()+"','"+excelData.get(location).getLastMonthProgress()
                           +"','"+excelData.get(location).getHouseHolds()+"','"+excelData.get(location).getRouteLength()+"','"+excelData.get(location).getReformWay()
                           +"','"+excelData.get(location).getConsStageGroup()+"','"+excelData.get(location).getConcealedWork()+"','"+excelData.get(location).getHookingOrTube()
                           +"','"+excelData.get(location).getOrderChangeNo()+"','"+excelData.get(location).getOrderChangeAccount()+"','"+excelData.get(location).getConstruction()
                           +"',"+excelData.get(location).getCompletedDate()+","+excelData.get(location).getSubmitCompletionData()+",'"+excelData.get(location).getAcceptance()
                           +"','"+excelData.get(location).getActualInstall()+"','"+excelData.get(location).getAssetsTransfer()+"','"+excelData.get(location).getAssetsGIS()
                           +"','"+excelData.get(location).getCompletionDocNo()+"','"+excelData.get(location).getDataTransfer()+"',"+excelData.get(location).getImportantDataSubmit()
                           +",'"+excelData.get(location).getSettlementAmount()+"','"+excelData.get(location).getImportantProAmount()+"','"+excelData.get(location).getSettlementPayable()
                           +"','"+excelData.get(location).getSettlementPayMerchants()+"','"+excelData.get(location).getOwedAmount()+"','"+excelData.get(location).getThirdPaymentAmount()
                           +"','"+excelData.get(location).getRetentionAmount()+"','"+excelData.get(location).getRetentionExpires()+"','"+excelData.get(location).getNextMonthPayAmount()
                           +"','"+excelData.get(location).getOpticalNode()+"','"+excelData.get(location).getCable()+"','"+excelData.get(location).getChargeConstruction()+"')";  // 插入数据的sql语句 
                    st = (Statement) conn.createStatement();    // 创建用于执行静态sql语句的Statement对象  
                    st.executeUpdate(sql);  // 执行插入操作的sql语句，并返回插入数据的个数  
                      
                    location = location + 1;
            } catch (SQLException e) {  
                    System.out.println("插入数据失败" + e.getMessage());  
            }
        }
        try{
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
        String sql = "UPDATE scn.user SET password = '" + newEncryptedPassword + "' WHERE username = '" + username + "'";
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
    public ArrayList<String> getAllUSERAccounts() {
        // TODO Auto-generated method stub
        Connection conn = getConnection();
        Statement st;
        ResultSet rs;
        ArrayList<String> username = new ArrayList<String>();
        int usergroup = 0;
        String sql = "SELECT username FROM scn.user WHERE scn.user.group = " + usergroup;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                username.add(rs.getString("username"));
            }
            
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
        }
        return username;
    }

    @Override
    public boolean delUserByUsername(String username) {
        // TODO Auto-generated method stub
        Connection conn = getConnection();
        Statement st;
        String sql = "DELETE FROM scn.user WHERE username = '" +username+ "'";
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
        return true;
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
        String sql = "INSERT INTO scn.user VALUES('" + userName + "','" +password+ "','" +userGroup+ "')";
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
