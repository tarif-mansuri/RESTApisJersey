//$Id$
package com.tm.messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.tm.messenger.model.Message;
import com.tm.messenger.model.Profile;

public class DatabaseClass {
	private static Map<Long, Message> messages = new HashMap();
	private static Map<String, Profile> profiles = new HashMap();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	public static void setMessages(Map<Long, Message> messages) {
		DatabaseClass.messages = messages;
	}
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
	public static void setProfiles(Map<String, Profile> profiles) {
		DatabaseClass.profiles = profiles;
	}

}
