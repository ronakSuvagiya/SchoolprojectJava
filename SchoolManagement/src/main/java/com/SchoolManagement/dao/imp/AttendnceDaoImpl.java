package com.SchoolManagement.dao.imp;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SchoolManagement.enitiy.AttendanceMaster;
import com.SchoolManagement.enitiy.DivMaster;
import com.SchoolManagement.enitiy.SchoolMaster;
import com.SchoolManagement.enitiy.StdMaster;

@Service
@Transactional
public class AttendnceDaoImpl {
	
	
	@Autowired
	EntityManager em;
	
	public List<AttendanceMaster> findByDivAndSchoolAndStdAndDateBetween(DivMaster div,SchoolMaster school,StdMaster std,Date startDate,Date endDate)
	{
		System.out.println(startDate);
		System.out.println(endDate);
	    CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<AttendanceMaster> cq = cb.createQuery(AttendanceMaster.class);
	    Root<AttendanceMaster> from = cq.from(AttendanceMaster.class);
	    cq.select(from);
	    cq.where(cb.equal(from.get("std"), std),cb.equal(from.get("div"), div),cb.equal(from.get("std"), std),cb.equal(from.get("school"), school), cb.between(from.get("date"), startDate, endDate));
	    Query q = em.createQuery(cq);
	    List<AttendanceMaster> appliction = q.getResultList();
	   
	    return appliction;
	}

}
