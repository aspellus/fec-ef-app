package com.salientcrgt.ezamendment.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
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
	ScheduleAService scheduleAService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/committee/{committee_id}", method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
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

			// Checking for Response Code
			if (conn.getResponseCode() != 200) 
				logger.error("Failed : HTTP error code : " + conn.getResponseCode());
			
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
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/committee/{committee_id}/filings/{report_year}", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json")
	@ResponseBody
	public JSONObject getCommitteeReportsByYear(@PathVariable String committee_id, @PathVariable String report_year) {
		JSONObject jsonObject = null;
		HttpURLConnection conn = null;
		try {
			
			// Establishing Connection to FEC API to get Committee Details.
			StringBuilder apiURL = new StringBuilder();
			apiURL.append("https://api.open.fec.gov/v1/committee/")
				.append(committee_id).
				append("/filings/?api_key=tXL6l6lELFouuaG2ZiLrFedd2MVx8yxPn5Jyas3y&report_year=")
				.append(report_year);
			URL url = new URL(apiURL.toString());
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			// Checking for Response Code
			if (conn.getResponseCode() != 200) 
				logger.error("Failed : HTTP error code : " + conn.getResponseCode());
			
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
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/committee/{committee_id}/filings/{report_year}/{form_type}", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json")
	@ResponseBody
	public JSONObject getCommitteeReportsByYearAndFormType(@PathVariable String committee_id, @PathVariable String report_year, @PathVariable String form_type) {
		JSONObject jsonObject = null;
		HttpURLConnection conn = null;
		try {
			
			// Establishing Connection to FEC API to get Committee Details.
			StringBuilder apiURL = new StringBuilder();
			apiURL.append("https://api.open.fec.gov/v1/committee/")
				.append(committee_id).
				append("/filings/?api_key=tXL6l6lELFouuaG2ZiLrFedd2MVx8yxPn5Jyas3y&report_year=")
				.append(report_year)
				.append("&form_type=")
				.append(form_type);
			URL url = new URL(apiURL.toString());
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			// Checking for Response Code
			if (conn.getResponseCode() != 200) 
				logger.error("Failed : HTTP error code : " + conn.getResponseCode());
			
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
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/report/{report_id}/receipts", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json")
	@ResponseBody
	public String getScheduleAByReportId(@PathVariable long report_id) {
		String saJson = null;
		try {
			List<ScheduleA> scheduleAList = scheduleAService.findByReportId(report_id);
			System.out.println(scheduleAList);
			Gson gson = new Gson();
		    // convert your list to json
		    saJson = gson.toJson(scheduleAList);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return saJson;
	}
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<String> errorHandler(Exception exc) {
		logger.error(exc.getMessage(), exc);
	    return new ResponseEntity<>(exc.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
}

