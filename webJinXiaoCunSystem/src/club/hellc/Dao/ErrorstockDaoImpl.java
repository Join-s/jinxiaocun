package club.hellc.Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import club.hellc.pojo.Errorstock;

public class ErrorstockDaoImpl {
	JdbcUtils ju = new JdbcUtils();

	public int add(Errorstock e) {
		try {
			String sql = "INSERT INTO enterstock(EmployeeID,StoreHouseID,ProductID,EnterStockDate,EnterStockID,number,price,ispub) VALUES(?,?,?,?,DEFAULT,?,?,?)";
			Object[] objs = { e.getEmployeeid(), e.getStorehouseid(), e.getProductid(), e.getErrorstockdate(),
					e.getNumber(), e.getPrice(), e.getIspub() };
			int result = ju.executeSQL(sql, objs);
			if (result > 0) {
				return 1;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;

	}

	public int deleteById(Integer id) {
		try {
			String sql = "delete from  Errorstock where  EnterStockID=?";
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

	public int updateById(Errorstock e) {
		try {
			String sql = "UPDATE enterstock SET EmployeeID=?,StoreHouseID=?,ProductID=?,number=?,price=?,ispub=? WHERE EnterStockID=?";
			Object[] objs = { e.getEmployeeid(), e.getStorehouseid(), e.getProductid(), e.getErrorstockdate(),
					e.getNumber(), e.getPrice(), e.getIspub(), e.getErrorstockid() };
			int result = ju.executeSQL(sql, objs);
			if (result > 0) {
				return 1;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	public Errorstock findById(Integer id) {
		Errorstock e = new Errorstock();
		ResultSet rs = null;
		try {
			String sql = "select * from Errorstock where EnterStockID=?";
			Object[] objs = { id };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				e.setEmployeeid(rs.getInt("Employeeid"));
				e.setErrorstockdate(rs.getDate("Errorstockdate"));
				e.setErrorstockid(rs.getInt("Errorstockid"));
				e.setIspub(rs.getString("Ispub"));
				e.setNumber(rs.getInt("Number"));
				e.setPrice(rs.getInt("Price"));
				e.setProductid(rs.getInt("Productid"));
				e.setStorehouseid(rs.getInt("Storehouseid"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return e;

	}

	public List<Errorstock> findAll() {
		List<Errorstock> list = new ArrayList<Errorstock>();
		ResultSet rs = null;
		try {
			String sql = "select * from Errorstock";

			rs = ju.getResultSetBySql(sql, null);
			while (rs.next()) {
				Errorstock e = new Errorstock();
				e.setEmployeeid(rs.getInt("Employeeid"));
				e.setErrorstockdate(rs.getDate("Errorstockdate"));
				e.setErrorstockid(rs.getInt("Errorstockid"));
				e.setIspub(rs.getString("Ispub"));
				e.setNumber(rs.getInt("Number"));
				e.setPrice(rs.getInt("Price"));
				e.setProductid(rs.getInt("Productid"));
				e.setStorehouseid(rs.getInt("Storehouseid"));
				list.add(e);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return list;

	}

	public List<Errorstock> findAll(Integer protypeid, Integer curPage, Integer row) {
		List<Errorstock> list = new ArrayList<Errorstock>();
		ResultSet rs = null;
		if (curPage <= 0)
			curPage = 1;
		if (row <= 0)
			row = 1;
		try {
			String sql = "select * from Errorstock where producttypeid=? limit ?,?";
			Object[] objs = { protypeid, (curPage - 1) * row, row };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				Errorstock e = new Errorstock();
				e.setEmployeeid(rs.getInt("Employeeid"));
				e.setErrorstockdate(rs.getDate("Errorstockdate"));
				e.setErrorstockid(rs.getInt("Errorstockid"));
				e.setIspub(rs.getString("Ispub"));
				e.setNumber(rs.getInt("Number"));
				e.setPrice(rs.getInt("Price"));
				e.setProductid(rs.getInt("Productid"));
				e.setStorehouseid(rs.getInt("Storehouseid"));
				list.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return list;
	}

	public int getCountsOfRow(Integer protypeid, Integer row) {
		ResultSet rs = null;
		if (row <= 0)
			row = 1;
		try {
			String sql = "select ceil(count(*) / ? ) as csum from Errorstock where producttypeid=?";
			Object[] objs = { row, protypeid };
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
