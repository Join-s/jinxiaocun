package club.hellc.Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import club.hellc.pojo.Producttype;

public class ProducttypeDaoImpl {
	JdbcUtils ju = new JdbcUtils();

	public int add(Producttype protype) {
		try {
			String sql = "INSERT INTO producttype(productTypeID,typeName) values(DEFAULT,?)";
			Object[] objs = { protype.getTypename() };
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
			String sql = "delete from  Producttype where  productTypeID=?";
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

	public int updateById(Producttype protype) {
		try {
			String sql = "update producttype set typeName=? where ProducttypeID=?";
			Object[] objs = { protype.getTypename(), protype.getProducttypeid() };
			int result = ju.executeSQL(sql, objs);
			if (result > 0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public Producttype findById(Integer id) {
		Producttype protype = new Producttype();
		ResultSet rs = null;
		try {
			String sql = "select * from Producttype where ProducttypeID=?";
			Object[] objs = { id };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				protype.setProducttypeid(rs.getInt("producttypeid"));
				protype.setTypename(rs.getString("typename"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return protype;
	}

	public int findByName(String name) {
		Producttype protype = new Producttype();
		ResultSet rs = null;
		try {
			String sql = "select * from Producttype where  typename=?";
			Object[] objs = { name };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				return rs.getInt("producttypeid");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return -1;
	}

	public List<Producttype> findAll() {
		List<Producttype> protypeList = new ArrayList<Producttype>();
		ResultSet rs = null;
		try {
			String sql = "select * from Producttype ";

			rs = ju.getResultSetBySql(sql, null);
			while (rs.next()) {
				Producttype protype = new Producttype();
				protype.setProducttypeid(rs.getInt("producttypeid"));
				protype.setTypename(rs.getString("typename"));
				protypeList.add(protype);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return protypeList;

	}

	public List<Producttype> findAll(Integer curPage, Integer row) {
		List<Producttype> protypeList = new ArrayList<Producttype>();
		ResultSet rs = null;
		if (curPage == null || curPage < 1)
			curPage = 1;
		if (row == null || row < 1)
			row = 1;
		try {
			String sql = "select * from Producttype limit ?,?";
			Object[] objs = { (curPage - 1) * row, row };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				Producttype protype = new Producttype();
				protype.setProducttypeid(rs.getInt("producttypeid"));
				protype.setTypename(rs.getString("typename"));
				protypeList.add(protype);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return protypeList;

	}

	public int getCountsOfRow(Integer row) {
		if (row == null || row < 1)
			row = 1;
		ResultSet rs = null;
		try {
			String sql = "select ceil(count(*) / ? ) as csum from Producttype";
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
		return 1;
	}
}
