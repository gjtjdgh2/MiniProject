package com.miniProject;

public class PhoneBookVo {
 
	private int id;
	private String name;
	private String hp;
	private String tel;
	
	public PhoneBookVo() {
		
	}
	public PhoneBookVo(int id) {
		this.id=id;
	}
	public PhoneBookVo(String name,String hp,String tel) {
		this.name=name;
		this.hp = hp;
		this.tel=tel;
	}
	
	public PhoneBookVo(int id,String name,String hp,String tel) {
	this(name,hp,tel);
	this.id=id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	} 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "PhoneBookVo [id=" + id + ", name=" + name + ", hp=" + hp + ", tel=" + tel + "]";
	}

	
}