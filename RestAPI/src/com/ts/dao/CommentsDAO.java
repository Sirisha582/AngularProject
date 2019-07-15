package com.ts.dao;
import org.hibernate.SessionFactory;
import com.ts.db.HibernateTemplate;
import com.rest.dto.*;
public class CommentsDAO {
	private SessionFactory factory = null;
	
	public Comments getComments(String emailId) {

		return (Comments)HibernateTemplate.CommentsgetObjectByUserName(emailId);
	}

	public int register(Comments comments) {
		return HibernateTemplate.addObject(comments);
	}
	public Comments getComments(int productId) {

		return (Comments)HibernateTemplate.CommentsgetObjectByProductId(productId);
	}

}
