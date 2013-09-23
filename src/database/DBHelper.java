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
}
