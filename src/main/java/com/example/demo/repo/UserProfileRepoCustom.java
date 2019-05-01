package com.example.demo.repo;

import com.example.demo.table.RequestParameters;
import com.example.demo.table.UserProfile;

import java.util.List;

public interface UserProfileRepoCustom {
    List<UserProfile> findByFirstNameAndLastNameAndStatus(RequestParameters requestParameters);
    UserProfile findByFirstNameAndLastNameAndStatus(String firstName, String lastName, String status);

}
