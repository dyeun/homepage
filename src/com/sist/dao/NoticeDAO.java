package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sist.vo.Member;
import com.sist.vo.Notice;

public class NoticeDAO {

	public Connection getConn() {
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String user="MYHOME";
		String pwd="1234";
		
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("접속 실패, 계정명과 비밀번호를 확인하세요.");
			e.printStackTrace();
		}
		
		return con;
	}
	
	
	
	public int getSeqCount(String field, String query){
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int count = 0;
		
		String sql="SELECT COUNT(SEQ) AS CNT FROM NOTICES WHERE "+field+" LIKE ?";
		con = getConn();
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, "%"+query+"%");
			rs=ps.executeQuery();
			if(rs.next()){
				count = rs.getInt("cnt");
				System.out.println("count="+count);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return count;
	}
	
	
	//게시글 목록조회
	public List<Notice> getNotices(int pg, String field, String query){
		Connection con = null;
		//Statement st = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Notice> list = null; 
		Notice n =null;
		int startRN = 1 + (pg-1)*10;
		
		String sql="SELECT * FROM (SELECT ROWNUM AS RN, N.* FROM (SELECT * FROM NOTICES WHERE "+field+" LIKE ? ORDER BY TO_NUMBER(SEQ) DESC) N) WHERE RN BETWEEN ? AND ?";
		con = getConn();
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+query+"%");
			ps.setInt(2, startRN);
			ps.setInt(3, startRN+9);
			rs=ps.executeQuery();
			list=new ArrayList<Notice>();
			while(rs.next()){
				n = new Notice();
				n.setSeq(rs.getString("seq"));
				n.setTitle(rs.getString("title"));
				n.setWriter(rs.getString("writer"));
				n.setContent(rs.getString("content"));
				n.setRegdate(rs.getString("regdate"));
				n.setHit(rs.getInt("hit"));
				n.setFileSrc(rs.getString("filesrc"));
				
				list.add(n);
			}
		} catch (SQLException e) {
			System.out.println("게시글 목록조회중 오류 발생");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("접속해제 실패");
				e.printStackTrace();
			}
		}
		
		
		return list;
	}
	
	
	public Notice getNotice(String seq) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Notice n = null;
		
		String sql = "SELECT * FROM NOTICES WHERE SEQ=?";
		con = getConn();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, seq);
			rs=ps.executeQuery();
			System.out.println("rs="+rs);
			if(rs.next()){
				n = new Notice();
				n.setSeq(rs.getString("seq"));
				n.setTitle(rs.getString("title"));
				n.setWriter(rs.getString("writer"));
				n.setContent(rs.getString("content"));
				n.setRegdate(rs.getString("regdate"));				
				n.setHit(rs.getInt("hit"));
				n.setFileSrc(rs.getString("filesrc"));
			}
			
		} catch (SQLException e) {
			System.out.println("조회중 오류 발생");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("접속해제 실패");
				e.printStackTrace();
			}
		}
		
		
		return n;
	}
	
	public int addNotice(Notice n) {
		Connection con = null;
		PreparedStatement ps=null;
		int af = 0;
		
		String sql="INSERT INTO NOTICES(SEQ,TITLE,WRITER,CONTENT,FILESRC) VALUES(?,?,?,?,?)";
		
		con=getConn();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, n.getSeq());
			ps.setString(2, n.getTitle());
			ps.setString(3, n.getWriter());
			ps.setString(4, n.getContent());
			ps.setString(5, n.getFileSrc());
			
			af = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("게시글 추가중 오류 발생");
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("접속해제 실패");
				e.printStackTrace();
			}
		}
		
		return af;
	}

	
	
	
	public int modifyNotice(Notice n) {
		Connection con=null;
		PreparedStatement ps=null;
		int af=0;
		
		String sql="UPDATE NOTICES SET TITLE=?, CONTENT=? WHERE SEQ=?";
		con=getConn();
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, n.getTitle());
			ps.setString(2, n.getContent());
			ps.setString(3, n.getSeq());
			af = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("게시글 수정중 오류 발생");
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("접속해제 실패");
				e.printStackTrace();
			}
		}
		
		return af;
	}

	public int deleteNotice(String seq) {
		Connection con=null;
		PreparedStatement ps=null;
		int af=0;
		
		String sql ="DELETE NOTICES WHERE SEQ=?";
		con = getConn();
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, seq);
			
			af=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("게시글삭제중 오류 발생");
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("접속해제 실패");
				e.printStackTrace();
			}
		}
		
		return af;
	}



	public int hitUp(String seq) {
		Connection con=null;
		PreparedStatement ps=null;
		int af=0;
		
		String sql="UPDATE NOTICES SET HIT=HIT+1 WHERE SEQ=?";
		con=getConn();
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, seq);
			af = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("조회수 업데이트중 오류 발생");
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("접속해제 실패");
				e.printStackTrace();
			}
		}
		
		return af;
	}

	
	
	

	
	
	
	
	
}
