package com.salientcrgt.ezamendment.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.salientcrgt.ezamendment.controller.AmendmentController;
import com.salientcrgt.ezamendment.dao.ScheduleARepository;
import com.salientcrgt.ezamendment.model.ScheduleA;

/**
 *
 * Business service for ScheduleA entity related operations
 *
 */
@Service
public class ScheduleAService {

	private static final Logger logger = LoggerFactory.getLogger(AmendmentController.class);
    
    @Autowired
    private ScheduleARepository scheduleARepository;

    @Transactional(readOnly = true)
    public List<ScheduleA> findByReportId(long reportId) {
        return scheduleARepository.findByReportId(reportId);
    }
    
    /**
    *
    * merges a new ScheduleA in the database
    *
    */
   @Transactional
   public ScheduleA mergeScheduleA(long report_id, String committee_id, String line_num, String tran_id, String lname, String fname, String mname, 
								String prefix, String suffix, String str1, String str2, String city, String state, String zip, Date date_con, 
								double amount, String transdesc, String indemp, String indocc, String memo_code) {
		ScheduleA scheduleA = new ScheduleA(report_id, line_num, 0L, committee_id, tran_id, "", lname, fname, mname, 
				   								prefix, suffix, str1, str2, city, state, zip, "", "", date_con, 
				   								amount, 0d, transdesc, indemp, indocc, memo_code);
		scheduleA = scheduleARepository.merge(scheduleA);
		return scheduleA;
   }
   
   /**
   *
   * creates a new ScheduleA in the database
   *
   */
  @Transactional
  public ScheduleA createScheduleA(long report_id, String committee_id, String line_num, String tran_id, String lname, String fname, String mname, 
								String prefix, String suffix, String str1, String str2, String city, String state, String zip, Date date_con, 
								double amount, String transdesc, String indemp, String indocc, String memo_code) {
		ScheduleA scheduleA = new ScheduleA(report_id, line_num, 0L, committee_id, tran_id, "", lname, fname, mname, 
				   								prefix, suffix, str1, str2, city, state, zip, "", "", date_con, 
				   								amount, 0d, transdesc, indemp, indocc, memo_code);
		scheduleA = scheduleARepository.create(scheduleA);
		return scheduleA;
  }
  
  /**
  *
  * creates a new ScheduleA in the database
  *
  */
  @Transactional
  public void deleteScheduleA(long report_id, String tran_id) {
		scheduleARepository.delete(report_id, tran_id);
  }

}
