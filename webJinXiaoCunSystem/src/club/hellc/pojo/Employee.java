package club.hellc.pojo;

import java.util.Date;

public class Employee {
	private Integer employeeid;

	private Integer deptid;

	private String name;

	private String duty;

	private String sex;

	private Date borthdate;

	private Date hiredate;

	private Date maturdate;

	private String idard;

	private String address;

	private String phone;

	private String email;

	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public Integer getDeptid() {
		return deptid;
	}

	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty == null ? null : duty.trim();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	public Date getBorthdate() {
		return borthdate;
	}

	public void setBorthdate(Date borthdate) {
		this.borthdate = borthdate;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Date getMaturdate() {
		return maturdate;
	}

	public void setMaturdate(Date maturdate) {
		this.maturdate = maturdate;
	}

	public String getIdard() {
		return idard;
	}

	public void setIdard(String idard) {
		this.idard = idard == null ? null : idard.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	@Override
	public String toString() {
		return "Employee [employeeid=" + employeeid + ", deptid=" + deptid + ", name=" + name + ", duty=" + duty
				+ ", sex=" + sex + ", borthdate=" + borthdate + ", hiredate=" + hiredate + ", maturdate=" + maturdate
				+ ", idard=" + idard + ", address=" + address + ", phone=" + phone + ", email=" + email + "]";
	}
}