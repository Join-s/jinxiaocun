package club.hellc.pojo;

import java.sql.Date;

public class Orders {
	private Integer ordersid;

	private Integer customerid;

	private Integer productid;

	private String saleid;

	private Integer number;
	private String ispub;

	private Integer price;
	private Date createdate;

	public String getIspub() {
		return ispub;
	}

	public void setIspub(String ispub) {
		this.ispub = ispub;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Integer getOrdersid() {
		return ordersid;
	}

	public void setOrdersid(Integer ordersid) {
		this.ordersid = ordersid;
	}

	public Integer getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

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

	@Override
	public String toString() {
		return "Orders [ordersid=" + ordersid + ", customerid=" + customerid + ", productid=" + productid + ", saleid="
				+ saleid + ", number=" + number + ", ispub=" + ispub + ", price=" + price + ", createdate=" + createdate
				+ "]";
	}
}