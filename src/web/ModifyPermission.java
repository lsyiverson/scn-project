package web;

import bean.User.UserGroup;

import com.opensymphony.xwork2.ActionSupport;

import database.DBHelper;

public class ModifyPermission extends ActionSupport {
    private static final String ADMINSUCCESS = "adminsuccess";

    /**
     * 修改权限的用户名
     */
    private String username;
    
    /**
     * 修改权限的的用户分组
     */
    private int group;
    
    /**
     * 用户区域访问权限
     */
    private String[] area;
    
    public String execute() throws Exception {
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
        
        //首先删除用户的所有访问权限
        DBHelper.getInstance().removeAllUserDistrict(username);
        //重新添加用户权限
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
