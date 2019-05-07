package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import com.example.demo.table.UserProfile;

import java.lang.String;

//it will  mark the interface as  spring components
@Component
//will tell spring to enable JPA Repositories
@EnableJpaRepositories // this will tell that this is the repository which is handling the database part
//JpaRepository is a predefine interface which have boiler plate logic for CRUD operation
//UserProfileRepoCustom this is custom interface which shows our custom operation on database
public interface UserProfileRepo extends JpaRepository<UserProfile, Long>, UserProfileRepoCustom{


	
}
