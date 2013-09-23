package web;

import com.opensymphony.xwork2.ActionSupport;

import database.DBTest;

public class CreateUser extends ActionSupport {

    private String username;
    
    @Override
    public String execute() throws Exception {
        if (isInvalid(username)) {
            return INPUT;
        }
        if(DBTest.getInstance().isAlreadyHaveTheUser(username)){
            return INPUT;
        }
        DBTest.getInstance().createUser(username);
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
