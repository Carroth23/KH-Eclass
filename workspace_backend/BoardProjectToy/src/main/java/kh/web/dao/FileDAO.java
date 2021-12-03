package kh.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kh.web.dto.FileDTO;

public class FileDAO {
	private static FileDAO instance = null;
	public static FileDAO getInstance() {
		if(instance == null) {
			instance =  new FileDAO();
		}
		return instance;
	}
	private FileDAO() {};
	
	private Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	public int insert(FileDTO dto) throws Exception{
		String sql = "insert into files values(files_seq.nextval,?,?,?)";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, dto.getOriName());
			pstat.setString(2, dto.getSysName());
			pstat.setInt(3, dto.getParentSeq());
			return pstat.executeUpdate();
		}
	}
	
	public List<FileDTO> selectAll() throws Exception {
		String sql = "select * from files";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery()){
			List<FileDTO> list = new ArrayList<>();
			while(rs.next()) {
				FileDTO dto = new FileDTO();
				dto.setSeq(rs.getInt("seq"));
				dto.setOriName(rs.getString("oriname"));
				dto.setSysName(rs.getString("sysname"));
				dto.setParentSeq(rs.getInt("parentseq"));
				list.add(dto);
			}
			return list;
		}
	}
}
