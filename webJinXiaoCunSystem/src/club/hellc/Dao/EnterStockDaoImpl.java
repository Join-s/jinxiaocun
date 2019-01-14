package club.hellc.Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import club.hellc.pojo.Enterstock;
import club.hellc.pojo.Product;

public class EnterStockDaoImpl {
	JdbcUtils ju = new JdbcUtils();

	public int add(Enterstock es) {
		try {
			String sql = "INSERT INTO enterstock(EmployeeID,StoreHouseID,ProductID,EnterStockDate,EnterStockID,number,price,ispub) VALUES(?,?,?,DEFAULT,DEFAULT,?,?,?)";
			Object[] objs = { es.getEmployeeid(), es.getStorehouseid(), es.getProductid(), es.getNumber(),
					es.getPrice(), es.getIspub() };
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
			String sql = "delete from  enterstock where  EnterStockID=?";
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

	public int updateById(Enterstock es) {
		try {
			String sql = "update enterstock set  StoreHouseID=?,ProductID=?,number=?,price=?,ispub=? where EnterStockID=?";
			Object[] objs = { es.getStorehouseid(), es.getProductid(), es.getNumber(), es.getPrice(), es.getIspub(),
					es.getEnterstockid() };
			int reslut = ju.executeSQL(sql, objs);
			if (reslut > 0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public Enterstock findById(Integer id) {
		Enterstock es = new Enterstock();
		ResultSet rs = null;
		try {
			String sql = "select * from enterstock where EnterStockID=?";
			Object[] objs = { id };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				es.setEmployeeid(rs.getInt("EmployeeID"));
				es.setEnterstockdate(rs.getDate("EnterstockDate"));
				es.setEnterstockid(rs.getInt("EnterStockID"));
				es.setIspub(rs.getString("ispub"));
				es.setNumber(rs.getInt("number"));
				es.setPrice(rs.getInt("price"));
				es.setProductid(rs.getInt("ProductID"));
				es.setStorehouseid(rs.getInt("StoreHouseID"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			// return null;
		} finally {
			ju.closeAll(null, null, rs);
		}
		return es;

	}

	public List<Enterstock> findAll() {
		List<Enterstock> esList = new ArrayList<Enterstock>();
		ResultSet rs = null;
		try {
			String sql = "select * from enterstock";
			rs = ju.getResultSetBySql(sql, null);
			while (rs.next()) {
				Enterstock es = new Enterstock();
				es.setEmployeeid(rs.getInt("EmployeeID"));
				es.setEnterstockdate(rs.getDate("EnterstockDate"));
				es.setEnterstockid(rs.getInt("EnterStockID"));
				es.setIspub(rs.getString("ispub"));
				es.setNumber(rs.getInt("number"));
				es.setPrice(rs.getInt("price"));
				es.setProductid(rs.getInt("ProductID"));
				es.setStorehouseid(rs.getInt("StoreHouseID"));
				esList.add(es);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return esList;

	}

	public List<Enterstock> findAllByProName(String proname) {
		List<Enterstock> esList = new ArrayList<Enterstock>();
		ResultSet rs = null;
		try {
			String sql = "select * from enterstock where 1=2";

			ProductDaoImpl productDaoImpl = new ProductDaoImpl();
			List<Product> prolist = new ArrayList<Product>();
			prolist = productDaoImpl.findAllByName(proname);

			if (prolist != null) {

				for (Product product : prolist) {
					sql = sql + " or Productid=" + product.getProductid();
				}
			} else {
				System.out.println("[error]--------->");
			}
			// System.out.println("[sql]--------->" + sql);

			rs = ju.getResultSetBySql(sql, null);
			while (rs.next()) {
				Enterstock es = new Enterstock();
				es.setEmployeeid(rs.getInt("EmployeeID"));
				es.setEnterstockdate(rs.getDate("EnterstockDate"));
				es.setEnterstockid(rs.getInt("EnterStockID"));
				es.setIspub(rs.getString("ispub"));
				es.setNumber(rs.getInt("number"));
				es.setPrice(rs.getInt("price"));
				es.setProductid(rs.getInt("ProductID"));
				es.setStorehouseid(rs.getInt("StoreHouseID"));
				esList.add(es);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return esList;

	}

	public List<Enterstock> findAllBytime(String time) {
		List<Enterstock> esList = new ArrayList<Enterstock>();
		ResultSet rs = null;
		try {
			String sql = "select * from enterstock where EnterstockDate like concat('%',?,'%') and ispub=1 ";
			Object[] objs = { time };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				Enterstock es = new Enterstock();
				es.setEmployeeid(rs.getInt("EmployeeID"));
				es.setEnterstockdate(rs.getDate("EnterstockDate"));
				es.setEnterstockid(rs.getInt("EnterStockID"));
				es.setIspub(rs.getString("ispub"));
				es.setNumber(rs.getInt("number"));
				es.setPrice(rs.getInt("price"));
				es.setProductid(rs.getInt("ProductID"));
				es.setStorehouseid(rs.getInt("StoreHouseID"));
				esList.add(es);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return esList;

	}

	public List<Enterstock> findAll(Integer curPage, Integer row) {
		List<Enterstock> esList = new ArrayList<Enterstock>();
		ResultSet rs = null;
		if (curPage <= 0)
			curPage = 1;
		if (row <= 0)
			row = 1;
		try {
			String sql = "select * from enterstock  where ispub=1 order by EnterstockDate desc  limit ?,?";
			Object[] objs = { (curPage - 1) * row, row };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				Enterstock es = new Enterstock();
				es.setEmployeeid(rs.getInt("EmployeeID"));
				es.setEnterstockdate(rs.getDate("EnterstockDate"));
				es.setEnterstockid(rs.getInt("EnterStockID"));
				es.setIspub(rs.getString("ispub"));
				es.setNumber(rs.getInt("number"));
				es.setPrice(rs.getInt("price"));
				es.setProductid(rs.getInt("ProductID"));
				es.setStorehouseid(rs.getInt("StoreHouseID"));
				esList.add(es);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return esList;
	}

	public int getCountsOfRow(Integer row) {
		ResultSet rs = null;
		if (row <= 0)
			row = 1;
		try {
			String sql = "select ceil(count(*) / ? ) as csum from enterstock where ispub=1";
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
