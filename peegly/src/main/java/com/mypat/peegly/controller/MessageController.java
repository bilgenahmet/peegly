package com.mypat.peegly.controller;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mypat.peegly.SecureUser;
import com.mypat.peegly.dao.CommentDao;
import com.mypat.peegly.dao.MessageDao;
import com.mypat.peegly.dao.UserDao;
import com.mypat.peegly.model.Comment;
import com.mypat.peegly.model.Message;
import com.mypat.peegly.model.User;

@Controller
public class MessageController {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private MessageDao messageDao;
	@Autowired
	private CommentDao commentDao;
	
	public int id1;
	
	
	@RequestMapping(value = "/newmesaj", method = RequestMethod.GET)
	public String newMesaj(ModelMap m) {
		m.addAttribute("mesaj", new Message());
		m.addAttribute("listmesaj",messageDao.findAll());
		return "mesaj";
	}

	@RequestMapping(value = "/newmesaj", method = RequestMethod.POST)
	public String newMesaj(@ModelAttribute Message mesaj) {
		SecureUser secUser = (SecureUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		User user1 = secUser.getUser();
		mesaj.setDate(new Date());
		mesaj.setCategory("gülme");
		mesaj.setOwner(user1);
		mesaj.setVote(0);
		mesaj.setComments(null);
		messageDao.save(mesaj);
		return "redirect:/newmesaj";
	}
	@RequestMapping("/voteadd/{id}")
	public String addVote(@PathVariable("id") int id,@ModelAttribute Message model){
		model=this.messageDao.findOne(id);
		SecureUser secUser = (SecureUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//User user1 = secUser.getUser();
		if(model.owner.name.equals(secUser.getUser().getName())){
			model.setVote(model.getVote());
		}
		else {
			model.setVote(model.getVote()+1);
			this.messageDao.update(model);
		}
        return "redirect:/newmesaj";
    }
	
	@RequestMapping(value = "/newcomment/{id}", method = RequestMethod.GET)
	public String newComment(@PathVariable("id") int id,ModelMap m) {
		id1=id;
		m.addAttribute("yorum", new Comment());
		m.addAttribute("mesaj1",messageDao.findOne(id));
		//m.addAttribute("yorums",commentDao.findAllByForegion(id));
		return "yorum";
	}
	
	@RequestMapping(value = "/newcomment/add", method = RequestMethod.POST)
	public String newComment(@ModelAttribute("yorum") Comment yorum){
		SecureUser secUser = (SecureUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user1 = secUser.getUser();
		yorum.setUser(user1);
		yorum.setMessage(this.messageDao.findOne(id1));
        return "redirect:/newmesaj";
    }

}
