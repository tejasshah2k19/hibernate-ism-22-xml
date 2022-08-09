package com;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.CategoryBean;
import com.bean.ProductBean;
import com.bean.UserBean;

public class ManyToManyCategoryProduct {

	Configuration cfg = null;
	SessionFactory factory = null;

	public ManyToManyCategoryProduct() {
		cfg = new Configuration().configure("hibernate-config.xml");
		factory = cfg.buildSessionFactory();
	}

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int choice;
		ManyToManyCategoryProduct app = new ManyToManyCategoryProduct();

		while (true) {
			System.out.println("0 for exit");
			System.out.println("1 for add category");
			System.out.println("2 for add product");
			System.out.println("entr choice");
			choice = scr.nextInt();

			if (choice == 1) {
				Session session = app.factory.openSession();
				System.out.println("Enter categoryName");
				CategoryBean category = new CategoryBean(); // transient state
				category.setCategoryName(scr.next());
				Transaction tx = session.beginTransaction();
				session.save(category);// persist
				tx.commit();
				session.close();
			} else if (choice == 2) {
				
				Session session = app.factory.openSession();
			
				System.out.println("Enter productName  and  price ");
				ProductBean productBean = new ProductBean();
				productBean.setProductName(scr.next());
				productBean.setPrice(scr.nextInt());
				
				while(true){
					System.out.println("Enter category in which you want to add product? 0 for exit");
					int categoryId = scr.nextInt();
					if(categoryId <= 0 ) {
						break;
					}
					CategoryBean category = session.get(CategoryBean.class, categoryId);
					productBean.getCategories().add(category);
			 			
				}
				
				Transaction tx = session.beginTransaction();
				session.save(productBean);
				tx.commit();
				session.close();
			} 
		}
	}
}
