package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repo.UserProfileRepo;
import com.example.demo.table.RequestParameters;
import com.example.demo.table.UserProfile;

//stereotype annotation helps to identify the service class
@Service
public class ProfileServiceImpl implements ProfileService{

	@Autowired
	private UserProfileRepo userProfileRepo;

	//This creates a user with unique first name and lastname only
	@Override
	public String createUserProfile(RequestParameters requestParam) {
		// TODO Auto-generated method stub
		String profileCreateResponse=ProfileServiceConstants.PROFILE_CREATE_FAILED;
		UserProfile userProfileExisting=userProfileRepo.findByFirstNameAndLastNameAndStatus(requestParam.getFirst_name(),requestParam.getLast_name(),ProfileServiceConstants.STATUS_NEW_PROFILE_ACTIVE);
      //  UserProfile userProfileExisting=null;
		if (userProfileExisting==null) {
		UserProfile userProfile=new UserProfile();
		userProfile.setActivationDate(new Date());
		userProfile.setStatus(ProfileServiceConstants.STATUS_NEW_PROFILE_ACTIVE);
		userProfile.setUsername(requestParam.getUserName());
		userProfile.setFirstName(requestParam.getFirst_name());
		userProfile.setLastName(requestParam.getLast_name());
		userProfile.setAge(Long.parseLong(requestParam.getAge()));
			UserProfile userProfileSaved=userProfileRepo.save(userProfile);
			if (userProfileSaved!=null&&userProfileSaved.getStatus().equals(ProfileServiceConstants.STATUS_NEW_PROFILE_ACTIVE)) {

				profileCreateResponse=ProfileServiceConstants.PROFILE_CREATE_SUCCESS+"\nProfile Id : "+userProfileSaved.getUserProfileId();
			}
		}else {
			profileCreateResponse=ProfileServiceConstants.PROFILE_SEARCHED_ALREADY_EXISTS+"\n"+ProfileServiceConstants.PROFILE_CREATE_FAILED;
		}
			return profileCreateResponse;	
	}
	

	@Override
	public String updateUserProfile(RequestParameters requestParam) {
		// TODO Auto-generated method stub
		String profileUpdateResponse=ProfileServiceConstants.PROFILE_UPDATE_FAILED;
		UserProfile userProfile=userProfileRepo.findByFirstNameAndLastNameAndStatus(requestParam.getFirst_name(),requestParam.getLast_name(),ProfileServiceConstants.STATUS_NEW_PROFILE_ACTIVE);
        //UserProfile userProfile=userProfileRepo.getOne(Long.parseLong(requestParam.getId()));
		if (userProfile!=null) {
			userProfile.setUsername(requestParam.getUserName());
			userProfile.setAge(Long.parseLong(requestParam.getAge()));
			UserProfile userProfileSaved=userProfileRepo.save(userProfile);
			if (userProfileSaved!=null&&userProfileSaved.getStatus().equals(ProfileServiceConstants.STATUS_NEW_PROFILE_ACTIVE)) {
				profileUpdateResponse=ProfileServiceConstants.PROFILE_UPDATE_SUCCESS;
			}
		}
		else {
			profileUpdateResponse=ProfileServiceConstants.PROFILE_SEARCHED_NOT_ACTIVE;
		}
		return profileUpdateResponse;
	}

//This deletes the user using userProfileId
	@Override
	public String deleteUserProfile(RequestParameters requestParam) {
		// TODO Auto-generated method stub
		String profileDeleteResponse=ProfileServiceConstants.PROFILE_DELETE_FAILED;

		UserProfile userProfile=new UserProfile();
		userProfile.setUserProfileId(Long.parseLong(requestParam.getId()));
		try {
			boolean isUserExist=userProfileRepo.existsById(userProfile.getUserProfileId());
			if(isUserExist) {
				userProfileRepo.delete(userProfile);
				isUserExist=userProfileRepo.existsById(userProfile.getUserProfileId());
				if(isUserExist)
					profileDeleteResponse=ProfileServiceConstants.PROFILE_DELETE_FAILED;
				else
					profileDeleteResponse=ProfileServiceConstants.PROFILE_DELETE_SUCCESS;
			}
			else
				profileDeleteResponse=ProfileServiceConstants.USER_ID_DOES_NOT_EXIST;

		}catch (Exception e){

		}


		return profileDeleteResponse;

	}


	//read all the profile having same first name and last name
	@Override
	public List<RequestParameters> readUserProfileByName(RequestParameters requestParam) {
		// TODO Auto-generated method stub
				String profileReadResponse=ProfileServiceConstants.PROFILE_READ_FAILED;
				List<UserProfile> userProfile=userProfileRepo.findByFirstNameAndLastNameAndStatus(requestParam);

				List<RequestParameters>requestParameters=null;
				if (userProfile!=null&&userProfile.size()>0) {
				    requestParameters=new ArrayList<>();
				    for(UserProfile profile:userProfile){
				        RequestParameters request=new RequestParameters();

                        request.setId(profile.getUserProfileId()+"");
                        request.setAge(profile.getAge()+"");
                        request.setUserName(profile.getUsername());
                        request.setFirst_name(profile.getFirstName());
                        request.setLast_name(profile.getLastName());

                        requestParameters.add(request);
                    }

					profileReadResponse=ProfileServiceConstants.PROFILE_READ_SUCCESS;
				}

				return requestParameters;
	}

	//read single profile having first name and last name this is used only if firsname and last name both works as primary key
    @Override
    public String readUserProfile(RequestParameters requestParam) {

        UserProfile userProfile=userProfileRepo.findByFirstNameAndLastNameAndStatus(requestParam.getFirst_name(),
                requestParam.getLast_name(),ProfileServiceConstants.STATUS_NEW_PROFILE_ACTIVE);

        if(userProfile!=null){
            requestParam.setId(userProfile.getUserProfileId()+"");
            requestParam.setUserName(userProfile.getUsername());
            requestParam.setAge(userProfile.getAge()+"");
            return ProfileServiceConstants.PROFILE_READ_SUCCESS;
        }else {
            return ProfileServiceConstants.PROFILE_READ_FAILED;
        }
    }

    // This returns unique result based on the userProfileId
    @Override
    public RequestParameters readUserProfileById(String userProfileId) {

	    try {
           UserProfile userProfile= userProfileRepo.getOne(Long.parseLong(userProfileId));
            if(userProfile!=null){
                RequestParameters requestParam=new RequestParameters();
                requestParam.setId(userProfile.getUserProfileId()+"");
                requestParam.setUserName(userProfile.getUsername());
                requestParam.setAge(userProfile.getAge()+"");
                requestParam.setFirst_name(userProfile.getFirstName());
                requestParam.setLast_name(userProfile.getLastName());
                return requestParam;
            }

        }catch (Exception e){
	        e.printStackTrace();
        }
        return null;
    }
}
