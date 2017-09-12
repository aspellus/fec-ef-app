package com.salientcrgt.ezamendment.model;

import java.util.Date;

import javax.persistence.Column;
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
	@Column(name="repid")
	private long reportId;
	@Column(name="line_num")
	private String lineNumber;
	@Column(name="rel_lineno")
	private long relLineNumber;
	@Column(name="comid")
	private String committeeId;
	@Id
	@Column(name="tran_id")
	private String tranId;
	@Column(name="entity")
	private String entityType;
	@Column(name="name")
	private String lastName;
	@Column(name="fname")
	private String firstName;
	@Column(name="mname")
	private String middleName;
	@Column(name="prefix")
	private String prefixName;
	@Column(name="suffix")
	private String suffixName;
	@Column(name="str1")
	private String streetOne;
	@Column(name="str2")
	private String streetTwo;
	@Column(name="city")
	private String addressCity;
	@Column(name="state")
	private String addressState;
	@Column(name="zip")
	private String addressZip;
	@Column(name="pgo")
	private String electionType;
	@Column(name="pg_des")
	private String pgDes;
	@Column(name="date_con")
	private Date dateTransaction;
	@Column(name="amount")
	private double transactionAmount;
	@Column(name="ytd")
	private double yearToDate;
	@Column(name="reccode")
	private String recordCode;
	@Column(name="transdesc")
	private String transDesciption;
	@Column(name="limit_ind")
	private String limitInd;
	@Column(name="indemp")
	private String indEmployer;
	@Column(name="indocc")
	private String indOccupation;
	@Column(name="memo_code")
	private String memoCode;
	//Add-A, Change-C, Delete-D
	@Column(name="amend")
	private String amendment;
	
	//Default Constructor
	public ScheduleA() {
		
	}

	public long getReportId() {
		return reportId;
	}

	public void setReportId(long reportId) {
		this.reportId = reportId;
	}

	public String getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}

	public long getRelLineNumber() {
		return relLineNumber;
	}

	public void setRelLineNumber(long relLineNumber) {
		this.relLineNumber = relLineNumber;
	}

	public String getCommitteeId() {
		return committeeId;
	}

	public void setCommitteeId(String committeeId) {
		this.committeeId = committeeId;
	}

	public String getTranId() {
		return tranId;
	}

	public void setTranId(String tranId) {
		this.tranId = tranId;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPrefixName() {
		return prefixName;
	}

	public void setPrefixName(String prefixName) {
		this.prefixName = prefixName;
	}

	public String getSuffixName() {
		return suffixName;
	}

	public void setSuffixName(String suffixName) {
		this.suffixName = suffixName;
	}

	public String getStreetOne() {
		return streetOne;
	}

	public void setStreetOne(String streetOne) {
		this.streetOne = streetOne;
	}

	public String getStreetTwo() {
		return streetTwo;
	}

	public void setStreetTwo(String streetTwo) {
		this.streetTwo = streetTwo;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressState() {
		return addressState;
	}

	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}

	public String getAddressZip() {
		return addressZip;
	}

	public void setAddressZip(String addressZip) {
		this.addressZip = addressZip;
	}

	public String getElectionType() {
		return electionType;
	}

	public void setElectionType(String electionType) {
		this.electionType = electionType;
	}

	public String getPgDes() {
		return pgDes;
	}

	public void setPgDes(String pgDes) {
		this.pgDes = pgDes;
	}

	public Date getDateTransaction() {
		return dateTransaction;
	}

	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public double getYearToDate() {
		return yearToDate;
	}

	public void setYearToDate(double yearToDate) {
		this.yearToDate = yearToDate;
	}

	public String getRecordCode() {
		return recordCode;
	}

	public void setRecordCode(String recordCode) {
		this.recordCode = recordCode;
	}

	public String getTransDesciption() {
		return transDesciption;
	}

	public void setTransDesciption(String transDesciption) {
		this.transDesciption = transDesciption;
	}

	public String getLimitInd() {
		return limitInd;
	}

	public void setLimitInd(String limitInd) {
		this.limitInd = limitInd;
	}

	public String getIndEmployer() {
		return indEmployer;
	}

	public void setIndEmployer(String indEmployer) {
		this.indEmployer = indEmployer;
	}

	public String getIndOccupation() {
		return indOccupation;
	}

	public void setIndOccupation(String indOccupation) {
		this.indOccupation = indOccupation;
	}

	public String getMemoCode() {
		return memoCode;
	}

	public void setMemoCode(String memoCode) {
		this.memoCode = memoCode;
	}

	public String getAmendment() {
		return amendment;
	}

	public void setAmendment(String amendment) {
		this.amendment = amendment;
	}
	
}
