package club.hellc.Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import club.hellc.pojo.Uusers;

public class UusersDaoImpl {
	JdbcUtils ju = new JdbcUtils();

	public int add(Uusers u) {
		try {
			String sql = "INSERT INTO uusers(uusersID,NAME,psw,TYPE,createDate) VALUES(DEFAULT,?,?,?,NOW()) ";
			Object[] objs = { u.getName(), u.getPsw(), u.getType() };
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
			String sql = "delete from  Uusers where  uusersID=?";
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

	public int updateById(Uusers u) {
		try {
			String sql = "UPDATE uusers SET NAME=?,psw=?,TYPE=? WHERE uusersID=?";
			Object[] objs = { u.getName(), u.getPsw(), u.getType(), u.getUusersid() };
			int result = ju.executeSQL(sql, objs);
			if (result > 0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int updateBynameAndPwd(String name, String pwd) {
		try {
			String sql = "UPDATE uusers SET psw=? WHERE name=?";
			Object[] objs = { pwd, name };
			int result = ju.executeSQL(sql, objs);
			if (result > 0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public Uusers findById(Integer id) {
		Uusers u = new Uusers();
		ResultSet rs = null;
		try {
			String sql = "select * from Uusers where uusersID=?";
			Object[] objs = { id };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				u.setCreatedate(rs.getDate("Createdate"));
				u.setName(rs.getString("Name"));
				u.setPsw(rs.getString("Psw"));
				u.setType(rs.getString("Type"));
				u.setUusersid(rs.getInt("Uusersid"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return u;

	}

	public List<Uusers> findAll() {
		List<Uusers> list = new ArrayList<Uusers>();
		ResultSet rs = null;
		try {
			String sql = "select * from Uusers ";

			rs = ju.getResultSetBySql(sql, null);
			while (rs.next()) {
				Uusers u = new Uusers();
				u.setCreatedate(rs.getDate("Createdate"));
				u.setName(rs.getString("Name"));
				u.setPsw(rs.getString("Psw"));
				u.setType(rs.getString("Type"));
				u.setUusersid(rs.getInt("Uusersid"));
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return list;

	}

	public List<Uusers> findAll(String utype, Integer curPage, Integer row) {
		List<Uusers> list = new ArrayList<Uusers>();
		ResultSet rs = null;
		if (curPage <= 0)
			curPage = 1;
		if (row <= 0)
			row = 1;
		try {
			String sql = "select * from Uusers where TYPE=? limit ?,?";
			Object[] objs = { utype, (curPage - 1) * row, row };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				Uusers u = new Uusers();
				u.setCreatedate(rs.getDate("Createdate"));
				u.setName(rs.getString("Name"));
				u.setPsw(rs.getString("Psw"));
				u.setType(rs.getString("Type"));
				u.setUusersid(rs.getInt("Uusersid"));
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return list;
	}

	public int getCountsOfRow(String utype, Integer row) {
		ResultSet rs = null;
		if (row <= 0)
			row = 1;
		try {
			String sql = "select ceil(count(*) / ? ) as csum from Uusers where TYPE=? ";
			Object[] objs = { row, utype };
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

	public int login(String uname, String upwd) {
		ResultSet rs = null;
		try {
			String sql = "select * from Uusers where name=? and psw=?";
			Object[] objs = { uname, upwd };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return -1;
	}
}
