package com.salientcrgt.ezamendment.service;

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

}
