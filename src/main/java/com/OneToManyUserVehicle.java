package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.RoleBean;
import com.bean.UserBean;
import com.bean.VehicleBean;

public class OneToManyUserVehicle {
	public static void main(String[] args) {

		Configuration cfg = null;
		SessionFactory factory = null;

		cfg = new Configuration().configure("hibernate-config.xml");
		factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		UserBean user = session.get(UserBean.class, 3);//ram 

		Scanner scr = new Scanner(System.in);

		System.out.println("Enter Vehicle Registration Number");
		VehicleBean v1 = new VehicleBean();
		v1.setRegNo(scr.next());

		System.out.println("Enter Vehicle Registration Number");
		VehicleBean v2 = new VehicleBean();
		v2.setRegNo(scr.next());

		if(user.getVehicles() == null) {
			List<VehicleBean> list = new ArrayList<VehicleBean>();
			list.add(v1);
			list.add(v2);
			user.setVehicles(list);
		}else {
			user.getVehicles().add(v1);
			user.getVehicles().add(v2);
		}

		session.save(user);
		tx.commit();
		session.close();
		// user
		// fn ln em pass

		// userdetail
		// ssn profile gender
	}
}
