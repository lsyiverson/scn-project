package web;

import java.security.MessageDigest;

import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport {

    private String username;

    private String password;
    /* ----start----
     * 临时用户名密码
     */
    private static final String u1 = "admin";
    private static final String p1 = "psw";
    
    public final static String MD5(String s) {
        char hexDigits[] = { '0', '1', '2', '3', '4',
                             '5', '6', '7', '8', '9',
                             'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            byte[] btInput = s.getBytes();
     //获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
     //使用指定的字节更新摘要
            mdInst.update(btInput);
     //获得密文
            byte[] md = mdInst.digest();
     //把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* ----end---- */
    @Override
    public String execute() throws Exception {
        System.out.println("username = " + getUsername() + " password = " + getPassword());
        
        System.out.println(MD5(p1));
        if (isInvalid(getUsername())) {
            return INPUT;
        }
        if (isInvalid(getPassword())) {
            return INPUT;
        }
        
        if (getUsername().equals(u1) && getPassword().equals(p1)) {
            return SUCCESS;
        } else {
            return ERROR;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
