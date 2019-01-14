package club.hellc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库工具类
 * 
 * @author Hellc 2018年8月8日下午8:28:10
 */

public class JdbcUtils {
	private static final String DRIVER = "com.mysql.jdbc.Driver";// 驱动
	private static final String URL = "jdbc:mysql://localhost:3306/db_jxcsystem2?characterEncoding=utf-8";// 连接字符串
	private static final String USER = "root";// 账号
	private static final String PWD = "root";// 密码

	/**
	 * 获取可用的数据库连接对象
	 * 
	 * @return 连接对象
	 */
	static public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PWD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 关闭相应资源
	 * 
	 * @param conn
	 * @param pstm
	 * @param rs
	 */
	public void closeAll(Connection conn, PreparedStatement pstm, ResultSet rs) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 执行增、删、该带？的sql语句
	 * 
	 * @param sql
	 *            带？的sql语句
	 * @param objs
	 *            Object数组
	 * @return 执行后受影响行数
	 */
	public int executeSQL(String sql, Object[] objs) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int result = -1;// 存储返回受影响行数
		try {
			conn = getConnection();
			pstm = conn.prepareStatement(sql);
			// 通过循环给？赋值
			if (objs != null)
				for (int i = 0; i < objs.length; i++) {
					pstm.setObject(i + 1, objs[i]);
				}
			result = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstm, null);
		}
		return result;
	}

	public ResultSet getResultSetBySql(String sql, Object[] objs) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstm = conn.prepareStatement(sql);
			if (objs != null)
				for (int i = 0; i < objs.length; i++) {
					pstm.setObject(i + 1, objs[i]);
				}
			rs = pstm.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
