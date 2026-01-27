package com.restaurant.workshopmongodb.service;

import com.restaurant.workshopmongodb.models.User;
import com.restaurant.workshopmongodb.record.UserRecord;
import com.restaurant.workshopmongodb.repositories.UserRepository;
import com.restaurant.workshopmongodb.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

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

    public UserRecord insert(UserRecord dto){
        if(dto.username() == null || dto.username().isBlank()){
            throw new IllegalArgumentException("Username is required");
        }
        if(userRepository.existsByemail(dto.email())){
            throw new IllegalArgumentException("Email is already exists");
        }

        User userSave = new User();
        userSave.setUsername(dto.username());
        userSave.setEmail(dto.email());

        //userRepository.save(userSave) returns the persisted User entity, used to build the UserRecord DTO.
        return new UserRecord(userRepository.save(userSave));
    }

    public void delete(String id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
        } else{
            throw new ObjectNotFoundException("User not found");
        }
    }

    public UserRecord update(String id, UserRecord dto){

        if(dto.username() == null || dto.username().isBlank()){
            throw new IllegalArgumentException("Username is required");
        }
        if(dto.email() == null || dto.email().isBlank()){
            throw new IllegalArgumentException("Email is required");
        }

        if(userRepository.existsById(id)){
            User user = new User();
            user.setUsername(dto.username());
            user.setEmail(dto.email());

            userRepository.save(user);

            return new UserRecord(user);

        } else{
            throw new ObjectNotFoundException("User not found");
        }
    }
}
