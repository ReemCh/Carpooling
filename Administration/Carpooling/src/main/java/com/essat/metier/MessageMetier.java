package com.essat.metier;

import java.util.List;

import com.essat.entities.Message;

public interface MessageMetier {
	
	public List<Message> getAllMessages();
	public Message getMessageById(Long id);
	public void deleteMessage(Long id);

}
