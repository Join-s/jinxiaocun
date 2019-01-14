package club.hellc.pojo;

import java.util.Date;

public class Uusers {
	private Integer uusersid;

	private String name;

	private String psw;

	private String type;

	private Date createdate;

	public Integer getUusersid() {
		return uusersid;
	}

	public void setUusersid(Integer uusersid) {
		this.uusersid = uusersid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw == null ? null : psw.trim();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@Override
	public String toString() {
		return "Uusers [uusersid=" + uusersid + ", name=" + name + ", psw=" + psw + ", type=" + type + ", createdate="
				+ createdate + "]";
	}
}