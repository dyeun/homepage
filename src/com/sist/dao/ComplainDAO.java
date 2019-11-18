package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.sist.vo.Complain;


public class ComplainDAO {

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
	
	//��ü���÷��� ��ȸ -> ������
		public List<Complain> getComplains(){
			Connection con = null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			List<Complain> list = null;
			Complain c = null;
			
			String sql="SELECT * FROM COMPLAINS ORDER BY REGDATE";
			con = getConn();
			
			try {
				ps = con.prepareStatement(sql);
				rs=ps.executeQuery();
				list = new ArrayList<Complain>();
				while(rs.next()){
					c = new Complain();
					c.setSeq(rs.getString("seq"));
					c.setName(rs.getString("name"));
					c.setPhone(rs.getString("phone"));
					c.setEmail(rs.getString("email"));
					c.setPwd(rs.getString("pwd"));
					c.setTitle(rs.getString("title"));
					c.setContent(rs.getString("content"));
					c.setRegdate(rs.getString("regdate"));
					
					
					list.add(c);
				}

			} catch (SQLException e) {
				System.out.println("���÷��� ��ȸ�� ���� �߻�");
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
		
	// ���÷��� ��ȸ
		public Complain getComplain(String email) {
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			Complain c = null;
			
			String sql = "SELECT * FROM COMPLAINS WHERE EMAIL=?";
			con = getConn();
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, email);
				rs=ps.executeQuery();
				System.out.println("rs="+rs);
				if(rs.next()){
					c = new Complain();
					c.setSeq(rs.getString("seq"));
					c.setName(rs.getString("name"));
					c.setPhone(rs.getString("phone"));
					c.setEmail(rs.getString("email"));
					c.setPwd(rs.getString("pwd"));
					c.setTitle(rs.getString("title"));				
					c.setContent(rs.getString("content"));
					c.setRegdate(rs.getString("regdate"));
					
				}
				
			} catch (SQLException e) {
				System.out.println("��ȸ�� ���� �߻�");
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
			
			
			return c;
		}
	
	
	
		public int addComplain(Complain c) {
			Connection con = null;
			PreparedStatement ps=null;
			int af = 0;
			
			String sql="INSERT INTO COMPLAINS(SEQ,NAME,PHONE,EMAIL,PWD,TITLE,CONTENT) VALUES(?,?,?,?,?,?,?)";
			
			con=getConn();
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, c.getSeq());
				ps.setString(2, c.getName());
				ps.setString(3, c.getPhone());
				ps.setString(4, c.getEmail());
				ps.setString(5, c.getPwd());
				ps.setString(6, c.getTitle());
				ps.setString(7, c.getContent());
				
				
				af = ps.executeUpdate();
			} catch (SQLException e) {
				System.out.println("���÷��� �߰��� ���� �߻�");
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
	
		
		public int modifyComplain(Complain c) {
			Connection con=null;
			PreparedStatement ps=null;
			int af=0;
			
			String sql="UPDATE COMPLAINS SET NAME=?, PHONE=?, EMAIL=?, PWD=?, TITLE=?, CONTENT=?";
			con=getConn();
			
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, c.getName());
				ps.setString(2, c.getPhone());
				ps.setString(3, c.getEmail());
				ps.setString(4, c.getPwd());
				ps.setString(5, c.getTitle());
				ps.setString(6, c.getContent());
				af = ps.executeUpdate();
				
			} catch (SQLException e) {
				System.out.println("���÷��� ������ ���� �߻�");
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

		
		
		public int deleteComplain(String seq) {
			Connection con=null;
			PreparedStatement ps=null;
			int af=0;
			
			String sql ="DELETE COMPLAINS WHERE SEQ=?";
			con = getConn();
			
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, seq);
				af=ps.executeUpdate();
			} catch (SQLException e) {
				System.out.println("���÷��λ����� ���� �߻�");
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
