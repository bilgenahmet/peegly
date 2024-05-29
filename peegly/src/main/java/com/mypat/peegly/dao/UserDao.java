package com.mypat.peegly.dao;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.mypat.peegly.model.User;

@Repository
public class UserDao extends AbstractHibernateDAO<User> {
	public UserDao() {
		setClazz(User.class);
	}

	@Transactional
	public User getUserByEmail(String email) {
		Query query = getCurrentSession().createQuery("from User where email=:email");
		query.setString("email", email);
		User u = (User) query.uniqueResult();
		return u;
	}
	
}
