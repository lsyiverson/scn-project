package web;

import java.util.ArrayList;

import javax.print.attribute.standard.Severity;

import org.apache.struts2.ServletActionContext;

import bean.User;

import com.opensymphony.xwork2.ActionSupport;

import database.DBHelper;

public class GetAllUsers extends ActionSupport {
    /**
     * 所有用户列表
     */
    private ArrayList<User> alluserlist;
    
    @Override
    public String execute() throws Exception {
        alluserlist = DBHelper.getInstance().getAllUSERAccounts();
        ServletActionContext.getRequest().setAttribute("alluserlist", alluserlist);
        return SUCCESS;
    }

    public ArrayList<User> getUserlist() {
        return alluserlist;
    }

    public void setUserlist(ArrayList<User> userlist) {
        this.alluserlist = userlist;
    }
    
    
}
