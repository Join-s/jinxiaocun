package club.hellc.pojo;

public class Sale {
    private String saleid;

    private Integer number;

    private Integer price;

    private String remark;

    public String getSaleid() {
        return saleid;
    }

    public void setSaleid(String saleid) {
        this.saleid = saleid == null ? null : saleid.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}