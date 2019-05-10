//$Id$
package com.tm.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tm.messenger.database.DatabaseClass;
import com.tm.messenger.model.Profile;

public class ProfileService {
	Map<String, Profile> profiles = DatabaseClass.getProfiles();
	public ProfileService(){
		profiles.put("tarif", new Profile(1L,"Tarif's Profile","Tarif","Mansuri"));
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public List<Profile> getAllProfile(){
		return new ArrayList<Profile>(profiles.values()); 
	}
	
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName){
		return profiles.remove(profileName);
	}
}
