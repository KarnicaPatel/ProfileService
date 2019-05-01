package com.example.demo.service.impl;

import com.example.demo.table.RequestParameters;

import java.util.List;

public interface ProfileService {
	String createUserProfile(RequestParameters requestParam);
	String updateUserProfile(RequestParameters requestParam);
	String deleteUserProfile(RequestParameters requestParam);
	String readUserProfile(RequestParameters requestParam);
	RequestParameters readUserProfileById(String userProfileId);
	List<RequestParameters> readUserProfileByName(RequestParameters requestParameters);
}
