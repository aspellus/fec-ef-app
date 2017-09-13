package com.salientcrgt.ezamendment.service;

import com.salientcrgt.ezamendment.dao.ScheduleARepository;
import com.salientcrgt.ezamendment.dto.ScheduleADTO;
import com.salientcrgt.ezamendment.model.ScheduleA;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;

/**
 * Business service for ScheduleA entity related operations
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
     * FEC API call to pull committee details
     */
    public JSONObject getCommitteeDetails(String committeeId) {
        return buildJsonFromPublicAPI(committeeId, null, null);
    }

    /**
     * FEC API call to pull Reports by Filing Year and Form Type
     */
    public JSONObject getCommitteeReportsByYearAndFormType(String committeeId, String reportYear, String formType) {
        return buildJsonFromPublicAPI(committeeId, reportYear, formType);
    }

    /**
     * merges ScheduleA in the database
     */
    @Transactional
    public ScheduleA mergeScheduleA(long reportId, String tranId, ScheduleADTO scheduleADTO) {
        scheduleADTO.setTran_id(tranId);
        ScheduleA scheduleA = buildScheduleAFromDTO(reportId, "C", scheduleADTO);
        scheduleA = scheduleARepository.merge(scheduleA);
        return scheduleA;
    }

    /**
     * creates a new ScheduleA in the database
     */
    @Transactional
    public ScheduleA createScheduleA(long reportId, ScheduleADTO scheduleADTO) {
        if (StringUtils.isEmpty(scheduleADTO.getTran_id())) {
            long randomNumber = 0L;
            try {
                randomNumber = SecureRandom.getInstanceStrong().nextLong();
            } catch (NoSuchAlgorithmException e) {
                logger.error(e.getMessage());
            }
            scheduleADTO.setTran_id("SA" + randomNumber);
        }
        ScheduleA scheduleA = buildScheduleAFromDTO(reportId, "A", scheduleADTO);
        scheduleA = scheduleARepository.create(scheduleA);
        return scheduleA;
    }

    /**
     * deletes ScheduleA from the database
     */
    @Transactional
    public void deleteScheduleA(long reportId, String tranId) {
        scheduleARepository.delete(reportId, tranId);
    }

    /**
     * @param reportId
     * @param amend
     * @param scheduleADTO
     * @return ScheduleA
     */
    private ScheduleA buildScheduleAFromDTO(long reportId, String amend, ScheduleADTO scheduleADTO) {
        ScheduleA scheduleA = new ScheduleA();
        scheduleA.setReportId(reportId);
        scheduleA.setLineNumber(scheduleADTO.getLine_num());
        scheduleA.setRelLineNumber(0L);
        scheduleA.setCommitteeId(scheduleADTO.getComid());
        scheduleA.setTranId(scheduleADTO.getTran_id());
        scheduleA.setEntityType("");
        scheduleA.setLastName(scheduleADTO.getName());
        scheduleA.setFirstName(scheduleADTO.getFname());
        scheduleA.setMiddleName(scheduleADTO.getMname());
        scheduleA.setPrefixName(scheduleADTO.getPrefix());
        scheduleA.setSuffixName(scheduleADTO.getSuffix());
        scheduleA.setStreetOne(scheduleADTO.getStr1());
        scheduleA.setStreetTwo(scheduleADTO.getStr2());
        scheduleA.setAddressCity(scheduleADTO.getCity());
        scheduleA.setAddressState(scheduleADTO.getState());
        scheduleA.setAddressZip(scheduleADTO.getZip());
        scheduleA.setElectionType("");
        scheduleA.setPgDes("");
        scheduleA.setDateTransaction(scheduleADTO.getDate_con());
        scheduleA.setTransactionAmount(scheduleADTO.getAmount());
        scheduleA.setYearToDate(scheduleADTO.getYtd());
        scheduleA.setTransDesciption(scheduleADTO.getTransdesc());
        scheduleA.setIndEmployer(scheduleADTO.getIndemp());
        scheduleA.setIndOccupation(scheduleADTO.getIndocc());
        scheduleA.setMemoCode(scheduleADTO.getMemo_code());
        scheduleA.setAmendment("C");
        return scheduleA;
    }

    /**
     * @param committeeId
     * @param reportYear
     * @param formType
     * @return
     */
    private JSONObject buildJsonFromPublicAPI(String committeeId, String reportYear, String formType) {
        JSONObject jsonObject = null;
        HttpURLConnection conn = null;
        try {
            // Establishing Connection to FEC API to get Committee Details.
	        	StringBuilder apiURL = new StringBuilder();
	   		   	apiURL.append("https://api.open.fec.gov/v1/committee/")
	   		   	.append(committeeId);
	   		   	if(StringUtils.isNotEmpty(committeeId) && StringUtils.isEmpty(reportYear) && StringUtils.isEmpty(formType)) {
	   		  	 apiURL.append("/?api_key=tXL6l6lELFouuaG2ZiLrFedd2MVx8yxPn5Jyas3y");
	   		   	}
	   		   	if(StringUtils.isNotEmpty(reportYear)) {
	   		  	 apiURL.append("/filings/?api_key=tXL6l6lELFouuaG2ZiLrFedd2MVx8yxPn5Jyas3y")
	   		  	 .append("&report_year=")
	   			   .append(reportYear);
	   		   	}
	   		   	if(StringUtils.isNotEmpty(formType)) {
	   			   apiURL.append("&form_type=")
	   			   .append(formType);
	   		   	}
            URL url = new URL(apiURL.toString());
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            // Building JSONObject from API call
            BufferedReader reader = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            jsonObject = (JSONObject) new JSONParser().parse(reader);
        } catch (IOException | ParseException e) {
            logger.error(e.getMessage());
        } finally {
            // close connection
            if (conn != null) {
                conn.disconnect();
            }
        }
        return jsonObject;
    }

    public void setScheduleARepository(ScheduleARepository scheduleARepository) {
        this.scheduleARepository = scheduleARepository;
    }
}
