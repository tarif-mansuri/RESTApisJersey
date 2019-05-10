//$Id$
package com.tm.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tm.messenger.model.Profile;
import com.tm.messenger.service.ProfileService;

@Path("/profiles")
public class ProfileResources {
	ProfileService profileService =new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getProfiles(){
		return profileService.getAllProfile();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String profileName)
	{
		return profileService.getProfile(profileName);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addProfile(Profile profile){
		profileService.addProfile(profile);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{profileName}")
	public Profile updateProfile(Profile profile,@PathParam("profileName") String profileName){
		profile.setProfileName(profileName);
		profileService.addProfile(profile);
		return profile;
	}
	
	@DELETE
	@Path("profileName")
	public Profile deleteProfile(@PathParam("profileName") String profileName){
		return profileService.removeProfile(profileName);
	}

}
