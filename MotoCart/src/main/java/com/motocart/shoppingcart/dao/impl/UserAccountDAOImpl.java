package com.motocart.shoppingcart.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.motocart.shoppingcart.dao.UserAccountDAO;
import com.motocart.shoppingcart.entity.UserAccount;

//Transactional for Hibernate
@Transactional
public class UserAccountDAOImpl implements UserAccountDAO {
 
 @Autowired
 private SessionFactory sessionFactory;

 @Override
 public UserAccount findAccount(String userName ) {
     Session session = sessionFactory.getCurrentSession();
     Criteria crit = session.createCriteria(UserAccount.class);
     crit.add(Restrictions.eq("userName", userName));
     return (UserAccount) crit.uniqueResult();
 }

}