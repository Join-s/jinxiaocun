package club.hellc.pojo;

import java.util.Date;

public class Accountings {
	private Integer accountingsid;
	private Integer productid;
	private Integer number;
	private Integer price;
	private Date createdate;

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Integer getAccountingsid() {
		return accountingsid;
	}

	public void setAccountingsid(Integer accountingsid) {
		this.accountingsid = accountingsid;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
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
}
