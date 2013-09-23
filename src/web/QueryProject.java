package web;

import com.opensymphony.xwork2.ActionSupport;

public class QueryProject extends ActionSupport {
    /**
     * 项目来源
     */
    private String[] itemsource;
    
    /**
     * 来单时间
     */
    private String itemdate;
    
    /**
     * 来单名称
     */
    private String itemname;
    
    /**
     * 项目编号
     */
    private String pronumber;
    
    /**
     * 项目名称
     */
    private String proname;
    
    /**
     * 项目性质
     */
    private String[] proproperty;
    
    /**
     * 项目类别
     */
    private String[] protype;
    
    @Override
    public String execute() throws Exception {
        for(String str : itemsource) {
            System.out.println("---" + str);
        }
        System.out.println(itemdate);
        if (itemdate.isEmpty()) {
            return ERROR;
        }
        System.out.println(itemname);
        System.out.println(pronumber);
        System.out.println(proname);
        for(String str : proproperty) {
            System.out.println("---" + str);
        }
        for(String str : protype) {
            System.out.println("---" + str);
        }
        System.out.println(proaddress);
        return SUCCESS;
    }

    public String[] getItemsource() {
        return itemsource;
    }

    public void setItemsource(String[] itemsource) {
        this.itemsource = itemsource;
    }

    public String getItemdate() {
        return itemdate;
    }

    public void setItemdate(String itemdate) {
        this.itemdate = itemdate;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getPronumber() {
        return pronumber;
    }

    public void setPronumber(String pronumber) {
        this.pronumber = pronumber;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public String[] getProproperty() {
        return proproperty;
    }

    public void setProproperty(String[] proproperty) {
        this.proproperty = proproperty;
    }

    public String[] getProtype() {
        return protype;
    }

    public void setProtype(String[] protype) {
        this.protype = protype;
    }

    public String getProaddress() {
        return proaddress;
    }

    public void setProaddress(String proaddress) {
        this.proaddress = proaddress;
    }

    /**
     * 项目地址
     */
    private String proaddress;
}
