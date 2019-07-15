package com.rest.dto;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class TestClient {
	public static void main(String[] args) {
		Configuration cfg=new AnnotationConfiguration();
		cfg=cfg.configure("hibernate.cfg.xml");
		SessionFactory factory= cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx = session.beginTransaction();
		Product p = new Product();
		ImageUrls im = new ImageUrls();
		List<ImageUrls> i = new ArrayList<ImageUrls>();
		p.setDescription("helloo");
		p.setProductName("pencils");
		im.setProducts(p);
		im.setImageurl("/home/sirisha");
		i.add(im);
		p.setImages(i);
		session.save(p);
		session.save(im);
		tx.commit();
	}
}
