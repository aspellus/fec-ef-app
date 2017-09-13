package com.salientcrgt.ezamendment.test;

import com.salientcrgt.ezamendment.dao.ScheduleARepository;
import com.salientcrgt.ezamendment.dto.ScheduleADTO;
import com.salientcrgt.ezamendment.model.ScheduleA;
import com.salientcrgt.ezamendment.service.ScheduleAService;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class ScheduleAServiceTest {

    @Mock
    private ScheduleARepository scheduleARepository;

    private ScheduleAService service;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        service = new ScheduleAService();
        service.setScheduleARepository(scheduleARepository);
    }

    @Test
    public void shouldReturnReportTranById() {

        ScheduleA scheduleA = new ScheduleA();
        scheduleA.setTranId("ID");
        scheduleA.setReportId(1L);

        when(scheduleARepository.findByReportTranId(1L, "ID")).thenReturn(scheduleA);
        ScheduleA ret = service.findByReportTranId(1L, "ID");
        Assert.assertTrue(ret.getTranId().equals("ID"));
        Assert.assertTrue(ret.getReportId() == 1L);

    }

    @Test
    public void shouldReturnReportByIdList() {

        ScheduleA scheduleA = new ScheduleA();
        scheduleA.setReportId(1L);
        List<ScheduleA> list = new ArrayList<ScheduleA>(1);
        list.add(scheduleA);

        when(scheduleARepository.findByReportId(1L)).thenReturn(list);
        List<ScheduleA> retList = service.findByReportId(1L);
        Assert.assertTrue(retList.size() == 1);
        Assert.assertTrue(retList.get(0).getReportId() == 1L);

    }

    @Test
    public void shouldMergeScheduleA() {

        ScheduleA scheduleA = new ScheduleA();
        scheduleA.setReportId(1L);

        when(scheduleARepository.merge(any(ScheduleA.class))).thenReturn(scheduleA);
        ScheduleA ret = service.mergeScheduleA(scheduleA.getReportId(), "TEST", new ScheduleADTO());
        Assert.assertTrue(ret.getReportId() == 1L);

    }

    @Test
    @Ignore
    public void shouldCreateScheduleAWithRandomTranId() {

        ScheduleA scheduleA = new ScheduleA();
        scheduleA.setReportId(1L);

        when(scheduleARepository.create(any(ScheduleA.class))).thenReturn(scheduleA);
        ScheduleA ret = service.createScheduleA(scheduleA.getReportId(), new ScheduleADTO());
        Assert.assertTrue(ret != null);
        Assert.assertTrue(ret.getTranId().startsWith("SA"));

    }

    @Test
    public void shouldCreateScheduleA() {

        ScheduleA scheduleA = new ScheduleA();
        scheduleA.setReportId(1L);

        ScheduleADTO scheduleADTO = new ScheduleADTO();
        scheduleADTO.setTran_id("TEST");

        when(scheduleARepository.create(any(ScheduleA.class))).thenReturn(scheduleA);
        ScheduleA ret = service.createScheduleA(scheduleA.getReportId(), scheduleADTO);
        Assert.assertTrue(ret != null);
    }

    @Test
    public void shouldReturnGivenCommitteeDetails() {

        JSONObject ret = service.getCommitteeDetails("C00577759");
        Assert.assertTrue(ret != null);

    }

    @Test
    public void shouldReturnGivengetCommitteeReportsByYearAndFormType() {

        JSONObject ret = service.getCommitteeReportsByYearAndFormType("C00577759", "2017", "F3");
        Assert.assertTrue(ret != null);

    }

}
