package club.hellc.pojo;

import java.util.Date;

public class Product {
    private Integer productid;

    private Integer producttypeid;

    private String name;

    private String productspec;

    private String productunit;

    private Integer price;

    private Date createdate;

    private Date updatedate;

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getProducttypeid() {
        return producttypeid;
    }

    public void setProducttypeid(Integer producttypeid) {
        this.producttypeid = producttypeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getProductspec() {
        return productspec;
    }

    public void setProductspec(String productspec) {
        this.productspec = productspec == null ? null : productspec.trim();
    }

    public String getProductunit() {
        return productunit;
    }

    public void setProductunit(String productunit) {
        this.productunit = productunit == null ? null : productunit.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }
}