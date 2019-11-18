package com.sist.vo;

public class Apply {
	
	private String name;
	private String phone;
	private String email;
	private String store;
	private String content;
	private String regdate;
	
	
	
	
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
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
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Apply(){
		this(null,null,null,null,null,null);
	}
	
	
	public Apply(String name,String phone,String email,String store,String content,String regdate){
		this.name=name;
		this.phone=phone;
		this.email=email;
		this.store=store;
		this.content=content;
		this.regdate=regdate;
		
	}
	@Override
	public String toString() {
		return "Apply [name=" + name + ", phone=" + phone + ", email=" + email + ", store=" + store + ", content="
				+ content + ", regdate=" + regdate + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
