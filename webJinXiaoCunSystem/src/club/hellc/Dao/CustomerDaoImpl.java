package club.hellc.Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import club.hellc.pojo.Customer;

public class CustomerDaoImpl {
	JdbcUtils ju = new JdbcUtils();

	public int add(Customer cus) {
		try {
			String sql = "INSERT INTO customer(CustomerID,NAME,address,phone,fax,postalCode,ConstactPerson) VALUES(DEFAULT,?,?,?,?,?,?) ";
			Object[] objs = { cus.getName(), cus.getAddress(), cus.getPhone(), cus.getFax(), cus.getPostalcode(),
					cus.getConstactperson() };
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
			String sql = "delete from  Customer where  CustomerID=?";
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

	public int updateById(Customer cus) {
		try {
			String sql = "UPDATE customer SET NAME=?,address=?,phone=?,fax=?,postalCode=?,ConstactPerson=? WHERE CustomerID=?";
			Object[] objs = { cus.getName(), cus.getAddress(), cus.getPhone(), cus.getFax(), cus.getPostalcode(),
					cus.getConstactperson(), cus.getCustomerid() };
			int result = ju.executeSQL(sql, objs);
			if (result > 0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public Customer findById(Integer id) {
		Customer cus = new Customer();
		ResultSet rs = null;
		try {
			String sql = "select * from Customer where CustomerID=?";
			Object[] objs = { id };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				cus.setAddress(rs.getString("Address"));
				cus.setConstactperson(rs.getInt("Constactperson"));
				cus.setCustomerid(rs.getInt("Customerid"));
				cus.setFax(rs.getString("Fax"));
				cus.setName(rs.getString("Name"));
				cus.setPhone(rs.getString("Phone"));
				cus.setPostalcode(rs.getString("Postalcode"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return cus;

	}

	public List<Customer> findAll() {
		List<Customer> cusList = new ArrayList<Customer>();
		ResultSet rs = null;
		try {
			String sql = "select * from Customer ";

			rs = ju.getResultSetBySql(sql, null);
			while (rs.next()) {
				Customer cus = new Customer();
				cus.setAddress(rs.getString("Address"));
				cus.setConstactperson(rs.getInt("Constactperson"));
				cus.setCustomerid(rs.getInt("Customerid"));
				cus.setFax(rs.getString("Fax"));
				cus.setName(rs.getString("Name"));
				cus.setPhone(rs.getString("Phone"));
				cus.setPostalcode(rs.getString("Postalcode"));
				cusList.add(cus);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return cusList;

	}

	public List<Customer> findAll(Integer curPage, Integer row) {
		List<Customer> cList = new ArrayList<Customer>();
		ResultSet rs = null;
		if (curPage <= 0)
			curPage = 1;
		if (row <= 0)
			row = 1;
		try {
			String sql = "select * from Customer  limit ?,?";
			Object[] objs = { (curPage - 1) * row, row };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				Customer cus = new Customer();
				cus.setAddress(rs.getString("Address"));
				cus.setConstactperson(rs.getInt("Constactperson"));
				cus.setCustomerid(rs.getInt("Customerid"));
				cus.setFax(rs.getString("Fax"));
				cus.setName(rs.getString("Name"));
				cus.setPhone(rs.getString("Phone"));
				cus.setPostalcode(rs.getString("Postalcode"));
				cList.add(cus);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return cList;
	}

	public int getCountsOfRow(Integer row) {
		ResultSet rs = null;
		if (row <= 0)
			row = 1;
		try {
			String sql = "select ceil(count(*) / ? ) as csum from Customer  ";
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
