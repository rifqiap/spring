package com.os.spring.service;

import java.util.List;

import com.os.spring.model.Message;

public interface MessageService {

	public void addMessage(Message p);
	public void updateMessage(Message p);
	public List<Message> listMessages();
	public Message getMessageById(int id);
	public void removeMessage(int id);
	
}
