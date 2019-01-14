package club.hellc.Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import club.hellc.pojo.Dept;

public class DeptDaoImpl {

	JdbcUtils ju = new JdbcUtils();

	public int add(Dept d) {
		try {
			String sql = "INSERT INTO dept(deptID,NAME,Remark)  VALUES(DEFAULT,?,?)";
			Object[] objs = { d.getName(), d.getRemark() };
			int result = ju.executeSQL(sql, objs);
			if (result > 0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;

	}

	public int deleteById(Integer id) {
		try {
			String sql = "delete from  Dept where  deptID=?";
			Object[] objs = { id };
			int result = ju.executeSQL(sql, objs);
			if (result > 0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;

	}

	public int updateById(Dept d) {
		try {
			String sql = "update dept set NAME=?,Remark=? where deptID=?";
			Object[] objs = { d.getName(), d.getRemark(), d.getDeptid() };
			int result = ju.executeSQL(sql, objs);
			if (result > 0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public Dept findById(Integer id) {
		Dept d = new Dept();
		ResultSet rs = null;
		try {
			String sql = "select * from Dept where deptID=?";
			Object[] objs = { id };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				d.setDeptid(rs.getInt("Deptid"));
				d.setName(rs.getString("Name"));
				d.setRemark(rs.getString("Remark"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return d;
	}

	public Dept findByName(String name) {
		Dept d = new Dept();
		ResultSet rs = null;
		try {
			String sql = "select * from Dept where name=?";
			Object[] objs = { name };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				d.setDeptid(rs.getInt("Deptid"));
				d.setName(rs.getString("Name"));
				d.setRemark(rs.getString("Remark"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return d;
	}

	public List<Dept> findAll() {
		List<Dept> proList = new ArrayList<Dept>();
		ResultSet rs = null;
		try {
			String sql = "select * from Dept ";

			rs = ju.getResultSetBySql(sql, null);
			while (rs.next()) {
				Dept d = new Dept();
				d.setDeptid(rs.getInt("Deptid"));
				d.setName(rs.getString("Name"));
				d.setRemark(rs.getString("Remark"));
				proList.add(d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return proList;

	}
}
