package baseball.db;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBconnection {
	private static final String TAG = "DBconnection : ";

	public static Connection DBconn() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			Connection conn = ds.getConnection();
			// etc.
			System.out.println(TAG+"DB연결 성공");
			return conn;
		} catch (Exception e) {
			System.out.println(TAG+"DB연결 실패");
			return null;
		}
	}
}
