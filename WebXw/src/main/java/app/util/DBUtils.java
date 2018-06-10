package app.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import app.base.SourceTemplate;

/**
 * ���ݿ����������
 * 
 */
public class DBUtils {
	private static Properties pathProperties;
	static {
		pathProperties = new Properties();
		try {
			pathProperties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public DBUtils() {
	}

	public static DataSource getDataSource() {
		DataSource dataSource = (DataSource) SourceTemplate.getSpringContextInstance().getBean("dataSource");
		return dataSource;
	}

	public static Connection getConn() throws RuntimeException {
		Connection conn = null;
		DataSource dataSource = null;
		try{
			dataSource = (DataSource) SourceTemplate.getSpringContextInstance().getBean("dataSource");
			conn = dataSource.getConnection();
		}catch(Exception exception) {
			
		}
		
		if(conn==null){
			conn = getConnection();
		}
		return conn;
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(pathProperties.getProperty("jdbc.driver"));
			String url = pathProperties.getProperty("jdbc.url");
			String user = pathProperties.getProperty("jdbc.username");
			String password = pathProperties.getProperty("jdbc.password");
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * ��Ϣƽ̨����
	 * @return
	 */
	public static Connection getMessageConnection() {
		Connection conn = null;
		try {
			Class.forName(pathProperties.getProperty("message.driver"));
			String url = pathProperties.getProperty("message.url");
			String user = pathProperties.getProperty("message.username");
			String password = pathProperties.getProperty("message.password");
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * �ر����
	 * 
	 * @param statement
	 */
	public static void closeStatement(Statement statement) {
		try {
			if (statement != null) {
				statement.close();
				statement = null;
			}
		} catch (SQLException sqlexception) {
			throw new RuntimeException("error.closeStatement", sqlexception);
		}
	}

	/**
	 * �ر����
	 * 
	 * @param resultset
	 */
	public static void closeResultset(ResultSet resultset) {
		try {
			if (resultset != null) {
				resultset.close();
				resultset = null;
			}
		} catch (SQLException sqlexception) {
			throw new RuntimeException("error.closeResultset", sqlexception);
		}
	}

	/**
	 * �ر�����
	 * 
	 * @param connection
	 */
	public static void closeConnection(Connection connection) {
		if (connection == null) {
			return;
		}
		try {
			connection.close();
			connection = null;
		} catch (SQLException sqlexception) {
			throw new RuntimeException("error.closeConnection", sqlexception);
		}
	}
}
