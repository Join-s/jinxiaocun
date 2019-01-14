package club.hellc.Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import club.hellc.pojo.Product;

public class ProductDaoImpl {
	JdbcUtils ju = new JdbcUtils();

	public int add(Product pro) {
		try {
			String sql = "INSERT INTO product(ProductID,productTypeID,NAME,productSpec,productUnit,price,createDate,updateDate) VALUES(DEFAULT,?,?,?,?,?,now(),DEFAULT)";
			Object[] objs = { pro.getProducttypeid(), pro.getName(), pro.getProductspec(), pro.getProductunit(),
					pro.getPrice() };
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
			String sql = "delete from  Product where  ProductID=?";
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

	public int updateById(Product pro) {
		try {
			String sql = "update product set productTypeID=?,NAME=?,productSpec=?,productUnit=?,price=? where ProductID=?";
			Object[] objs = { pro.getProducttypeid(), pro.getName(), pro.getProductspec(), pro.getProductunit(),
					pro.getPrice(), pro.getProductid() };
			int result = ju.executeSQL(sql, objs);
			if (result > 0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public Product findById(Integer id) {
		Product pro = new Product();
		ResultSet rs = null;
		try {
			String sql = "select * from Product where ProductID=?";
			Object[] objs = { id };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				pro.setCreatedate(rs.getDate("Createdate"));
				pro.setName(rs.getString("Name"));
				pro.setPrice(rs.getInt("Price"));
				pro.setProductid(rs.getInt("Productid"));
				pro.setProductspec(rs.getString("Productspec"));
				pro.setProducttypeid(rs.getInt("Producttypeid"));
				pro.setProductunit(rs.getString("Productunit"));
				pro.setUpdatedate(rs.getDate("Updatedate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return pro;

	}

	public List<Product> findAll() {
		List<Product> proList = new ArrayList<Product>();
		ResultSet rs = null;
		try {
			String sql = "select * from Product ";

			rs = ju.getResultSetBySql(sql, null);
			while (rs.next()) {
				Product pro = new Product();
				pro.setCreatedate(rs.getDate("Createdate"));
				pro.setName(rs.getString("Name"));
				pro.setPrice(rs.getInt("Price"));
				pro.setProductid(rs.getInt("Productid"));
				pro.setProductspec(rs.getString("Productspec"));
				pro.setProducttypeid(rs.getInt("Producttypeid"));
				pro.setProductunit(rs.getString("Productunit"));
				pro.setUpdatedate(rs.getDate("Updatedate"));
				proList.add(pro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return proList;

	}

	public List<Product> findAllByName(String proname) {
		List<Product> proList = new ArrayList<Product>();
		ResultSet rs = null;
		try {
			String sql = "select * from Product where name like CONCAT('%',?,'%')";
			Object[] objsObjects = { proname };
			rs = ju.getResultSetBySql(sql, objsObjects);
			while (rs.next()) {
				Product pro = new Product();
				pro.setCreatedate(rs.getDate("Createdate"));
				pro.setName(rs.getString("Name"));
				pro.setPrice(rs.getInt("Price"));
				pro.setProductid(rs.getInt("Productid"));
				pro.setProductspec(rs.getString("Productspec"));
				pro.setProducttypeid(rs.getInt("Producttypeid"));
				pro.setProductunit(rs.getString("Productunit"));
				pro.setUpdatedate(rs.getDate("Updatedate"));
				proList.add(pro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return proList;

	}

	public List<Product> findAll(Integer protypeid, Integer curPage, Integer row) {
		List<Product> proList = new ArrayList<Product>();
		ResultSet rs = null;
		if (curPage <= 0)
			curPage = 1;
		if (row <= 0)
			row = 1;
		try {
			String sql = "select * from product where producttypeid=? limit ?,?";
			Object[] objs = { protypeid, (curPage - 1) * row, row };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				Product pro = new Product();
				pro.setCreatedate(rs.getDate("Createdate"));
				pro.setName(rs.getString("Name"));
				pro.setPrice(rs.getInt("Price"));
				pro.setProductid(rs.getInt("Productid"));
				pro.setProductspec(rs.getString("Productspec"));
				pro.setProducttypeid(rs.getInt("Producttypeid"));
				pro.setProductunit(rs.getString("Productunit"));
				pro.setUpdatedate(rs.getDate("Updatedate"));
				proList.add(pro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return proList;
	}

	public int getCountsOfRow(Integer protypeid, Integer row) {
		ResultSet rs = null;
		if (row <= 0)
			row = 1;
		try {
			String sql = "select ceil(count(*) / ? ) as csum from product where producttypeid=?";
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
