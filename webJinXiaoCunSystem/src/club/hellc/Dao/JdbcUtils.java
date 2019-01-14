package club.hellc.Dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ���ݿ⹤����
 * 
 * @author Hellc 2018��8��8������8:28:10
 */
public class JdbcUtils {
	private static String DRIVER = "com.mysql.jdbc.Driver";// ����
	private static String URL = "jdbc:mysql://localhost:3306/db_jxcsystem2?characterEncoding=utf-8";// �����ַ���
	private static String USER = "root";// �˺�
	private static String PWD = "root";// ����

	public JdbcUtils() {
		FileInputStream in = null;
		try {
			Properties properties = new Properties();
			in = new FileInputStream(new File("src/jdbc.properties"));
			properties.load(in);
			DRIVER = properties.getProperty("jdbc.driver");
			URL = properties.getProperty("jdbc.url");
			USER = properties.getProperty("jdbc.user");
			PWD = properties.getProperty("jdbc.password");

			System.out.println("DRIVER:" + DRIVER + "\nURL:" + URL + "\nUSER:" + USER + "\nPWD:" + PWD);

			System.out.println("[info]\t读取配置信息成功！");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[error]\t读取配置信息失败！");
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

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
