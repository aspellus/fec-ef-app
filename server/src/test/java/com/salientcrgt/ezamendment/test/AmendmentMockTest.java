package com.salientcrgt.ezamendment.test;

import com.salientcrgt.ezamendment.controller.AmendmentController;
import com.salientcrgt.ezamendment.dto.ScheduleADTO;
import com.salientcrgt.ezamendment.model.ScheduleA;
import com.salientcrgt.ezamendment.service.ScheduleAService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AmendmentController.class)
public class AmendmentMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ScheduleAService service;

    @Test
    public void shouldReturnCommiteeDetails() throws Exception {
        this.mockMvc.perform(get("/committee/C00577759")).andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void shouldReturnCommiteeFilingDetails() throws Exception {
        this.mockMvc.perform(get("/committee/C00577759/filings/?report_year=2017")).andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void shouldReturnCommiteeFilingDetailsByFormType() throws Exception {
        this.mockMvc.perform(get("/committee/C00577759/filings/?report_year=2017&form_type=F3")).andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void shouldReturnReceipts() throws Exception {
        this.mockMvc.perform(get("/schedules/1178702/schedule_a/")).andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void shouldCreateReceipt() throws Exception {
        when(service.createScheduleA(anyLong(), any(ScheduleADTO.class))).thenReturn(new ScheduleA());
        this.mockMvc.perform(post("/schedules/1178702/schedule_a/").content("{\"comid\": \"C00577759\"}")
                .contentType(MediaType.APPLICATION_JSON_UTF8)).andDo(print()).andExpect(status().isCreated());

    }

    @Test
    public void shouldUpdateReceipt() throws Exception {
        when(service.mergeScheduleA(anyLong(), anyString(), any(ScheduleADTO.class))).thenReturn(new ScheduleA());

        this.mockMvc.perform(put("/schedules/1178702/schedule_a/SA11AI.26847/?").content("{\"comid\": \"C00577759\"}")
                .contentType(MediaType.APPLICATION_JSON_UTF8)).andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void shouldDeleteReceipt() throws Exception {
        this.mockMvc.perform(delete("/schedules/1178702/schedule_a/SA11AI.26847/")).andDo(print())
                .andExpect(status().isOk());

    }
}
