package club.hellc.Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import club.hellc.pojo.CusDept;

public class CusDeptDaoImpl {

	JdbcUtils ju = new JdbcUtils();

	public int add(CusDept vo) {
		try {
			String sql = "INSERT INTO cus_dept(deptID,CustomerID) VALUES(?,?)";
			Object[] objs = { vo.getDeptid(), vo.getCustomerid() };
			int result = ju.executeSQL(sql, objs);
			if (result > 0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;

	}

	public int deleteById(Integer deptid) {
		try {
			String sql = "delete from  CusDept where deptID=?";
			Object[] objs = { deptid };
			int result = ju.executeSQL(sql, objs);
			if (result > 0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;

	}

	public int updateById(CusDept vo) {
		try {
			String sql = "UPDATE cus_dept SET CustomerID=?,deptID=?";
			Object[] objs = { vo.getCustomerid(), vo.getCustomerid() };
			int result = ju.executeSQL(sql, objs);
			if (result > 0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public CusDept findById(Integer deptid) {
		CusDept vo = new CusDept();
		ResultSet rs = null;
		try {
			String sql = "select * from CusDept where WHERE deptID=?";
			Object[] objs = { deptid };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				vo.setCustomerid(rs.getInt("Customerid"));
				vo.setDeptid(rs.getInt("deptID"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return vo;

	}

	public List<CusDept> findAll() {
		List<CusDept> proList = new ArrayList<CusDept>();
		ResultSet rs = null;
		try {
			String sql = "select * from CusDept ";

			rs = ju.getResultSetBySql(sql, null);
			while (rs.next()) {
				CusDept vo = new CusDept();
				vo.setCustomerid(rs.getInt("Customerid"));
				vo.setDeptid(rs.getInt("deptID"));
				proList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return proList;

	}

	/**
	 * 返回当前页列表
	 * 
	 * 
	 * @param curPage
	 *            当前页
	 * @param row
	 *            行数
	 * 
	 * @return
	 * @author Hellc
	 * @date 2018年8月16日下午2:07:20
	 */
	public List<CusDept> findAll(Integer curPage, Integer row) {
		List<CusDept> voList = new ArrayList<CusDept>();
		ResultSet rs = null;
		if (curPage <= 0)
			curPage = 1;
		if (row <= 0)
			row = 1;
		try {
			String sql = "select * from cus_dept  limit ?,?";
			Object[] objs = { (curPage - 1) * row, row };
			rs = ju.getResultSetBySql(sql, objs);
			while (rs.next()) {
				CusDept vo = new CusDept();
				vo.setCustomerid(rs.getInt("Customerid"));
				vo.setDeptid(rs.getInt("deptID"));
				voList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ju.closeAll(null, null, rs);
		}
		return voList;
	}

	/**
	 * * 总页数
	 * 
	 * @param row
	 *            行数
	 * @return
	 * @author Hellc
	 * @date 2018年8月16日下午2:16:18
	 */
	public int getCountsOfRow(Integer row) {
		ResultSet rs = null;
		if (row <= 0)
			row = 1;
		try {
			String sql = "select ceil(count(*) / ? ) as csum from CusDept ";
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
