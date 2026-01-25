package com.restaurant.workshopmongodb.service;

import com.restaurant.workshopmongodb.models.User;
import com.restaurant.workshopmongodb.record.UserRecord;
import com.restaurant.workshopmongodb.repositories.userRepository;
import com.restaurant.workshopmongodb.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private userRepository userRepository;

    // Retrieves all users from the database and returns them as DTOs.
    public List<UserRecord> findAll(){
        List<User> list = userRepository.findAll();
        return list.stream().map(UserRecord::new).collect(Collectors.toList());
    }

    /*
        Searches for a user in the database using the specified ID.
        If found, returns the user's data as a DTO.
        If not found, throws an ObjectNotFoundException.
    */
    public UserRecord findById(String id){
         if(userRepository.findById(id).isPresent()){
            User user =  userRepository.findById(id).get();
            return new UserRecord(user);

         } else{
             throw new ObjectNotFoundException("User not found");
         }
    }
}
