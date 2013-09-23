package database;

import java.util.ArrayList;
import java.util.List;

import utils.Utils;
import bean.ProjectInfo;
import bean.User;
import bean.User.UserGroup;

public interface DBInterface {
    /**
     * 通过用户名查找对应的加密后的密码字符串
     * @param username 用户名
     * @return 加密后的密码字符串
     */
    public String getEncryptedPasswordByUsername(String username);
    
    /**
     * 通过用户名得到对应的用户对象
     * @param username 用户名
     * @return 用户
     */
    public User getUserByUsername(String username);
    
    /**
     * 修改用户密码
     * @param username 用户名
     * @param newEncryptedPassword 新密码密文字符串
     */
    public boolean updateUserPassword(String username, String newEncryptedPassword);
    
    /**
     * 得到所有的用户分组为USER级别的用户账号
     * @return 用户列表
     */
    public ArrayList<String> getAllUSERAccounts();
    
    /**
     * 通过用户名删除用户
     * @param username
     * @return
     */
    public boolean delUserByUsername(String username);
    
    /**
     * 判断用户是否已经存在
     * @param username
     * @return
     */
    public boolean isAlreadyHaveTheUser(String username);
    
    /**
     * 根据指定用户名创建用户
     * @param username
     */
    public void createUser(String username);
    
    /**
     * 将读出的数据列表插入数据库
     * @param excelData excel数据List
     * @return boolean 插入是否成功
     */
    public boolean insertExcelData(List<ProjectInfo> excelData);
}
