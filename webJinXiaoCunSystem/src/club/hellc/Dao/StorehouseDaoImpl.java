package club.hellc.Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import club.hellc.pojo.Storehouse;

public class StorehouseDaoImpl {
	JdbcUtils ju = new JdbcUtils();

	public int add(Storehouse sh) {
		try {
			String sql = "INSERT INTO storehouse(StoreHouseID,EmployeeID,name,address,phone,fax,Remark) values(DEFAULT,?,?,?,?,?,?)";
			Object[] objs = { sh.getEmployeeid(), sh.getName(), sh.getAddress(), sh.getPhone(), sh.getFax(),
					sh.getRemark() };
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
			String sql = "delete from  storehouse where StoreHouseID=?";
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

	public int updateById(Storehouse sh) {
		try {
			String sql = "update storehouse set EmployeeID=?,name=?,address=?,phone=?,fax=?,Remark=?  where StorehouseID=?";
			Object[] objs = { sh.getEmployeeid(), sh.getName(), sh.getAddress(), sh.getPhone(), sh.getFax(),
					sh.getRemark(), sh.getStorehouseid() };
			int result = ju.executeSQL(sql, objs);
			if (result > 0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public Storehouse findById(Integer id) {
		Storehouse sh = new Storehouse();
		ResultSet rs = null;
		try {
			String sql = "select * from Storehouse where StorehouseID=?";
			Object[] objs = { id };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				sh.setStorehouseid(rs.getInt("StorehouseID"));
				sh.setEmployeeid(rs.getInt("Employeeid"));
				sh.setName(rs.getString("Name"));
				sh.setAddress(rs.getString("Address"));
				sh.setPhone(rs.getString("Phone"));
				sh.setFax(rs.getString("Fax"));
				sh.setRemark(rs.getString("Remark"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return sh;

	}

	public List<Storehouse> findAll() {
		List<Storehouse> shLsit = new ArrayList<Storehouse>();
		ResultSet rs = null;
		try {
			String sql = "select * from Storehouse ";
			rs = ju.getResultSetBySql(sql, null);
			while (rs.next()) {
				Storehouse sh = new Storehouse();
				sh.setStorehouseid(rs.getInt("StorehouseID"));
				sh.setEmployeeid(rs.getInt("Employeeid"));
				sh.setName(rs.getString("Name"));
				sh.setAddress(rs.getString("Address"));
				sh.setPhone(rs.getString("Phone"));
				sh.setFax(rs.getString("Fax"));
				sh.setRemark(rs.getString("Remark"));
				shLsit.add(sh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return shLsit;

	}
}
