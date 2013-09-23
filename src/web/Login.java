package web;

import java.security.MessageDigest;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;

import bean.User;

import com.opensymphony.xwork2.ActionSupport;

import database.DBTest;

public class Login extends ActionSupport {

    private String username;

    private String password;
    
    @Override
    public String execute() throws Exception {
        System.out.println("username = " + getUsername() + " password = " + getPassword());
        
        if (isInvalid(getUsername())) {
            return INPUT;
        }
        if (isInvalid(getPassword())) {
            return INPUT;
        }
        
        if (isPasswordMatchesUsername(username, password)) {
            User loginUser = DBTest.getInstance().getUserByUsername(username);
            HttpSession session = ServletActionContext.getRequest().getSession();
            session.setAttribute("user", loginUser);
            return SUCCESS;
        } else {
            return ERROR;
        }
    }
    
    private boolean isInvalid(String value) {
        return (value == null || value.length() == 0);
    }
    
    private boolean isPasswordMatchesUsername(String username, String password) {
        String encryptedPsw = DBTest.getInstance().getEncryptedPasswordByUsername(username);
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

}
