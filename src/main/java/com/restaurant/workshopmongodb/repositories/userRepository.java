package com.restaurant.workshopmongodb.repositories;

import com.restaurant.workshopmongodb.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends MongoRepository<User, String> {
    boolean existsByemail(String email);
}
