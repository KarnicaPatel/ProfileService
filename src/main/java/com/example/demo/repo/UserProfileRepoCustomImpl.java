package com.example.demo.repo;

import com.example.demo.service.impl.ProfileServiceConstants;
import com.example.demo.table.RequestParameters;
import com.example.demo.table.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class UserProfileRepoCustomImpl implements  UserProfileRepoCustom{

    @Autowired
    private EntityManager entityManager;


    @Override
    public UserProfile findByFirstNameAndLastNameAndStatus(String firstName, String lastName, String status) {

        UserProfile userProfile=null;
        try{
            Query query=entityManager.createNativeQuery(ProfileServiceConstants.QUERY);
            query.setParameter("firstName",firstName);
            query.setParameter("lastName",lastName);
            query.setParameter("status",status);

            List<Object[]>list= query.getResultList();

            if(list!=null&&list.size()>0){

               Object[]obj=list.get(0);
                    userProfile=new UserProfile();
                    if(obj[0]!=null)
                        userProfile.setUserProfileId(Long.parseLong(obj[0]+""));
                    if(obj[1]!=null)
                        userProfile.setUsername(obj[1]+"");
                    if(obj[2]!=null)
                        userProfile.setFirstName(obj[2]+"");
                    if(obj[3]!=null)
                        userProfile.setLastName(obj[3]+"");
                    if(obj[4]!=null)
                        userProfile.setAge(Long.parseLong(obj[4]+""));
                    if(obj[5]!=null)
                        userProfile.setStatus(obj[5]+"");

                }

        }catch (Exception e){
            e.printStackTrace();
        }
        return userProfile;
    }

    @Override
    public List<UserProfile> findByFirstNameAndLastNameAndStatus(RequestParameters requestParameters) {

        UserProfile userProfile=null;
        List<UserProfile>userProfiles=null;

        try {
            Query query = entityManager.createNativeQuery(ProfileServiceConstants.QUERY);
            query.setParameter("firstName", requestParameters.getFirst_name());
            query.setParameter("lastName", requestParameters.getLast_name());
            query.setParameter("status", ProfileServiceConstants.STATUS_NEW_PROFILE_ACTIVE);

            List<Object[]> list = query.getResultList();

            if (list != null && list.size() > 0) {
                userProfiles = new ArrayList<>();
                for (Object[] obj : list) {
                    userProfile = new UserProfile();
                    if (obj[0] != null)
                        userProfile.setUserProfileId(Long.parseLong(obj[0] + ""));
                    if (obj[1] != null)
                        userProfile.setUsername(obj[1] + "");
                    if (obj[2] != null)
                        userProfile.setFirstName(obj[2] + "");
                    if (obj[3] != null)
                        userProfile.setLastName(obj[3] + "");
                    if (obj[4] != null)
                        userProfile.setAge(Long.parseLong(obj[4] + ""));
                    if (obj[5] != null)
                        userProfile.setStatus(obj[5] + "");

                    userProfiles.add(userProfile);
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return userProfiles;
    }
}
