package com.salientcrgt.ezamendment.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.salientcrgt.ezamendment.dto.ResponseList;
import com.salientcrgt.ezamendment.dto.ScheduleADTO;
import com.salientcrgt.ezamendment.model.ScheduleA;
import com.salientcrgt.ezamendment.service.ScheduleAService;

/*
 * AmendmentController This is the master REST controller using spring 4.3.10
 * 
 * It implements a method for each web request possible within the system. 
 * Currently this class has a method to invoke FEC OpenAPI and return JSONObject 
 * 
 */

@RestController
public class AmendmentController {
	
	private static final Logger logger = LoggerFactory.getLogger(AmendmentController.class);
	
	@Autowired
	private ScheduleAService scheduleAService;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    public ResponseEntity handle() {
        return new ResponseEntity(HttpStatus.OK);
    }
	
	/**
    *
    * This service will return Committee basic details
    *
    */
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/committee/{committee_id}", produces = "application/json")
	public JSONObject getCommitteeDetails(@PathVariable String committee_id) {
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
		} catch (IOException e) {
			logger.error(e.getMessage());
		} catch (ParseException e) {
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
    * This service will return Filings by year and Form Type
    *
    */
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/committee/{committee_id}/filings", produces = "application/json")
	public JSONObject getCommitteeReportsByYearAndFormType(@PathVariable String committee_id, @RequestParam String report_year, @RequestParam(value="", required=false) String form_type) {
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
		} catch (IOException e) {
			logger.error(e.getMessage());
		} catch (ParseException e) {
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
    * This service will return Receipts for a Report
    *
    */
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/schedules/{report_id}/schedule_a", produces = "application/json")
	public ResponseList getScheduleAsByReportId(@PathVariable long report_id) {
		List<ScheduleA> scheduleAList = scheduleAService.findByReportId(report_id);
		List<Object> scheduleADTOList = scheduleAList.stream().map(ScheduleADTO::mapFromScheduleAEntity).collect(Collectors.toList());
		ResponseList scheduleAResponseList = new ResponseList();
		scheduleAResponseList.setList(scheduleADTOList);
		return scheduleAResponseList;
	}
	
	/**
    *
    * This service will update a Receipt or Create a new one if it doesn't exist
    *
    */
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/schedules/{report_id}/schedule_a", produces = "application/json")
	public ScheduleADTO createScheduleA(@PathVariable long report_id, @RequestBody ScheduleADTO scheduleADTO) {
		ScheduleA scheduleA = scheduleAService.createScheduleA(report_id, scheduleADTO);
		return ScheduleADTO.mapFromScheduleAEntity(scheduleA);
	}
	
	/**
    *
    * This service will update a Receipt or Create a new one if it doesn't exist
    *
    */
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "*")
	@PutMapping(value = "/schedules/{report_id}/schedule_a", produces = "application/json")
	public ScheduleADTO mergeScheduleA(@PathVariable long report_id, @RequestBody ScheduleADTO scheduleADTO) {
		ScheduleA scheduleA = scheduleAService.mergeScheduleA(report_id, scheduleADTO.getTran_id(), scheduleADTO);
		return ScheduleADTO.mapFromScheduleAEntity(scheduleA);
	}
	
	/**
    *
    * This service will delete a Receipt
    *
    */
	
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "*")
	@DeleteMapping(value = "/schedules/{report_id}/schedule_a")
	public void deleteScheduleA(@PathVariable long report_id, @RequestParam("tran_id") String tran_id) {
		scheduleAService.deleteScheduleA(report_id, tran_id);
	}
	
	/**
    *
    * ExceptionHandler for EZ Amendment Application
    *
    */
	@ExceptionHandler(Exception.class)
    public ResponseEntity<String> errorHandler(Exception exc) {
		logger.error(exc.getMessage(), exc);
	    return new ResponseEntity<>(exc.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
}

