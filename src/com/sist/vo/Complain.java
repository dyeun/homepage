package com.sist.vo;

public class Complain {

	private String seq;
	private String name;
	private String phone;
	private String email;
	private String pwd;
	private String title;
	private String content;
	private String regdate;
	
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "Complain [seq=" + seq + ", name=" + name + ", phone=" + phone + ", email=" + email + ", pwd=" + pwd
				+ ", title=" + title + ", content=" + content + ", regdate=" + regdate + "]";
	}
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
}
