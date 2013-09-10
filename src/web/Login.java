package web;

import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport {

    private String username;

    private String password;
    /* ----start----
     * 临时用户名密码
     */
    private static final String u1 = "admin";
    private static final String p1 = "psw";

    /* ----end---- */
    @Override
    public String execute() throws Exception {
        System.out.println("lisy============username" + getUsername() + "=====");
        System.out.println("lisy============password" + getPassword() + "=====");
        if (isInvalid(getUsername())) {
            return INPUT;
        }
        if (isInvalid(getPassword())) {
            return INPUT;
        }
        
        if (getUsername().equals(u1) && getPassword().equals(p1)) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }
    
    private boolean isInvalid(String value) {
        return (value == null || value.length() == 0);
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
