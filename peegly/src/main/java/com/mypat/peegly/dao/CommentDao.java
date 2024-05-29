package com.mypat.peegly.dao;

import org.springframework.stereotype.Repository;

import com.mypat.peegly.model.Comment;

@Repository
public class CommentDao extends AbstractHibernateDAO<Comment> {
	public CommentDao() {
		setClazz(Comment.class);
	}
}