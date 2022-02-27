package JDBC;

import java.sql.*;
import java.util.*;
import JDBC.tempMemberVO;

public class tempMemberDAO {
	private final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private final String USER = "SCOTT";
	private final String PASS = "tiger";
	
	public tempMemberDAO() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (Exception e) {
			System.out.println("ERROR : JDBC DRIVER 로딩 실패");
		}
	}
	
	public Vector<tempMemberVO> getMemberList() {
		Vector<tempMemberVO> vecList = new Vector<tempMemberVO>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			
			String strQuery = "select * from tempmember";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(strQuery);
			
			while(rs.next()) {
				tempMemberVO vo = new tempMemberVO(); // vo 객체 생성
				
				// 객체 DB에 저장된 값을 가져와 저장
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				vo.setMem_num1(rs.getString("mem_num1"));
				vo.setMem_num2(rs.getString("mem_num2"));
				vo.setEmail(rs.getString("e_mail"));
				vo.setPhone(rs.getString("phone"));
				vo.setZipcode(rs.getString("zipcode"));
				vo.setAddress(rs.getString("address"));
				vo.setJob(rs.getString("job"));
				
				vecList.add(vo);
			}
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					
				}
			}
			
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					
				}
			}
		}
		
		return vecList;
	}
}