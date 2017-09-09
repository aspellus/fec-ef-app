package com.salientcrgt.ezamendment.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    EntityManager em;
    
    /**
     * finds a list of ScheduleA's for reportId
     *
     * @param reportId - the report Id to view ScheduleA's 
     * @return  a List of matching ScheduleA's.
     */
    @SuppressWarnings("unchecked")
	  public List<ScheduleA> findByReportId(long reportId) {

      return em.createQuery("select sa from ScheduleA sa where repid = :reportId")
    			.setParameter("reportId", reportId)
    			.getResultList();
    }


    /**
     * Delete a ScheduleA, given its identifier
     *
     * @param deletedSubId - the id of the ScheduleA to be deleted
     */
    public void delete(Long deletedSubId) {
    	ScheduleA delete = em.find(ScheduleA.class, deletedSubId);
        em.remove(delete);
    }

    /**
     *
     * save changes made to a scheduleA, or create the scheduleA if its a new.
     *
     */
    public ScheduleA save(ScheduleA scheduleA) {
        return em.merge(scheduleA);
    }

}
