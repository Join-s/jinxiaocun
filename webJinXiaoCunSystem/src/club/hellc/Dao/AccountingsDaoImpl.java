package club.hellc.Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import club.hellc.pojo.Accountings;
import club.hellc.pojo.Autoclass;

public class AccountingsDaoImpl {
	JdbcUtils ju = new JdbcUtils();

	public int add(Accountings acc) {
		try {
			String sql = "INSERT INTO Accountings(AccountingsID,productid,number,price,createdate) VALUES(default,?,?,?,NOW())";
			Object[] objs = { acc.getProductid(), acc.getNumber(), acc.getPrice() };
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
			String sql = "DELETE FROM  Accountings WHERE  AccountingsID=?";
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

	public int updateById(Accountings acc) {
		try {
			String sql = "UPDATE Accountings SET  productid=?,number=?,price=? WHERE AccountingsID=?";
			Object[] objs = { acc.getProductid(), acc.getNumber(), acc.getPrice(), acc.getAccountingsid() };
			int result = ju.executeSQL(sql, objs);
			if (result > 0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public Accountings findById(Integer id) {
		Accountings acc = new Accountings();
		ResultSet rs = null;
		try {
			String sql = "select * from Accountings where AccountingsID=? order by createdate desc";
			Object[] objs = { id };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				acc.setAccountingsid(rs.getInt("Accountingsid"));
				acc.setPrice(rs.getInt("Price"));
				acc.setNumber(rs.getInt("Number"));
				acc.setProductid(rs.getInt("Productid"));
				acc.setCreatedate(rs.getDate("createdate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return acc;

	}

	public List<Accountings> findAll() {
		List<Accountings> acksList = new ArrayList<Accountings>();
		ResultSet rs = null;
		try {
			String sql = "select * from Accountings order by createdate desc";

			rs = ju.getResultSetBySql(sql, null);
			while (rs.next()) {
				Accountings acc = new Accountings();
				acc.setAccountingsid(rs.getInt("Accountingsid"));
				acc.setPrice(rs.getInt("Price"));
				acc.setNumber(rs.getInt("Number"));
				acc.setProductid(rs.getInt("Productid"));
				acc.setCreatedate(rs.getDate("createdate"));
				acksList.add(acc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return acksList;
	}

	public List<Accountings> findAllByTime(String time) {
		List<Accountings> acksList = new ArrayList<Accountings>();
		ResultSet rs = null;
		try {
			String sql = "select * from Accountings where createdate like concat('%',?,'%')";
			Object[] objs = { time };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				Accountings acc = new Accountings();
				acc.setAccountingsid(rs.getInt("Accountingsid"));
				acc.setPrice(rs.getInt("Price"));
				acc.setNumber(rs.getInt("Number"));
				acc.setProductid(rs.getInt("Productid"));
				acc.setCreatedate(rs.getDate("createdate"));
				acksList.add(acc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return acksList;
	}

	public List<Autoclass> findAllByTimeAuto(String time) {
		List<Autoclass> acksList = new ArrayList<Autoclass>();
		ResultSet rs = null;
		try {
			String sql = "SELECT SUM(IF(price*number>0,price*number,0)) AS shou,SUM(IF(price*number<0,price*number,0)) AS zhi,SUM(price*number) AS zong,createDate AS autotime FROM Accountings GROUP BY createDate  HAVING createdate LIKE CONCAT('%',?,'%')";
			Object[] objs = { time.trim() };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				Autoclass acc = new Autoclass();
				acc.setDate(rs.getDate("autotime"));
				acc.setShou(rs.getInt("shou"));
				acc.setZhi(rs.getInt("zhi"));
				acc.setZong(rs.getInt("zong"));
				acksList.add(acc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return acksList;
	}

	/**
	 * 返回当前页列表
	 * 
	 * @param curPage
	 *            当前页
	 * @param row
	 *            行数
	 * @return
	 * @author Hellc
	 * @date 2018年8月16日下午2:07:20
	 */
	public List<Accountings> findAll(Integer curPage, Integer row) {
		List<Accountings> acksList = new ArrayList<Accountings>();
		ResultSet rs = null;
		if (curPage <= 0)
			curPage = 1;
		if (row <= 0)
			row = 1;
		try {
			String sql = "select * from Accountings order by createdate desc  limit ?,?";
			Object[] objs = { (curPage - 1) * row, row };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				Accountings acc = new Accountings();
				acc.setAccountingsid(rs.getInt("Accountingsid"));
				acc.setPrice(rs.getInt("Price"));
				acc.setNumber(rs.getInt("Number"));
				acc.setProductid(rs.getInt("Productid"));
				acc.setCreatedate(rs.getDate("createdate"));
				acksList.add(acc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return acksList;
	}

	/**
	 * 总页数
	 * 
	 * @param row
	 *            行数
	 * @return
	 * @author Hellc
	 * @date 2018年8月16日下午2:12:38
	 */
	public int getCountsOfRow(Integer row) {
		ResultSet rs = null;
		if (row <= 0)
			row = 1;
		try {
			String sql = "select ceil(count(*) / ? ) as csum from Accountings";
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
