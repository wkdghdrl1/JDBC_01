package com.biz.jdbc.model;

public class IolistVO {
	
	
	private int io_seq;			//number
	private String io_date;		//varchar2(10 byte)
	private String io_inout;	//nvarchar2(10 char)
	private int io_amt;			//number
	private int io_price;		//number
	private int io_total;		//number
	private String io_pcode;	//varchar2(7 byte)
	private String io_ccode;		//varchar2(5 byte)
	public int getIo_seq() {
		return io_seq;
	}
	public void setIo_seq(int io_seq) {
		this.io_seq = io_seq;
	}
	public String getIo_date() {
		return io_date;
	}
	public void setIo_date(String io_date) {
		this.io_date = io_date;
	}
	public String getIo_inout() {
		return io_inout;
	}
	public void setIo_inout(String io_inout) {
		this.io_inout = io_inout;
	}
	public int getIo_amt() {
		return io_amt;
	}
	public void setIo_amt(int io_amt) {
		this.io_amt = io_amt;
	}
	public int getIo_price() {
		return io_price;
	}
	public void setIo_price(int io_price) {
		this.io_price = io_price;
	}
	public int getIo_total() {
		return io_total;
	}
	public void setIo_total(int io_total) {
		this.io_total = io_total;
	}
	public String getIo_pcode() {
		return io_pcode;
	}
	public void setIo_pcode(String io_pcode) {
		this.io_pcode = io_pcode;
	}
	public String getIo_ccode() {
		return io_ccode;
	}
	public void setIo_ccode(String io_ccode) {
		this.io_ccode = io_ccode;
	}
	@Override
	public String toString() {
		return "IolistVO [io_seq=" + io_seq + ", io_date=" + io_date + ", io_inout=" + io_inout + ", io_amt=" + io_amt
				+ ", io_price=" + io_price + ", io_total=" + io_total + ", io_pcode=" + io_pcode + ", io_ccode="
				+ io_ccode + "]";
	}
	
		
	
}
