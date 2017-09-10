package com.salientcrgt.ezamendment.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.dom4j.tree.AbstractEntity;

/**
*
* The ScheduleA JPA entity.
*
*/
@Entity
@Table(name = "sched_a")

public class ScheduleA  extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1915138817685864614L;
	@Id
	private long repid;
	private String line_num;
	private long rel_lineno;
	private String comid;
	@Id
	private String tran_id;
	private String entity;
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
	private String pgo;
	private String pg_des;
	private Date date_con;
	private double amount;
	private double ytd;
	private String reccode;
	private String transdesc;
	private String limit_ind;
	private String indemp;
	private String indocc;
	private String memo_code;
	//Add-A, Change-C, Delete-D
	private String amend;
	
	public ScheduleA() {
		
	}
	
	public ScheduleA(long repid, String line_num, long rel_lineno, String comid, String tran_id, String entity, String name, 
			String fname, String mname, String prefix, String suffix, String str1, String str2, String city, String state,
			String zip, String pgo, String pg_des, Date date_con, double amount, double ytd, String transdesc, String indemp, 
			String indocc, String memo_code, String amend) {
		this.repid = repid;
		this.line_num = line_num;
		this.rel_lineno = rel_lineno;
		this.comid = comid;
		this.tran_id = tran_id;
		this.entity = entity;
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
		this.pgo = pgo;
		this.pg_des = pg_des;
		this.date_con = date_con;
		this.amount = amount;
		this.ytd = ytd;
		this.transdesc = transdesc;
		this.indemp = indemp;
		this.indocc = indocc;
		this.memo_code = memo_code;
		this.amend = amend;
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

	public long getRel_lineno() {
		return rel_lineno;
	}

	public void setRel_lineno(long rel_lineno) {
		this.rel_lineno = rel_lineno;
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

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
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

	public String getPgo() {
		return pgo;
	}

	public void setPgo(String pgo) {
		this.pgo = pgo;
	}

	public String getPg_des() {
		return pg_des;
	}

	public void setPg_des(String pg_des) {
		this.pg_des = pg_des;
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

	public String getReccode() {
		return reccode;
	}

	public void setReccode(String reccode) {
		this.reccode = reccode;
	}

	public String getTransdesc() {
		return transdesc;
	}

	public void setTransdesc(String transdesc) {
		this.transdesc = transdesc;
	}

	public String getLimit_ind() {
		return limit_ind;
	}

	public void setLimit_ind(String limit_ind) {
		this.limit_ind = limit_ind;
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
