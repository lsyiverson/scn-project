package web;

import com.opensymphony.xwork2.ActionSupport;

import database.DBHelper;

public class CreateUser extends ActionSupport {

    private String username;
    
    @Override
    public String execute() throws Exception {
        if (isInvalid(username)) {
            return INPUT;
        }
        if(DBHelper.getInstance().isAlreadyHaveTheUser(username)){
            return INPUT;
        }
        DBHelper.getInstance().createUser(username);
        return SUCCESS;
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
}
