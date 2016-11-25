package spms.vo;

import java.util.Date;

public class Member {
	protected int 		no;
	protected String 	name;
	protected String 	email;
	protected String 	password;
	protected Date		createdDate;
	protected Date		modifiedDate;
	protected String    sex;
	protected String    p_num;
	protected String    hobby;
	protected int    age;
	protected int point;
	
	public int getNo() {
		return no;
	}
	public Member setNo(int no) {
		this.no = no;
		return this;
	}
	public int getPoint(){
		return point;
	}
	public Member setPoint(int point){
		this.point = point;
		return this;
	}
	public String getName() {
		return name;
	}
	public Member setName(String name) {
		this.name = name;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public Member setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public String getSex(){
		return sex;
	}
	public String getPnum(){
		return p_num;
	}
	public String getHobby(){
		return hobby;
	}
	public int getAge(){
		return age;
	}
	public Member setPassword(String password) {
		this.password = password;
		return this;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public Member setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
		return this;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public Member setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
		return this;
	}
	public Member setSex(String sex){
		this.sex = sex;
		return this;
	}
	public Member setPnum(String p_num){
		this.p_num = p_num;
		return this;
	}
	public Member setHobby(String hobby){
		this.hobby = hobby;
		return this;
	}
	public Member setAge(int age){
		this.age = age;
		return this;
	}
}
