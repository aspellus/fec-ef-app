package com.salientcrgt.ezamendment.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.salientcrgt.ezamendment.model.ScheduleA;

/**
*
* JSON-serializable DTO containing ScheduleA data
*
*/
public class ScheduleADTO {

	private long repid;
	private String line_num;
	private String comid;
	private String tran_id;
	private String name;
	private String fname;
	private String mname;
	private String prefix;
	private String suffix;
	private String str1;
	private String str2;
	private String city;
	private String state;
	private String zip;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-mm-ddThh:mi:ss")
	private Date date_con;
	private double amount;
	private double ytd;
	private String transdesc;
	private String indemp;
	private String indocc;
	private String memo_code;
	private String amend;
	
	public ScheduleADTO(long repid, String comid, String line_num, String tran_id, String name, String fname, String mname, 
			String prefix, String suffix, String str1, String str2, String city, String state, String zip, Date date_con, 
			double amount, double ytd, String transdesc, String indemp, String indocc, String memo_code, String amend) {
		
		this.repid = repid;
		this.line_num = line_num;
		this.comid = comid;
		this.tran_id = tran_id;
		this.name = name;
		this.fname = fname;
		this.mname = mname;
		this.prefix = prefix;
		this.suffix = suffix;
		this.str1 = str1;
		this.str2 = str2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.date_con = date_con;
		this.amount = amount;
		this.ytd = ytd;
		this.transdesc = transdesc;
		this.indemp = indemp;
		this.indocc = indocc;
		this.memo_code = memo_code;
		this.amend = amend;
	}
	
	public static ScheduleADTO mapFromScheduleAEntity(ScheduleA scheduleA) {
        return new ScheduleADTO(scheduleA.getRepid(), scheduleA.getComid(), scheduleA.getLine_num(), scheduleA.getTran_id(), 
        		scheduleA.getName(), scheduleA.getFname(), scheduleA.getMname(), scheduleA.getPrefix(), scheduleA.getSuffix(), 
        		scheduleA.getStr1(), scheduleA.getStr2(), scheduleA.getCity(), scheduleA.getState(), scheduleA.getZip(), 
        		scheduleA.getDate_con(), scheduleA.getAmount(), scheduleA.getYtd(), scheduleA.getTransdesc(), 
        		scheduleA.getIndemp(), scheduleA.getIndocc(), scheduleA.getMemo_code(), scheduleA.getAmend());
	}
	
	public static List<ScheduleADTO> mapFromScheduleAsEntities(List<ScheduleA> scheduleAs) {
        return scheduleAs.stream().map((scheduleA) -> mapFromScheduleAEntity(scheduleA)).collect(Collectors.toList());
	}

	public long getRepid() {
		return repid;
	}

	public void setRepid(long repid) {
		this.repid = repid;
	}

	public String getLine_num() {
		return line_num;
	}

	public void setLine_num(String line_num) {
		this.line_num = line_num;
	}

	public String getComid() {
		return comid;
	}

	public void setComid(String comid) {
		this.comid = comid;
	}

	public String getTran_id() {
		return tran_id;
	}

	public void setTran_id(String tran_id) {
		this.tran_id = tran_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getStr1() {
		return str1;
	}

	public void setStr1(String str1) {
		this.str1 = str1;
	}

	public String getStr2() {
		return str2;
	}

	public void setStr2(String str2) {
		this.str2 = str2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Date getDate_con() {
		return date_con;
	}

	public void setDate_con(Date date_con) {
		this.date_con = date_con;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getYtd() {
		return ytd;
	}

	public void setYtd(double ytd) {
		this.ytd = ytd;
	}

	public String getTransdesc() {
		return transdesc;
	}

	public void setTransdesc(String transdesc) {
		this.transdesc = transdesc;
	}

	public String getIndemp() {
		return indemp;
	}

	public void setIndemp(String indemp) {
		this.indemp = indemp;
	}

	public String getIndocc() {
		return indocc;
	}

	public void setIndocc(String indocc) {
		this.indocc = indocc;
	}

	public String getMemo_code() {
		return memo_code;
	}

	public void setMemo_code(String memo_code) {
		this.memo_code = memo_code;
	}

	public String getAmend() {
		return amend;
	}

	public void setAmend(String amend) {
		this.amend = amend;
	}
}
