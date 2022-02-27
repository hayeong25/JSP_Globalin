package BoardMVC;

import java.util.*;
import java.sql.*;

public class BoardDAO {
	private static BoardDAO instance = null;
	
	private BoardDAO() {
		   
	}
	   
	public static BoardDAO getInstance() {
		if(instance == null) {
			synchronized (BoardDAO.class) {
				instance = new BoardDAO();
			}
		}
		return instance;
	} 
	   // 이하, 게시판 메소드
	
	public void insertArticle(BoardVO article) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int num = article.getNum();
		int ref = article.getRef();
		int step = article.getStep();
		int depth = article.getDepth();
		
		int number = 0;
		
		String sql = "";
		
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement("select max(num) from board");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				number = rs.getInt(1) + 1;
			}
			else {
				number = 1;
			}
			
			if(num != 0) { // 답변글일 경우
				sql = "update board set step = step + 1 where ref = ? and step > ?";
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, ref);
				pstmt.setInt(2, step);
				
				pstmt.executeUpdate();
				
				step = step + 1;
				depth = depth + 1;
			}
			else { // 새 글일 경우
				ref = number;
				step = 0;
				depth = 0;
			}
			
			sql = "insert into board(num, writer, email, subject, pass, regdate, ref, step, depth, content, ip) values(board_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getWriter());
			pstmt.setString(2, article.getEmail());
			pstmt.setString(3, article.getSubject());
			pstmt.setString(4, article.getPass());
			pstmt.setTimestamp(5, article.getRegdate());
			pstmt.setInt(6, ref);
			pstmt.setInt(7, step);
			pstmt.setInt(8, depth);
			pstmt.setString(9, article.getContent());
			pstmt.setString(10, article.getIp());
			
			pstmt.executeUpdate();
			
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
	}
	
	public int getArticleCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;
		
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement("select count(*) from board");
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				x = rs.getInt(1);
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
		
		return x;
	}
	
	public List<BoardVO> getArticles() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> articleList = null;
		
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement("select * from board order by num desc");
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				articleList = new ArrayList<BoardVO>();
				
				do {
					BoardVO article = new BoardVO();
					
					article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("writer"));
					article.setEmail(rs.getString("email"));
					article.setSubject(rs.getString("subject"));
					article.setPass(rs.getString("pass"));
					article.setRegdate(rs.getTimestamp("regdate"));
					article.setReadcount(rs.getInt("readcount"));
					article.setRef(rs.getInt("ref"));
					article.setStep(rs.getInt("step"));
					article.setDepth(rs.getInt("depth"));
					article.setContent(rs.getString("content"));
					article.setIp(rs.getString("ip"));
					
					articleList.add(article);
				} while(rs.next());
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
		
		return articleList;
	}
	
	public BoardVO getArticle(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO article = null;
		
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement("update board set readcount = readcount + 1 where num = ?");
			
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("select * from board where num = ?");
			
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				article = new BoardVO();
				
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setEmail(rs.getString("email"));
				article.setSubject(rs.getString("subject"));
				article.setPass(rs.getString("pass"));
				article.setRegdate(rs.getTimestamp("regdate"));
				article.setReadcount(rs.getInt("readcount"));
				article.setRef(rs.getInt("ref"));
				article.setStep(rs.getInt("step"));
				article.setDepth(rs.getInt("depth"));
				article.setContent(rs.getString("content"));
				article.setIp(rs.getString("ip"));
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
		
		return article;
	}
	
	public BoardVO updateGetArticle(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO article = null;
		
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement("select * from board where num = ?");
			
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				article = new BoardVO();
				
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setEmail(rs.getString("email"));
				article.setSubject(rs.getString("subject"));
				article.setPass(rs.getString("pass"));
				article.setRegdate(rs.getTimestamp("regdate"));
				article.setReadcount(rs.getInt("readcount"));
				article.setRef(rs.getInt("ref"));
				article.setStep(rs.getInt("step"));
				article.setDepth(rs.getInt("depth"));
				article.setContent(rs.getString("content"));
				article.setIp(rs.getString("ip"));
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
		
		return article;
	}
	
	public int updateArticle(BoardVO article) {
		  
		  Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String dbpasswd="";
			String sql="";
			int result = -1; // 결과 없음  , 1: 수정성공, 0: 수정 실패
		  
			 try {
				 conn = ConnUtil.getConnection();
				 pstmt = conn.prepareStatement("select pass from board where num=?");
				 pstmt.setInt(1, article.getNum());
				 rs = pstmt.executeQuery();
				 
				 if(rs.next()) {
					 // 비밀번호 비교 
					 dbpasswd = rs.getString("pass");
					 
					 if(dbpasswd.equals(article.getPass())) {
						 // 비밀번호가 같으면 수정처리
						 sql ="update board set writer=?, email=?, "
						 		+ "subject=?, content=? where num=?";
						 
						 pstmt = conn.prepareStatement(sql);
						 pstmt.setString(1, article.getWriter());
						 pstmt.setString(2, article.getEmail());		 
						 pstmt.setString(3, article.getSubject());		 
						 pstmt.setString(4, article.getContent());
						 pstmt.setInt(5, article.getNum());
						 pstmt.executeUpdate();
						 
						 result = 1; //수정성공
					 }else {
						 result = 0;//비밀번호 오류
					 }
				 }
			 }catch(Exception e) {
					e.printStackTrace();
				}finally {
					if(rs != null) try {rs.close();}catch(SQLException s) {}
					if(pstmt != null) try {pstmt.close();}catch(SQLException s) {}
					if(conn != null) try {conn.close();}catch(SQLException s) {}
				}
			return result;
	   }
}