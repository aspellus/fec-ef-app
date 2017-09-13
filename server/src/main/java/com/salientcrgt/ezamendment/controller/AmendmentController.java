package com.salientcrgt.ezamendment.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.json.simple.JSONObject;
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

	/**
	 * CORS handler to ensure that CORS-aware browsers will serve this
	 * 
	 * TODO this should be replaced with full CORS support once we are out of prototype mode
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
	public ResponseEntity handle() {
		return new ResponseEntity(HttpStatus.OK);
	}

	/**
	 *
	 * This service will return Committee basic details
	 *
	 * @param committee_id
	 * @return
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/committee/{committee_id}", produces = "application/json")
	public JSONObject getCommitteeDetails(@PathVariable String committee_id) {
		return scheduleAService.getCommitteeDetails(committee_id);
	}

	/**
	 *
	 * This service will return Filings by year and Form Type
	 *
	 * @param committee_id
	 * @param report_year
	 * @param form_type
	 * @return
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/committee/{committee_id}/filings", produces = "application/json")
	public JSONObject getCommitteeReportsByYearAndFormType(@PathVariable String committee_id,
			@RequestParam String report_year, @RequestParam(value = "", required = false) String form_type) {
		return scheduleAService.getCommitteeReportsByYearAndFormType(committee_id, report_year, form_type);
	}

	/**
	 *
	 * This service will return Receipts for a Report
	 *
	 * @param report_id
	 * @return
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/schedules/{report_id}/schedule_a", produces = "application/json")
	public ResponseList getScheduleAsByReportId(@PathVariable long report_id) {
		List<ScheduleA> scheduleAList = scheduleAService.findByReportId(report_id);
		List<Object> scheduleADTOList = scheduleAList.stream().map(ScheduleADTO::mapFromScheduleAEntity)
				.collect(Collectors.toList());
		ResponseList scheduleAResponseList = new ResponseList();
		scheduleAResponseList.setList(scheduleADTOList);
		return scheduleAResponseList;
	}

	/**
	 *
	 * This service will update a Receipt or Create a new one if it doesn't
	 * exist
	 *
	 * @param report_id
	 * @param scheduleADTO
	 * @return
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/schedules/{report_id}/schedule_a", produces = "application/json")
	public ScheduleADTO createScheduleA(@PathVariable long report_id, @RequestBody ScheduleADTO scheduleADTO) {
		ScheduleA scheduleA = scheduleAService.createScheduleA(report_id, scheduleADTO);
		return ScheduleADTO.mapFromScheduleAEntity(scheduleA);
	}

	/**
	 *
	 * This service will update a Receipt or Create a new one if it doesn't
	 * exist
	 *
	 * @param report_id
	 * @param tran_id
	 * @param scheduleADTO
	 * @return
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "*")
	@PutMapping(value = "/schedules/{report_id}/schedule_a/{tran_id}", produces = "application/json")
	public ScheduleADTO mergeScheduleA(@PathVariable long report_id, @PathVariable String tran_id,
			@RequestBody ScheduleADTO scheduleADTO) {
		ScheduleA scheduleA = scheduleAService.mergeScheduleA(report_id, tran_id, scheduleADTO);
		return ScheduleADTO.mapFromScheduleAEntity(scheduleA);
	}

	/**
	 *
	 * This service will delete a Receipt
	 *
	 * @param report_id
	 * @param tran_id
	 */
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "*")
	@DeleteMapping(value = "/schedules/{report_id}/schedule_a/{tran_id}")
	public void deleteScheduleA(@PathVariable long report_id, @PathVariable("tran_id") String tran_id) {
		scheduleAService.deleteScheduleA(report_id, tran_id);
	}

	/**
	 *
	 * ExceptionHandler for EZ Amendment Application
	 * 
	 * @param exc
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> errorHandler(Exception exc) {
		logger.error(exc.getMessage(), exc);
		return new ResponseEntity<>(exc.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
