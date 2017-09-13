package com.salientcrgt.ezamendment.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.dom4j.tree.AbstractEntity;

/**
 * The ScheduleA JPA entity.
 * @author spanyala
 *
 */
@Entity
@Table(name = "sched_a")
public final class ScheduleA extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1915138817685864614L;
	@Id
	@Column(name = "repid")
	private long reportId;
	@Column(name = "line_num")
	private String lineNumber;
	@Column(name = "rel_lineno")
	private long relLineNumber;
	@Column(name = "comid")
	private String committeeId;
	@Id
	@Column(name = "tran_id")
	private String tranId;
	@Column(name = "entity")
	private String entityType;
	@Column(name = "name")
	private String lastName;
	@Column(name = "fname")
	private String firstName;
	@Column(name = "mname")
	private String middleName;
	@Column(name = "prefix")
	private String prefixName;
	@Column(name = "suffix")
	private String suffixName;
	@Column(name = "str1")
	private String streetOne;
	@Column(name = "str2")
	private String streetTwo;
	@Column(name = "city")
	private String addressCity;
	@Column(name = "state")
	private String addressState;
	@Column(name = "zip")
	private String addressZip;
	@Column(name = "pgo")
	private String electionType;
	@Column(name = "pg_des")
	private String pgDes;
	@Column(name = "date_con")
	private Date dateTransaction;
	@Column(name = "amount")
	private double transactionAmount;
	@Column(name = "ytd")
	private double yearToDate;
	@Column(name = "reccode")
	private String recordCode;
	@Column(name = "transdesc")
	private String transDesciption;
	@Column(name = "limit_ind")
	private String limitInd;
	@Column(name = "indemp")
	private String indEmployer;
	@Column(name = "indocc")
	private String indOccupation;
	@Column(name = "memo_code")
	private String memoCode;
	// Add-A, Change-C, Delete-D
	@Column(name = "amend")
	private String amendment;

	/**
	 * @return the reportId
	 */
	public final long getReportId() {
		return reportId;
	}

	/**
	 * @param reportId
	 *            the reportId to set
	 */
	public final void setReportId(long reportId) {
		this.reportId = reportId;
	}

	/**
	 * @return the lineNumber
	 */
	public final String getLineNumber() {
		return lineNumber;
	}

	/**
	 * @param lineNumber
	 *            the lineNumber to set
	 */
	public final void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}

	/**
	 * @return the relLineNumber
	 */
	public final long getRelLineNumber() {
		return relLineNumber;
	}

	/**
	 * @param relLineNumber
	 *            the relLineNumber to set
	 */
	public final void setRelLineNumber(long relLineNumber) {
		this.relLineNumber = relLineNumber;
	}

	/**
	 * @return the committeeId
	 */
	public final String getCommitteeId() {
		return committeeId;
	}

	/**
	 * @param committeeId
	 *            the committeeId to set
	 */
	public final void setCommitteeId(String committeeId) {
		this.committeeId = committeeId;
	}

	/**
	 * @return the tranId
	 */
	public final String getTranId() {
		return tranId;
	}

	/**
	 * @param tranId
	 *            the tranId to set
	 */
	public final void setTranId(String tranId) {
		this.tranId = tranId;
	}

	/**
	 * @return the entityType
	 */
	public final String getEntityType() {
		return entityType;
	}

	/**
	 * @param entityType
	 *            the entityType to set
	 */
	public final void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	/**
	 * @return the lastName
	 */
	public final String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public final String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the middleName
	 */
	public final String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName
	 *            the middleName to set
	 */
	public final void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the prefixName
	 */
	public final String getPrefixName() {
		return prefixName;
	}

	/**
	 * @param prefixName
	 *            the prefixName to set
	 */
	public final void setPrefixName(String prefixName) {
		this.prefixName = prefixName;
	}

	/**
	 * @return the suffixName
	 */
	public final String getSuffixName() {
		return suffixName;
	}

	/**
	 * @param suffixName
	 *            the suffixName to set
	 */
	public final void setSuffixName(String suffixName) {
		this.suffixName = suffixName;
	}

	/**
	 * @return the streetOne
	 */
	public final String getStreetOne() {
		return streetOne;
	}

	/**
	 * @param streetOne
	 *            the streetOne to set
	 */
	public final void setStreetOne(String streetOne) {
		this.streetOne = streetOne;
	}

	/**
	 * @return the streetTwo
	 */
	public final String getStreetTwo() {
		return streetTwo;
	}

	/**
	 * @param streetTwo
	 *            the streetTwo to set
	 */
	public final void setStreetTwo(String streetTwo) {
		this.streetTwo = streetTwo;
	}

	/**
	 * @return the addressCity
	 */
	public final String getAddressCity() {
		return addressCity;
	}

	/**
	 * @param addressCity
	 *            the addressCity to set
	 */
	public final void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	/**
	 * @return the addressState
	 */
	public final String getAddressState() {
		return addressState;
	}

	/**
	 * @param addressState
	 *            the addressState to set
	 */
	public final void setAddressState(String addressState) {
		this.addressState = addressState;
	}

	/**
	 * @return the addressZip
	 */
	public final String getAddressZip() {
		return addressZip;
	}

	/**
	 * @param addressZip
	 *            the addressZip to set
	 */
	public final void setAddressZip(String addressZip) {
		this.addressZip = addressZip;
	}

	/**
	 * @return the electionType
	 */
	public final String getElectionType() {
		return electionType;
	}

	/**
	 * @param electionType
	 *            the electionType to set
	 */
	public final void setElectionType(String electionType) {
		this.electionType = electionType;
	}

	/**
	 * @return the pgDes
	 */
	public final String getPgDes() {
		return pgDes;
	}

	/**
	 * @param pgDes
	 *            the pgDes to set
	 */
	public final void setPgDes(String pgDes) {
		this.pgDes = pgDes;
	}

	/**
	 * @return the dateTransaction
	 */
	public final Date getDateTransaction() {
		return dateTransaction;
	}

	/**
	 * @param dateTransaction
	 *            the dateTransaction to set
	 */
	public final void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	/**
	 * @return the transactionAmount
	 */
	public final double getTransactionAmount() {
		return transactionAmount;
	}

	/**
	 * @param transactionAmount
	 *            the transactionAmount to set
	 */
	public final void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	/**
	 * @return the yearToDate
	 */
	public final double getYearToDate() {
		return yearToDate;
	}

	/**
	 * @param yearToDate
	 *            the yearToDate to set
	 */
	public final void setYearToDate(double yearToDate) {
		this.yearToDate = yearToDate;
	}

	/**
	 * @return the recordCode
	 */
	public final String getRecordCode() {
		return recordCode;
	}

	/**
	 * @param recordCode
	 *            the recordCode to set
	 */
	public final void setRecordCode(String recordCode) {
		this.recordCode = recordCode;
	}

	/**
	 * @return the transDesciption
	 */
	public final String getTransDesciption() {
		return transDesciption;
	}

	/**
	 * @param transDesciption
	 *            the transDesciption to set
	 */
	public final void setTransDesciption(String transDesciption) {
		this.transDesciption = transDesciption;
	}

	/**
	 * @return the limitInd
	 */
	public final String getLimitInd() {
		return limitInd;
	}

	/**
	 * @param limitInd
	 *            the limitInd to set
	 */
	public final void setLimitInd(String limitInd) {
		this.limitInd = limitInd;
	}

	/**
	 * @return the indEmployer
	 */
	public final String getIndEmployer() {
		return indEmployer;
	}

	/**
	 * @param indEmployer
	 *            the indEmployer to set
	 */
	public final void setIndEmployer(String indEmployer) {
		this.indEmployer = indEmployer;
	}

	/**
	 * @return the indOccupation
	 */
	public final String getIndOccupation() {
		return indOccupation;
	}

	/**
	 * @param indOccupation
	 *            the indOccupation to set
	 */
	public final void setIndOccupation(String indOccupation) {
		this.indOccupation = indOccupation;
	}

	/**
	 * @return the memoCode
	 */
	public final String getMemoCode() {
		return memoCode;
	}

	/**
	 * @param memoCode
	 *            the memoCode to set
	 */
	public final void setMemoCode(String memoCode) {
		this.memoCode = memoCode;
	}

	/**
	 * @return the amendment
	 */
	public final String getAmendment() {
		return amendment;
	}

	/**
	 * @param amendment
	 *            the amendment to set
	 */
	public final void setAmendment(String amendment) {
		this.amendment = amendment;
	}

}
