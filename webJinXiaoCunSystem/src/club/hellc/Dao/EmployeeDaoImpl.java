package club.hellc.Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import club.hellc.pojo.Employee;

public class EmployeeDaoImpl {
	JdbcUtils ju = new JdbcUtils();

	public int add(Employee ee) {
		try {
			String sql = "INSERT INTO employee(EmployeeID,deptID,name,duty,sex,borthDate,hireDate,maturDate,IDard,address,phone,Email) VALUES(DEFAULT,?,?,?,?,?,?,?,?,?,?,?)";
			Object[] objs = { ee.getDeptid(), ee.getName(), ee.getDuty(), ee.getSex(), ee.getBorthdate(),
					ee.getHiredate(), ee.getMaturdate(), ee.getIdard(), ee.getAddress(), ee.getPhone(), ee.getEmail() };
			int reslut = ju.executeSQL(sql, objs);
			if (reslut > 0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;

	}

	public int deleteById(Integer id) {
		try {
			String sql = "delete from  Employee where  EmployeeID=?";
			Object[] objs = { id };
			int reslut = ju.executeSQL(sql, objs);
			if (reslut > 0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;

	}

	public int updateById(Employee ee) {
		try {
			String sql = "update Employee set deptID=?,name=?,duty=?,sex=?,borthDate=?,hireDate=?,maturDate=?,IDard=?,address=?,phone=?,Email=? where EmployeeID=?";
			Object[] objs = { ee.getDeptid(), ee.getName(), ee.getDuty(), ee.getSex(), ee.getBorthdate(),
					ee.getHiredate(), ee.getMaturdate(), ee.getIdard(), ee.getAddress(), ee.getPhone(), ee.getEmail(),
					ee.getEmployeeid() };
			int reslut = ju.executeSQL(sql, objs);
			if (reslut > 0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public Employee findById(Integer id) {
		Employee ee = new Employee();
		ResultSet rs = null;
		try {
			String sql = "select * from Employee where EmployeeID=?";
			Object[] objs = { id };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				ee.setAddress(rs.getString("Address"));
				ee.setBorthdate(rs.getDate("Borthdate"));
				ee.setDeptid(rs.getInt("Deptid"));
				ee.setDuty(rs.getString("Duty"));
				ee.setEmail(rs.getString("Email"));
				ee.setEmployeeid(rs.getInt("Employeeid"));
				ee.setHiredate(rs.getDate("Hiredate"));
				ee.setIdard(rs.getString("Idard"));
				ee.setMaturdate(rs.getDate("Maturdate"));
				ee.setName(rs.getString("Name"));
				ee.setPhone(rs.getString("Phone"));
				ee.setSex(rs.getString("Sex"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return ee;

	}

	public List<Employee> findAll() {
		List<Employee> eeList = new ArrayList<Employee>();
		ResultSet rs = null;
		try {
			String sql = "select * from Employee";
			rs = ju.getResultSetBySql(sql, null);
			while (rs.next()) {
				Employee ee = new Employee();
				ee.setAddress(rs.getString("Address"));
				ee.setBorthdate(rs.getDate("Borthdate"));
				ee.setDeptid(rs.getInt("Deptid"));
				ee.setDuty(rs.getString("Duty"));
				ee.setEmail(rs.getString("Email"));
				ee.setEmployeeid(rs.getInt("Employeeid"));
				ee.setHiredate(rs.getDate("Hiredate"));
				ee.setIdard(rs.getString("Idard"));
				ee.setMaturdate(rs.getDate("Maturdate"));
				ee.setName(rs.getString("Name"));
				ee.setPhone(rs.getString("Phone"));
				ee.setSex(rs.getString("Sex"));
				eeList.add(ee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return eeList;
	}

	public List<Employee> findAll(Integer currPage, Integer row) {
		List<Employee> eeList = new ArrayList<Employee>();
		ResultSet rs = null;

		if (currPage <= 1)
			currPage = 1;
		if (row <= 1)
			row = 1;

		try {
			String sql = "select * from Employee order by deptid limit ?,?";

			Object[] objs = { (currPage - 1) * row, row };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				Employee ee = new Employee();
				ee.setAddress(rs.getString("Address"));
				ee.setBorthdate(rs.getDate("Borthdate"));
				ee.setDeptid(rs.getInt("Deptid"));
				ee.setDuty(rs.getString("Duty"));
				ee.setEmail(rs.getString("Email"));
				ee.setEmployeeid(rs.getInt("Employeeid"));
				ee.setHiredate(rs.getDate("Hiredate"));
				ee.setIdard(rs.getString("Idard"));
				ee.setMaturdate(rs.getDate("Maturdate"));
				ee.setName(rs.getString("Name"));
				ee.setPhone(rs.getString("Phone"));
				ee.setSex(rs.getString("Sex"));
				eeList.add(ee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return eeList;
	}

	public int getCountsOfRow(Integer row) {
		ResultSet rs = null;
		if (row <= 0)
			row = 1;
		try {
			String sql = "select ceil(count(*) / ? ) as csum from Employee  order by deptid ";
			Object[] objs = { row };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				return rs.getInt("csum");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return -1;
	}
}
