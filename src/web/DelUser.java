package web;

import com.opensymphony.xwork2.ActionSupport;

import database.DBTest;

public class DelUser extends ActionSupport {
    
    /**
     * 需要删除的用户名
     */
    private String username;
    
    @Override
    public String execute() throws Exception {
        System.out.println("del=====" + username);
        DBTest.getInstance().delUserByUsername(username);
        return super.execute();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
