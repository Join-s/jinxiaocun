package club.hellc.Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import club.hellc.pojo.Orders;

public class OrdersDaoImpl {
	JdbcUtils ju = new JdbcUtils();

	public int add(Orders o) {
		try {
			String sql = "INSERT INTO orders(ordersID,CustomerID,productID,SaleID,number,price,createdate,ispub) VALUES(DEFAULT,?,?,?,?,?,NOW(),'0')";
			Object[] objs = { o.getCustomerid(), o.getProductid(), o.getSaleid(), o.getNumber(), o.getPrice() };
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
			String sql = "delete from  Orders where  OrdersID=?";
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

	public int updateById(Orders o) {
		try {
			String sql = "UPDATE orders SET CustomerID=?,ProductID=?,SaleID=?,number=?,price=?,ispub=? WHERE ordersID=?";
			Object[] objs = { o.getCustomerid(), o.getProductid(), o.getSaleid(), o.getNumber(), o.getPrice(),
					o.getIspub(), o.getOrdersid() };
			int result = ju.executeSQL(sql, objs);
			if (result > 0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public Orders findById(Integer id) {
		Orders o = new Orders();
		ResultSet rs = null;
		try {
			String sql = "select * from Orders where OrdersID=?";
			Object[] objs = { id };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				o.setCustomerid(rs.getInt("Customerid"));
				o.setNumber(rs.getInt("Number"));
				o.setOrdersid(rs.getInt("Ordersid"));
				o.setPrice(rs.getInt("Price"));
				o.setProductid(rs.getInt("Productid"));
				o.setSaleid(rs.getString("Saleid"));
				o.setCreatedate(rs.getDate("createdate"));
				o.setIspub(rs.getString("ispub"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return o;

	}

	public List<Orders> findAll() {
		List<Orders> list = new ArrayList<Orders>();
		ResultSet rs = null;
		try {
			String sql = "select * from Orders order by createdate desc";

			rs = ju.getResultSetBySql(sql, null);
			while (rs.next()) {
				Orders o = new Orders();
				o.setCustomerid(rs.getInt("Customerid"));
				o.setNumber(rs.getInt("Number"));
				o.setOrdersid(rs.getInt("Ordersid"));
				o.setPrice(rs.getInt("Price"));
				o.setProductid(rs.getInt("Productid"));
				o.setSaleid(rs.getString("Saleid"));
				o.setCreatedate(rs.getDate("createdate"));
				o.setIspub(rs.getString("ispub"));
				list.add(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return list;

	}

	public List<Orders> findAllByIspub(String ispub) {
		List<Orders> list = new ArrayList<Orders>();
		ResultSet rs = null;
		try {
			String sql = "select * from Orders where ispub=?";
			Object[] objs = { ispub };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				Orders o = new Orders();
				o.setCustomerid(rs.getInt("Customerid"));
				o.setNumber(rs.getInt("Number"));
				o.setOrdersid(rs.getInt("Ordersid"));
				o.setPrice(rs.getInt("Price"));
				o.setProductid(rs.getInt("Productid"));
				o.setSaleid(rs.getString("Saleid"));
				o.setCreatedate(rs.getDate("createdate"));
				o.setIspub(rs.getString("ispub"));
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
	public List<Orders> findAllBySale(String sale) {
		List<Orders> list = new ArrayList<Orders>();
		ResultSet rs = null;
		try {
			String sql = "select * from Orders where Saleid like CONCAT('%',?,'%')";
			Object[] objsObjects = { sale };
			rs = ju.getResultSetBySql(sql, objsObjects);
			while (rs.next()) {
				Orders o = new Orders();
				o.setCustomerid(rs.getInt("Customerid"));
				o.setNumber(rs.getInt("Number"));
				o.setOrdersid(rs.getInt("Ordersid"));
				o.setPrice(rs.getInt("Price"));
				o.setProductid(rs.getInt("Productid"));
				o.setSaleid(rs.getString("Saleid"));
				o.setCreatedate(rs.getDate("createdate"));
				o.setIspub(rs.getString("ispub"));
				list.add(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return list;

	}

	public List<Orders> findAll(Integer curPage, Integer row) {
		List<Orders> list = new ArrayList<Orders>();
		ResultSet rs = null;
		if (curPage <= 0)
			curPage = 1;
		if (row <= 0)
			row = 1;
		try {
			String sql = "select * from Orders limit ?,?";
			Object[] objs = { (curPage - 1) * row, row };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				Orders o = new Orders();
				o.setCustomerid(rs.getInt("Customerid"));
				o.setNumber(rs.getInt("Number"));
				o.setOrdersid(rs.getInt("Ordersid"));
				o.setPrice(rs.getInt("Price"));
				o.setProductid(rs.getInt("Productid"));
				o.setSaleid(rs.getString("Saleid"));
				o.setCreatedate(rs.getDate("createdate"));
				o.setIspub(rs.getString("ispub"));
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
			String sql = "select ceil(count(*) / ? ) as csum from Orders  ";
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
