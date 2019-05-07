package com.example.demo.service.impl;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

//This interface we have craeted to define our constants which will be used across the application
public interface ProfileServiceConstants {
	
	public static String UNEXPECTED_ERROR="An Unexpected Error Occured";

	public static String STATUS_NEW_PROFILE_ACTIVE="A";
	
	public static String STATUS_EXPIRED="E";
	public static String STATUS_SUCCESS="S";
	public static String STATUS_FAIL="F";
		
	public static String PROFILE_CREATE_FAILED="Profile Creation Failed";
	public static String PROFILE_CREATE_SUCCESS="Profile Created Successfully";
	
	public static String PROFILE_UPDATE_FAILED="Profile Updation Failed";
	public static String PROFILE_UPDATE_SUCCESS="Profile Updated Successfully";
	
	public static String PROFILE_DELETE_FAILED="Profile Deletion Failed";
	public static String PROFILE_DELETE_SUCCESS="Profile Deleted Successfully";

	public static  String INVALID_USER_ID="User Id is invalid. it must be integer";
	public static  String VALID_USER_ID="User Id is valid";
	public static  String USER_ID_DOES_NOT_EXIST="User Id does not exist.";

	public static String PROFILE_READ_FAILED="Profile Reading Failed";
	public static String PROFILE_READ_SUCCESS="Profile Read Successfully";
	
	public static String PROFILE_SEARCHED_NOT_ACTIVE="Requested Profile Is Not Active";
	public static String PROFILE_SEARCHED_ALREADY_EXISTS="Profile Is Already Active for Given Details";
	
	public static String AGE_VALIDATION_REGX="^[0-9]{1,2}$";

	public static String INVALID_FIRST_NAME="Please Enter a Valid First Name";
	public static String INVALID_LAST_NAME="Please Enter a Valid Last Name";
	public static String INVALID_USER_NAME="Please Enter a Valid Username";
	public static String INVALID_AGE="Please Enter a Valid Age";
	public static String INVALID_ID="Please Enter a Valid Id";

	public static String INVALID_NAME="Please Enter a Valid Name";
	public static String VALID_NAME="Valid Name";

	public static String INVALID_INPUT_PARAMETER="Input parameter is invalid";



	public String QUERY="SELECT USER_PROFILE_ID,USERNAME,FIRST_NAME,LAST_NAME,AGE,STATUS FROM USER_PROFILE WHERE FIRST_NAME=:firstName AND LAST_NAME=:lastName" +
			" AND STATUS=:status";





}
