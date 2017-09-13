package com.salientcrgt.ezamendment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.salientcrgt.ezamendment.model.ScheduleA;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * JSON-serializable DTO containing ScheduleA data.
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
    private Date date_con;
    private double amount;
    private double ytd;
    private String transdesc;
    private String indemp;
    private String indocc;
    private String memo_code;
    private String amend;

    /**
     * This is Default Constructor.
     */
    public ScheduleADTO() {

    }

    public static ScheduleADTO mapFromScheduleAEntity(ScheduleA scheduleA) {
        ScheduleADTO schedule = new ScheduleADTO();
        schedule.setRepid(scheduleA.getReportId());
        schedule.setLine_num(scheduleA.getLineNumber());
        schedule.setComid(scheduleA.getCommitteeId());
        schedule.setTran_id(scheduleA.getTranId());
        schedule.setName(scheduleA.getLastName());
        schedule.setFname(scheduleA.getFirstName());
        schedule.setMname(scheduleA.getMiddleName());
        schedule.setPrefix(scheduleA.getPrefixName());
        schedule.setSuffix(scheduleA.getSuffixName());
        schedule.setStr1(scheduleA.getStreetOne());
        schedule.setStr2(scheduleA.getStreetTwo());
        schedule.setCity(scheduleA.getAddressCity());
        schedule.setState(scheduleA.getAddressState());
        schedule.setZip(scheduleA.getAddressZip());
        schedule.setDate_con(scheduleA.getDateTransaction());
        schedule.setAmount(scheduleA.getTransactionAmount());
        schedule.setYtd(scheduleA.getYearToDate());
        schedule.setTransdesc(scheduleA.getTransDesciption());
        schedule.setIndemp(scheduleA.getIndEmployer());
        schedule.setIndocc(scheduleA.getIndOccupation());
        schedule.setMemo_code(scheduleA.getMemoCode());
        schedule.setAmend(scheduleA.getAmendment());
        return schedule;
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
