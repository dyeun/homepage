package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.Member;

public class MemberDAO {
	
		
	public Connection getConn() {
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String user="MYHOME";
		String pwd="1234";
		
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("���� ����, ������� ��й�ȣ�� Ȯ���ϼ���.");
			e.printStackTrace();
		}
		
		return con;
	}
	
	public Member getMember(String mid) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Member m = null;
		
		String sql = "SELECT * FROM MEMBERS WHERE MID=?";
		con = getConn();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs=ps.executeQuery();
			System.out.println("rs="+rs);
			if(rs.next()){
				m = new Member();
				m.setMid(rs.getString("mid"));
				m.setPwd(rs.getString("pwd"));
				m.setName(rs.getString("name"));
				m.setGender(rs.getString("gender"));
				m.setBirthday(rs.getString("birthday"));				
				m.setPhone(rs.getString("phone"));
				m.setRegdate(rs.getString("regdate"));
			}
			
		} catch (SQLException e) {
			System.out.println("ȸ������ ��ȸ�� ���� �߻�");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("�������� ����");
				e.printStackTrace();
			}
		}
		return m;
	}

	public int addMember(Member m) {
		Connection con = null;
		PreparedStatement ps=null;
		int af = 0;
		
		String sql="INSERT INTO MEMBERS(MID,PWD,NAME,GENDER,BIRTHDAY,PHONE) VALUES(?, ?, ?, ?, ?, ?)";
		
		
		con=getConn();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, m.getMid());
			ps.setString(2, m.getPwd());
			ps.setString(3, m.getName());
			ps.setString(4, m.getGender());
			ps.setString(5, m.getBirthday());
			ps.setString(6, m.getPhone());
			
			af = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("ȸ�������� ���� �߻�");
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("�������� ����");
				e.printStackTrace();
			}
		}
		
		return af;
	}

	public int modifyMember(Member m) {
		Connection con=null;
		PreparedStatement ps=null;
		int af=0;
		
		String sql="UPDATE MEMBERS SET PWD=?, NAME=?, GENDER=?, BIRTHDAY=?, PHONE=? WHERE MID=?";
		con=getConn();
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, m.getPwd());
			ps.setString(2, m.getName());
			ps.setString(3, m.getGender());
			ps.setString(4, m.getBirthday());
			ps.setString(5, m.getPhone());
			ps.setString(6, m.getMid());
			af = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("ȸ������ ������ ���� �߻�");
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("�������� ����");
				e.printStackTrace();
			}
		}
		
		return af;
	}

	public int deleteMember(Member member) {
		Connection con=null;
		PreparedStatement ps=null;
		int af=0;
		
		String sql ="DELETE MEMBERS WHERE MID=?";
		con = getConn();
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getMid());
			
			af=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("ȸ�������� ���� �߻�");
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("�������� ����");
				e.printStackTrace();
			}
		}
		
		return af;
	}

	public ArrayList<Member> gMembers() {
		Connection con = null;
		ResultSet rs=null;
		Member m =null;
		ArrayList<Member> list=null;

		String sql="SELECT * FROM MEMBERS";
		con = getConn();
		
		Statement st = null;
		try {
			st = con.createStatement();
			rs=st.executeQuery(sql);
			list=new ArrayList<Member>();
			while(rs.next()){
				m = new Member();
				m.setMid(rs.getString("mid"));
				m.setPwd(rs.getString("pwd"));
				m.setName(rs.getString("name"));
				m.setGender(rs.getString("gender"));
				m.setBirthday(rs.getString("birthday"));
				m.setPhone(rs.getString("phone"));
				m.setRegdate(rs.getString("regdate"));
				
				list.add(m);
			}
		} catch (SQLException e) {
			System.out.println("��ü ȸ�� ��ȸ�� ���� �߻�");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("�������� ����");
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
