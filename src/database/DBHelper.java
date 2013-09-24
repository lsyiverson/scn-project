package database;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

import utils.Utils;
import bean.ProjectInfo;
import bean.User;
import bean.User.UserGroup;

/**
 * 此类中的方法需要重新实现
 */
public class DBHelper implements DBInterface{
    private static DBHelper mDB;
    //------start------
    //临时数据
    private static Hashtable<String, User> usertable = new Hashtable<String, User>();
    //------end------
    

    public static DBHelper getInstance() {
        if (mDB == null) {
            mDB = new DBHelper();
        }
        return mDB;
    }
    
    private DBHelper() {
        //TODO: 实现此方法
        //生成临时数据
        //------start------
        User user = new User("user", Utils.hex_md5("user" + "user"), UserGroup.USER);
        User user1 = new User("user1", Utils.hex_md5("user1" + "user"), UserGroup.USER);
        User user2 = new User("user2", Utils.hex_md5("user2" + "user"), UserGroup.USER);
        User user3 = new User("user3", Utils.hex_md5("user3" + "user"), UserGroup.USER);
        User user4 = new User("user4", Utils.hex_md5("user4" + "user"), UserGroup.USER);
        User admin = new User("admin", Utils.hex_md5("admin" + "admin"), UserGroup.ADMIN);
        User superadmin = new User("superadmin", Utils.hex_md5("superadmin" + "superadmin"), UserGroup.SUPERADMIN);
        usertable.put(user.getUsername(), user);
        usertable.put(user1.getUsername(), user1);
        usertable.put(user2.getUsername(), user2);
        usertable.put(user3.getUsername(), user3);
        usertable.put(user4.getUsername(), user4);
        usertable.put(admin.getUsername(), admin);
        usertable.put(superadmin.getUsername(), superadmin);
        //------end------
    }

    @Override
    public String getEncryptedPasswordByUsername(String username) {
        //TODO: 实现此方法
        // SELECT password FROM DB WHERE username==username;
        return getUserByUsername(username).getPassword();
    }
    
    @Override
    public User getUserByUsername(String username) {
        //TODO: 实现此方法
        return (User)usertable.get(username);
    }
    
    @Override
    public boolean updateUserPassword(String username, String newEncryptedPassword) {
        //TODO: 实现此方法
        usertable.get(username).setPassword(newEncryptedPassword);
        return true;
    }
    
    @Override
    public ArrayList<String> getAllUSERAccounts() {
        //TODO: 实现此方法
        ArrayList<String> allUserList = new ArrayList<String>();
        User[] allUsers = usertable.values().toArray(new User[0]);
        for(User user : allUsers) {
            if (user.getGroup() == UserGroup.USER) {
                allUserList.add(user.getUsername());
            }
        }
        return allUserList;
    }
    
    @Override
    public boolean delUserByUsername(String username) {
        //TODO: 实现此方法
        usertable.remove(username);
        return true;
    }
    
    @Override
    public boolean isAlreadyHaveTheUser(String username) {
        //TODO: 实现此方法
        return usertable.containsKey(username);
    }
    
    @Override
    public void createUser(String username) {
        //TODO: 实现此方法
        User user = new User(username, Utils.hex_md5(username+"123456"), UserGroup.USER);
        usertable.put(username, user);
    }
    
    @Override
    public boolean insertExcelData(List<ProjectInfo> excelData){
      //TODO: 实现此方法,用于向数据库中插入excel数据
        return true;
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
        return null;
    }

    private String buildQueryStatement(String field, ArrayList<String> list) {
        StringBuilder sb = new StringBuilder();
        if (list.size() == 1) {
            sb.append(" " + field + " LIKE '%" + list.get(0) + "%'");
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    sb.append(" " + field + " IN['%" + list.get(i) + "%'");
                } else if (i == list.size() - 1) {
                    sb.append(",'%" + list.get(i) + "%']");
                } else {
                    sb.append(",'%" + list.get(i) + "%'");
                }
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
}
