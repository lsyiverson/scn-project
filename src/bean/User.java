package bean;

import java.util.ArrayList;

public class User {
    
    /**
     * 用户名
     */
    private String username;
    
    /**
     * Hash后的密码密文
     */
    private String password;
    
    /**
     * 用户分组
     */
    private UserGroup group;
    
    /**
     * 用户权限列表
     */
    private ArrayList<String> permission;

    public User(String username, String encryptedPsw, UserGroup gourp) {
        this.username = username;
        this.password = encryptedPsw;
        this.group = gourp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserGroup getGroup() {
        return group;
    }

    public void setGroup(UserGroup group) {
        this.group = group;
    }

    public ArrayList<String> getPermission() {
        return permission;
    }

    public void setPermission(ArrayList<String> permission) {
        this.permission = permission;
    }

    /**
     * 用户分组枚举定义
     * @author IVERSON
     *
     */
    public static enum UserGroup {
        /**
         * 普通用户
         * <p>可以查询工程列表
         */
        USER,
        /**
         * 管理员用户
         * <p>可以上传工程项目表格，查询工程列表，管理用户账号
         */
        ADMIN,
        /**
         * 超级管理员用户
         * <p>可以管理管理员帐号
         */
        SUPERADMIN
    };
    
    public static String groupToString(UserGroup group) {
        switch(group) {
        case USER:
            return "user";
        case ADMIN:
            return "admin";
        case SUPERADMIN:
            return "superadmin";
        }
        return null;
    }
}
