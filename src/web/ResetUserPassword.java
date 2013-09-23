package web;

import utils.Utils;

import com.opensymphony.xwork2.ActionSupport;

import database.DBTest;

public class ResetUserPassword extends ActionSupport {
    /**
     * 需要重置密码的用户名
     */
    private String username;
    
    @Override
    public String execute() throws Exception {
        String resetPassword = Utils.hex_md5(username+"123456");
        DBTest.getInstance().updateUserPassword(username, resetPassword);
        return SUCCESS;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
