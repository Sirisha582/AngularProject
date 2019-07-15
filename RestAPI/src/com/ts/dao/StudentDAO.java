package com.ts.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import com.rest.dto.*;
import com.ts.db.HibernateTemplate;
public class StudentDAO {
private SessionFactory factory = null;
	
	public Student getStudent(String emailId) {
		Student s = new Student();
		s =((Student)HibernateTemplate.StudentgetObjectByUserName(emailId));
		return (Student)HibernateTemplate.StudentgetObjectByUserName(emailId);
	}

	public int register(Student student) {
		return HibernateTemplate.addObject(student);
	}

	public List<Student> getAllStudent() {
		List<Student> student=(List)HibernateTemplate.getObjectListByQuery("From Student");
		System.out.println("Inside All Employees ..."+student);
		return student;	
	}
	public Student getStudentByPassword(String emailId, String password) {
		return (Student)HibernateTemplate.StudentgetObjectByPassword(emailId, password);
	}
}
