package database;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

import utils.Utils;
import bean.User;
import bean.User.UserGroup;

/**
 * 此类中的方法需要重新实现
 */
public class DBHelper {
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

    /**
     * 通过用户名查找对应的加密后的密码字符串
     * @param username 用户名
     * @return 加密后的密码字符串
     */
    public String getEncryptedPasswordByUsername(String username) {
        //TODO: 实现此方法
        // SELECT password FROM DB WHERE username==username;
        return getUserByUsername(username).getPassword();
    }
    
    /**
     * 通过用户名得到对应的用户对象
     * @param username 用户名
     * @return 用户
     */
    public User getUserByUsername(String username) {
        //TODO: 实现此方法
        return (User)usertable.get(username);
    }
    
    /**
     * 修改用户密码
     * @param username 用户名
     * @param newEncryptedPassword 新密码密文字符串
     */
    public boolean updateUserPassword(String username, String newEncryptedPassword) {
        //TODO: 实现此方法
        usertable.get(username).setPassword(newEncryptedPassword);
        return true;
    }
    
    /**
     * 得到所有的用户分组为USER级别的用户账号
     * @return 用户列表
     */
    public ArrayList<User> getAllUSERAccounts() {
        //TODO: 实现此方法
        ArrayList<User> allUserList = new ArrayList<User>();
        User[] allUsers = usertable.values().toArray(new User[0]);
        for(User user : allUsers) {
            if (user.getGroup() == UserGroup.USER) {
                allUserList.add(user);
            }
        }
        return allUserList;
    }
    
    public boolean delUserByUsername(String username) {
        //TODO: 实现此方法
        usertable.remove(username);
        return true;
    }
    
    public boolean isAlreadyHaveTheUser(String username) {
        //TODO: 实现此方法
        return usertable.containsKey(username);
    }
    
    public void createUser(String username) {
        //TODO: 实现此方法
        User user = new User(username, Utils.hex_md5(username+"123456"), UserGroup.USER);
        usertable.put(username, user);
    }
}
