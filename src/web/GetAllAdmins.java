package web;

import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import database.DBHelper;

public class GetAllAdmins extends ActionSupport {
    /**
     * 所有用户列表
     */
    private ArrayList<String> alladminlist;
    
    @Override
    public String execute() throws Exception {
        alladminlist = DBHelper.getInstance().getAllADMINAccounts();
        ServletActionContext.getRequest().setAttribute("alladminlist", alladminlist);
        return SUCCESS;
    }

    public ArrayList<String> getAdminlist() {
        return alladminlist;
    }

    public void setAdminlist(ArrayList<String> adminlist) {
        this.alladminlist = adminlist;
    }
}
