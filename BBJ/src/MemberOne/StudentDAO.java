package MemberOne;

import java.sql.*;
import java.util.Vector;

import javax.sql.*;
import javax.naming.*;

public class StudentDAO {
	private Connection getConnection() {
		Connection conn = null;
		
		try {
			Context initContext = new InitialContext();
		    DataSource ds =(DataSource)initContext.lookup("java:/comp/env/jdbc/myoracle");
		     
		    conn = ds.getConnection(); 
		} catch (Exception e) {
			System.out.println("Connection 생성 실패");
		}
		
		return conn;
	}
	
	// 아이디 체크
	public boolean idCheck(String id) {
		boolean result = true;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("select * from student where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(!rs.next()) {
				result = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {

				}
			}
			
			if(pstmt != null) {
				try {
					pstmt.close();
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
		
		return result;
	}
	
	// 우편번호를 DB에서 검색 후 결과를 Vector에 저장해 리턴
	public Vector<ZipCodeVO> zipcodeRead(String dong) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector<ZipCodeVO> vecList = new Vector<ZipCodeVO>();
		
		try {
			conn = getConnection();
			
			String strQuery = "select * from zipcode where dong like '" + dong + "%'";
			
			pstmt = conn.prepareStatement(strQuery);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ZipCodeVO tempZipcode = new ZipCodeVO();
				tempZipcode.setZipcode(rs.getString("zipcode"));
				tempZipcode.setSido(rs.getString("sido"));
				tempZipcode.setGugun(rs.getString("gugun"));
				tempZipcode.setDong(rs.getString("dong"));
				tempZipcode.setRi(rs.getString("ri"));
				tempZipcode.setBunji(rs.getString("bunji"));
				vecList.addElement(tempZipcode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {

				}
			}
			
			if(pstmt != null) {
				try {
					pstmt.close();
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
	
	public boolean MemberInsert(StudentVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean flag = false; // 회원추가 성공 여부
		
		try {
			conn = getConnection();
			
			String strQuery = "insert into student values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(strQuery);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPass());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPhone1());
			pstmt.setString(5, vo.getPhone2());
			pstmt.setString(6, vo.getPhone3());
			pstmt.setString(7, vo.getEmail());
			pstmt.setString(8, vo.getZipcode());
			pstmt.setString(9, vo.getAddress1());
			pstmt.setString(10, vo.getAddress2());
			
			int count = pstmt.executeUpdate();
			
			if(count > 0) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
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
		
		return flag;
	}
	
	// LoginCheck 메소드 추가 >>  로그인 성공 : 1, 비밀번호 오휴 : 0, 아이디 없음 : -1
	public int loginCheck(String id, String pass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int check = -1;
		
		try {
			conn = getConnection();
			
			String strQuery = "select pass from student where id = ?";
			pstmt = conn.prepareStatement(strQuery);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String dbPass = rs.getString("pass");
				if(pass.equals(dbPass)) {
					check = 1;
				}
				else {
					check = 0;
				}
			}
		} catch (Exception e) {
			
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {

				}
			}
			
			if(pstmt != null) {
				try {
					pstmt.close();
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
		
		return check;
	}
	
	// ID로 회원정보를 가져오는 메소드
	public StudentVO getMember(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentVO vo = null;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("select * from student where id = ?");
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new StudentVO();
				
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setPhone1(rs.getString("phone1"));
				vo.setPhone2(rs.getString("phone2"));
				vo.setPhone3(rs.getString("phone3"));
				vo.setEmail(rs.getString("email"));
				vo.setZipcode(rs.getString("zipcode"));
				vo.setAddress1(rs.getString("address1"));
				vo.setAddress2(rs.getString("address2"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {

				}
			}
			
			if(pstmt != null) {
				try {
					pstmt.close();
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
		
		return vo;
	}
	
	public void updateMember(StudentVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("update student set pass = ?, phone1 = ?, phone2 = ?, phone3 = ?, email = ?, zipcode = ?, address1 = ?, address2 = ? where id = ?");
			
			pstmt.setString(1, vo.getPass());
			pstmt.setString(2, vo.getPhone1());
			pstmt.setString(3, vo.getPhone2());
			pstmt.setString(4, vo.getPhone3());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getZipcode());
			pstmt.setString(7, vo.getAddress1());
			pstmt.setString(8, vo.getAddress2());
			pstmt.setString(9, vo.getId());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
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
	}
	
	// 회원 탈퇴 >> 성공 : 1, 실패 : 0
	public int deleteMember(String id, String pass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String dbPass = ""; // DB에서 비밀번호를 가져와 저장
		
		int result = -1; // ID 존재하지 않을 경우 -1
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select pass from student where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dbPass = rs.getString("pass");
				
				if(dbPass.equals(pass)) {
					pstmt = conn.prepareStatement("delete from student where id = ?");
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					
					result = 1;
				}
				else { // 비밀번호 오류
					result = 0;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {

				}
			}
			
			if(pstmt != null) {
				try {
					pstmt.close();
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
		
		return result;
	}
}