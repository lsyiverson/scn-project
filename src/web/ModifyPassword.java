package web;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import bean.User;

import com.opensymphony.xwork2.ActionSupport;

import database.DBHelper;
import database.DBTest;
public class ModifyPassword extends ActionSupport {

    /**
     * 用户名
     */
    private String username;

    /**
     * 新设置的密码
     */
    private String password;
    
    /**
     * 原密码
     */
    private String oldpassword;

    @Override
    public String execute() throws Exception {
        if(isInvalid(username) || isInvalid(password)) {
            return ERROR;
        }
        HttpSession session = ServletActionContext.getRequest().getSession();
        User current_user = (User)session.getAttribute("user");
        String usernamInSession = current_user.getUsername();
        String oldEncryptedPassword = current_user.getPassword();
        
        // 校验提交的用户名与会话中用户名是否一致
        if (!username.equals(usernamInSession)) {
            return ERROR;
        }
        
        if (!getOldpassword().equals(oldEncryptedPassword) || !isOldpasswordCorrect(username, getOldpassword())) {
            return ERROR;
        }
        
        if (DBTest.getInstance().updateUserPassword(username, password)) {
            session.removeAttribute("user");
            return SUCCESS;
        }
        return ERROR;
    }
    
    private boolean isOldpasswordCorrect(String username, String oldPassword ) {
        String encryptedPsw = DBHelper.getInstance().getEncryptedPasswordByUsername(username);
        return encryptedPsw.equals(oldPassword);
    }
    
    private boolean isInvalid(String value) {
        return (value == null || value.length() == 0);
    }
    
    private boolean isPasswordMatchesUsername(String username, String password) {
        String encryptedPsw = DBHelper.getInstance().getEncryptedPasswordByUsername(username);
        return encryptedPsw.equals(password);
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

    public String getOldpassword() {
        return oldpassword;
    }

    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
    }
    
}
