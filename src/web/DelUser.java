package web;

import bean.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import database.DBHelper;

public class DelUser extends ActionSupport {
    
    private static final String SUPER = "super";
    
    /**
     * 需要删除的用户名
     */
    private String username;
    
    @Override
    public String execute() throws Exception {
        System.out.println("del=====" + username);
        DBHelper.getInstance().delUserByUsername(username);
        ActionContext actionContext = ActionContext.getContext();
        User user = (User)actionContext.getSession().get("user");
        switch (user.getGroup()) {
        case SUPERADMIN:
            return SUPER;
        default:
            return SUCCESS;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
