package web;

import bean.User.UserGroup;

import com.opensymphony.xwork2.ActionSupport;

import database.DBHelper;

public class CreateUser extends ActionSupport {
    
    private static final String ADMINSUCCESS = "adminsuccess";

    /**
     * 要创建的用户名
     */
    private String username;
    
    /**
     * 要创建的用户分组
     */
    private int group;
    
    /**
     * 用户区域访问权限
     */
    private String[] area;
    
    @Override
    public String execute() throws Exception {
        if (isInvalid(username)) {
            return INPUT;
        }
        if(DBHelper.getInstance().isAlreadyHaveTheUser(username)){
            return INPUT;
        }
        UserGroup usergroup;
        switch (group) {
        case 0: 
            usergroup = UserGroup.USER;
            break;
        case 1:
            usergroup = UserGroup.ADMIN;
            break;
        case 2:
            usergroup = UserGroup.SUPERADMIN;
            break;
        default:
            usergroup = UserGroup.USER;
        }
        DBHelper.getInstance().createUser(username, usergroup);//创建用户对象
        
        //添加用户权限
        for (String district : area) {
            DBHelper.getInstance().addUserDistrict(username, district);
        }

        switch (usergroup) {
        case ADMIN:
            return ADMINSUCCESS;
        default:
            return SUCCESS;
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

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String[] getArea() {
        return area;
    }

    public void setArea(String[] area) {
        this.area = area;
    }
}
