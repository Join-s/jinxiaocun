package club.hellc.Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import club.hellc.pojo.Acksale;

public class AcksaleDaoImpl {
	JdbcUtils ju = new JdbcUtils();

	/**
	 * 添加退订表单
	 * 
	 * @param acks(主键为订单表主键)
	 * @return
	 * @author Hellc
	 * @date 2018年8月16日下午2:02:49
	 */
	public int add(Acksale acks) {
		try {
			String sql = "INSERT INTO acksale(ackSaleID,Remark,number,price) VALUES(?,?,?,?)";
			Object[] objs = { acks.getAcksaleid(), acks.getRemark(), acks.getNumber(), acks.getPrice() };
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
			String sql = "DELETE FROM  acksale WHERE  ackSaleID=?";
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

	public int updateById(Acksale acks) {
		try {
			String sql = "UPDATE acksale SET Remark=?,number=?,price=? WHERE ackSaleID=?";
			Object[] objs = { acks.getRemark(), acks.getNumber(), acks.getPrice(), acks.getAcksaleid() };
			int result = ju.executeSQL(sql, objs);
			if (result > 0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public Acksale findById(Integer id) {
		Acksale acks = new Acksale();
		ResultSet rs = null;
		try {
			String sql = "select * from Acksale where ackSaleID=?";
			Object[] objs = { id };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				acks.setAcksaleid(rs.getInt("Acksaleid"));
				acks.setNumber(rs.getInt("Number"));
				acks.setPrice(rs.getInt("Price"));
				acks.setRemark(rs.getString("Remark"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return acks;

	}

	public List<Acksale> findAll() {
		List<Acksale> acksList = new ArrayList<Acksale>();
		ResultSet rs = null;
		try {
			String sql = "select * from Acksale ";

			rs = ju.getResultSetBySql(sql, null);
			while (rs.next()) {
				Acksale acks = new Acksale();
				acks.setAcksaleid(rs.getInt("Acksaleid"));
				acks.setNumber(rs.getInt("Number"));
				acks.setPrice(rs.getInt("Price"));
				acks.setRemark(rs.getString("Remark"));
				acksList.add(acks);
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
	public List<Acksale> findAll(Integer curPage, Integer row) {
		List<Acksale> acksList = new ArrayList<Acksale>();
		ResultSet rs = null;
		if (curPage <= 0)
			curPage = 1;
		if (row <= 0)
			row = 1;
		try {
			String sql = "select * from Acksale limit ?,?";
			Object[] objs = { (curPage - 1) * row, row };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				Acksale acks = new Acksale();
				acks.setAcksaleid(rs.getInt("Acksaleid"));
				acks.setNumber(rs.getInt("Number"));
				acks.setPrice(rs.getInt("Price"));
				acks.setRemark(rs.getString("Remark"));
				acksList.add(acks);
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
			String sql = "select ceil(count(*) / ? ) as csum from Acksale";
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
