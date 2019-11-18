package com.sist.vo;


public class Member {
	private String mid;
	private String pwd;
	private String name;
	private String gender;
	private String birthday;
	private String phone;
	private String regdate;
	
	
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public Member() {
		this(null,null,null,null,null,null,null);
	}
	
	public Member(String mid, String pwd, String name, String gender, String birthday, String phone, String regdate) {
		this.mid=mid;
		this.pwd=pwd;
		this.name=name;
		this.gender=gender;
		this.birthday=birthday;
		this.phone=phone;
		this.regdate=regdate;
	}
	
	
	@Override
	public String toString() {
		return "Member [mid=" + mid + ", pwd=" + pwd + ", name=" + name + ", gender=" + gender + ", birthday="
				+ birthday + ", phone=" + phone + ", regdate=" + regdate + "]";
	}
	
	
	
	
	

	
	
}































