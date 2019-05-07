package com.example.demo.webresource;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.impl.ProfileService;
import com.example.demo.service.impl.ProfileServiceConstants;
import com.example.demo.service.impl.ProfileServiceHelper;
import com.example.demo.table.RequestParameters;

import java.util.List;

//this is the controller or resource class
//This is used to mark a class as a rest resource, and spring component. 
@RestController
//use to provide the URI to resources
@RequestMapping("/user")
public class ProfileController {

	/*it will help spring boot to identify the dependent class &
	to inject the object of ProfileServiceImpl class*/
	@Autowired
	private ProfileService profileService;

	@Autowired
	private ProfileServiceHelper profileServiceHelper;

	
	@RequestMapping(value ="/profile",method=RequestMethod.POST,consumes = "application/json")
    //the  annotation tells to controller to serialized returned object into json and directly pass it as responsebody
	@ResponseBody
	public String createUserProfile(@RequestBody RequestParameters requestParameters){

		String responseMessage=ProfileServiceConstants.UNEXPECTED_ERROR;
		responseMessage=profileServiceHelper.validateProfileCreationParameter(requestParameters);
		if (responseMessage.equals(ProfileServiceConstants.STATUS_SUCCESS)) {
			responseMessage=profileService.createUserProfile(requestParameters);
		}
		return responseMessage;
	}
	@RequestMapping(value ="/profile",method=RequestMethod.PUT)
	public String updateUserProfile(@RequestBody RequestParameters requestParameters){
		ProfileServiceHelper profileServiceHelper=new ProfileServiceHelper();
		String responseMessage=ProfileServiceConstants.UNEXPECTED_ERROR;
		responseMessage=profileServiceHelper.validateProfileUpdateParameter(requestParameters);
		if (responseMessage.equals(ProfileServiceConstants.STATUS_SUCCESS)) {
			responseMessage=profileService.updateUserProfile(requestParameters);
		}
		return responseMessage;
	}

	
	@RequestMapping(value ="/profile/{userId}",method=RequestMethod.DELETE)
    //@PathVariable used to bind the URI param to the method parameter, but uri key and pathvariable value must be same
	public String deleteUserProfile(@PathVariable("userId")String userId){

		String responseMessage=ProfileServiceConstants.UNEXPECTED_ERROR;
		responseMessage=profileServiceHelper.validateUserId(userId);
		if (responseMessage.equals(ProfileServiceConstants.VALID_USER_ID)) {

			RequestParameters requestParameters=new RequestParameters();
			requestParameters.setId(userId);
			responseMessage=profileService.deleteUserProfile(requestParameters);
		}
		return responseMessage;
	}


	//@RequestMapping(value ="/readUserProfile",method=RequestMethod.GET)
	@GetMapping(value = "/profile/{firstName}/{lastName}",produces = "application/json")
	public String readUserProfileByName(@PathVariable("firstName") String firstName,@PathVariable("lastName")String lastName)
	{
		String responseMessage=null;
		responseMessage=profileServiceHelper.validateNames(firstName);
		boolean isValidName=false;
		if(responseMessage.equals(ProfileServiceConstants.VALID_NAME)&&
				profileServiceHelper.validateNames(lastName).equals(ProfileServiceConstants.VALID_NAME)) {
			isValidName=true;
		}
		if(isValidName){

			RequestParameters requestParameters=new RequestParameters();
			requestParameters.setFirst_name(firstName);
			requestParameters.setLast_name(lastName);
			responseMessage=profileService.readUserProfile(requestParameters);
			if(responseMessage.equals(ProfileServiceConstants.PROFILE_READ_SUCCESS)){
				Gson gson = new Gson();
				responseMessage=gson.toJson(requestParameters);
			}
		}
		return responseMessage;
	}

	@GetMapping("/profile/{userId}")
	public String readUserById(@PathVariable("userId") String userId){

		String responseMessage=null;
		if(userId!=null && !userId.isEmpty()&&userId.trim().length()>0){
			RequestParameters requestParameters=profileService.readUserProfileById(userId);
			if (requestParameters!=null){
				Gson gson=new Gson();
				responseMessage=gson.toJson(requestParameters);
			}else{
				responseMessage=ProfileServiceConstants.USER_ID_DOES_NOT_EXIST;
			}
		}
		return responseMessage;

	}
/*
	//@RequestMapping(value ="/readUserProfile",method=RequestMethod.GET)
	@GetMapping(value = "/profile/{firstName}/{lastName}",produces = "application/json")
	public String readAllUserProfileOfSameNames(@PathVariable("firstName") String firstName,@PathVariable("lastName")String lastName){

		List<RequestParameters>requestParameters=null;
		String responseMessage;
		responseMessage=profileServiceHelper.validateNames(firstName);
		boolean isValidNames=false;
		if(responseMessage.equals(ProfileServiceConstants.VALID_NAME)&&
				profileServiceHelper.validateNames(lastName).equals(ProfileServiceConstants.VALID_NAME)){
			isValidNames=true;
		}
		if (isValidNames) {
			RequestParameters requestParameter=new RequestParameters();
			requestParameter.setFirst_name(firstName);
			requestParameter.setLast_name(lastName);

			requestParameters=profileService.readUserProfileByName(requestParameter);
			if(requestParameters!=null && requestParameters.size()>0){
				Gson gson = new Gson();
				responseMessage=gson.toJson(requestParameters);
			}else{
				responseMessage="Profile with this name is not available";
			}
		}
		return responseMessage;
	}
	*/
}
