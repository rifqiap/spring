package com.os.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.os.spring.dao.MessageDAO;
import com.os.spring.model.Message;

@Service
public class MessageServiceImpl implements MessageService {
	
	private MessageDAO messageDAO;

	public void setMessageDAO(MessageDAO messageDAO) {
		this.messageDAO = messageDAO;
	}

	@Override
	@Transactional
	public void addMessage(Message p) {
		this.messageDAO.addMessage(p);
	}

	@Override
	@Transactional
	public void updateMessage(Message p) {
		this.messageDAO.updateMessage(p);
	}

	@Override
	@Transactional
	public List<Message> listMessages() {
		return this.messageDAO.listMessages();
	}

	@Override
	@Transactional
	public Message getMessageById(int id) {
		return this.messageDAO.getMessageById(id);
	}

	@Override
	@Transactional
	public void removeMessage(int id) {
		this.messageDAO.removeMessage(id);
	}

}
