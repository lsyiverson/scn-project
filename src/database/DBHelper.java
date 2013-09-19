package database;

import java.util.Hashtable;

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
        User admin = new User("admin", Utils.hex_md5("admin" + "admin"), UserGroup.ADMIN);
        User superadmin = new User("superadmin", Utils.hex_md5("superadmin" + "superadmin"), UserGroup.SUPERADMIN);
        usertable.put(user.getUsername(), user);
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
}
