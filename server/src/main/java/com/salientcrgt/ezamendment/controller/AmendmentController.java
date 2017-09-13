package com.salientcrgt.ezamendment.controller;

import com.salientcrgt.ezamendment.dto.ResponseList;
import com.salientcrgt.ezamendment.dto.ScheduleADTO;
import com.salientcrgt.ezamendment.model.ScheduleA;
import com.salientcrgt.ezamendment.service.ScheduleAService;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
     * CORS handler to ensure that CORS-aware browsers will serve this TODO this
     * should be replaced with full CORS support once we are out of prototype
     * mode
     *
     * @return OK - 200
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    public ResponseEntity handle() {
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * This service will return Committee basic details
     *
     * @param committeeId committee id
     * @return Committee in JSON
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "*")
    @GetMapping(value = "/committee/{committee_id}", produces = "application/json")
    public JSONObject getCommitteeDetails(@PathVariable("committee_id") String committeeId) {
        return scheduleAService.getCommitteeDetails(committeeId);
    }

    /**
     * This service will return Filings by year and Form Type
     *
     * @param committeeId committee id
     * @param reportYear  report year
     * @param formType    form type
     * @return Filings matching filters in JSON
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "*")
    @GetMapping(value = "/committee/{committee_id}/filings", produces = "application/json")
    public JSONObject getCommitteeReportsByYearAndFormType(@PathVariable("committee_id") String committeeId,
                                                           @RequestParam("report_year") String reportYear,
                                                           @RequestParam(name = "form_type", value = "", required = false) String formType) {
        return scheduleAService.getCommitteeReportsByYearAndFormType(committeeId, reportYear, formType);
    }

    /**
     * This service will return Receipts for a Report
     *
     * @param reportId report id
     * @return Receipts for specified report
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "*")
    @GetMapping(value = "/schedules/{report_id}/schedule_a", produces = "application/json")
    public ResponseList getScheduleAsByReportId(@PathVariable("report_id") long reportId) {
        List<ScheduleA> scheduleAList = scheduleAService.findByReportId(reportId);
        List<Object> scheduleADTOList = scheduleAList.stream().map(ScheduleADTO::mapFromScheduleAEntity)
                .collect(Collectors.toList());
        ResponseList scheduleAResponseList = new ResponseList();
        scheduleAResponseList.setList(scheduleADTOList);
        return scheduleAResponseList;
    }

    /**
     * This service will update a Receipt or Create a new one if it doesn't
     * exist
     *
     * @param reportId     report id
     * @param scheduleADTO schedule A
     * @return resulting transaction
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin(origins = "*")
    @PostMapping(value = "/schedules/{report_id}/schedule_a", produces = "application/json")
    public ScheduleADTO createScheduleA(@PathVariable("report_id") long reportId,
                                        @RequestBody ScheduleADTO scheduleADTO) {
        ScheduleA scheduleA = scheduleAService.createScheduleA(reportId, scheduleADTO);
        return ScheduleADTO.mapFromScheduleAEntity(scheduleA);
    }

    /**
     * This service will update a Receipt or Create a new one if it doesn't
     * exist
     *
     * @param reportId     report id
     * @param tranId       transaction id
     * @param scheduleADTO scheduleA
     * @return resulting schedule
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "*")
    @PutMapping(value = "/schedules/{report_id}/schedule_a/{tran_id}", produces = "application/json")
    public ScheduleADTO mergeScheduleA(@PathVariable("report_id") long reportId, @PathVariable("tran_id") String tranId,
                                       @RequestBody ScheduleADTO scheduleADTO) {
        ScheduleA scheduleA = scheduleAService.mergeScheduleA(reportId, tranId, scheduleADTO);
        return ScheduleADTO.mapFromScheduleAEntity(scheduleA);
    }

    /**
     * This service will delete a Receipt
     *
     * @param reportId report id
     * @param tranId   transactin id
     */
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "*")
    @DeleteMapping(value = "/schedules/{report_id}/schedule_a/{tran_id}")
    public void deleteScheduleA(@PathVariable("report_id") long reportId, @PathVariable("tran_id") String tranId) {
        scheduleAService.deleteScheduleA(reportId, tranId);
    }

    /**
     * ExceptionHandler for EZ Amendment Application
     *
     * @param exc exception
     * @return generic response to unexpected requests
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> errorHandler(Exception exc) {
        logger.error(exc.getMessage(), exc);
        return new ResponseEntity<>(exc.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
