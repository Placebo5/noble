package com.noble.vo;

public class PromotionVO {
//promotion
	private String pro_no;
	private String pro_type;
	private String user_no;
	private String user_tel;
	private String pro_contents1;
	private String pro_contents2;
	private String atch_file1_nm;
	private String atch_file1_nm_summary;
	private String atch_file2_nm;
	private String atch_file2_nm_summary;
	private String res_date;
//protime
	private String protime_no;
	private String [] week_day;
	private String [] start_time;
	private String [] end_time;
	private String [] holiday;
	private String pro_unit;
	private String [] holidayArr;
	private String [] pro_noArr;
	private String [] pro_unitArr;
	public String getAtch_file1_nm() {
		return atch_file1_nm;
	}
	public void setAtch_file1_nm(String atch_file1_nm) {
		this.atch_file1_nm = atch_file1_nm;
	}
	public String getAtch_file1_nm_summary() {
		return atch_file1_nm_summary;
	}
	public void setAtch_file1_nm_summary(String atch_file1_nm_summary) {
		this.atch_file1_nm_summary = atch_file1_nm_summary;
	}
	public String getAtch_file2_nm() {
		return atch_file2_nm;
	}
	public void setAtch_file2_nm(String atch_file2_nm) {
		this.atch_file2_nm = atch_file2_nm;
	}
	public String getAtch_file2_nm_summary() {
		return atch_file2_nm_summary;
	}
	public void setAtch_file2_nm_summary(String atch_file2_nm_summary) {
		this.atch_file2_nm_summary = atch_file2_nm_summary;
	}
	public String getPro_no() {
		return pro_no;
	}
	public void setPro_no(String pro_no) {
		this.pro_no = pro_no;
	}
	public String getPro_type() {
		return pro_type;
	}
	public void setPro_type(String pro_type) {
		this.pro_type = pro_type;
	}
	public String getUser_no() {
		return user_no;
	}
	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}
	public String getUser_tel() {
		return user_tel;
	}
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}
	public String getPro_contents1() {
		return pro_contents1;
	}
	public void setPro_contents1(String pro_contents1) {
		this.pro_contents1 = pro_contents1;
	}
	public String getPro_contents2() {
		return pro_contents2;
	}
	public void setPro_contents2(String pro_contents2) {
		this.pro_contents2 = pro_contents2;
	}
	public String getRes_date() {
		return res_date;
	}
	public void setRes_date(String res_date) {
		this.res_date = res_date;
	}
	public String getProtime_no() {
		return protime_no;
	}
	public void setProtime_no(String protime_no) {
		this.protime_no = protime_no;
	}
	public String[] getWeek_day() {
		return week_day;
	}
	public void setWeek_day(String[] week_day) {
		this.week_day = week_day;
	}
	public String[] getStart_time() {
		return start_time;
	}
	public void setStart_time(String[] start_time) {
		this.start_time = start_time;
	}
	public String[] getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String[] end_time) {
		this.end_time = end_time;
	}
	public String[] getHoliday() {
		return holiday;
	}
	public void setHoliday(String[] holiday) {
		this.holiday = holiday;
	}
	public String getPro_unit() {
		return pro_unit;
	}
	public void setPro_unit(String pro_unit) {
		this.pro_unit = pro_unit;
	}
	public String[] getHolidayArr() {
		return holidayArr;
	}
	public void setHolidayArr(String[] holidayArr) {
		this.holidayArr = holidayArr;
	}
	public String[] getPro_noArr() {
		return pro_noArr;
	}
	public void setPro_noArr(String[] pro_noArr) {
		this.pro_noArr = pro_noArr;
	}
	public String[] getPro_unitArr() {
		return pro_unitArr;
	}
	public void setPro_unitArr(String[] pro_unitArr) {
		this.pro_unitArr = pro_unitArr;
	}
}
