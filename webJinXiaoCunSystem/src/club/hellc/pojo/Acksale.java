package club.hellc.pojo;

public class Acksale {
	private Integer acksaleid;

	private String remark;

	private Integer number;

	private Integer price;

	public Integer getAcksaleid() {
		return acksaleid;
	}

	public void setAcksaleid(Integer acksaleid) {
		this.acksaleid = acksaleid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
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