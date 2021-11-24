package dao;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ContactDAO {
	private static ContactDAO instance = null;
	public static ContactDAO getInstance() {
		if (instance == null) {
			instance = new ContactDAO();
		}
		return instance;
	}
	private ContactDAO() {}
	private Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	
	
}
