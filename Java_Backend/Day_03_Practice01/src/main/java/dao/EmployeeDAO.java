package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.EmployeeDTO;

public class EmployeeDAO {
	private static EmployeeDAO instance = null;
	public static EmployeeDAO getInstance() {
		if (instance == null) {
			instance = new EmployeeDAO();
		}
		return instance;
	}
	private EmployeeDAO() {}
	
	private Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	public List<EmployeeDTO> select () throws Exception {
		String sql = "select emp_id, emp_name, dept_title, email from employee e left join department d on (e.dept_code = d.dept_id) order by 1";
//		String sql = "select emp_id, emp_name, dept_title, email from employee inner join department on(employee.dept_code=department.dept_id)";
		try (Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();) {
			List<EmployeeDTO> list = new ArrayList<>();
			while (rs.next()) {
				int emp_id = rs.getInt("emp_id");
				String emp_name = rs.getString("emp_name");
				String dept_title = rs.getString("dept_title");
				String email = rs.getString("email");
				EmployeeDTO dto = new EmployeeDTO(emp_id, emp_name, dept_title, email);
				list.add(dto);
			}
			return list;
		}
	}
}
