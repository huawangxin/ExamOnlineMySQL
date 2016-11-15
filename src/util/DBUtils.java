package util;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


/**
 * �������ݿ�Ĺ�����
 * */
public class DBUtils {
	// �������ݿ��·��
	private static String url;
	// �������ݿ���û���
	private static String user;
	// �������ݿ������
	private static String pwd;
	private static ThreadLocal<Connection> tl=
		new ThreadLocal<Connection>();
	// ��̬��
	static {

		try {
			// ��ȡ�����ļ�
			Properties prop = new Properties();
			/*
			 * ����д���ǽ��������Ƽ������·��д����
			 */
			InputStream is = DBUtils.class.getClassLoader().getResourceAsStream(
					"db.properties");
			prop.load(is);
			is.close();
			// �������
			String driver = prop.getProperty("driverClassName").trim();
			// ��õ�ַ
			url = prop.getProperty("url").trim();
			// ��ȡ�û���
			user = prop.getProperty("username").trim();
			// ��ȡ����
			pwd = prop.getProperty("password").trim();
			// ע������
			Class.forName(driver);

		} catch (Exception e) {
//			e.printStackTrace();
		}
	}

	/*
	 * ��ȡһ������
	 * 
	 * @return
	 */
	public static Connection getConnection() throws Exception {
		try {
			/*
			 * ͨ��DriverManager����һ�����ݿ�����Ӳ�����
			 */
			Connection conn=DriverManager.getConnection(url, user, pwd);
			/*
			 * ThreadLocal��set����
			 * �Ὣ��ǰ�߳���Ϊkey��������������ֵ��Ϊvalue�����ڲ���map�б��档
			 */
			tl.set(conn);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			// ֪ͨ�����ߣ��������ӳ���
			throw e;
		}
	}
	/**
	 * �رո���������
	 */
	public static void closeConnection(){
		try{
			Connection conn=tl.get();
			if(conn!=null){
				conn.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
