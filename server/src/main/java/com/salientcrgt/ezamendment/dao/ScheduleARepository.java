package com.salientcrgt.ezamendment.dao;

import com.salientcrgt.ezamendment.model.ScheduleA;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Repository class for the ScheduleA entity
 *
 * @author spanyala
 */
@Repository
public class ScheduleARepository {

    @PersistenceContext
    private EntityManager em;

    /**
     * finds a list of ScheduleA's for reportId
     *
     * @param reportId - the report Id to view ScheduleA's
     * @return a List of matching ScheduleA's.
     */
    @SuppressWarnings("unchecked")
    public List<ScheduleA> findByReportId(long reportId) {
        return em.createQuery("select sa from ScheduleA sa where repid = :reportId and amend!= 'D'")
                .setParameter("reportId", reportId).getResultList();
    }

    /**
     * finds a list of ScheduleA's for reportId
     *
     * @param reportId - the report Id to view ScheduleA's
     * @return a List of matching ScheduleA's.
     */
    public ScheduleA findByReportTranId(long reportId, String tranId) {
        return (ScheduleA) em.createQuery("select sa from ScheduleA sa where repid = :reportId and tran_id = :tranId")
                .setParameter("reportId", reportId).setParameter("tranId", tranId).getSingleResult();
    }

    /**
     * Delete a ScheduleA, given its identifier
     *
     * @param reportId report id
     * @param tranId   transaction id
     */
    public void delete(long reportId, String tranId) {
        ScheduleA scheduleA = findByReportTranId(reportId, tranId);
        // Technically we are not deleting from database, we would be updating
        // Amend indicator to D
        scheduleA.setAmendment("D");
        em.merge(scheduleA);
    }

    /**
     * save changes made to a scheduleA, or create the scheduleA if its a new.
     *
     * @param scheduleA scheduleA object to merge
     * @return merged ScheduleA object
     */
    public ScheduleA merge(ScheduleA scheduleA) {
        em.merge(scheduleA);
        return scheduleA;
    }

    /**
     * save changes made to a scheduleA, or create the scheduleA if its a new.
     *
     * @param scheduleA scheduleA object to create
     * @return new ScheduleA object
     */
    public ScheduleA create(ScheduleA scheduleA) {
        em.persist(scheduleA);
        return scheduleA;
    }

}
