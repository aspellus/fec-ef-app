package com.salientcrgt.ezamendment.test;


import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.salientcrgt.ezamendment.dto.ScheduleADTO;
import com.salientcrgt.ezamendment.model.ScheduleA;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.salientcrgt.ezamendment.controller.AmendmentController;
import com.salientcrgt.ezamendment.service.ScheduleAService;


@RunWith(SpringRunner.class)
@WebMvcTest(AmendmentController.class)
public class AmendmentMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ScheduleAService service;

    @Test
    public void shouldReturnCommiteeDetails() throws Exception {
        this.mockMvc
                .perform(get("/committee/C00577759"))
                .andDo(print())
                .andExpect(status().isOk());

    }
    
    @Test
    public void shouldReturnCommiteeFilingDetails() throws Exception {
        this.mockMvc
                .perform(get("/committee/C00577759/filings/?reportYear=2017"))
                .andDo(print())
                .andExpect(status().isOk());

    }
    
    @Test
    public void shouldReturnCommiteeFilingDetailsByFormType() throws Exception {
        this.mockMvc
                .perform(get("/committee/C00577759/filings/?reportYear=2017&form_type=F3"))
                .andDo(print())
                .andExpect(status().isOk());

    }
    
    @Test
    public void shouldReturnReceipts() throws Exception {
        this.mockMvc
                .perform(get("/schedules/1178702/schedule_a/"))
                .andDo(print())
                .andExpect(status().isOk());

    }
    
    @Test
    public void shouldCreateReceipt() throws Exception {
        when(service.createScheduleA(anyLong(), any(ScheduleADTO.class))).thenReturn(new ScheduleA());
        this.mockMvc
                .perform(post("/schedules/1178702/schedule_a/")
                .content("{\"comid\": \"C00577759\"}")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk());

    }
    
    @Test @Ignore
    public void shouldUpdateReceipt() throws Exception {
        this.mockMvc
                .perform(put("/schedules/1178702/schedule_a/SA11AI.26847/?")
                		.param("comid", "C00577759")
                    	.param("line_num", "11AI")
                    	.param("name", "Gardner")
                    	.param("fname", "Drew")
                    	.param("str1", "8255 Greensboro Dr")
                    	.param("str2", "Suite 400")
                    	.param("city", "Tysons")
                    	.param("state", "VA")
                    	.param("zip", "22102")
                    	.param("date_con", "10/14/2016")
                    	.param("amount", "3000")
                    	.param("transdesc", "Testing Updating a Receipt")
                    	.param("indemp", "SalientCRGT")
                    	.param("indocc", "")
                    	.param("memo_code", ""))
                .andDo(print())
                .andExpect(status().isOk());

    }
    
    @Test
    public void shouldDeleteReceipt() throws Exception {
        this.mockMvc
                .perform(delete("/schedules/1178702/schedule_a/SA11AI.26847/"))
                .andDo(print())
                .andExpect(status().isOk());

    }
}
