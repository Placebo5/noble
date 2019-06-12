package com.noble.vo;

public class CommentsVO {
	private String comm_no;
	private String user_no;
	private String come_no;
	private String come_contents;
	private String come_date;
	private String user_id;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getCome_date() {
		return come_date;
	}
	public void setCome_date(String come_date) {
		this.come_date = come_date;
	}
	public String getComm_no() {
		return comm_no;
	}
	public void setComm_no(String comm_no) {
		this.comm_no = comm_no;
	}
	public String getUser_no() {
		return user_no;
	}
	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}
	public String getCome_no() {
		return come_no;
	}
	public void setCome_no(String come_no) {
		this.come_no = come_no;
	}
	public String getCome_contents() {
		return come_contents;
	}
	public void setCome_contents(String come_contents) {
		this.come_contents = come_contents;
	}
	
}
