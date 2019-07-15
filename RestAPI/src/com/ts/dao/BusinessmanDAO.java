package com.ts.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import com.rest.dto.*;
import com.ts.db.HibernateTemplate;

public class BusinessmanDAO {
	private SessionFactory factory = null;
	
	public Businessman getBusinessman(String emailId) {

		return (Businessman)HibernateTemplate.BusinessmangetObjectByUserName(emailId);
	}
	public Businessman getBusinessmanByPassword(String emailId, String password) {
		return (Businessman)HibernateTemplate.BusinessmangetObjectByPassword(emailId, password);
	}
	public int register(Businessman businessman) {
		return HibernateTemplate.addObject(businessman);
	}

	public List<Businessman> getAllBusinessman() {
		List<Businessman> businessman=(List)HibernateTemplate.getObjectListByQuery("From Businessman");
		System.out.println("Inside All Employees ..."+businessman);
		return businessman;	
	}

}
