package com.hani.notice;

import java.sql.Date;

public class NoticeDTO {
	
	private long nnum;
	private String title;
	private String contenst;
	private String writer;
	private Date rdate;
	private long views;
	
	
	public long getNnum() {
		return nnum;
	}
	public void setNnum(long nnum) {
		this.nnum = nnum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContenst() {
		return contenst;
	}
	public void setContenst(String contenst) {
		this.contenst = contenst;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	public long getViews() {
		return views;
	}
	public void setViews(long views) {
		this.views = views;
	}
	
	
}