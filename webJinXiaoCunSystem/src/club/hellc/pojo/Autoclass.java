package club.hellc.pojo;

import java.util.Date;

public class Autoclass {
	private Date date;
	private Integer zhi;
	private Integer shou;
	private Integer zong;

	public Integer getZong() {
		return zong;
	}

	public void setZong(Integer zong) {
		this.zong = zong;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getZhi() {
		return zhi;
	}

	public void setZhi(Integer zhi) {
		this.zhi = zhi;
	}

	public Integer getShou() {
		return shou;
	}

	public void setShou(Integer shou) {
		this.shou = shou;
	}

	@Override
	public String toString() {
		return "Autoclass [date=" + date + ", zhi=" + zhi + ", shou=" + shou + ", zong=" + zong + "]";
	}
}
