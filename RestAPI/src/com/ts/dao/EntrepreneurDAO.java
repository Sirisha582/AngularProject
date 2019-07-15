package com.ts.dao;
import com.rest.dto.*;
import com.ts.db.HibernateTemplate;

import java.util.List;

import org.hibernate.SessionFactory;

public class EntrepreneurDAO {
private SessionFactory factory = null;
	
	public Entrepreneur getEntrepreneur(String emailId) {

		return (Entrepreneur)HibernateTemplate.EntrepreneurgetObjectByUserName(emailId);
	}

	public int register(Entrepreneur entrepreneur) {
		return HibernateTemplate.addObject(entrepreneur);
	}

	public List<Entrepreneur> getAllEntrepreneur() {
		List<Entrepreneur> entrepreneur=(List)HibernateTemplate.getObjectListByQuery("From Entrepreneur");
		System.out.println("Inside All Employees ..."+entrepreneur);
		return entrepreneur;	
	}
	public Entrepreneur getEntrepreneurByPassword(String emailId, String password) {
		return (Entrepreneur)HibernateTemplate.EntrepreneurgetObjectByPassword(emailId, password);
	}

}

