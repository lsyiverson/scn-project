package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;

import utils.Utils;
import bean.ProjectInfo;
import bean.User;
import bean.User.UserGroup;

public class DBHelper implements DBInterface{
    private static DBHelper mDB;
    
    public static DBHelper getInstance() {
        if (mDB == null) {
            mDB = new DBHelper();
        }
        return mDB;
    }
    
    private DBHelper() {
    }
    
    public Connection getConnection() {
        Connection con = null;  //创建用于连接数据库的Connection对象  
        try {  
            Context initCtx = new InitialContext();
            Context ctx = (Context)initCtx.lookup("java:comp/env");
            DataSource ds = (DataSource)ctx.lookup("jdbc/mysql");
            con = ds.getConnection();
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
        while (location < excelData.size()) {
            if (excelData.get(location).getItemName() == null 
                    || StringUtils.isEmpty(excelData.get(location).getItemName().trim())) {
                location++;
                continue;
            }

            try {
                StringBuilder sqlBuilder = new StringBuilder("INSERT INTO projectinfo (");
                if (excelData.get(location).getNumber() != 0) {
                    sqlBuilder.append("number, ");
                }
                sqlBuilder.append("itemSource, itemDate, itemName, proNumber, proName, proProperty, proType, proAddress, A_MaterialCST, A_MaterialBill, B_MaterialCST, "
                        + "B_MaterialBill, laborCost, laborCstBill, coordinationFee, totalFee, materialQua, consMethodGroup, proOADate, proPaperDate, dispatchDate, "
                        + "auditRecordDate, contractNumber, contractAccount, firstPaymentAmount, secondPaymentAmount, approachTime, approachExpectMaterial, proLeader, "
                        + "constructionUnit, monthProgress, lastMonthProgress, houseHolds, routeLength, reformWay, consStageGroup, concealedWork, hookingOrTube, "
                        + "orderChangeNo, orderChangeAccount, construction, completedDate, submitCompletionData, acceptance, actualInstall, assetsTransfer, assetsGIS, "
                        + "completionDocNo, dataTransfer, importantDataSubmit, settlementAmount, importantProAmount, settlementPayable, settlementPayMerchants, owedAmount, "
                        + "thirdPaymentAmount, retentionAmount, retentionExpires, nextMonthPayAmount, opticalNode, cable, chargeConstruction) ");
                sqlBuilder.append("VALUES (");
                if (excelData.get(location).getNumber() != 0) {
                    sqlBuilder.append(excelData.get(location).getNumber() + ",");
                }
                sqlBuilder.append("'"+excelData.get(location).getItemSourceGroup()+"',str_to_date('"+ Utils.DATE_FORMAT.format(excelData.get(location).getItemDate())+"','%Y.%m.%d')"
                           +",'"+excelData.get(location).getItemName()+"','"+excelData.get(location).getProNumber()+"','"+excelData.get(location).getProName()
                           +"','"+excelData.get(location).getProPropertyGroup()+"','"+excelData.get(location).getProTypeGroup()+"','"+excelData.get(location).getProAddress()
                           +"',"+excelData.get(location).getA_MaterialCST()+",'"+excelData.get(location).getA_MaterialBill()+"',"+excelData.get(location).getB_MaterialCST()
                           +",'"+excelData.get(location).getB_MaterialBill()+"',"+excelData.get(location).getLaborCost()+",'"+excelData.get(location).getLaborCstBill()
                           +"',"+excelData.get(location).getCoordinationFee()+","+excelData.get(location).getTotalFee()+",'"+excelData.get(location).getMaterialQua()
                           +"','"+excelData.get(location).getConsMethodGroup()+"','"+excelData.get(location).getProOADate()+"','"+excelData.get(location).getProPaperDate()
                           +"','"+excelData.get(location).getDispatchDate()+"','"+excelData.get(location).getAuditRecordDate()+"','"+excelData.get(location).getContractNumber()
                           +"',"+excelData.get(location).getContractAccount()+",'"+excelData.get(location).getFirstPaymentAmount()+"','"+excelData.get(location).getSecondPaymentAmount()
                           +"','"+excelData.get(location).getApproachTime()+"','"+excelData.get(location).getApproachExpectMaterial()+"','"+excelData.get(location).getProLeader() 
                           +"','"+excelData.get(location).getConstructionUnit()+"','"+excelData.get(location).getMonthProgress()+"','"+excelData.get(location).getLastMonthProgress()
                           +"','"+excelData.get(location).getHouseHolds()+"','"+excelData.get(location).getRouteLength()+"','"+excelData.get(location).getReformWay()
                           +"','"+excelData.get(location).getConsStageGroup()+"','"+excelData.get(location).getConcealedWork()+"','"+excelData.get(location).getHookingOrTube()
                           +"','"+excelData.get(location).getOrderChangeNo()+"','"+excelData.get(location).getOrderChangeAccount()+"','"+excelData.get(location).getConstruction()
                           +"','"+excelData.get(location).getCompletedDate()+"','"+excelData.get(location).getSubmitCompletionData()+"','"+excelData.get(location).getAcceptance()
                           +"','"+excelData.get(location).getActualInstall()+"','"+excelData.get(location).getAssetsTransfer()+"','"+excelData.get(location).getAssetsGIS()
                           +"','"+excelData.get(location).getCompletionDocNo()+"','"+excelData.get(location).getDataTransfer()+"','"+excelData.get(location).getImportantDataSubmit()
                           +"','"+excelData.get(location).getSettlementAmount()+"','"+excelData.get(location).getImportantProAmount()+"','"+excelData.get(location).getSettlementPayable()
                           +"','"+excelData.get(location).getSettlementPayMerchants()+"','"+excelData.get(location).getOwedAmount()+"','"+excelData.get(location).getThirdPaymentAmount()
                           +"','"+excelData.get(location).getRetentionAmount()+"','"+excelData.get(location).getRetentionExpires()+"','"+excelData.get(location).getNextMonthPayAmount()
                           +"','"+excelData.get(location).getOpticalNode()+"','"+excelData.get(location).getCable()+"','"+excelData.get(location).getChargeConstruction()+"')"
                           +" ON DUPLICATE KEY UPDATE ");
                if (excelData.get(location).getNumber() != 0) {
                    sqlBuilder.append("number=" + excelData.get(location).getNumber() + ", ");
                }
                sqlBuilder.append("itemSource='"+excelData.get(location).getItemSourceGroup()+"', itemDate=str_to_date('"+ Utils.DATE_FORMAT.format(excelData.get(location).getItemDate())+"','%Y.%m.%d')"
                           +", itemName='"+excelData.get(location).getItemName()+"', proNumber='"+excelData.get(location).getProNumber()+"', proName='"+excelData.get(location).getProName()
                           +"', proProperty='"+excelData.get(location).getProPropertyGroup()+"', proType='"+excelData.get(location).getProTypeGroup()+"', proAddress='"+excelData.get(location).getProAddress()
                           +"', A_MaterialCST="+excelData.get(location).getA_MaterialCST()+", A_MaterialBill='"+excelData.get(location).getA_MaterialBill()+"', B_MaterialCST="+excelData.get(location).getB_MaterialCST()
                           +", B_MaterialBill='"+excelData.get(location).getB_MaterialBill()+"', laborCost="+excelData.get(location).getLaborCost()+", LaborCstBill='"+excelData.get(location).getLaborCstBill()
                           +"', coordinationFee="+excelData.get(location).getCoordinationFee()+", totalFee="+excelData.get(location).getTotalFee()+", materialQua='"+excelData.get(location).getMaterialQua()
                           +"', consMethodGroup='"+excelData.get(location).getConsMethodGroup()+"', proOADate='"+excelData.get(location).getProOADate()+"', proPaperDate='"+excelData.get(location).getProPaperDate()
                           +"', dispatchDate='"+excelData.get(location).getDispatchDate()+"', auditRecordDate='"+excelData.get(location).getAuditRecordDate()+"', contractNumber='"+excelData.get(location).getContractNumber()
                           +"', contractAccount="+excelData.get(location).getContractAccount()+", firstPaymentAmount='"+excelData.get(location).getFirstPaymentAmount()+"', secondPaymentAmount='"+excelData.get(location).getSecondPaymentAmount()
                           +"', approachTime='"+excelData.get(location).getApproachTime()+"', approachExpectMaterial='"+excelData.get(location).getApproachExpectMaterial()+"', proLeader='"+excelData.get(location).getProLeader() 
                           +"', constructionUnit='"+excelData.get(location).getConstructionUnit()+"', monthProgress='"+excelData.get(location).getMonthProgress()+"', lastMonthProgress='"+excelData.get(location).getLastMonthProgress()
                           +"', houseHolds='"+excelData.get(location).getHouseHolds()+"', routeLength='"+excelData.get(location).getRouteLength()+"', reformWay='"+excelData.get(location).getReformWay()
                           +"', consStageGroup='"+excelData.get(location).getConsStageGroup()+"', concealedWork='"+excelData.get(location).getConcealedWork()+"', hookingOrTube='"+excelData.get(location).getHookingOrTube()
                           +"', orderChangeNo='"+excelData.get(location).getOrderChangeNo()+"', orderChangeAccount='"+excelData.get(location).getOrderChangeAccount()+"', construction='"+excelData.get(location).getConstruction()
                           +"', completedDate='"+excelData.get(location).getCompletedDate()+"', submitCompletionData='"+excelData.get(location).getSubmitCompletionData()+"', acceptance='"+excelData.get(location).getAcceptance()
                           +"', actualInstall='"+excelData.get(location).getActualInstall()+"', assetsTransfer='"+excelData.get(location).getAssetsTransfer()+"', assetsGIS='"+excelData.get(location).getAssetsGIS()
                           +"', completionDocNo='"+excelData.get(location).getCompletionDocNo()+"', dataTransfer='"+excelData.get(location).getDataTransfer()+"', importantDataSubmit='"+excelData.get(location).getImportantDataSubmit()
                           +"', settlementAmount='"+excelData.get(location).getSettlementAmount()+"', importantProAmount='"+excelData.get(location).getImportantProAmount()+"', settlementPayable='"+excelData.get(location).getSettlementPayable()
                           +"', settlementPayMerchants='"+excelData.get(location).getSettlementPayMerchants()+"', owedAmount='"+excelData.get(location).getOwedAmount()+"', thirdPaymentAmount='"+excelData.get(location).getThirdPaymentAmount()
                           +"', retentionAmount='"+excelData.get(location).getRetentionAmount()+"', retentionExpires='"+excelData.get(location).getRetentionExpires()+"', nextMonthPayAmount='"+excelData.get(location).getNextMonthPayAmount()
                           +"', opticalNode='"+excelData.get(location).getOpticalNode()+"', cable='"+excelData.get(location).getCable()+"', chargeConstruction='"+excelData.get(location).getChargeConstruction()+"'");  // 插入数据的sql语句 
                String sql = sqlBuilder.toString();
                    if(0==location)
                    Utils.Log(sql);
                    st = (Statement) conn.createStatement();    // 创建用于执行静态sql语句的Statement对象  
                    st.executeUpdate(sql);  // 执行插入操作的sql语句，并返回插入数据的个数  
            } catch (SQLException e) {  
                    System.out.println("插入数据失败" + e.getMessage());  
            } catch (NullPointerException e){
                Utils.Log(""+location+"-------size--->"+excelData.size()+"--excelData.get(location)--->"+excelData.get(location)+"-----excelData.get(location).getItemDate()----->"+excelData.get(location).getItemDate());
            } finally {
                location = location + 1;
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
                
                //向用户对象添加权限列表
                user.setPermission(getPermisssionByUsername(username));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
        }
        return user;
    }
    
    public ArrayList<String> getPermisssionByUsername(String username) {
        ArrayList<String> permissionList = new ArrayList<String>();
        Connection conn = getConnection();
        Statement st;
        ResultSet rs;
        String sql = "SELECT districtname FROM scn.permission WHERE username = '" + username +"'";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                permissionList.add(rs.getString("districtname"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return permissionList;
    }

    @Override
    public ArrayList<String> getAllUSERAccounts() {
        return getAllUserAccountsByGroup(UserGroup.USER);
    }

    @Override
    public boolean delUserByUsername(String username) {
        // TODO Auto-generated method stub
        Connection conn = getConnection();
        Statement st;
        String sql = "DELETE FROM scn.user WHERE username = '" +username+ "'";
        String sql_del_permission = "DELETE FROM scn.permission WHERE username = '" +username+ "'";
        try {
            st = conn.createStatement();
            st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量  
            st.executeUpdate(sql);// 执行更新操作的sql语句，返回更新数据的个数 
            
            //删除用户关联的权限
            st.execute(sql_del_permission);
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public void removeAllUserDistrict(String username) {
        Connection conn = getConnection();
        Statement st;
        String sql_del_permission = "DELETE FROM scn.permission WHERE username = '" +username+ "'";
        try {
            st = conn.createStatement();
            st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量  
            
            //删除用户关联的权限
            st.execute(sql_del_permission);
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
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
    public void createUser(String username, UserGroup usergroup) {
        // TODO Auto-generated method stub
        String userName =username;
        String password = Utils.hex_md5(username+"123456");
        int userGroup;
        switch (usergroup) {
        case USER:
            userGroup = 0;
            break;
        case ADMIN:
            userGroup = 1;
            break;
        default:
            userGroup = 0;
            break;
        }
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
    
    @Override
    public void addUserDistrict(String username, String district) {
        Connection conn = getConnection();
        Statement st;
        String sql = "INSERT INTO scn.permission(username, districtname) VALUES('" + username + "','" + district + "')";
        try {
            st = conn.createStatement();
            st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量  
            st.executeUpdate(sql);// 执行更新操作的sql语句，返回更新数据的个数 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * 查询的项目来源关键字列表
     */
    private ArrayList<String> mSourceList;
    
    /**
     * 查询的项目性质关键字列表
     */
    private ArrayList<String> mPropertyList;
    
    /**
     * 查询的项目类别关键字列表
     */
    private ArrayList<String> mTypeList;

    @Override
    public ArrayList<ProjectInfo> queryProjectRecord(String[] itemsource,
            String itemdate, String itemname, String pronumber, String proname,
            String[] proproperty, String[] protype, String proaddress) {
        
        ArrayList<ProjectInfo> queryResult = new ArrayList<ProjectInfo>();
        String SQL = generateSQLStatement(itemsource, itemdate, itemname, pronumber, proname, proproperty, protype, proaddress);
        
        //TODO: 实现此方法，以查询到的数据生成ProjectInfo的LIst
        Connection conn = getConnection();
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(SQL);
            while (rs.next()) {
                ProjectInfo projectInfo = new ProjectInfo();
                projectInfo.setNumber(rs.getInt("number"));
                projectInfo.setItemSourceGroup(rs.getString("itemSource"));
                projectInfo.setItemDate(rs.getDate("itemDate"));
                projectInfo.setItemName(rs.getString("itemName"));
                projectInfo.setProNumber(rs.getString("proNumber"));
                projectInfo.setProName(rs.getString("proName"));
                projectInfo.setProPropertyGroup(rs.getString("proProperty"));
                projectInfo.setProTypeGroup(rs.getString("proType"));
                projectInfo.setProAddress(rs.getString("proAddress"));
                projectInfo.setA_MaterialCST(rs.getFloat("A_MaterialCST"));
                projectInfo.setA_MaterialBill(rs.getString("A_MaterialBill"));
                projectInfo.setB_MaterialCST(rs.getFloat("B_MaterialCST"));
                projectInfo.setB_MaterialBill(rs.getString("B_MaterialBill"));
                projectInfo.setLaborCost(rs.getFloat("laborCost"));
                projectInfo.setLaborCstBill(rs.getString("laborCstBill"));
                projectInfo.setCoordinationFee(rs.getFloat("coordinationFee"));
                projectInfo.setTotalFee(rs.getFloat("totalFee"));
                projectInfo.setMaterialQua(rs.getString("materialQua"));
                projectInfo.setConsMethodGroup(rs.getString("consMethodGroup"));
                projectInfo.setProOADate(rs.getString("proOADate"));
                projectInfo.setProPaperDate(rs.getString("proPaperDate"));
                projectInfo.setDispatchDate(rs.getString("dispatchDate"));
                projectInfo.setAuditRecordDate(rs.getString("auditRecordDate"));
                projectInfo.setContractNumber(rs.getString("contractNumber"));
                projectInfo.setContractAccount(rs.getFloat("contractAccount"));
                projectInfo.setFirstPaymentAmount(convertToMoney(rs.getString("firstPaymentAmount")));
                projectInfo.setSecondPaymentAmount(convertToMoney(rs.getString("secondPaymentAmount")));
                projectInfo.setApproachTime(rs.getString("approachTime"));
                projectInfo.setApproachExpectMaterial(rs.getString("approachExpectMaterial"));
                projectInfo.setProLeader(rs.getString("proLeader"));
                projectInfo.setConstructionUnit(rs.getString("constructionUnit"));
                projectInfo.setMonthProgress(rs.getString("monthProgress"));
                projectInfo.setLastMonthProgress(rs.getString("lastMonthProgress"));
                projectInfo.setHouseHolds(rs.getString("houseHolds"));
                projectInfo.setRouteLength(rs.getString("routeLength"));
                projectInfo.setReformWay(rs.getString("reformWay"));
                projectInfo.setConsStageGroup(rs.getString("consStageGroup"));
                projectInfo.setConcealedWork(rs.getString("concealedWork"));
                projectInfo.setHookingOrTube(rs.getString("hookingOrTube"));
                projectInfo.setOrderChangeNo(rs.getString("orderChangeNo"));
                projectInfo.setOrderChangeAccount(rs.getString("orderChangeAccount"));
                projectInfo.setConstruction(rs.getString("construction"));
                projectInfo.setCompletedDate(rs.getString("completedDate"));
                projectInfo.setSubmitCompletionData(rs.getString("submitCompletionData"));
                projectInfo.setAcceptance(rs.getString("acceptance"));
                projectInfo.setActualInstall(rs.getString("actualInstall"));
                projectInfo.setAssetsTransfer(rs.getString("assetsTransfer"));
                projectInfo.setAssetsGIS(rs.getString("assetsGIS"));
                projectInfo.setCompletionDocNo(rs.getString("completionDocNo"));
                projectInfo.setDataTransfer(rs.getString("dataTransfer"));
                projectInfo.setImportantDataSubmit(rs.getString("importantDataSubmit"));
                projectInfo.setSettlementAmount(rs.getString("settlementAmount"));
                projectInfo.setImportantProAmount(rs.getString("importantProAmount"));
                projectInfo.setSettlementPayable(rs.getString("settlementPayable"));
                projectInfo.setSettlementPayMerchants(rs.getString("settlementPayMerchants"));
                projectInfo.setOwedAmount(rs.getString("owedAmount"));
                projectInfo.setThirdPaymentAmount(convertToMoney(rs.getString("thirdPaymentAmount")));
                projectInfo.setRetentionAmount(rs.getString("retentionAmount"));
                projectInfo.setRetentionExpires(rs.getString("retentionExpires"));
                projectInfo.setNextMonthPayAmount(rs.getString("nextMonthPayAmount"));
                projectInfo.setOpticalNode(rs.getString("opticalNode"));
                projectInfo.setCable(rs.getString("cable"));
                projectInfo.setChargeConstruction(rs.getString("chargeConstruction"));
                queryResult.add(projectInfo);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return queryResult;
    }
    
    private String convertToMoney(String src) {
        DecimalFormat df = new DecimalFormat("0.00");
        try {
            float value = Float.parseFloat(src);
            String money = df.format(value);
            return money;
        } catch(NumberFormatException ex){
            return src;
        } catch(IllegalArgumentException ex) {
            return src;
        }
    }
    
    private String generateSQLStatement(String[] itemsource,
            String itemdate, String itemname, String pronumber, String proname,
            String[] proproperty, String[] protype, String proaddress) {
        StringBuilder sql = new StringBuilder("SELECT * FROM scn.projectinfo");
        mSourceList = removeEmptyItem(itemsource);
        mPropertyList = removeEmptyItem(proproperty);
        mTypeList = removeEmptyItem(protype);
        boolean needAddAnd = false;
        if(isQueryNeedFilter(itemsource, itemdate, itemname, pronumber, proname, proproperty, protype, proaddress)){
            sql.append(" WHERE");
            if (!mSourceList.isEmpty()) {
                if (!needAddAnd){
                    needAddAnd = true;
                }
                sql.append(buildQueryStatement("itemSource", mSourceList));
            }
            if (!mPropertyList.isEmpty()) {
                if (needAddAnd) {
                    sql.append(" AND");
                } else {
                    needAddAnd = true;
                }
                sql.append(buildQueryStatement("proProperty", mPropertyList));
            }
            if (!mTypeList.isEmpty()) {
                if (needAddAnd) {
                    sql.append(" AND");
                } else {
                    needAddAnd = true;
                }
                sql.append(buildQueryStatement("proType", mTypeList));
            }
            if (!itemdate.isEmpty()) {
                if (needAddAnd) {
                    sql.append(" AND");
                } else {
                    needAddAnd = true;
                }
                sql.append(" itemDate=str_to_date('"+ itemdate +"', '%Y-%m-%d')");
            }
            if (!itemname.isEmpty()) {
                if (needAddAnd) {
                    sql.append(" AND");
                } else {
                    needAddAnd = true;
                }
                sql.append(" itemName LIKE '%" + itemname +"%'");
            }
            if (!pronumber.isEmpty()) {
                if (needAddAnd) {
                    sql.append(" AND");
                } else {
                    needAddAnd = true;
                }
                sql.append(" proNumber LIKE '%" + pronumber +"%'");
            }
            if (!proname.isEmpty()) {
                if (needAddAnd) {
                    sql.append(" AND");
                } else {
                    needAddAnd = true;
                }
                sql.append(" proName LIKE '%" + proname +"%'");
            }
            if (!proaddress.isEmpty()) {
                if (needAddAnd) {
                    sql.append(" AND");
                } else {
                    needAddAnd = true;
                }
                sql.append(" proAddress LIKE '%" + proaddress +"%'");
            }
        }
        System.out.println(sql.toString());
        return sql.toString();
    }

    private String buildQueryStatement(String field, ArrayList<String> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                sb.append(" " + field + " LIKE '%" + list.get(i) + "%'");
            } else {
                sb.append(" OR " + field + " LIKE '%" + list.get(i) + "%'");
            }
        }
        return sb.toString();
    }
    
    /**
     * 判断字符串数组中是否每一项都有内容
     */
    private ArrayList<String> removeEmptyItem(String[] strArray) {
        ArrayList<String> list = new ArrayList<>();
        for(String str : strArray) {
            if(!str.isEmpty()) {
                list.add(str);
            }
        }
        return list;
    }
    
    /**
     * 判断是否需要在查询SQL语句中加入WHERE条件判断
     */
    private boolean isQueryNeedFilter(String[] itemsource,
            String itemdate, String itemname, String pronumber, String proname,
            String[] proproperty, String[] protype, String proaddress) {
        if (mSourceList == null) {
            mSourceList = removeEmptyItem(itemsource);
        }
        if (mPropertyList == null) {
            mPropertyList = removeEmptyItem(proproperty);
        }
        if (mTypeList == null) {
            mTypeList = removeEmptyItem(protype);
        }
        if (!mSourceList.isEmpty()||!mPropertyList.isEmpty()||!mTypeList.isEmpty()) {
            return true;
        }
        if (!itemdate.isEmpty()||!itemname.isEmpty()||!pronumber.isEmpty()
                ||!proname.isEmpty()||!proaddress.isEmpty()) {
            return true;
        }
        return false;
    }
    
    private ArrayList<String> getAllUserAccountsByGroup(UserGroup group) {
        int usergroup = 0;
        switch(group) {
        case USER:
            usergroup = 0;
            break;
        case ADMIN:
            usergroup = 1;
            break;
        case SUPERADMIN:
            usergroup = 2;
        default:
            break;
        }
        Connection conn = getConnection();
        Statement st;
        ResultSet rs;
        ArrayList<String> username = new ArrayList<String>();
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
    public ArrayList<String> getAllADMINAccounts() {
        return getAllUserAccountsByGroup(UserGroup.ADMIN);
    }

    @Override
    public ArrayList<String> getAllDistricts() {
        ArrayList<String> districtsList = new ArrayList<String>();
        Connection conn = getConnection();
        Statement st;
        ResultSet rs;
        String sql = "SELECT name FROM scn.district";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                districtsList.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return districtsList;
    }
}
