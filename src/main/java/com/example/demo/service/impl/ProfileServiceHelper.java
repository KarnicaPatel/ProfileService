package com.example.demo.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.demo.table.RequestParameters;
import org.springframework.stereotype.Component;

// this is a helper class used to validate the request body data
@Component
public class ProfileServiceHelper {
//Validation part
	public String validateProfileCreationParameter(RequestParameters requestParameters) {
		StringBuilder validationStatus=new StringBuilder();
		if (requestParameters!=null) {

			if (requestParameters.getFirst_name()!=null) {
				if (requestParameters.getFirst_name().trim().length()>0) {
					for(int i=0;i<requestParameters.getFirst_name().length();i++){
						char ch = requestParameters.getFirst_name().charAt(i);
						if (Character.isLetter(ch) || ch == ' ') {
							continue;
						}
						validationStatus.append(ProfileServiceConstants.INVALID_FIRST_NAME+"\n");
						break;
					}
				}
				else {
					validationStatus.append(ProfileServiceConstants.INVALID_FIRST_NAME+"\n");
				}
			}
			else {
				validationStatus.append(ProfileServiceConstants.INVALID_FIRST_NAME+"\n");
			}
			if (requestParameters.getLast_name()!=null) {
				if (requestParameters.getLast_name().trim().length()>0) {
					for(int i=0;i<requestParameters.getLast_name().length();i++){
						char ch = requestParameters.getLast_name().charAt(i);
						if (Character.isLetter(ch) || ch == ' ') {
							continue;
						}
						validationStatus.append(ProfileServiceConstants.INVALID_LAST_NAME+"\n");
						break;
					}
				}
				else {
					validationStatus.append(ProfileServiceConstants.INVALID_LAST_NAME+"\n");
				}
			}
			else {
				validationStatus.append(ProfileServiceConstants.INVALID_LAST_NAME+"\n");
			}
			if (requestParameters.getUserName()!=null) {
				if (requestParameters.getUserName().trim().length()>0) {
					for(int i=0;i<requestParameters.getUserName().length();i++){
						char ch = requestParameters.getUserName().charAt(i);
						if (Character.isLetter(ch)) {
							continue;
						}
						validationStatus.append(ProfileServiceConstants.INVALID_USER_NAME+"\n");
						break;
					}
				}
				else {
					validationStatus.append(ProfileServiceConstants.INVALID_USER_NAME+"\n");
				}
			}
			else {
				validationStatus.append(ProfileServiceConstants.INVALID_USER_NAME+"\n");
			}

			if (requestParameters.getAge()!=null) {
				if (requestParameters.getAge().trim().length()>0) {
					if (!requestParameters.getAge().matches(ProfileServiceConstants.AGE_VALIDATION_REGX)) {
						validationStatus.append(ProfileServiceConstants.INVALID_AGE+"\n");
					}
				}
				else {
					validationStatus.append(ProfileServiceConstants.INVALID_AGE+"\n");
				}
			}
			else {
				validationStatus.append(ProfileServiceConstants.INVALID_AGE+"\n");
			}

			if (validationStatus.toString().isEmpty()) {
				validationStatus.append(ProfileServiceConstants.STATUS_SUCCESS);
			}
		}
		else {
			validationStatus.append(ProfileServiceConstants.INVALID_INPUT_PARAMETER+"\n");
		}
		return validationStatus.toString();
	}
	
	public String validateProfileUpdateParameter(RequestParameters requestParameters) {
		StringBuilder validationStatus=new StringBuilder();
		if (requestParameters!=null) {

			if (requestParameters.getFirst_name()!=null) {
				if (requestParameters.getFirst_name().trim().length()>0) {
					for(int i=0;i<requestParameters.getFirst_name().length();i++){
						char ch = requestParameters.getFirst_name().charAt(i);
						if (Character.isLetter(ch) || ch == ' ') {
							continue;
						}
						validationStatus.append(ProfileServiceConstants.INVALID_FIRST_NAME+"\n");
						break;
					}
				}
				else {
					validationStatus.append(ProfileServiceConstants.INVALID_FIRST_NAME+"\n");
				}
			}
			else {
				validationStatus.append(ProfileServiceConstants.INVALID_FIRST_NAME+"\n");
			}
			if (requestParameters.getLast_name()!=null) {
				if (requestParameters.getLast_name().trim().length()>0) {
					for(int i=0;i<requestParameters.getLast_name().length();i++){
						char ch = requestParameters.getLast_name().charAt(i);
						if (Character.isLetter(ch) || ch == ' ') {
							continue;
						}
						validationStatus.append(ProfileServiceConstants.INVALID_LAST_NAME+"\n");
						break;
					}
				}
				else {
					validationStatus.append(ProfileServiceConstants.INVALID_LAST_NAME+"\n");
				}
			}
			else {
				validationStatus.append(ProfileServiceConstants.INVALID_LAST_NAME+"\n");
			}
			if (requestParameters.getUserName()!=null) {
				if (requestParameters.getUserName().trim().length()>0) {
					for(int i=0;i<requestParameters.getUserName().length();i++){
						char ch = requestParameters.getUserName().charAt(i);
						if (Character.isLetter(ch)) {
							continue;
						}
						validationStatus.append(ProfileServiceConstants.INVALID_USER_NAME+"\n");
						break;
					}
				}
				else {
					validationStatus.append(ProfileServiceConstants.INVALID_USER_NAME+"\n");
				}
			}

			if (requestParameters.getAge()!=null) {
				if (requestParameters.getAge().trim().length()>0) {
					if (!requestParameters.getAge().matches(ProfileServiceConstants.AGE_VALIDATION_REGX)) {
						validationStatus.append(ProfileServiceConstants.INVALID_AGE+"\n");
					}
				}
				else {
					validationStatus.append(ProfileServiceConstants.INVALID_AGE+"\n");
				}
			}

			if (validationStatus.toString().isEmpty()) {
				validationStatus.append(ProfileServiceConstants.STATUS_SUCCESS);
			}
		}
		else {
			validationStatus.append(ProfileServiceConstants.INVALID_INPUT_PARAMETER+"\n");
		}
		return validationStatus.toString();
	}
	
	
 public String validateUserId(String userId){

		String intRegex="[0-9]*";
		if(userId.matches(intRegex))
			return ProfileServiceConstants.VALID_USER_ID;
		return ProfileServiceConstants.INVALID_USER_ID;
	}


	public String validateNames(String name){
		String strRegx="[a-zA-Z]*";
		if(!name.matches(strRegx))
			return ProfileServiceConstants.INVALID_FIRST_NAME;
		return ProfileServiceConstants.VALID_NAME;
	}
}
