package spms.vo;

import java.util.Date;

public class Message {
	protected int 		no;
	protected int       delno;
	protected String 	title;
	protected String 	content;
	protected String 	name;
	protected Date		createdDate;
	
	public int getNo() {
		return no;
	}
	public Message setNo(int no) {
		this.no = no;
		return this;
	}
	public int getDelno(){
		return delno;
	}
	public Message setDelno(int delno){
		this.delno= delno;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public Message setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getContent() {
		return content;
	}
	public Message setContent(String content) {
		this.content = content;
		return this;
	}
	public String getName() {
		return name;
	}
	public Message setName(String name) {
		this.name = name;
		return this;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public Message setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
		return this;
	}
}
