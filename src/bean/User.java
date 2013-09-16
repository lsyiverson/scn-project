package bean;

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
}
