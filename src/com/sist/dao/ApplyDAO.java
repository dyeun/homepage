package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sist.vo.Apply;




public class ApplyDAO {

	
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
	
	//전체신청서 조회 -> 관리자
	public List<Apply> getApps(){
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Apply> list = null;
		Apply a = null;
		
		String sql="SELECT * FROM APPLY ORDER BY REGDATE";
		con = getConn();
		
		try {
			ps = con.prepareStatement(sql);
			rs=ps.executeQuery();
			list = new ArrayList<Apply>();
			while(rs.next()){
				a = new Apply();
				a.setName(rs.getString("name"));
				a.setPhone(rs.getString("phone"));
				a.setEmail(rs.getString("email"));
				a.setStore(rs.getString("store"));
				a.setContent(rs.getString("content"));
				a.setRegdate(rs.getString("regdate"));
				
				list.add(a);
			}

		} catch (SQLException e) {
			System.out.println("전체신청서 조회중 오류 발생");
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
	
	
	//신청서 조회
	public Apply getApply(String email){
		
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Apply a = null;

		String sql="SELECT * FROM APPLY WHERE EMAIL=?";
		con = getConn();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			rs=ps.executeQuery();   
			while(rs.next()){
				a = new Apply(); 
				a.setName(rs.getString("name"));
				a.setPhone(rs.getString("phone"));
				a.setEmail(rs.getString("email"));
				a.setStore(rs.getString("store"));
				a.setContent(rs.getString("content"));
				a.setRegdate(rs.getString("regdate"));
			}
		} catch (SQLException e) {
			System.out.println("신청서 조회중 오류가 발생하였습니다.");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("접속해제에 실패하였습니다.");
				e.printStackTrace();
			}

		}
		return a;
	
	}
	
	
	public int addApply(Apply a) {
		Connection con = null;
		PreparedStatement ps=null;
		int af = 0;
		
		String sql="INSERT INTO APPLY(NAME,PHONE,EMAIL,STORE,CONTENT) VALUES(?,?,?,?,?)";
		
		con=getConn();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, a.getName());
			ps.setString(2, a.getPhone());
			ps.setString(3, a.getEmail());
			ps.setString(4, a.getStore());
			ps.setString(5, a.getContent());
			
			
			af = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("신청서 추가중 오류 발생");
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

		

	public int modifyApply(Apply a) {
		Connection con=null;
		PreparedStatement ps=null;
		int af=0;
		
		String sql="UPDATE APPLY SET NAME=?, PHONE=?, STORE=?, CONTENT=? WHERE EMAIL=?";
		con=getConn();
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, a.getName());
			ps.setString(2, a.getPhone());
			ps.setString(3, a.getStore());
			ps.setString(4, a.getContent());
			ps.setString(5, a.getEmail());
			af = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("지원서수정중 오류 발생");
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

	public int deleteApply(String email) {
		Connection con=null;
		PreparedStatement ps=null;
		int af=0;
		
		String sql ="DELETE APPLY WHERE EMAIL=?";
		con = getConn();
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			af=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("지원서삭제중 오류 발생");
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
