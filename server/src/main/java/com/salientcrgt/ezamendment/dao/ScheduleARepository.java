package com.salientcrgt.ezamendment.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.salientcrgt.ezamendment.model.ScheduleA;

/**
 *
 * Repository class for the ScheduleA entity
 *
 */
@Repository
public class ScheduleARepository {

	private static final Logger logger = LoggerFactory.getLogger(ScheduleARepository.class);

    @PersistenceContext
    private EntityManager em;
    
    /**
     * finds a list of ScheduleA's for reportId
     *
     * @param reportId - the report Id to view ScheduleA's 
     * @return  a List of matching ScheduleA's.
     */
    @SuppressWarnings("unchecked")
	public List<ScheduleA> findByReportId(long reportId) {
        return em.createQuery("select sa from ScheduleA sa where repid = :reportId and amend!= 'D'")
    			.setParameter("reportId", reportId)
    			.getResultList();
    }
    
    /**
     * finds a list of ScheduleA's for reportId
     *
     * @param reportId - the report Id to view ScheduleA's 
     * @return  a List of matching ScheduleA's.
     */
    public ScheduleA findByReportTranId(long reportId, String tranId) {
        return (ScheduleA)em.createQuery("select sa from ScheduleA sa where repid = :reportId and tran_id = :tranId")
    			.setParameter("reportId", reportId)
    			.setParameter("tranId", tranId)
    			.getSingleResult();
    }


    /**
     * Delete a ScheduleA, given its identifier
     *
     */
    public void delete(long reportId, String tranId) {
    	ScheduleA scheduleA = findByReportTranId(reportId, tranId);
    	// Technically we are not deleting from database, we would be updating Amend indicator to D
        //em.remove(scheduleA);
        scheduleA.setAmend("D");
    	em.merge(scheduleA);
    }

    /**
     *
     * save changes made to a scheduleA, or create the scheduleA if its a new.
     *
     */
    public ScheduleA merge(ScheduleA scheduleA) {
    	em.merge(scheduleA);
        return scheduleA;
    }
    
    /**
    *
    * save changes made to a scheduleA, or create the scheduleA if its a new.
    *
    */
	public ScheduleA create(ScheduleA scheduleA) {
		em.persist(scheduleA);
		return scheduleA;
	}

}
