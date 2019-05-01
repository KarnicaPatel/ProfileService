package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import com.example.demo.table.UserProfile;

import java.lang.String;

//it will mark spring components
@Component
//will tell spring to enable JPA Repositories
@EnableJpaRepositories
public interface UserProfileRepo extends JpaRepository<UserProfile, Long>, UserProfileRepoCustom{


	
}
