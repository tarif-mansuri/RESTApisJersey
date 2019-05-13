//$Id$
package com.tm.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.tm.messenger.database.DatabaseClass;
import com.tm.messenger.exception.DataNotFoundException;
import com.tm.messenger.model.Message;

public class MessageService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public MessageService() {
		messages.put(1L, new Message(1, "Hello WOrld", "Tarif-Mansuri"));
		messages.put(2L, new Message(2, "Hello Jersey WOrld", "Tarif-Mansuri"));
	}

	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}

	public Message getMessage(long id) {
		Message message = messages.get(id);
		if (message == null) {
			throw new DataNotFoundException("Message with id : " + id + " not found");
		}
		return message;
	}

	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}

	public Message removeMessage(long id) {
		return messages.remove(id);
	}

	public List<Message> getALlMessageForYear(int year) {
		List<Message> messageForYear = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		for (Message message : messages.values()) {
			calendar.setTime(message.getCreated());
			if (calendar.get(Calendar.YEAR) == year) {
				messageForYear.add(message);
			}
		}
		return messageForYear;
	}

	public List<Message> getAllMessagePaginated(int start, int size) {
		List<Message> list = new ArrayList<Message>(messages.values());
		if (start + size > list.size()) {
			return new ArrayList<Message>();
		}
		return list.subList(start, start + size);
	}
}
