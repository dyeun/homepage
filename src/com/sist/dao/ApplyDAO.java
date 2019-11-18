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
			System.out.println("����̹� �ε� ����");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("���� ����, ������� ��й�ȣ�� Ȯ���ϼ���.");
			e.printStackTrace();
		}
		
		return con;
	}
	
	//��ü��û�� ��ȸ -> ������
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
			System.out.println("��ü��û�� ��ȸ�� ���� �߻�");
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
		
		
		return list;
	}
	
	
	//��û�� ��ȸ
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
			System.out.println("��û�� ��ȸ�� ������ �߻��Ͽ����ϴ�.");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("���������� �����Ͽ����ϴ�.");
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
			System.out.println("��û�� �߰��� ���� �߻�");
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
			System.out.println("������������ ���� �߻�");
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
			System.out.println("������������ ���� �߻�");
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
	
	
	
	
	
	
	
	
	
	
	
	
	
}
