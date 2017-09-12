package com.salientcrgt.ezamendment.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	private static final Logger logger = LoggerFactory.getLogger(ScheduleAService.class);
    
    @Autowired
    private ScheduleARepository scheduleARepository;

    @Transactional(readOnly = true)
    public ScheduleA findByReportTranId(long reportId, String tranId) {
        return scheduleARepository.findByReportTranId(reportId, tranId);
    }
    
    @Transactional(readOnly = true)
    public List<ScheduleA> findByReportId(long reportId) {
        return scheduleARepository.findByReportId(reportId);
    }
    
    /**
    *
    * FEC API call to pull committee details
    *
    */
    public JSONObject getCommitteeDetails(String committee_id) {
		JSONObject jsonObject = null;
		HttpURLConnection conn = null;
		try {
			// Establishing Connection to FEC API to get Committee Details.
			StringBuilder apiURL = new StringBuilder();
			apiURL.append("https://api.open.fec.gov/v1/committee/")
				.append(committee_id).
				append("/?api_key=tXL6l6lELFouuaG2ZiLrFedd2MVx8yxPn5Jyas3y");
			URL url = new URL(apiURL.toString());
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			// Building JSONObject from API call
			BufferedReader reader = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
			jsonObject = (JSONObject) new JSONParser().parse(reader);
		} catch (MalformedURLException e) {
			logger.error(e.getMessage());
		} catch (IOException | ParseException e) {
			logger.error(e.getMessage());
		} finally {
			// close connection
			if(conn != null)
				conn.disconnect();
		}
		return jsonObject;
	}
    
    /**
    *
    * FEC API call to pull Reports by Filing Year and Form Type 
    *
    */
    public JSONObject getCommitteeReportsByYearAndFormType(String committee_id, String report_year, String form_type) {
		JSONObject jsonObject = null;
		HttpURLConnection conn = null;
		try {
			
			// Establishing Connection to FEC API to get Committee Details.
			StringBuilder apiURL = new StringBuilder();
			apiURL.append("https://api.open.fec.gov/v1/committee/")
				.append(committee_id).
				append("/filings/?api_key=tXL6l6lELFouuaG2ZiLrFedd2MVx8yxPn5Jyas3y&report_year=")
				.append(report_year);
			if(form_type != null && !form_type.equals("")) {
				apiURL.append("&form_type=")
				.append(form_type);
			}
			URL url = new URL(apiURL.toString());
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			// Building JSONObject from API call
			BufferedReader reader = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
			jsonObject = (JSONObject) new JSONParser().parse(reader);
		} catch (MalformedURLException e) {
			logger.error(e.getMessage());
		} catch (IOException | ParseException e) {
			logger.error(e.getMessage());
		} finally {
			// close connection
			if(conn != null)
				conn.disconnect();
		}
		return jsonObject;
	}
    
    /**
    *
    * merges ScheduleA in the database
    *
    */
    @Transactional
    public ScheduleA mergeScheduleA(long report_id, String tran_id, ScheduleADTO scheduleADTO) {
 		ScheduleA scheduleA = new ScheduleA(report_id, scheduleADTO.getLine_num(), 0L, scheduleADTO.getComid(), tran_id, "", 
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
	   if(StringUtils.isEmpty(scheduleADTO.getTran_id())){
		   long randomNumber=0L;
		   try {
			   randomNumber = SecureRandom.getInstanceStrong().nextLong();
			} catch (NoSuchAlgorithmException e) {
			   logger.error(e.getMessage());
			}
		   	scheduleADTO.setTran_id("SA"+randomNumber);
	   }
	   	
	   	ScheduleA scheduleA = new ScheduleA(report_id, scheduleADTO.getLine_num(), 0L, scheduleADTO.getComid(), scheduleADTO.getTran_id(), "", 
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
