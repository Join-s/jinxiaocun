package club.hellc.Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import club.hellc.pojo.Sale;

public class SaleDaoImpl {
	JdbcUtils ju = new JdbcUtils();

	public int add(Sale o) {
		try {
			String sql = "INSERT INTO sale(SaleID,number,price,remark) VALUES(?,?,?,?)";
			Object[] objs = { o.getSaleid(), o.getNumber(), o.getPrice(), o.getRemark() };
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
			String sql = "DELETE FROM  sale WHERE SaleID=?";
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

	public int updateById(Sale o) {
		try {
			String sql = "UPDATE sale SET number=?,price=?,remark=? WHERE SaleID=?";
			Object[] objs = { o.getNumber(), o.getPrice(), o.getPrice(), o.getRemark(), o.getSaleid() };
			int result = ju.executeSQL(sql, objs);
			if (result > 0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public Sale findById(String id) {
		Sale o = new Sale();
		ResultSet rs = null;
		try {
			String sql = "select * from Sale where SaleID=?";
			Object[] objs = { id };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				o.setNumber(rs.getInt("Number"));
				o.setPrice(rs.getInt("Price"));
				o.setRemark(rs.getString("Remark"));
				o.setSaleid(rs.getString("Saleid"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return o;

	}

	public List<Sale> findAll() {
		List<Sale> list = new ArrayList<Sale>();
		ResultSet rs = null;
		try {
			String sql = "select * from Sale ";

			rs = ju.getResultSetBySql(sql, null);
			while (rs.next()) {
				Sale o = new Sale();
				o.setNumber(rs.getInt("Number"));
				o.setPrice(rs.getInt("Price"));
				o.setRemark(rs.getString("Remark"));
				o.setSaleid(rs.getString("Saleid"));
				list.add(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return list;

	}

	/**
	 * 根据订单编号查询
	 * 
	 * @param sale
	 * @return
	 * @author Hellc
	 * @date 2018年8月19日下午2:45:51
	 */
	public List<Sale> findAllBySale(String sale) {
		List<Sale> list = new ArrayList<Sale>();
		ResultSet rs = null;
		try {
			String sql = "select * from Sale where Saleid like CONCAT('%',?,'%')";
			Object[] objsObjects = { sale };
			rs = ju.getResultSetBySql(sql, objsObjects);
			while (rs.next()) {
				Sale o = new Sale();
				o.setNumber(rs.getInt("Number"));
				o.setPrice(rs.getInt("Price"));
				o.setRemark(rs.getString("Remark"));
				o.setSaleid(rs.getString("Saleid"));
				list.add(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return list;

	}

	public List<Sale> findAll(Integer curPage, Integer row) {
		List<Sale> list = new ArrayList<Sale>();
		ResultSet rs = null;
		if (curPage <= 0)
			curPage = 1;
		if (row <= 0)
			row = 1;
		try {
			String sql = "select * from Sale limit ?,?";
			Object[] objs = { (curPage - 1) * row, row };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				Sale o = new Sale();
				o.setNumber(rs.getInt("Number"));
				o.setPrice(rs.getInt("Price"));
				o.setRemark(rs.getString("Remark"));
				o.setSaleid(rs.getString("Saleid"));
				list.add(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return list;
	}

	public int getCountsOfRow(Integer row) {
		ResultSet rs = null;
		if (row <= 0)
			row = 1;
		try {
			String sql = "select ceil(count(*) / ? ) as csum from Sale  ";
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
