package com.salientcrgt.ezamendment.service;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.salientcrgt.ezamendment.controller.AmendmentController;
import com.salientcrgt.ezamendment.dao.ScheduleARepository;
import com.salientcrgt.ezamendment.dto.ScheduleADTO;
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
    * merges ScheduleA in the database
    *
    */
    @Transactional
    public ScheduleA mergeScheduleA(long report_id, ScheduleADTO scheduleADTO) {
 		ScheduleA scheduleA = new ScheduleA(scheduleADTO.getRepid(), scheduleADTO.getLine_num(), 0L, scheduleADTO.getComid(), scheduleADTO.getTran_id(), "", 
												scheduleADTO.getName(), scheduleADTO.getFname(), scheduleADTO.getMname(),scheduleADTO.getPrefix(), 
												scheduleADTO.getSuffix(), scheduleADTO.getStr1(), scheduleADTO.getStr2(), scheduleADTO.getCity(), scheduleADTO.getState(), 
												scheduleADTO.getZip(), "", "", scheduleADTO.getDate_con(), scheduleADTO.getAmount(), scheduleADTO.getYtd(), 
												scheduleADTO.getTransdesc(), scheduleADTO.getIndemp(), scheduleADTO.getIndocc(), scheduleADTO.getMemo_code(), "C");
 		scheduleA = scheduleARepository.merge(scheduleA);
 		return scheduleA;
    } 
    
   
   /**
   *
   * creates a new ScheduleA in the database
   *
   */
   @Transactional
   public ScheduleA createScheduleA(long report_id, ScheduleADTO scheduleADTO) {
	   	if(scheduleADTO.getTran_id() != null || !scheduleADTO.getTran_id().trim().equals("")) {
	   		//Tran ID has been generated from Front End 
	   	} else {
	   		//assuming it's empty and generating Tran ID
	   		long randomNumber = new Random().nextLong();
	   		scheduleADTO.setTran_id("SA-"+randomNumber);
	   	}
 		ScheduleA scheduleA = new ScheduleA(scheduleADTO.getRepid(), scheduleADTO.getLine_num(), 0L, scheduleADTO.getComid(), scheduleADTO.getTran_id(), "", 
 												scheduleADTO.getName(), scheduleADTO.getFname(), scheduleADTO.getMname(),scheduleADTO.getPrefix(), 
 												scheduleADTO.getSuffix(), scheduleADTO.getStr1(), scheduleADTO.getStr2(), scheduleADTO.getCity(), scheduleADTO.getState(), 
 												scheduleADTO.getZip(), "", "", scheduleADTO.getDate_con(), scheduleADTO.getAmount(), scheduleADTO.getYtd(), 
 												scheduleADTO.getTransdesc(), scheduleADTO.getIndemp(), scheduleADTO.getIndocc(), scheduleADTO.getMemo_code(), "A");
 		scheduleA = scheduleARepository.create(scheduleA);
 		return scheduleA;
   } 
   
  /**
  *
  * deletes ScheduleA from the database
  *
  */
  @Transactional
  public void deleteScheduleA(long report_id, String tran_id) {
		scheduleARepository.delete(report_id, tran_id);
  }

}
