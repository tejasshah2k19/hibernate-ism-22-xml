package com;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.RoleBean;
import com.bean.UserBean;

public class OneToOneUserRole {

	public static void main(String[] args) {

		Configuration cfg = null;
		SessionFactory factory = null;

		cfg = new Configuration().configure("hibernate-config.xml");
		factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Scanner scr = new Scanner(System.in);

		System.out.println("Enter FirstName email and password");
		UserBean user = new UserBean();
		user.setFirstName(scr.next());
		user.setEmail(scr.next());
		user.setPassword(scr.next());

		// user role ->
		// 1 to 1

		RoleBean role = session.get(RoleBean.class, 1); // 1
		user.setRole(role);

		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
		// user
		// fn ln em pass

		// userdetail
		// ssn profile gender

	}
}
