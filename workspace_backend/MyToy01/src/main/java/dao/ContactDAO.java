package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.ContactDTO;

public class ContactDAO {
	private static ContactDAO instance = null;

	public static ContactDAO getInstance() {
		if (instance == null) {
			instance = new ContactDAO();
		}
		return instance;
	}

	private ContactDAO() {
	}

	private Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}

	public List<ContactDTO> selectAll() throws Exception {
		String sql = "select * from contact";
		try (Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();) {
			List<ContactDTO> list = new ArrayList<>();
			while (rs.next()) {
				int seq = rs.getInt("seq");
				String name = rs.getString("name");
				String contact = rs.getString("contact");
				list.add(new ContactDTO(seq, name, contact));
			}
			return list;
		}
	}

	public int delete(int delID) throws Exception {
		String sql = "delete from contact where seq = ?";
		try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
			pstat.setInt(1, delID);
			int result = pstat.executeUpdate();
			return result;
		}
	}
	
	public int insert (String name, String contact) throws Exception {
		String sql = "insert into contact values(contact_seq.nextval,?,?)";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, name);
			pstat.setString(2, contact);
			int result = pstat.executeUpdate();
			return result;
		}
	}
	
	public int modify (String contact, String name, int seq) throws Exception {
		String sql = "update contact set contact = ?, name = ? where seq = ?";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, contact);
			pstat.setString(2, name);
			pstat.setInt(3, seq);
			int result = pstat.executeUpdate();
			return result;
		}
	}

}
