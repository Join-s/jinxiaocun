package club.hellc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ���ݿ⹤����
 * 
 * @author Hellc 2018��8��8������8:28:10
 */

public class JdbcUtils {
	private static final String DRIVER = "com.mysql.jdbc.Driver";// ����
	private static final String URL = "jdbc:mysql://localhost:3306/db_jxcsystem2?characterEncoding=utf-8";// �����ַ���
	private static final String USER = "root";// �˺�
	private static final String PWD = "root";// ����

	/**
	 * ��ȡ���õ����ݿ����Ӷ���
	 * 
	 * @return ���Ӷ���
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
	 * �ر���Ӧ��Դ
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
	 * ִ������ɾ���ô�����sql���
	 * 
	 * @param sql
	 *            ������sql���
	 * @param objs
	 *            Object����
	 * @return ִ�к���Ӱ������
	 */
	public int executeSQL(String sql, Object[] objs) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int result = -1;// �洢������Ӱ������
		try {
			conn = getConnection();
			pstm = conn.prepareStatement(sql);
			// ͨ��ѭ��������ֵ
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
