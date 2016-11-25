package spms.vo;

import java.util.Date;

public class Board {
	protected int 		no;
	protected String 	name;
	protected String 	text;
	protected Date		createdDate;
	
	public int getNo() {
		return no;
	}
	public Board setNo(int no) {
		this.no = no;
		return this;
	}
	public String getText() {
		return text;
	}
	public Board setText(String content) {
		this.text = content;
		return this;
	}
	public String getName() {
		return name;
	}
	public Board setName(String name) {
		this.name = name;
		return this;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public Board setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
		return this;
	}
}
