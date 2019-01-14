package club.hellc.pojo;

import java.util.Date;

public class Enterstock {
    private Integer enterstockid;

    private Integer employeeid;

    private Integer storehouseid;

    private Integer productid;

    private Date enterstockdate;

    private Integer number;

    private Integer price;

    private String ispub;

    public Integer getEnterstockid() {
        return enterstockid;
    }

    public void setEnterstockid(Integer enterstockid) {
        this.enterstockid = enterstockid;
    }

    public Integer getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    public Integer getStorehouseid() {
        return storehouseid;
    }

    public void setStorehouseid(Integer storehouseid) {
        this.storehouseid = storehouseid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Date getEnterstockdate() {
        return enterstockdate;
    }

    public void setEnterstockdate(Date enterstockdate) {
        this.enterstockdate = enterstockdate;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getIspub() {
        return ispub;
    }

    public void setIspub(String ispub) {
        this.ispub = ispub == null ? null : ispub.trim();
    }
}