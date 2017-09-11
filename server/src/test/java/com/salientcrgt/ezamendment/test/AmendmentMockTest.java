package com.salientcrgt.ezamendment.test;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
                .perform(get("/committee/C00577759/filings/?report_year=2017"))
                .andDo(print())
                .andExpect(status().isOk());

    }
    
    @Test
    public void shouldReturnCommiteeFilingDetailsByFormType() throws Exception {
        this.mockMvc
                .perform(get("/committee/C00577759/filings/?report_year=2017&form_type=F3"))
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
        this.mockMvc
                .perform(post("/schedules/1178702/schedule_a/?")
                		.param("comid", "C00577759")
                    	.param("line_num", "11AI")
                    	.param("tran_id", "")
                    	.param("name", "Gardner")
                    	.param("fname", "Drew")
                    	.param("str1", "8255 Greensboro Dr")
                    	.param("str2", "Suite 500")
                    	.param("city", "Tysons")
                    	.param("state", "VA")
                    	.param("zip", "22102")
                    	.param("date_con", "10/13/2016")
                    	.param("amount", "2000")
                    	.param("transdesc", "Testing Creating a Receipt")
                    	.param("indemp", "SalientCRGT")
                    	.param("indocc", "")
                    	.param("memo_code", "X"))
                .andDo(print())
                .andExpect(status().isOk());

    }
    
    @Test
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
                .andExpect(status().isOk());

    }
}
