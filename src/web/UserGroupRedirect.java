package web;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import bean.User;

import com.opensymphony.xwork2.ActionSupport;

public class UserGroupRedirect extends ActionSupport {
    /**
     * Action结果 user
     */
    private static final String RESULT_USER = "user";

    /**
     * Action结果 superadmin
     */
    private static final String RESULT_SUPERADMIN = "superadmin";

    @Override
    public String execute() throws Exception {
        HttpSession session = ServletActionContext.getRequest().getSession();
        User user = (User) session.getAttribute("user");
        switch (user.getGroup()) {
        case USER:
        case ADMIN:
            System.out.println("user and admin");
            return RESULT_USER;
        case SUPERADMIN:
            System.out.println("superadmin");
            return RESULT_SUPERADMIN;
        default:
            return ERROR;
        }
    }

}
