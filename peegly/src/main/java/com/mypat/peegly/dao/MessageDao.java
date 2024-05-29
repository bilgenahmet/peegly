package com.mypat.peegly.dao;

import org.springframework.stereotype.Repository;

import com.mypat.peegly.model.Message;
import com.mypat.peegly.dao.AbstractHibernateDAO;

@Repository
public class MessageDao extends AbstractHibernateDAO<Message> {
	public MessageDao() {
		setClazz(Message.class);
	}
}
